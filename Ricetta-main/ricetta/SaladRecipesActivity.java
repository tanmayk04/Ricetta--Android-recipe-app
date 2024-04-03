package com.app.ricetta;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class SaladRecipesActivity extends AppCompatActivity {
    RecipeAdapter recipeAdapter;
    private RecyclerView bfRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.salad_recipe_layout);

        DataBaseObject.connectToFiireBase();
        bfRecyclerView = findViewById(R.id.salad_recycler_view);

        DataBaseObject dataProvider = new DataBaseObject();
        List<Recipe> recipes = dataProvider.getRecipes(3);
        recipeAdapter = new RecipeAdapter(recipes, this, "Salad");
        bfRecyclerView.setAdapter(recipeAdapter);
        bfRecyclerView.setLayoutManager(
                new LinearLayoutManager(SaladRecipesActivity.this));
    }
}
