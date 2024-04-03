package com.app.ricetta;

import java.util.List;

import java.util.ArrayList;

public class DataBaseObject {
    public static boolean isInited = false;
    public static List<Recipe> breakfastRecipes = new ArrayList<>();
    public static List<Recipe> lunchRecipes = new ArrayList<>();
    public static List<Recipe> dinnerRecipes = new ArrayList<>();
    public static List<Recipe> soupRecipes = new ArrayList<>();
    public static List<Recipe> saladRecipes = new ArrayList<>();
    public static List<Recipe> juiceRecipes = new ArrayList<>();

    public DataBaseObject() {

    }


    public void addRecipes() {
        int categoryId = 1;
        Recipe recipe1 = new Recipe(1,categoryId,"BananaOatBread","BananaOatBread.png", "45", 4.5f);
        Recipe recipe2 = new Recipe(2,categoryId,"BranWholeWheatMuffin","BranWholeWheatMuffin.png", "30", 4.9f);
        Recipe recipe3 = new Recipe(3,categoryId,"NoBreadSoojiToast","NoBreadSoojiToast.png", "25", 4.6f);
        Recipe recipe4 = new Recipe(4,categoryId,"OatAppleCrumble","OatAppleCrumble.png", "30", 3.8f);
        Recipe recipe5 = new Recipe(5,categoryId,"SpinachPancakes","SpinachPancakes.png", "50", 5f);

    }

    private static void addRecipesLocal() {
        int categoryId = 1;
        Recipe recipe1 = new Recipe(1,categoryId,"BananaOatBread","BananaOatBread.png", "45", 4.5f);
        Recipe recipe2 = new Recipe(2,categoryId,"BranWholeWheatMuffin","BranWholeWheatMuffin.png", "30", 4.9f);
        Recipe recipe3 = new Recipe(3,categoryId,"NoBreadSoojiToast","NoBreadSoojiToast.png", "25", 4.6f);
        Recipe recipe4 = new Recipe(4,categoryId,"OatAppleCrumble","OatAppleCrumble.png", "30", 3.8f);
        Recipe recipe5 = new Recipe(5,categoryId,"SpinachPancakes","SpinachPancakes.png", "50", 5f);

        Recipe recipe6 = new Recipe(6,categoryId,"Mushroom Soup","soup1.jpg", "45", 4.0f);
        Recipe recipe7 = new Recipe(7,categoryId,"Tomato Soup","soup2.jpg", "30", 4.2f);
        Recipe recipe8 = new Recipe(8,categoryId,"Veg Manchow Soup","soup3.jpg", "25", 4.5f);
        Recipe recipe9 = new Recipe(9,categoryId,"Sweet Corn Soup","soup4.jpg", "30", 4.8f);
        Recipe recipe10 = new Recipe(10,categoryId,"Hot Sour Soup","soup5.jpg", "50", 3.7f);

        Recipe recipe11 = new Recipe(11,categoryId,"Shredded Sprout Salad","salad1.jpg", "45", 4.1f);
        Recipe recipe12 = new Recipe(12,categoryId,"Pasta Salad","salad2.jpg", "30", 4.4f);
        Recipe recipe13 = new Recipe(13,categoryId,"Rainbow Orzo Salad","salad3.jpg", "25", 4.2f);
        Recipe recipe14 = new Recipe(14,categoryId,"Broccoli Pasta Salad","salad4.jpg", "30", 4.8f);
        Recipe recipe15 = new Recipe(15,categoryId,"Cherry Tomato Salad","salad5.jpg", "50", 4.78f);

        breakfastRecipes.add(recipe1);
        breakfastRecipes.add(recipe2);
        breakfastRecipes.add(recipe3);
        breakfastRecipes.add(recipe4);
        breakfastRecipes.add(recipe5);

        soupRecipes.add(recipe6);
        soupRecipes.add(recipe7);
        soupRecipes.add(recipe8);
        soupRecipes.add(recipe9);
        soupRecipes.add(recipe10);

        saladRecipes.add(recipe11);
        saladRecipes.add(recipe12);
        saladRecipes.add(recipe13);
        saladRecipes.add(recipe14);
        saladRecipes.add(recipe15);

    }

    public static void connectToFiireBase() {

        if (!isInited) {
            isInited = true;
            System.out.println("Generating recipes ==================>");
            addRecipesLocal();
            System.out.println("Number of recipes================? " + breakfastRecipes.size());
            /*AsyncTask.execute(new Runnable() {
                @Override
                public void run() {
                    FirebaseDBHandler.getAllRecipes();
                }
            });*/

        }
    }

    public List<Recipe> getRecipes(int categoryId) {

        if (categoryId == 1) {
            return breakfastRecipes;
        }
        else if (categoryId == 2) {
            return soupRecipes;
        }
        else{
            return saladRecipes;
        }
    }
}
