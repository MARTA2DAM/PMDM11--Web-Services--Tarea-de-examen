package com.example.appexamentiempo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;
import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {
    private ListView listado;
    private ImageView imagen;
    private ArrayList <String> ciudades =new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imagen = (ImageView)findViewById((R.id.imagen));
        listado = (ListView) findViewById((R.id.listado));
        Picasso.get()
                .load("https://images.pexels.com/photos/1118873/pexels-photo-1118873.jpeg")
                .fit()
                .into(imagen);


        anadirCiudades();
        listar();
        listado.setOnItemClickListener((adapterView, view, i1, l) -> {
            Intent i=new Intent(this, Tiempo.class);
            i.putExtra("cdad", ciudades.get(i1));
            startActivity(i);
        });
    }

    private void anadirCiudades() {
        ciudades.add("Murcia");
        ciudades.add("Cartagena");
        ciudades.add("Yecla");
        ciudades.add("Molina de Segura");
        ciudades.add("Lorca");
        ciudades.add("Cieza");
        ciudades.add("Jumilla");
        ciudades.add("San Pedro del Pinatar");
        ciudades.add("Águilas");
        ciudades.add("Torre-Pacheco");
    }

    private void listar() {
        ArrayAdapter<String> adaptador = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, ciudades);
        listado.setAdapter(adaptador);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected (MenuItem item){

        if(item.getItemId()==R.id.verTiempo){
            return true;
        } else if (item.getItemId()==R.id.verImagenes) {
            Intent i = new Intent(this, Imagenes.class);
            startActivity(i);
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }
}