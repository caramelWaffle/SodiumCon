package th.ac.cmu.camt.sodiumconqueror.adapter.GenricFoodAdapter;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import java.util.ArrayList;

import th.ac.cmu.camt.sodiumconqueror.R;
import th.ac.cmu.camt.sodiumconqueror.manager.db.dbHelper.DbHelper;
import th.ac.cmu.camt.sodiumconqueror.manager.db.model.MyFoodList;
import th.ac.cmu.camt.sodiumconqueror.view.CustomViewGroupFav;

/**
 * Created by Chart on 20/7/2559.
 */
public class GenericFavListViewAdapter extends BaseAdapter {

    DbHelper dbHelper;
    SQLiteDatabase sqLiteDatabase;

    CheckBox favCheckbox;

    ArrayList<MyFoodList> favListFood;
    Context mContext;

    public GenericFavListViewAdapter(ArrayList<MyFoodList> favListFood, Context context) {
        this.favListFood = favListFood;
        this.mContext = context;
    }

    @Override
    public int getCount() {
        return favListFood.size();//favListFood.size(); // num of fav
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
        CustomViewGroupFav fav;
        if (convertView != null) {
            fav = (CustomViewGroupFav) convertView;
            return fav;
        } else {

            initInstance();

            final String id = favListFood.get(position).getId();

            fav = new CustomViewGroupFav(parent.getContext());
            fav.setTvFoodFav(favListFood.get(position).getFoodName());
            fav.setTvFoodFavMg(Integer.toString(favListFood.get(position).getSodiumVolume())+" mg");

            favCheckbox = (CheckBox)fav.findViewById(R.id.checkboxStarThaiFav);

            if(dbHelper.isFavourite(id)){
                favCheckbox.setChecked(true);
            }

            favCheckbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    dbHelper.updateFavFoodList(id,isChecked);
                }
            });

            return fav;
        }
    }

    private void initInstance() {
        dbHelper = new DbHelper(mContext);
        sqLiteDatabase = dbHelper.getWritableDatabase();
    }
}
