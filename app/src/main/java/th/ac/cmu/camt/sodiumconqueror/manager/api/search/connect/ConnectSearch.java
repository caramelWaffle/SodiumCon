package th.ac.cmu.camt.sodiumconqueror.manager.api.search.connect;

import android.os.AsyncTask;
import android.widget.Toast;

import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import th.ac.cmu.camt.sodiumconqueror.manager.FatSecretAPI;
import th.ac.cmu.camt.sodiumconqueror.manager.api.search.model.SearchFood;
import th.ac.cmu.camt.sodiumconqueror.manager.api.search.model.SearchFoods;
import th.ac.cmu.camt.sodiumconqueror.manager.api.search.model.SearchRootFood;
import th.ac.cmu.camt.sodiumconqueror.utils.ApiKey;

/**
 * Created by Bitwarp on 7/20/2016.
 */

public class ConnectSearch {

    private final String ERROR_MESSAGE = "There was an error in processing your request. Please try again later.";
    private final String NOT_FOUND_ERROR = "total_results\":\"0";

    public static final String CONNECT_ERROR_STATUS = "CONNECT_ERROR";
    public static final String SEARCH_NOT_FOUND = "SEARCH_NOT_FOUND";
    public static final String CONNECT_OK = "OK";

    private JSONObject search_food;
    public ArrayList<SearchFood> foods;

    SearchListSingleton searchListSingleton = SearchListSingleton.getInstance();


    public class AsyncSearch extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... foodName) {

            FatSecretAPI api = new FatSecretAPI(ApiKey.APP_KEY, ApiKey.SECRET_KEY);

            try {
                search_food = api.getFoodItems(foodName[0]);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return search_food.toString();
        }

        @Override
        protected void onPostExecute(String foodsListJSON) {
            super.onPostExecute(foodsListJSON);


            if(!foodsListJSON.contains(ERROR_MESSAGE) && !foodsListJSON.contains(NOT_FOUND_ERROR)){

                Gson gson = new Gson();
                SearchRootFood searchRootFood = gson.fromJson(foodsListJSON,SearchRootFood.class);

                SearchFoods searchFoods = searchRootFood.getResult().getFoods();
                foods = searchFoods.getFood();

                searchListSingleton.setFood(foods);
                searchListSingleton.setSearch_status(CONNECT_OK);
            }

            if(foodsListJSON.contains(NOT_FOUND_ERROR)){
                searchListSingleton.setFood(null);
                searchListSingleton.setSearch_status(SEARCH_NOT_FOUND);
            }

            if(foodsListJSON.contains(ERROR_MESSAGE)){
                searchListSingleton.setFood(null);
                searchListSingleton.setSearch_status(CONNECT_ERROR_STATUS);
            }
        }
    }


}
