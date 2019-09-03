package com.tareas.guia3;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import static com.tareas.guia3.MainActivity.Ln;

public class Registro extends AppCompatActivity {
    EditText edtNombre;
    TextView porcentaje;
    Handler h = new Handler();
    ProgressBar proBar;
    int i = 0;
    boolean Activo = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        edtNombre = findViewById(R.id.edtNombre);
        porcentaje = findViewById(R.id.porcentaje);
        proBar = findViewById(R.id.proBar);
    }

    public void GuardarRegistro(View v){
        if(edtNombre.getText().toString().isEmpty()){
            new AlertDialog.Builder(this).setTitle("Alerta").setMessage("Digite un nombre").show();
        } else if(!Activo){
            Thread hr = new Thread(new Runnable() {
                @Override
                public void run() {
                    while(i <= 100){
                        h.post(new Runnable() {
                            @Override
                            public void run() {
                                porcentaje.setText(i +" %");
                                proBar.setProgress(i);
                            }
                        });
                        try {
                            Thread.sleep(20);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        if(i == 100) {
                            Ln.add(edtNombre.getText().toString());
                            runOnUiThread(new Runnable() {
                                public void run() {
                                    new AlertDialog.Builder(Registro.this).setTitle("¡Aviso!").setMessage("Guardo exitosamente. \n¿Desea agregar otro nombre?")
                                            .setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialogInterface, int i) {   //Cerrar
                                                    finish();
                                                }
                                            })
                                            .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialog, int which) {// Add otro
                                                    Activo = false;
                                                    i  = 0;
                                                    porcentaje.setText("");
                                                    edtNombre.setText("");
                                                    proBar.setProgress(0);
                                                }
                                            }).show();
                                }
                            });
                        }
                        i++;
                        Activo = true;
                    }
                }
            });
            hr.start();
        }
    }
}
