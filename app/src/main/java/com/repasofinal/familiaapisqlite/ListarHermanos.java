package com.repasofinal.familiaapisqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

public class ListarHermanos extends AppCompatActivity {

    ListView listaHermano;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_hermanos);
        listaHermano = findViewById(R.id.lv_hermano);
    }
}