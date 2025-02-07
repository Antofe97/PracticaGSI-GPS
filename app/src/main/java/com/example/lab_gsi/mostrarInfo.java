package com.example.lab_gsi;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.lab_gsi.Dominio.Recomendacion;
import com.squareup.picasso.Picasso;

public class mostrarInfo extends AppCompatActivity {

    private Recomendacion recomendacion;
    private String tipo;


    @Override
    public boolean onCreateOptionsMenu(android.view.Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.context_menu, menu);
        return true;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_info);



        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);


        tipo = (String) getIntent().getSerializableExtra("Tipo");


        recomendacion = (Recomendacion) getIntent().getSerializableExtra("Recomendacion");
        toolbar.setTitle("Mostrando Recomendación");
        EditText nombre = findViewById(R.id.editText3);
        EditText des = findViewById(R.id.editText4);
        nombre.setEnabled(false);
        nombre.setText(recomendacion.getNombre());
        des.setEnabled(false);
        des.setText(recomendacion.getComentario());
        ImageView imageView1 = findViewById(R.id.imageView2);
        Picasso.with(this).load(recomendacion.getImagenBit()).into(imageView1);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==android.R.id.home){
            Intent intent = new Intent(mostrarInfo.this, lista.class);

            intent.putExtra("Tipo", tipo);
            startActivity(intent);
            finish();
        } if (item.getItemId() == R.id.btnAutores) {
            AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
            builder1.setMessage("Aplicación realizada por Antonio Felipe Rojo y Roque Rojo Bacete.");
            builder1.setCancelable(true);

            builder1.setPositiveButton(
                    "Ok",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.cancel();
                        }
                    });
            AlertDialog alert11 = builder1.create();
            alert11.show();
        }
        return super.onOptionsItemSelected(item);
    }
}
