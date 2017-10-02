package com.example.gladson.buscafilmes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class MainActivity extends AppCompatActivity {
    //Guarda o nome do filme
    public final static String FILME = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView teste = (TextView) findViewById(R.id.testeVolley);

        //Inicializando a requisição
        RequestQueue request = Volley.newRequestQueue(this);
        String url = "http://www.omdbapi.com/?i=tt3896198&apikey=ea23cea2";

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>(){
                    @Override
                    public void onResponse(String response){
                        teste.setText("Resultado:" + response.toString());
                    }
        }, new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error){
                teste.setText(error.getMessage());
            }
        });
        request.add(stringRequest);
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
