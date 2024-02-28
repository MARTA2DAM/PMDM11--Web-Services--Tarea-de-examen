
package com.example.appexamentiempo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class Imagenes extends AppCompatActivity {

    Spinner spinnerCdad;
    ImageView imagen;
    private ArrayList<String> ciudades =new ArrayList<>();
    private ArrayList<String> urls =new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imagenes);
        spinnerCdad = (Spinner) findViewById(R.id.spinnerciudades);
        imagen = (ImageView) findViewById(R.id.imagen);
        anadirCiudades();
        listar();
        aniadirUrls();
        spinnerCdad.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Picasso.get()
                        .load(urls.get(i))
                        .fit()
                        .into(imagen);

            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {}
        });

    }
    private void listar() {
        ArrayAdapter<String> adaptador = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, ciudades);
        spinnerCdad.setAdapter(adaptador);

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
    private void aniadirUrls() {
        urls.add("https://www.barcelo.com/guia-turismo/wp-content/uploads/2023/01/catedral-de-murcia.jpg");
        urls.add("https://www.barcelo.com/guia-turismo/wp-content/uploads/2022/12/cartagena-murcia.jpg");
        urls.add("https://www.urbankroops.es/wp-content/uploads/2014/05/62ec7e72af331d651d570b6c0b0c47da.jpg");
        urls.add("https://encrypted-tbn1.gstatic.com/licensed-image?q=tbn:ANd9GcSbGhGVAgJ1dPA-bXeGalLR7pXTAHnlAIbrO8oiR2AWg4WoFXy84yfbn26erPOKfzop_jZcopLq6J09zgWV8pC33MfqB1sQBKqFd-LvgQ");
        urls.add("https://encrypted-tbn1.gstatic.com/licensed-image?q=tbn:ANd9GcRvaaO-Y4hq9zuLiysYWd8AoiDqFfLOx9xUV1lWl90pwyiUIOPfTZlvvacwpul4-iW1DVng4i78ScKAmExVV6McekHLdo6JAQhcdL3WDg");
        urls.add("https://www.canariasviaja.com/viajaresvivir/wp-content/uploads/2020/02/Floracion_2018-1024x557-cieza.jpg");
        urls.add("https://encrypted-tbn3.gstatic.com/licensed-image?q=tbn:ANd9GcQApeM4kBnv9UgtBXTJChsbp4G6ZDi14AMxoTbUUi8fkfbfNZB51ZoDRh-GZ6cKCWjn5tRB9NUjuXeYe3jlb4lQCojwt6nK9RkBWcPMUw");
        urls.add("https://encrypted-tbn1.gstatic.com/licensed-image?q=tbn:ANd9GcQd-QcnMT21_YqAbuqG9SWAg8sB7v8ayy2yfvSmcrtBhT3PUWNhyf-4kabANGyHgmkZ9-Q5aYgNQxGEr3ZU4gk1_LtcGowe4z2hDRXTHA");
        urls.add("https://lh5.googleusercontent.com/p/AF1QipP_v-gzNmEMKHQHM0p8fqLAjj8BTgJGjvA5qIbj=w945-h546-n-k-no");
        urls.add("https://www.torrepacheco.es/wp-content/uploads/2021/10/Torre-Pacheco.jpg");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected (MenuItem item){

        if(item.getItemId()==R.id.verTiempo){
            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);
            return true;
        } else if (item.getItemId()==R.id.verImagenes) {

            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }
}