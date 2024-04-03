package com.app.ricetta;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class SoupRecipesActivity extends AppCompatActivity {
    RecipeAdapter recipeAdapter;
    private RecyclerView bfRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.soup_recipe_layout);

        DataBaseObject.connectToFiireBase();
        bfRecyclerView = findViewById(R.id.soup_recycler_view);

        DataBaseObject dataProvider = new DataBaseObject();
        List<Recipe> recipes = dataProvider.getRecipes(2);
        recipeAdapter = new RecipeAdapter(recipes, this, "Soup");
        bfRecyclerView.setAdapter(recipeAdapter);
        bfRecyclerView.setLayoutManager(
                new LinearLayoutManager(SoupRecipesActivity.this));

    }
}
