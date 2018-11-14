package th.ac.cmu.camt.sodiumconqueror.manager.api.search.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Bitwarp on 7/5/2016.
 */

public class SearchResult {
    @SerializedName("foods")
    SearchFoods foods;

    public SearchFoods getFoods() {
        return foods;
    }

    public void setFoods(SearchFoods foods) {
        this.foods = foods;
    }
}
