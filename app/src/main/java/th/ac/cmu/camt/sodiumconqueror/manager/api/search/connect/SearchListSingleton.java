package th.ac.cmu.camt.sodiumconqueror.manager.api.search.connect;

import android.content.Context;

import com.inthecheesefactory.thecheeselibrary.manager.Contextor;

import java.util.ArrayList;

import th.ac.cmu.camt.sodiumconqueror.manager.api.search.model.SearchFood;

/**
 * Created by nuuneoi on 11/16/2014.
 */
public class SearchListSingleton {


    ArrayList<SearchFood> food;
    private String search_status;

    private static SearchListSingleton instance;

    public static SearchListSingleton getInstance() {
        if (instance == null)
            instance = new SearchListSingleton();
        return instance;
    }

    private Context mContext;

    private SearchListSingleton() {
        mContext = Contextor.getInstance().getContext();
    }

    public ArrayList<SearchFood> getFood() {
        return food;
    }

    public void setFood(ArrayList<SearchFood> food) {
        this.food = food;
    }

    public String getSearch_status() {
        return search_status;
    }

    public void setSearch_status(String search_status) {
        this.search_status = search_status;
    }
}
