package com.repasofinal.familiaapisqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.repasofinal.familiaapisqlite.Objetos.Hermano;
import com.repasofinal.familiaapisqlite.Objetos.InfoUser;

import java.util.ArrayList;

public class HermanoFamiliar extends AppCompatActivity {

    EditText nombre, fechaNac, lugarNac;
    CheckBox vive;
    ListView listaHermanos;
    ArrayList<Hermano> hermanos = new ArrayList<Hermano>();
    ArrayAdapter<Hermano> arrayAdapter;
    Hermano hermano = null;
    InfoUser infoUser = null;

    ConnectionSQLiteHelper con;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hermano);
        con = new ConnectionSQLiteHelper(getApplicationContext(), "db_usuarios", null, 1);

        nombre = (EditText) findViewById(R.id.et_nombreH);
        fechaNac = (EditText) findViewById(R.id.et_fechNacH);
        lugarNac = (EditText) findViewById(R.id.et_lugarNacH);
        listaHermanos = (ListView) findViewById(R.id.lv_agregarHermanos);
        vive = (CheckBox) findViewById(R.id.cb_Si);

        Bundle b = getIntent().getExtras();
        if(b != null){
             infoUser = (InfoUser) b.getSerializable("InfoUser");

        }


    }


    public void Grabar(View view) {

        SQLiteDatabase db = con.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Utilidades.CAMPO_IDUSUARIO, infoUser.getIdUser());
        values.put(Utilidades.CAMPO_NOMBREUSUARIO, infoUser.getNombre());
        values.put(Utilidades.CAMPO_NOMBREPADRE, infoUser.getNombrePadre());
        values.put(Utilidades.CAMPO_NOMBREMADRE, infoUser.getNombreMadre());
        values.put(Utilidades.CAMPO_FECHANACIMIENTO, infoUser.getFechaNacimiento());
        values.put(Utilidades.CAMPO_LUGARNACIMIENTO, infoUser.getLugarNacimiento());
        values.put(Utilidades.CAMPO_VIVE, infoUser.getVive());

        Long idResultante = db.insert(Utilidades.TABLA_USUARIO, Utilidades.CAMPO_IDUSUARIO, values);
        Toast.makeText(getApplicationContext(), "Registro ID: "+ idResultante, Toast.LENGTH_LONG).show();


        for(int i= 0; i<hermanos.size(); i++){
            ContentValues values2 = new ContentValues();

            values2.put(Utilidades.CAMPO_NOMBREHERMANO, hermanos.get(i).getNombre());
            values2.put(Utilidades.CAMPO_FECHANACIMIENTO, hermanos.get(i).getFechaNacimiento());
            values2.put(Utilidades.CAMPO_LUGARNACIMIENTO, hermanos.get(i).getLugarNacimiento());
            values2.put(Utilidades.CAMPO_VIVE, hermanos.get(i).getVive());
            values2.put(Utilidades.CAMPO_IDUSUARIO, infoUser.getIdUser());
            db.insert(Utilidades.TABLA_HERMANO, Utilidades.CAMPO_IDHERMANO, values2);
        }

        db.close();
    }

    public void Cerrar(View view) {
        Intent i = new Intent(HermanoFamiliar.this, MainActivity.class);
        i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        i.getBooleanExtra("EXIT", true);
        startActivity(i);
        finish();
        System.exit(0);
    }

    public void AgregarHermano(View view) {
        for (int i = 0; hermanos.size() >= 2 ; i++){
            Toast.makeText(getApplicationContext(), "No se pueden agregar hermanos", Toast.LENGTH_LONG).show();
            return;
        }
        hermano = new Hermano(nombre.getText().toString().trim(), fechaNac.getText().toString().trim(),
                lugarNac.getText().toString().trim(), vive.isChecked());
        /*hermano.setNombre(nombre.getText().toString().trim());
        hermano.setFechaNacimiento(fechaNac.getText().toString().trim());
        hermano.setLugarNacimiento(lugarNac.getText().toString().trim());
        hermano.setVive(vive.isChecked());
        */
        //hermanos = new ArrayList<Hermano>();
        hermanos.add(hermano);
        arrayAdapter = new ArrayAdapter<Hermano>(this, android.R.layout.simple_list_item_1, hermanos);
        listaHermanos.setAdapter(arrayAdapter);

        limpiar();
    }

    private void limpiar() {
        nombre.setText("");
        fechaNac.setText("");
        lugarNac.setText("");
        vive.setChecked(true);
    }
}