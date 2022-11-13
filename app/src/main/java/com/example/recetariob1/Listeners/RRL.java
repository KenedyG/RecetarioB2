package com.example.recetariob1.Listeners;

import com.example.recetariob1.Models.RandomRecipe;

public interface RRL {
    void didFetch(RandomRecipe response, String message);
    void didError(String message);
}
