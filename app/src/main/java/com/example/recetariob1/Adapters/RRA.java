package com.example.recetariob1.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recetariob1.Models.Recipe;
import com.example.recetariob1.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class RRA extends RecyclerView.Adapter<RandomRecipeViewHolder>{
    Context context;
    List<Recipe> list;

    public RRA(Context context, List<Recipe> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RandomRecipeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new RandomRecipeViewHolder(LayoutInflater.from(context).inflate(R.layout.recetas_aleatorias,parent,false  ));
    }

    @Override
    public void onBindViewHolder(@NonNull RandomRecipeViewHolder holder, int position) {
        holder.textView_title.setText(list.get(position).title);
        holder.textView_title.setSelected(true);
        holder.textView_likes.setText(list.get(position).aggregateLikes+" Me gusta");
        holder.textView_platos_hechos.setText(list.get(position).servings+" Lo han hecho");
        holder.textView_tiempo_aprox.setText(list.get(position).readyInMinutes+" Tiempo aproximado de realizacion");
        Picasso.get().load(list.get(position).image).into(holder.ImageView_Comida);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
class RandomRecipeViewHolder extends RecyclerView.ViewHolder{
    CardView c_recetas_aleatorias;
    TextView textView_title,textView_platos_hechos,textView_likes,textView_tiempo_aprox;
    ImageView ImageView_Comida;

    public RandomRecipeViewHolder(@NonNull View itemView) {
        super(itemView);
        c_recetas_aleatorias = itemView.findViewById(R.id.c_recetas_aleatorias);
        textView_title = itemView.findViewById(R.id.textView_title);
        textView_platos_hechos = itemView.findViewById(R.id.textView_platos_hechos);
        textView_likes = itemView.findViewById(R.id.textView_likes);
        textView_tiempo_aprox = itemView.findViewById(R.id.textView_tiempo_aprox);
        ImageView_Comida = itemView.findViewById(R.id.ImageView_Comida);

    }
}
