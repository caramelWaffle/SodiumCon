package th.ac.cmu.camt.sodiumconqueror.manager.api.get.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Bitwarp on 7/14/2016.
 */

public class GetFood {

    @SerializedName("food_id")
    String foodID;

    @SerializedName("food_name")
    String foodName;

    public GetServings getServings() {
        return servings;
    }

    public void setServings(GetServings servings) {
        this.servings = servings;
    }

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

    @SerializedName("servings")
    GetServings servings;


}
