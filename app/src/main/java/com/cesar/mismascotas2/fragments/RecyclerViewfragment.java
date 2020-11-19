package com.cesar.mismascotas2.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.cesar.mismascotas2.R;
import com.cesar.mismascotas2.adaptador.DogsAdaptador;
import com.cesar.mismascotas2.pojo.Miperro;

import java.util.ArrayList;

public class RecyclerViewfragment extends Fragment {

    ArrayList<Miperro> listaMisperros;
    private RecyclerView recyclerView;
    public DogsAdaptador adaptador;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.fragment_recycler_view, container,false);
        /* return super.onCreateView(inflater, container, savedInstanceState);*/
        recyclerView = v.findViewById(R.id.rvMisperros);
        LinearLayoutManager lm = new LinearLayoutManager(getContext());
        lm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(lm);
        obtenerlistaMisperros();
        inicializarAdaptador();

        return v;
    }

    public void inicializarAdaptador() {
        adaptador = new DogsAdaptador(listaMisperros, getActivity());
        recyclerView.setAdapter(adaptador);
    }
    public void obtenerlistaMisperros() {
        listaMisperros = new ArrayList<>();
        listaMisperros.add(new Miperro("Sabueso", 7, R.drawable.dogbaby_119594_9));
        listaMisperros.add(new Miperro("Beto", 1, R.drawable.beto));
        listaMisperros.add(new Miperro("Cooter", 6, R.drawable.cooter_9));
        listaMisperros.add(new Miperro("Duncan", 5, R.drawable.duncan_9));
        listaMisperros.add(new Miperro("Fido", 2, R.drawable.fido_9));
        listaMisperros.add(new Miperro("Lenon", 3, R.drawable.lenon_9));
        listaMisperros.add(new Miperro("Tony", 4, R.drawable.tony_9));
    }
}
