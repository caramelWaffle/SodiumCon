package th.ac.cmu.camt.sodiumconqueror.manager.api.get.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Bitwarp on 7/14/2016.
 */

public class GetRootFood {

    @SerializedName("result")
    GetResult result;


    public GetResult getResult() {
        return result;
    }

    public void setResult(GetResult result) {
        this.result = result;
    }

}
