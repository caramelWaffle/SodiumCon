package th.ac.cmu.camt.sodiumconqueror.manager.api.get.model;

/**
 * Created by Bitwarp on 7/25/2016.
 */
public class FoodDetail {

    String id;
    int sodiumVolume = 0;
    String foodName;

    public int getSodiumVolume() {
        return sodiumVolume;
    }

    public void setSodiumVolume(int sodiumVolume) {
        this.sodiumVolume = sodiumVolume;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
