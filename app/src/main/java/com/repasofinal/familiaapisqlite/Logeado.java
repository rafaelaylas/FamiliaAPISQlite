package com.repasofinal.familiaapisqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

import com.repasofinal.familiaapisqlite.Objetos.InfoUser;

public class Logeado extends AppCompatActivity {

    EditText nomPadre, nomMadre, fechaNac, lugarNac;
    RadioButton vive;
    InfoUser infoUser = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logeado);
        nomPadre = (EditText) findViewById(R.id.et_nomPadre);
        nomMadre = (EditText) findViewById(R.id.et_nomMadre);
        fechaNac = (EditText) findViewById(R.id.et_fechaNac);
        lugarNac = (EditText) findViewById(R.id.et_lugarNac);
        vive = (RadioButton) findViewById(R.id.rb_si);

    }

    public void Siguiente(View view) {

        int idUser = getIntent().getExtras().getInt("idUser");
        String nombre = getIntent().getExtras().getString("name");

        infoUser = new InfoUser();
        infoUser.setIdUser(idUser);
        infoUser.setNombre(nombre);
        infoUser.setNombrePadre(nomPadre.getText().toString().trim());
        infoUser.setNombreMadre(nomMadre.getText().toString().trim());
        infoUser.setFechaNacimiento(fechaNac.getText().toString().trim());
        infoUser.setLugarNacimiento(lugarNac.getText().toString().trim());
        infoUser.setVive(vive.isChecked());

        Intent i = new Intent(Logeado.this, HermanoFamiliar.class);
        Bundle b = new Bundle();
        b.putSerializable("InfoUser", infoUser);
        i.putExtras(b);
        startActivity(i);
    }
}