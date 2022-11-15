package com.example.recetariob1;

import android.content.Context;

import com.example.recetariob1.Listeners.RRL;
import com.example.recetariob1.Models.RandomRecipe;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public class Solicitudes {
    Context context;
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://api.spoonacular.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public Solicitudes(Context context) {
        this.context = context;
    }

    public void getRandomRecipes(RRL listener) {
        RecetaAleatoria recetaAleatoria = retrofit.create(RecetaAleatoria.class);
        Call<RandomRecipe> call = recetaAleatoria.callRandomRecipe(context.getString(R.string.api_key), "10");
        call.enqueue(new Callback<RandomRecipe>() {
            @Override
            public void onResponse(Call<RandomRecipe> call, Response<RandomRecipe> response) {
                if (!response.isSuccessful()){
                    listener.didError(response.message());
                    return;
                }
                listener.didFetch(response.body(), response.message());
            }

            @Override
            public void onFailure(Call<RandomRecipe> call, Throwable t) {
                listener.didError(t.getMessage());
            }
        });
    }

    private interface RecetaAleatoria {
        @GET("recipes/random")
        Call<RandomRecipe> callRandomRecipe(
                @Query("apiKey") String apiKey,
                @Query("number") String number
        );
    }
}
