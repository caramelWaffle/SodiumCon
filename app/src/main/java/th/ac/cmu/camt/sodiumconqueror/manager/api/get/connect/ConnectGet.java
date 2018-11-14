package th.ac.cmu.camt.sodiumconqueror.manager.api.get.connect;

import android.os.AsyncTask;

import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import th.ac.cmu.camt.sodiumconqueror.manager.FatSecretAPI;
import th.ac.cmu.camt.sodiumconqueror.manager.api.get.model.FoodDetail;
import th.ac.cmu.camt.sodiumconqueror.manager.api.get.model.GetFood;
import th.ac.cmu.camt.sodiumconqueror.manager.api.get.model.GetFoodArray;
import th.ac.cmu.camt.sodiumconqueror.manager.api.get.model.GetRootFood;
import th.ac.cmu.camt.sodiumconqueror.manager.api.get.model.GetRootFoodArray;
import th.ac.cmu.camt.sodiumconqueror.manager.api.get.model.GetServing;
import th.ac.cmu.camt.sodiumconqueror.manager.api.get.model.GetServingArray;
import th.ac.cmu.camt.sodiumconqueror.manager.api.get.model.GetServings;
import th.ac.cmu.camt.sodiumconqueror.manager.api.search.model.SearchFood;
import th.ac.cmu.camt.sodiumconqueror.utils.ApiKey;

/**
 * Created by Bitwarp on 7/20/2016.
 */

public class ConnectGet {

    private JSONObject get_food;
    public ArrayList<SearchFood> foods;


    public class AsyncGet extends AsyncTask<Integer, Void, String> {

        @Override
        protected String doInBackground(Integer... foodId) {

            FatSecretAPI api = new FatSecretAPI(ApiKey.APP_KEY, ApiKey.SECRET_KEY);

            try {
                get_food = api.getFoodItem(foodId[0]);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return get_food.toString();
        }

        @Override
        protected void onPostExecute(String foodDetailJson) {
            super.onPostExecute(foodDetailJson);

            Gson gson = new Gson();
            FoodDetail foodDetail = new FoodDetail();

            if(foodDetailJson.contains("\"serving\":[")){
                GetRootFoodArray getRootFoodArray = gson.fromJson(foodDetailJson,GetRootFoodArray.class);

                GetFoodArray getFoodArray = getRootFoodArray.getResultArray().getFoodArray();
                ArrayList<GetServingArray> getServingArrays = getFoodArray.getServingsArray().getServing();

                foodDetail.setId(getRootFoodArray.getResultArray().getFoodArray().getFoodID());
                foodDetail.setFoodName(getRootFoodArray.getResultArray().getFoodArray().getFoodName());
                foodDetail.setSodiumVolume(getServingArrays.get(0).getSodium());

            }else {
                GetRootFood getRootFood = gson.fromJson(foodDetailJson, GetRootFood.class);

                GetFood getFood = getRootFood.getResult().getFood();
                GetServing getServing = getFood.getServings().getServing();

                foodDetail.setId(getFood.getFoodID());
                foodDetail.setFoodName(getFood.getFoodName());
                foodDetail.setSodiumVolume(getServing.getSodium());
            }

            SingletonGet singletonGet = SingletonGet.getInstance();
            singletonGet.setFoodDetail(foodDetail);
        }




    }


}
