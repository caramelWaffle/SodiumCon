package th.ac.cmu.camt.sodiumconqueror.manager.api.get.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Bitwarp on 7/14/2016.
 */

public class GetRootFoodArray {

    @SerializedName("result")
    GetResultArray resultArray;

    public GetResultArray getResultArray() {
        return resultArray;
    }

    public void setResultArray(GetResultArray resultArray) {
        this.resultArray = resultArray;
    }
}
