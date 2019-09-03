package com.tareas.guia3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import static com.tareas.guia3.MainActivity.Ln;

public class Lista extends AppCompatActivity {
    private ListView LVn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);
        if(getSupportActionBar()!=null){
            getSupportActionBar().hide();
        }
        if(Ln == null || Ln.size()==0){
            Toast.makeText(this, "Lista Vacia", Toast.LENGTH_SHORT).show();
        }else{
            LVn = findViewById(R.id.listNombres);
            LVn.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,Ln));
            LVn.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                    if(position >=0 && position < Ln.size()){
                        Toast.makeText(Lista.this, "El nombre es: "+Ln.get(position), Toast.LENGTH_LONG).show();
                    }
                }
            });
        }
    }
}
