package com.tareas.guia3;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static List<String> Ln;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Ln = new ArrayList<>();
    }
    public void VerLista(View v){
        if(Ln == null || Ln.size() ==0){
            new AlertDialog.Builder(this).setTitle("Alerta").setMessage("Lista Vacia").show();
        }else{
            Intent i = new Intent(this,Lista.class);
            startActivity(i);
        }
    }
    public void AddNombre(View v){
        Intent i = new Intent(this,Registro.class);
        startActivity(i);
    }
    public void VerDatos(View v){
        Intent i = new Intent(this,Datos.class);
        startActivity(i);
    }
}
