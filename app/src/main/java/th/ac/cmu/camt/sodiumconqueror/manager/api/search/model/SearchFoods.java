package th.ac.cmu.camt.sodiumconqueror.manager.api.search.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Bitwarp on 7/5/2016.
 */

public class SearchFoods {
    @SerializedName("food")
    ArrayList<SearchFood> food;

    @SerializedName("max_results")
    int maxResults;

    @SerializedName("page_number")
    int pageNumber;

    @SerializedName("total_results")
    int totalResults;

    public ArrayList<SearchFood> getFood() {
        return food;
    }

    public void setFood(ArrayList<SearchFood> food) {
        this.food = food;
    }

    public int getMaxResults() {
        return maxResults;
    }

    public void setMaxResults(int maxResults) {
        this.maxResults = maxResults;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }
}
