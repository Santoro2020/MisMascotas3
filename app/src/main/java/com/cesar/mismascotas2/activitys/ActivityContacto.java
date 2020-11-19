package com.cesar.mismascotas2.activitys;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import androidx.appcompat.app.AppCompatActivity;

import com.cesar.mismascotas2.R;
import com.cesar.mismascotas2.activitys.ActivityComentario;

import java.text.ParseException;

public class ActivityContacto extends AppCompatActivity {
    EditText etNombre;
    EditText etEmail;
    EditText etcomentario;
    Button btsiguiente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);

        etNombre = (EditText) findViewById(R.id.etNombre);
        etEmail = (EditText) findViewById(R.id.etEmail);
        etcomentario = (EditText) findViewById(R.id.etcomentario);
        btsiguiente = (Button) findViewById(R.id.btsiguiente);

        Bundle d = getIntent().getExtras();
        if (d != null) {
            try {
                actualizaInfo(d);
            } catch ( ParseException e) {
                e.printStackTrace();
            }
        }

        btsiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(obtenerIntent());
                finish();
            }
        });
    }

    private void actualizaInfo(Bundle d) throws ParseException {

        String nombre = d.getString("nombre");
        String email = d.getString("email");
        String comentario = d.getString("comentario");

        etNombre.setText(nombre);
        etEmail.setText(email);
        etcomentario.setText(comentario);

    }

    private Intent obtenerIntent() {

        String nombre = null;
        if (etNombre.getText().length()>0)
            nombre = etNombre.getText().toString();
        else nombre = "Campo Obligatorio";

        String email = null;

        if (etEmail.getText().length()>0)
            email = etEmail.getText().toString();
        else email = "Campo Obligatorio";

        String comentario = null;
        if (etcomentario.getText().length()>0)
            comentario = etcomentario.getText().toString();
        else comentario = "Campo Obligatorio";


        Intent intent = new Intent(this, ActivityComentario.class);

        intent.putExtra("nombre", nombre);
        intent.putExtra("email", email);
        intent.putExtra("comentario", comentario);
        return intent;
    }
}
