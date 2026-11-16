import java.util.*;

class FoodRatings {
    HashMap<String, Integer> rating = new HashMap<>();
    HashMap<String, String> cuisine = new HashMap<>();
    HashMap<String, TreeSet<String>> list = new HashMap<>();

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        for(int i = 0; i < foods.length; i++){
            rating.put(foods[i], ratings[i]);
            cuisine.put(foods[i], cuisines[i]);

            if(!list.containsKey(cuisines[i])){
                list.put(cuisines[i], new TreeSet<>((a, b) -> {
                    int x = rating.get(a);
                    int y = rating.get(b);

                    if(x != y){
                        return y - x;
                    }
                    return a.compareTo(b);
                }));
            }
            list.get(cuisines[i]).add(foods[i]);
        }
    }

    public void changeRating(String food, int newRating) {
        String c = cuisine.get(food);
        
        list.get(c).remove(food);
        rating.put(food, newRating);
        list.get(c).add(food);
    }

    public String highestRated(String c) {
        return list.get(c).first();
    }
}
