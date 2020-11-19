package com.cesar.mismascotas2.adaptador;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cesar.mismascotas2.R;
import com.cesar.mismascotas2.pojo.Miperro;

import java.util.ArrayList;

public class DogfileAdaptador extends RecyclerView.Adapter<DogfileAdaptador.DogfileViewHolder>{

        ArrayList<Miperro> listaperros;
        Activity activity;

        public DogfileAdaptador(ArrayList<Miperro> listaperros, Activity activity){
            this.listaperros=listaperros;
            this.activity=activity;
        }

        @NonNull
        @Override
        public DogfileViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_dogfile, parent, false);
            return new DogfileViewHolder(v);
        }

        @Override
        public void onBindViewHolder(@NonNull final DogfileViewHolder miperroViewHolder, int position) {
            final Miperro miperro= listaperros.get(position);
            miperroViewHolder.imgdogfilecv.setImageResource(miperro.getImagen());
            miperroViewHolder.tvLikesdog.setText(""+miperro.getRating());

        }

        @Override
        public int getItemCount() {
            return listaperros.size();
        }

        public static class DogfileViewHolder extends RecyclerView.ViewHolder{
            private ImageView imgdogfilecv;
            private TextView tvLikesdog;
            public DogfileViewHolder(@NonNull View itemView) {
                super(itemView);
                imgdogfilecv=(ImageView)itemView.findViewById(R.id.imgdogfilecv);
                tvLikesdog=(TextView)itemView.findViewById(R.id.tvLikesdog);

            }
        }
    }


