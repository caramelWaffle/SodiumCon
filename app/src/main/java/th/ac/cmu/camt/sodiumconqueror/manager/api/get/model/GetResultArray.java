package th.ac.cmu.camt.sodiumconqueror.manager.api.get.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Bitwarp on 7/14/2016.
 */

public class GetResultArray {

    @SerializedName("food")
    GetFoodArray foodArray;

    public GetFoodArray getFoodArray() {
        return foodArray;
    }

    public void setFoodArray(GetFoodArray foodArray) {
        this.foodArray = foodArray;
    }
}
