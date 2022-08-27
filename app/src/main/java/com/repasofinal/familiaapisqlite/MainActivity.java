package com.repasofinal.familiaapisqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.repasofinal.familiaapisqlite.Objetos.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    EditText usuario, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        usuario =(EditText) findViewById(R.id.et_usuario);
        password = (EditText) findViewById(R.id.et_password);

        usuario.setText("Antonette");
        password.setText("Shanna@melissa.tv");

        if(getIntent().getBooleanExtra("EXIT", false)) {
            finish();
        }
    }

    public void Login(View view) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        UserService userService = retrofit.create(UserService.class);

        Call<List<User>> call = userService.getUserPass(usuario.getText().toString().trim(), password.getText().toString().trim());
        if(usuario.getText().toString().isEmpty() || password.getText().toString().isEmpty()){
            Toast.makeText(getApplicationContext(), "Ingrese credenciales", Toast.LENGTH_LONG).show();
        }else{
            call.enqueue(new Callback<List<User>>() {
                @Override
                public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                    if(response.body().isEmpty()){
                        Toast.makeText(getApplicationContext(), "Credenciales incorrectas!!", Toast.LENGTH_LONG).show();
                    }else{
                        if(response.body().get(0).getUsername().equals(usuario.getText().toString().trim())
                        && response.body().get(0).getEmail().equals(password.getText().toString().trim())){
                            Toast.makeText(getApplicationContext(), "Login exitoso!!", Toast.LENGTH_LONG).show();
                            Intent i = new Intent(MainActivity.this, Logeado.class);
                            i.putExtra("idUser", response.body().get(0).getId());
                            i.putExtra("name", response.body().get(0).getName());
                            startActivity(i);
                        }
                    }

                }

                @Override
                public void onFailure(Call<List<User>> call, Throwable t) {
                    Toast.makeText(getApplicationContext(), "Error: "+ t.getMessage(), Toast.LENGTH_LONG).show();
                }
            });

        }


    }
}