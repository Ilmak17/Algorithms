package arrayshashing;

/*
 * LeetCode Problem 2353: Design a Food Rating System
 * Difficulty: Medium
 *
 * Problem Statement:
 * Design a food rating system that can do the following:
 * Modify the rating of a food item listed in the system.
 * Return the highest-rated food item for a type of cuisine in the system.
 * Implement the FoodRatings class:
 * FoodRatings(String[] foods, String[] cuisines, int[] ratings) Initializes the system. The food items are described by foods, cuisines and ratings, all of which have a length of n.
 * foods[i] is the name of the ith food,
 * cuisines[i] is the type of cuisine of the ith food, and
 * ratings[i] is the initial rating of the ith food.
 * void changeRating(String food, int newRating) Changes the rating of the food item with the name food.
 * String highestRated(String cuisine) Returns the name of the food item that has the highest rating for the given type of cuisine. If there is a tie, return the item with the lexicographically smaller name.
 * Note that a string x is lexicographically smaller than string y if x comes before y in dictionary order, that is, either x is a prefix of y, or if i is the first position such that x[i] != y[i], then x[i] comes before y[i] in alphabetic order.
 */


import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

class FoodItem implements Comparable<FoodItem> {
    private final String food;
    private final String cuisine;
    private int rate;

    public FoodItem(String food, String cuisine, int rate) {
        this.food = food;
        this.cuisine = cuisine;
        this.rate = rate;
    }

    public String getFood() {
        return food;
    }

    public String getCuisine() {
        return cuisine;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public int getRate() {
        return rate;
    }

    @Override
    public int compareTo(FoodItem other) {
        if (this.rate != other.getRate()) {
            return Integer.compare(other.getRate(), this.rate);
        }
        return this.food.compareTo(other.getFood());
    }
}

public class DesignFoodRatingSystem_2353 {
    private final Map<String, FoodItem> foodItems = new HashMap<>();
    private final Map<String, TreeSet<FoodItem>> cuisineFoods = new HashMap<>();

    public DesignFoodRatingSystem_2353(String[] foods, String[] cuisines, int[] ratings) {
        for (int i = 0; i < foods.length; i++) {
            FoodItem item = new FoodItem(foods[i], cuisines[i], ratings[i]);
            foodItems.put(foods[i], item);
            cuisineFoods.computeIfAbsent(cuisines[i], k -> new TreeSet<>()).add(item);
        }
    }

    public void changeRating(String food, int newRating) {
        if (!foodItems.containsKey(food)) return;

        FoodItem item = foodItems.get(food);
        TreeSet<FoodItem> set = cuisineFoods.get(item.getCuisine());

        set.remove(item);

        item.setRate(newRating);

        set.add(item);
    }

    public String highestRated(String cuisine) {
        if (!cuisineFoods.containsKey(cuisine)) {
            return null;
        }
        TreeSet<FoodItem> items = cuisineFoods.get(cuisine);

        return items.first().getFood();
    }
}
