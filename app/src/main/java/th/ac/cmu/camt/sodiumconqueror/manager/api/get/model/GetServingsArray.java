package th.ac.cmu.camt.sodiumconqueror.manager.api.get.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Bitwarp on 7/14/2016.
 */

public class GetServingsArray {

    @SerializedName("serving")
    ArrayList<GetServingArray> serving;

    public ArrayList<GetServingArray> getServing() {
        return serving;
    }

    public void setServing(ArrayList<GetServingArray> serving) {
        this.serving = serving;
    }
}
