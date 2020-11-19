package com.cesar.mismascotas2.activitys;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.cesar.mismascotas2.R;
import com.cesar.mismascotas2.adaptador.DogsAdaptador;
import com.cesar.mismascotas2.pojo.Miperro;

import java.util.ArrayList;

public class MisFavoritos extends AppCompatActivity {

    private RecyclerView recyclerView;
    public DogsAdaptador adaptador;
    ArrayList<Miperro> misperrosfavoritos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mis_perros_favoritos);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        recyclerView= findViewById(R.id.rvMisfavoritos);
        LinearLayoutManager lm = new LinearLayoutManager(this);
        lm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(lm);

        obtenerMisperrosFavoritos();
        inicializarAdaptador();
    }

    public void inicializarAdaptador(){
        adaptador= new DogsAdaptador(misperrosfavoritos, this);
        recyclerView.setAdapter(adaptador);
    }
    public void obtenerMisperrosFavoritos(){
        misperrosfavoritos = new ArrayList<>();
        misperrosfavoritos.add(new Miperro("Tony",5,R.drawable.tony_9));
        misperrosfavoritos.add(new Miperro("Lenon",5,R.drawable.lenon_9));
        misperrosfavoritos.add(new Miperro("Duncan",5,R.drawable.duncan_9));
        misperrosfavoritos.add(new Miperro("Sabueso",5,R.drawable.dogbaby_119594_9));
        misperrosfavoritos.add(new Miperro("Beto",5,R.drawable.beto));

    }

}
