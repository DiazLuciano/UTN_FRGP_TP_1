package com.example.tpn1;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Suma extends AppCompatActivity {

    private EditText et1;
    private EditText et2;
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suma);
        et1 = (EditText)findViewById(R.id.txtNumeroUno);
        et2 = (EditText)findViewById(R.id.txtNumeroDos);
        tv = (TextView)findViewById(R.id.txtResultado);
    }

    //Este metodo realiza la suma
    public void Sumar (View view){
        String valor1 = et1.getText().toString();
        String valor2 = et2.getText().toString();

        int numeroUno = Integer.parseInt(valor1);
        int numeroDos = Integer.parseInt(valor2);

        int suma = numeroUno + numeroDos;

        String result = String.valueOf(suma);
        tv.setText(result);
    }


}