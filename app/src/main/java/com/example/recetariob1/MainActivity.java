package com.example.recetariob1;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recetariob1.Adapters.RRA;
import com.example.recetariob1.Listeners.RRL;
import com.example.recetariob1.Models.RandomRecipe;

public class MainActivity extends AppCompatActivity {
    ProgressDialog dialog;
    Solicitudes manager;
    RRA rra;
    RecyclerView recycler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dialog = new ProgressDialog(this );
        dialog.setTitle("Carganding...");

        manager = new Solicitudes(this );
        manager.getRandomRecipes(rrl);
        dialog.show();
    }
    private final RRL rrl = new RRL() {
        @Override
        public void didFetch(RandomRecipe response, String message) {
            recycler = findViewById(R.id.recycler_random);
            recycler.setHasFixedSize(true);
            recycler.setLayoutManager(new GridLayoutManager(MainActivity.this,1 ));
            rra = new RRA(MainActivity.this,response.recipes);
            recycler.setAdapter(rra);
        }

        @Override
        public void didError(String message) {
            Toast.makeText(MainActivity.this, "message", Toast.LENGTH_SHORT).show();
        }
    };
    }