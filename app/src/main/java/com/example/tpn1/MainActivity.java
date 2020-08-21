package com.example.tpn1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void Redireccionar_EjercicioUno(View view){
        Intent redireccion = new Intent(this, Suma.class);
        startActivity(redireccion);
    }

    public void Redireccionar_EjercicioDos(View view){
        Intent redireccion = new Intent(this, Calculadora.class);
        startActivity(redireccion);
    }
}