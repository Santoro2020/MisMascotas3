package com.cesar.mismascotas2.activitys;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.cesar.mismascotas2.R;

public class ActivityComentario extends AppCompatActivity {
    private TextView tvNombre;
    private TextView tvEmail;
    private TextView tvComentario;
    Button btEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comentario);

        Bundle d = getIntent().getExtras();

        tvNombre = (TextView) findViewById(R.id.tvNombre);
        tvEmail = (TextView) findViewById(R.id.tvEmail);
        tvComentario = (TextView) findViewById(R.id.tvComentario);
        btEdit=(Button) findViewById(R.id.btEdit);

        tvNombre.setText(d.getString("nombre"));
        tvEmail.setText(d.getString("email"));
        tvComentario.setText(d.getString("comentario"));

        btEdit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                startActivity(creaIntent());
                finish();
            }

        });
    }

    private Intent creaIntent() {

        Intent intent = new Intent(this, ActivityContacto.class);

        String nombre = tvNombre.getText().toString();
        String email = tvEmail.getText().toString();
        String comentario = tvComentario.getText().toString();

        intent.putExtra("nombre", nombre);
        intent.putExtra("email", email);
        intent.putExtra("comentario", comentario);

        return intent;
    }
}
