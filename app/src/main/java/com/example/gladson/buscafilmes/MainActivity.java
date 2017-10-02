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
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    //Guarda o nome do filme
    public final static String FILME = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }


    public void pesquisarFilme(View view){
        EditText editText = (EditText) findViewById(R.id.entrada);
        requisitarURL(editText.getText().toString());
    }
    public void requisitarURL(String filme){
        //Cria um vinculo entre a primeira e a segunda pagina
        Intent intent = new Intent(this,resultadoPesquisaActivity.class);
        //Pega a editText da primeira tela

        final TextView guardarResposta = (TextView) findViewById(R.id.testeVolley);

        //Inicializando a requisição
        RequestQueue request = Volley.newRequestQueue(this);
        String url = "http://www.omdbapi.com/?apikey=ea23cea2&t=" + filme;

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>(){
                    @Override
                    public void onResponse(JSONObject response){
                        try{
                            guardarResposta.setText(response.getString("Title"));
                        }catch (JSONException EX){
                            guardarResposta.setText(EX.getMessage());
                        }

                    }
                }, new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error){
                guardarResposta.setText(error.getMessage());
            }
        });
        request.add(jsonObjectRequest);
        TextView resposta = (TextView) findViewById(R.id.testeVolley);
        intent.putExtra(FILME, resposta.getText().toString());
        //Instancia a proxima tela
        startActivity(intent);

    }

}
