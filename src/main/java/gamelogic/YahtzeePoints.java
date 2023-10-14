package gamelogic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class YahtzeePoints {
    enum Categories {
        ONES,
        TWOS,
        THREES,
        FOURS,
        FIVES,
        SIXES,
        THREE_OF_A_KIND,
        FOUR_OF_A_KIND,
        FULL_HOUSE,
        SMALL_STRAIGHT,
        LARGE_STRAIGHT,
        YAHTZEE,
        CHANCE,
        TOTAL,
        BONUS
    }
    private Map<Categories, Integer> categories;

    public YahtzeePoints() {
        categories = new HashMap<>();
        categories.put(Categories.ONES, 0);
        categories.put(Categories.TWOS, 0);
        categories.put(Categories.THREES, 0);
        categories.put(Categories.FOURS, 0);
        categories.put(Categories.FIVES, 0);
        categories.put(Categories.SIXES, 0);
        categories.put(Categories.THREE_OF_A_KIND, 0);
        categories.put(Categories.FOUR_OF_A_KIND, 0);
        categories.put(Categories.FULL_HOUSE, 0);
        categories.put(Categories.SMALL_STRAIGHT, 0);
        categories.put(Categories.LARGE_STRAIGHT, 0);
        categories.put(Categories.YAHTZEE, 0);
        categories.put(Categories.CHANCE, 0);
        categories.put(Categories.TOTAL, 0);
        categories.put(Categories.BONUS, 0);
    }
    public int getPoints(String category) {
        return categories.getOrDefault(category, 0);
    }
    public void setPoints(Categories category, int points) {
        categories.put(category, points);
    }
    public void getAllPoints() {
        for (Map.Entry<Categories, Integer> entry : categories.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
    public void checkPossibilities(ArrayList<Die> dice){
        int[] diceValues = new int[6];
        for(Die die : dice){
            diceValues[die.getValue()-1]++;
        }
        for (int diceValue : diceValues) {
            if (diceValue == 1) {
                categories.put(Categories.ONES, categories.get(Categories.ONES) + 1);
            } else if (diceValue == 2) {
                categories.put(Categories.TWOS, categories.get(Categories.TWOS) + 2);
            } else if (diceValue == 3) {
                categories.put(Categories.THREES, categories.get(Categories.THREES) + 3);
            } else if (diceValue == 4) {
                categories.put(Categories.FOURS, categories.get(Categories.FOURS) + 4);
            } else if (diceValue == 5) {
                categories.put(Categories.FIVES, categories.get(Categories.FIVES) + 5);
            } else if (diceValue == 6) {
                categories.put(Categories.SIXES, categories.get(Categories.SIXES) + 6);
            }
        }
        if(diceValues[0] >= 3 || diceValues[1] >= 3 || diceValues[2] >= 3 || diceValues[3] >= 3 || diceValues[4] >= 3 || diceValues[5] >= 3){
            for(Die die : dice){
                categories.put(Categories.THREE_OF_A_KIND, categories.get(Categories.THREE_OF_A_KIND) + die.getValue());
            }
        }
        if(diceValues[0] >= 4 || diceValues[1] >= 4 || diceValues[2] >= 4 || diceValues[3] >= 4 || diceValues[4] >= 4 || diceValues[5] >= 4){
            for(Die die : dice){
                categories.put(Categories.FOUR_OF_A_KIND, categories.get(Categories.FOUR_OF_A_KIND) + die.getValue());
            }
        }

        // Full house
        // Small straight
        // Large straight
        // Yahtzee
        // Chance
    }
}
