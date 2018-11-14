package th.ac.cmu.camt.sodiumconqueror.manager.api.search.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Bitwarp on 7/5/2016.
 */

public class SearchFood {
    @SerializedName("food_description")
    String foodDescription;

    @SerializedName("food_id")
    String foodID;

    @SerializedName("food_name")
    String foodName;

    @SerializedName("food_type")
    String foodType;

    @SerializedName("food_url")
    String foodURL;

    public String getFoodDescription() {
        return foodDescription;
    }

    public void setFoodDescription(String foodDescription) {
        this.foodDescription = foodDescription;
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

    public String getFoodType() {
        return foodType;
    }

    public void setFoodType(String foodType) {
        this.foodType = foodType;
    }

    public String getFoodURL() {
        return foodURL;
    }

    public void setFoodURL(String foodURL) {
        this.foodURL = foodURL;
    }
}
