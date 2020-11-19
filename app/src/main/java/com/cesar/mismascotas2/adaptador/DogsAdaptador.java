package com.cesar.mismascotas2.adaptador;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cesar.mismascotas2.R;
import com.cesar.mismascotas2.pojo.Miperro;

import java.util.ArrayList;

public class DogsAdaptador extends RecyclerView.Adapter<DogsAdaptador.MiperroViewHolder>{

        ArrayList<Miperro> listaperros;
        Activity activity;

public  DogsAdaptador(ArrayList<Miperro> listaperros, Activity activity){
        this.listaperros = listaperros;
        this.activity=activity;
        }

@NonNull
@Override
public MiperroViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_miperro, parent, false);
        return new MiperroViewHolder(v);
        }

@Override
public void onBindViewHolder(@NonNull final MiperroViewHolder miperroViewHolder, int position) {
final Miperro miperro= listaperros.get(position);
        miperroViewHolder.imgDog.setImageResource(miperro.getImagen());
        miperroViewHolder.tvNombredog.setText(miperro.getNombre());
        miperroViewHolder.tvRating.setText(""+miperro.getRating());
        miperroViewHolder.btnRating.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View view) {
        Toast.makeText(activity, miperro.getNombre(), Toast.LENGTH_SHORT).show();
        miperro.setRating(miperro.getRating()+1);
        miperroViewHolder.tvRating.setText(""+miperro.getRating());
        }
        });
        }

@Override
public int getItemCount() {
        return listaperros.size();
        }

public static class MiperroViewHolder extends RecyclerView.ViewHolder{
    private ImageView imgDog;
    private ImageButton btnRating;
    private TextView tvNombredog;
    private TextView tvRating;
    public MiperroViewHolder(@NonNull View itemView) {
        super(itemView);
        imgDog=(ImageView)itemView.findViewById(R.id.imgDog);
        btnRating=(ImageButton)itemView.findViewById(R.id.btnRating);
        tvNombredog=(TextView)itemView.findViewById(R.id.tvNombredog);
        tvRating=(TextView)itemView.findViewById(R.id.tvRating);

    }
}
}


