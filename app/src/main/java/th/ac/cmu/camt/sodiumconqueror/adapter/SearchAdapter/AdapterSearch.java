package th.ac.cmu.camt.sodiumconqueror.adapter.SearchAdapter;

import android.os.CountDownTimer;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import th.ac.cmu.camt.sodiumconqueror.R;
import th.ac.cmu.camt.sodiumconqueror.manager.api.get.connect.ConnectGet;
import th.ac.cmu.camt.sodiumconqueror.manager.api.get.connect.SingletonGet;
import th.ac.cmu.camt.sodiumconqueror.manager.api.get.model.FoodDetail;
import th.ac.cmu.camt.sodiumconqueror.manager.api.search.model.SearchFood;
import th.ac.cmu.camt.sodiumconqueror.view.CustomViewGroupSearch;

/**
 * Created by Chart on 23/7/2559.
 */
public class AdapterSearch extends BaseAdapter {

    ArrayList<FoodDetail> foodDetails;

    public AdapterSearch(ArrayList<FoodDetail> foodDetails) {
        this.foodDetails = foodDetails;
    }

    @Override
    public int getCount() {
        return foodDetails.size();  // num of result
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        CustomViewGroupSearch item;

        if (convertView != null) {

            item = (CustomViewGroupSearch) convertView;
            return item;

        } else {

            String foodNameAtPosition = foodDetails.get(position).getFoodName();
            String idAtPosition = foodDetails.get(position).getId();

            item = new CustomViewGroupSearch(parent.getContext());

            item.setTvSearchFood(foodNameAtPosition);
            return item;
        }

    }

    @Override
    public int getViewTypeCount() {

        return getCount();
    }

    @Override
    public int getItemViewType(int position) {

        return position;
    }


}
