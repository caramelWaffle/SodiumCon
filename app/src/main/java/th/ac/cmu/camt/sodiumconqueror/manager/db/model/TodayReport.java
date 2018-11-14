package th.ac.cmu.camt.sodiumconqueror.manager.db.model;

import java.util.ArrayList;

/**
 * Created by Bitwarp on 7/23/2016.
 */
public class TodayReport {

    int totalSodium;
    ArrayList<Diary> foodList;


    public int getTotalSodium() {
        return totalSodium;
    }

    public void setTotalSodium(int totalSodium) {
        this.totalSodium = totalSodium;
    }

    public ArrayList<Diary> getFoodList() {
        return foodList;
    }

    public void setFoodList(ArrayList<Diary> foodList) {
        this.foodList = foodList;
    }
}
