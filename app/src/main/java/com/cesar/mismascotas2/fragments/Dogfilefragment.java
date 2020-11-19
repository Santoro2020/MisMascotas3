package com.cesar.mismascotas2.fragments;

import android.media.Rating;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.cesar.mismascotas2.R;
import com.cesar.mismascotas2.adaptador.DogfileAdaptador;
import com.cesar.mismascotas2.pojo.FileDog;
import com.cesar.mismascotas2.pojo.Miperro;

import java.util.ArrayList;

public class Dogfilefragment extends Fragment {
    FileDog filedog;
    private RecyclerView recyclerView;
    public DogfileAdaptador adaptador;
    private ImageView imgdogfile;
    private TextView tvNombredogfile;

    public Dogfilefragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v= inflater.inflate(R.layout.fragment_dogfile, container, false);
        recyclerView = v.findViewById(R.id.rvDogFile);
        GridLayoutManager lm = new GridLayoutManager(getContext(),2);
        recyclerView.setLayoutManager(lm);
        obtenerFileDog();
        imgdogfile= v.findViewById(R.id.imgdogfile);
        tvNombredogfile=v.findViewById(R.id.tvNombredogfile);

        imgdogfile.setImageResource(filedog.getFotoFile());
        tvNombredogfile.setText(filedog.getNombre());
        inicializarAdaptador();

        return v;
    }
    public void inicializarAdaptador() {
        adaptador = new DogfileAdaptador(filedog.getFotosfile(), getActivity());
        recyclerView.setAdapter(adaptador);
    }
    public void obtenerFileDog() {
        filedog= new FileDog();
        filedog.setNombre("Beto");
        filedog.setFotoFile(R.drawable.beto);
        filedog.setFotosfile(new ArrayList<Miperro>());

        filedog.getFotosfile().add(new Miperro( 2, R.drawable.beto));
        filedog.getFotosfile().add(new Miperro( 5, R.drawable.beto));
        filedog.getFotosfile().add(new Miperro( 1, R.drawable.beto));
        filedog.getFotosfile().add(new Miperro( 3, R.drawable.beto));
        filedog.getFotosfile().add(new Miperro( 4, R.drawable.beto));
        filedog.getFotosfile().add(new Miperro( 5, R.drawable.beto));
        filedog.getFotosfile().add(new Miperro( 3, R.drawable.beto));
        filedog.getFotosfile().add(new Miperro( 3, R.drawable.beto));

    }
}

