package com.example.formulario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.formulario.domain.Usuario;
import com.github.rtoshiro.util.format.MaskFormatter;
import com.github.rtoshiro.util.format.SimpleMaskFormatter;
import com.github.rtoshiro.util.format.pattern.MaskPattern;
import com.github.rtoshiro.util.format.text.MaskTextWatcher;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.mobsandgeeks.saripaar.ValidationError;
import com.mobsandgeeks.saripaar.Validator;
import com.mobsandgeeks.saripaar.annotation.Email;
import com.mobsandgeeks.saripaar.annotation.Length;
import com.mobsandgeeks.saripaar.annotation.NotEmpty;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements Validator.ValidationListener {

    @NotEmpty(message = "Campo obrigatório.")
    @Length(min = 3, max = 20, message = "O nome deve ter entre 3 e 20 caracteres.")
    private TextInputEditText etNome;

    @NotEmpty(message = "Campo obrigatório.")
    @Email(message = "E-mail inválido.")
    private TextInputEditText etEmail;

    @NotEmpty(message = "Campo obrigatório.")
    @Length(min = 10, max = 10, message = "Data inválida.")
    private TextInputEditText etDataNascimento;

    @NotEmpty(message = "Campo obrigatório.")
    @Length(min = 13, max = 13, message = "Telefone inválido.")
    private TextInputEditText etTelefone;

    private RadioGroup rgGenero;
    private Button btCadastrar;
    private RadioButton rbSelecionado;
    private CheckBox cbMusica;
    private CheckBox cbFilme;
    public ArrayList<Usuario> usuariosCadastrados;
    private Usuario usuario;
    private Button btEnviar;
    private TextInputLayout txtNome;
    private TextInputLayout txtEmail;
    private TextInputLayout txtTelefone;
    private TextInputLayout txtData;
    private Validator validator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inicializaComponentes();

        usuario = new Usuario();
        usuariosCadastrados = new ArrayList<>();

        btCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cadastrar();
            }
        });
        btEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enviar();
            }
        });
        this.rgGenero.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                rbSelecionado = findViewById(checkedId);
            }
        });
    }

    public void inicializaComponentes() {
        etNome = findViewById(R.id.et_nome);
        etEmail = findViewById(R.id.et_email);
        etTelefone = findViewById(R.id.et_telefone);
        etDataNascimento = findViewById(R.id.et_data_nascimento);
        cbMusica = findViewById(R.id.cb_musica);
        cbFilme = findViewById(R.id.cb_filme);
        txtNome = findViewById(R.id.txt_nome);
        txtEmail = findViewById(R.id.txt_email);
        txtTelefone = findViewById(R.id.txt_telefone);
        txtData = findViewById(R.id.txt_nascimento);
        rgGenero = findViewById(R.id.rg_genero);
        btCadastrar = findViewById(R.id.bt_cadastrar);
        btEnviar = findViewById(R.id.bt_editar);
        validator = new Validator(this);
        validator.setValidationListener(this);
        SimpleMaskFormatter smf = new SimpleMaskFormatter("(NN) NNNNNNNN");
        MaskTextWatcher mtw = new MaskTextWatcher(etTelefone, smf);
        etTelefone.addTextChangedListener(mtw);
        MaskPattern mp03 = new MaskPattern("[0-3]");
        MaskPattern mp09 = new MaskPattern("[0-9]");
        MaskPattern mp01 = new MaskPattern("[0-1]");
        MaskFormatter mf = new MaskFormatter("[0-3][0-9]/[0-1][0-9]/[0-9][0-9][0-9][0-9]");
        mf.registerPattern(mp01);
        mf.registerPattern(mp03);
        mf.registerPattern(mp09);
        MaskTextWatcher mtw2 = new MaskTextWatcher(etDataNascimento, mf);
        etDataNascimento.addTextChangedListener(mtw2);
    }

    @Override
    public void onValidationSucceeded() {
        adicionarUsuario();

        Toast.makeText(MainActivity.this,
                etNome.getText().toString() + " " +
                        etEmail.getText().toString() + " "
                        + etTelefone.getText().toString() + " " +
                        etDataNascimento.getText().toString() + " " +
                        rbSelecionado.getText().toString() + " Interesses: " +
                        (cbMusica.isChecked() ? cbMusica.getText().toString() : " ") +
                        (cbFilme.isChecked() ? cbFilme.getText().toString() : " "),
                Toast.LENGTH_LONG).show();
        limparFormulario();
    }

    @Override
    public void onValidationFailed(List<ValidationError> erros) {
        for (ValidationError erro : erros) {
            View view = erro.getView();
            String message = erro.getCollatedErrorMessage(this);

            switch (view.getId()) {
                case R.id.et_nome:
                    txtNome.setError(message);
                    break;
                case R.id.et_email:
                    txtEmail.setError(message);
                    break;
                case R.id.et_telefone:
                    txtTelefone.setError(message);
                    break;
                case R.id.et_data_nascimento:
                    txtData.setError(message);
                    break;
            }
        }
    }

    private void adicionarUsuario() {
        Usuario usuario = new Usuario();
        ArrayList<String> interesses = new ArrayList<>();

        usuario.setNome(etNome.getText().toString());
        usuario.setEmail(etEmail.getText().toString());
        usuario.setTelefone(etTelefone.getText().toString());
        usuario.setDataNascimento(etDataNascimento.getText().toString());

        RadioButton rb = findViewById(rgGenero.getCheckedRadioButtonId());
        usuario.setGenero(rb.getText().toString());
        if (cbFilme.isChecked()) {
            interesses.add(cbFilme.getText().toString());

        }
        if (cbMusica.isChecked()) {
            interesses.add(cbMusica.getText().toString());
        }

        usuario.setInteresses(interesses);


        this.usuariosCadastrados.add(usuario);
    }

    private void cadastrar() {
        txtNome.setError("");
        txtEmail.setError("");
        txtTelefone.setError("");
        txtData.setError("");

        validator.validate();
    }

    private void limparFormulario() {
        etNome.setText("");
        etEmail.setText("");
        etTelefone.setText("");
        etDataNascimento.setText("");
        cbMusica.setChecked(false);
        cbFilme.setChecked(false);
    }

    private void enviar() {
        if (usuariosCadastrados.isEmpty()) {
            Toast.makeText(this, "Não há usuários cadastrados", Toast.LENGTH_LONG).show();
            return;
        }

        Intent listaUsuario = new Intent(MainActivity.this, ListaUsuariosActivity.class);
        listaUsuario.putExtra("usuarios", (Serializable) usuariosCadastrados);
        startActivity(listaUsuario);
    }
}