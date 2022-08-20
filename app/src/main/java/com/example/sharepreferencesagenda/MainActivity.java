package com.example.sharepreferencesagenda;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText et_nombre, et_datos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_nombre = (EditText) findViewById(R.id.txt_nombre);
        et_datos = (EditText) findViewById(R.id.txt_datos);
    }
    //Metodo boton guardar
    public void guardar(View view){
        String nombre = et_nombre.getText().toString();
        String datos = et_datos.getText().toString();

        SharedPreferences preferencias = getSharedPreferences("agenda", Context.MODE_PRIVATE);//crear el objeto para guardar los datos
        SharedPreferences.Editor obj_editor = preferencias.edit();//Objeto para editar archivo
        obj_editor.putString(nombre, datos);//Valores
        obj_editor.commit();//confirmar guardado

        Toast.makeText(this, "El contacto ha sido guardado", Toast.LENGTH_LONG).show();
    }


    public void buscar (View view){
        String nombre = et_nombre.getText().toString();

        SharedPreferences preferencias = getSharedPreferences("agenda", Context.MODE_PRIVATE);//nombre del archivo agenda igual que el de arriba a fuerza
        String datos = preferencias.getString(nombre, "");//almacenar los datos que el usuario esta buscando
        if (datos.length() == 0) {//si no encuentra nada
            Toast.makeText(this, "No se encontro ningun registro", Toast.LENGTH_SHORT).show();
        }else{//si encuentra el nombre
            et_datos.setText(datos);
        }
    }
}