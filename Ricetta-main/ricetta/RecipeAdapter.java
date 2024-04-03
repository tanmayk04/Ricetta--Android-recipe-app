package com.app.ricetta;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.List;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class RecipeAdapter extends RecyclerView.Adapter<RecipeAdapter.RecipeCardView> {
    List<Recipe> recipes;
    String ASSET_URL = "file:///android_asset/";
    Context parentContext;

    public RecipeAdapter(List<Recipe> recpies, Context context, String tag) {
        this.recipes = recpies;
        System.out.println("Recipes count in adapter " + recpies.size());
        this.parentContext = context;
    }

    @Override
    public int getItemCount() {
        return recipes.size();
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @NonNull
    @Override
    public RecipeCardView onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view;
        //System.out.println("On create view holder called========> ");

        view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.recipe_row_layout, parent, false);
        return new RecipeCardView(view);
    }

    @Override
    public void onBindViewHolder(final RecipeCardView holder, final int position1) {
        //System.out.println("On bind view holder called========> ");
        int position  = holder.getAdapterPosition();
        final Recipe recipeObj = recipes.get(position);
        holder.recipeNameView.setText(recipeObj.name);
        String ratingValue = String.valueOf(recipeObj.rating) + " ratings";
        holder.ratingLabelView.setText(ratingValue);
        Picasso.get()
                .load(ASSET_URL +recipeObj.imUrl)
                .into(holder.recipeImageView, new Callback() {
                    @Override
                    public void onSuccess() {
                        holder.recipeImgDialog.setVisibility(View.GONE);
                    }
                    @Override
                    public void onError(Exception e) {
                        Log.d("Error : ", e.getMessage());
                    }
                });


        holder.favRecipeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

        holder.nutritionInfoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(parentContext, NutritionActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("chartId", recipeObj.recipeId + ".png");
                intent.putExtras(bundle);
                parentContext.startActivity(intent);
            }
        });
    }

    public class RecipeCardView extends RecyclerView.ViewHolder {
        ProgressBar recipeImgDialog;
        CardView recipeCardView;
        TextView nutritionInfoBtn;
        TextView ratingLabelView;
        TextView favRecipeBtn;
        ImageView recipeImageView;
        TextView recipeNameView;

        public RecipeCardView(@NonNull View view) {
            super(view);
            nutritionInfoBtn = view.findViewById(R.id.btn_nutrition_info);

            recipeImgDialog = view.findViewById(R.id.progressbar_attr_recipe);
            recipeCardView = view.findViewById(R.id.recipe_card_layout);
            ratingLabelView = view.findViewById(R.id.rating_label);
            favRecipeBtn = view.findViewById(R.id.btn_fav_recipe);
            recipeImageView = view.findViewById(R.id.recipe_image_attr);
            recipeNameView = view.findViewById(R.id.recipe_name);

        }
    }
}
