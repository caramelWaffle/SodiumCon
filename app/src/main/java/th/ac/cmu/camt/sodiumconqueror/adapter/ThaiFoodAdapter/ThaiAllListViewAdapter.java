package th.ac.cmu.camt.sodiumconqueror.adapter.ThaiFoodAdapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

import th.ac.cmu.camt.sodiumconqueror.manager.db.model.MyFoodList;
import th.ac.cmu.camt.sodiumconqueror.view.CustomViewGroupThaiAll;

/**
 * Created by Chart on 20/7/2559.
 */
public class ThaiAllListViewAdapter extends BaseAdapter {

    ArrayList<MyFoodList> thaiHomeMadeFoodList;

    public ThaiAllListViewAdapter(ArrayList<MyFoodList> thaiHomeMadeFoodList) {
        this.thaiHomeMadeFoodList = thaiHomeMadeFoodList;
    }

    @Override
    public int getCount() {
        return thaiHomeMadeFoodList.size(); // num of all
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
        CustomViewGroupThaiAll fav;
        if(convertView != null){
            fav = (CustomViewGroupThaiAll) convertView;
            return fav;
        }else {

            String thaiHomeMadeFoodName = thaiHomeMadeFoodList.get(position).getFoodName();
            String thaiHomeMadeSodiumVolume = Integer.toString(thaiHomeMadeFoodList.get(position).getSodiumVolume()) + " mg";

            fav = new CustomViewGroupThaiAll(parent.getContext());
            fav.setTvCookedFoodall(thaiHomeMadeFoodName);
            fav.setTvFoodAllMg(thaiHomeMadeSodiumVolume);

            return fav;
        }
    }

}
