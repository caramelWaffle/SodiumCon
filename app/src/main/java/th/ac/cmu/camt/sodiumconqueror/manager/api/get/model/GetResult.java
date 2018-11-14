package th.ac.cmu.camt.sodiumconqueror.manager.api.get.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Bitwarp on 7/14/2016.
 */

public class GetResult {

    @SerializedName("food")
    GetFood food;

    public GetFood getFood() {
        return food;
    }

    public void setFood(GetFood food) {
        this.food = food;
    }
}
