package th.ac.cmu.camt.sodiumconqueror.manager.api.get.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Bitwarp on 7/14/2016.
 */

public class GetFoodArray {

    @SerializedName("food_id")
    String foodID;

    @SerializedName("food_name")
    String foodName;

    @SerializedName("servings")
    GetServingsArray servingsArray;

    public String getFoodID() {
        return foodID;
    }

    public void setFoodID(String foodID) {
        this.foodID = foodID;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public GetServingsArray getServingsArray() {
        return servingsArray;
    }

    public void setServingsArray(GetServingsArray servingsArray) {
        this.servingsArray = servingsArray;
    }
}
