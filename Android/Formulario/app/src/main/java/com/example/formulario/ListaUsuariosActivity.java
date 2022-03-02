package com.example.formulario;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.formulario.domain.Usuario;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ListaUsuariosActivity extends ListActivity {
    public static List<Usuario> usuariosCadastrados;
    private List<String> usuariosLista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        usuariosLista = new ArrayList<String>();

        usuariosCadastrados = (List<Usuario>) getIntent().getSerializableExtra("usuarios");
        for (Usuario u : usuariosCadastrados) {
            usuariosLista.add(u.getNome().concat(" : ").concat(u.getGenero()));
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(ListaUsuariosActivity.this, android.R.layout.simple_list_item_1, usuariosLista);
        setListAdapter(adapter);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        Intent dados = new Intent(ListaUsuariosActivity.this, EditarDadosActivity.class);
        dados.putExtra("usuario", (Serializable) usuariosCadastrados.get(position));
        dados.putExtra("posicao", (Serializable) position);
        startActivity(dados);
    }
}
