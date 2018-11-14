package th.ac.cmu.camt.sodiumconqueror.manager.api.get.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Bitwarp on 7/14/2016.
 */

public class GetServings {

    @SerializedName("serving")
    GetServing serving;

    public GetServing getServing() {
        return serving;
    }

    public void setServing(GetServing serving) {
        this.serving = serving;
    }
}
