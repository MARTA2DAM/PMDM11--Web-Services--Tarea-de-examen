package com.example.appexamentiempo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.example.appexamentiempo.modelo.ApiWeather;
import com.example.appexamentiempo.modelo.Weather;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Tiempo extends AppCompatActivity {

    String ciudad;
    TextView titulo, temp, viento, humedad, condicion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tiempo);

        Intent i = getIntent();
        ciudad = i.getStringExtra("cdad");
        
        titulo = (TextView) findViewById(R.id.ciudad);
        temp=(TextView) findViewById(R.id.textgrados);
        viento=(TextView) findViewById(R.id.textviento);
        humedad=(TextView) findViewById(R.id.texthumedad);
        condicion=(TextView) findViewById(R.id.textcondition);
        titulo.setText(ciudad);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiWeather.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiWeather divisasAPI = retrofit.create(ApiWeather.class);
        String location = ciudad+" ,Spain";
        Call<Weather> call = divisasAPI.getStuff("b6b7ee66a8a746fabd6174434242602", location , "es");

        call.enqueue(new Callback<Weather>() {

            @Override
            public void onResponse
                    (Call<Weather> call, Response<Weather> response) {
                if (response.isSuccessful()) {
                    temp.setText(response.body().getCurrent().getTempCelsius()+" Grados");
                    viento.setText(response.body().getCurrent().getWindKph()+" Km/h");
                    condicion.setText(response.body().getCurrent().getCondition().getText()+"");
                    humedad.setText(response.body().getCurrent().getHumidity()+" %");

                } else {
                    Toast.makeText(Tiempo.this, "codigo de error: "+response.code(), Toast.LENGTH_LONG).show();
                    finish();
                }



            }

            @Override
            public void onFailure(Call<Weather> call, Throwable t) {
                Toast.makeText(Tiempo.this, "Algo salio mal:"+ t, Toast.LENGTH_SHORT).show();
                System.out.println(t);
            }


        });
    }
}