package com.example.gladson.buscafilmes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    public final static String FILME = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void pesquisarFilme(View view){
        Intent intent = new Intent(this,resultadoPesquisaActivity.class);
        EditText editText = (EditText) findViewById(R.id.entrada);
        String filme = editText.getText().toString();
        intent.putExtra(FILME, filme);
        startActivity(intent);
    }
}
