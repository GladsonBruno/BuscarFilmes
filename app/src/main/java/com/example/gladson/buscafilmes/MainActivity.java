package com.example.gladson.buscafilmes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    //Guarda o nome do filme
    public final static String FILME = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /*
    public void pesquisarFilme(View view){

        //Cria um vinculo entre a primeira e a segunda pagina
        Intent intent = new Intent(this,resultadoPesquisaActivity.class);
        //Pega a editText da primeira tela
        EditText editText = (EditText) findViewById(R.id.entrada);
        //atribui a variavel filme o nomme digitado no EditText component
        String filme = editText.getText().toString();
        //Adiciona o valor e editText ao intent
        intent.putExtra(FILME, filme);
        //Instancia a proxima tela
        startActivity(intent);
    }
     */
}
