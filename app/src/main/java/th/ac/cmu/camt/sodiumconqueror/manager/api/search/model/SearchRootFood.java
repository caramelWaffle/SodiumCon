package th.ac.cmu.camt.sodiumconqueror.manager.api.search.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Bitwarp on 7/5/2016.
 */

public class SearchRootFood {
    @SerializedName("result")
    SearchResult result;

    public SearchResult getResult() {
        return result;
    }

    public void setResult(SearchResult result) {
        this.result = result;
    }
}
