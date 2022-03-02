package com.example.formulario;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

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
import java.util.List;

import static com.example.formulario.ListaUsuariosActivity.usuariosCadastrados;

public class EditarDadosActivity extends AppCompatActivity implements Validator.ValidationListener {
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

    private Button btCadastrar;
    private RadioButton rbSelecionado;
    private RadioButton rbFeminino;
    private RadioButton rbMasculino;
    private RadioGroup rgGenero;
    private CheckBox cbMusica;
    private CheckBox cbFilme;
    private Usuario usuario;
    private Button btEditar;
    private TextInputLayout txtNome;
    private TextInputLayout txtEmail;
    private TextInputLayout txtTelefone;
    private TextInputLayout txtData;
    private Validator validator;
    private Usuario novoUsuario;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_dados);
        inicializaComponentes();

        usuario = (Usuario) getIntent().getSerializableExtra("usuario");
        int position = (int) getIntent().getSerializableExtra("posicao");
        novoUsuario = new Usuario();
        novoUsuario = usuariosCadastrados.get(position);

        inicializaCampos();
        btEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editar();
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
        rbFeminino = findViewById(R.id.rb_feminino);
        rbMasculino = findViewById(R.id.rb_masculino);
        btCadastrar = findViewById(R.id.bt_cadastrar);
        btEditar = findViewById(R.id.bt_editar);
        validator = new Validator(this);
        validator.setValidationListener(this);
        SimpleMaskFormatter smf = new SimpleMaskFormatter("(NN) NNNNNNNNN");
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

    public void inicializaCampos() {
        etNome.setText(usuario.getNome());
        etEmail.setText(usuario.getEmail());
        etTelefone.setText(usuario.getTelefone());
        etDataNascimento.setText(usuario.getDataNascimento());

        if (usuario.getGenero().equals("Feminino")) {
            rbFeminino.setChecked(true);
        } else if (usuario.getGenero().equals("Masculino")) {
            rbMasculino.setChecked(true);
        }

        if (usuario.getInteresses().contains("Filme")) {
            cbFilme.setChecked(true);
        }
        if (usuario.getInteresses().contains("Musica")) {
            cbMusica.setChecked(true);
        }
    }

    @Override
    public void onValidationSucceeded() {
        atualizarUsuario();
        Intent lista = new Intent(EditarDadosActivity.this, ListaUsuariosActivity.class);
        lista.putExtra("usuarios", (Serializable) usuariosCadastrados);

        startActivity(lista);
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

    private void atualizarUsuario() {
        novoUsuario.setNome(etNome.getText().toString());
        novoUsuario.setEmail(etEmail.getText().toString());
        novoUsuario.setTelefone(etTelefone.getText().toString());
        novoUsuario.setDataNascimento(etDataNascimento.getText().toString());
        RadioButton rb = findViewById(rgGenero.getCheckedRadioButtonId());
        novoUsuario.setGenero(rb.getText().toString());
        if (cbFilme.isChecked()) {
            novoUsuario.getInteresses().add(cbFilme.getText().toString());
        }
        if (cbMusica.isChecked()) {
            novoUsuario.getInteresses().add(cbMusica.getText().toString());
        }
    }


    private void editar() {
        txtNome.setError("");
        txtEmail.setError("");
        txtTelefone.setError("");
        txtData.setError("");
        validator.validate();

    }
}
