package th.ac.cmu.camt.sodiumconqueror.adapter.ThaiFoodAdapter;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import java.util.ArrayList;


import th.ac.cmu.camt.sodiumconqueror.R;
import th.ac.cmu.camt.sodiumconqueror.manager.db.dbHelper.DbHelper;
import th.ac.cmu.camt.sodiumconqueror.manager.db.model.MyFoodList;
import th.ac.cmu.camt.sodiumconqueror.view.CustomViewGroupThaiFav;

/**
 * Created by Chart on 20/7/2559.
 */
public class ThaiFavListViewAdapter extends BaseAdapter {

    DbHelper dbHelper;
    SQLiteDatabase sqLiteDatabase;

    CheckBox favCheckbox;


    ArrayList<MyFoodList> checkBoxThaiFavFoodList;
    ArrayList<MyFoodList> thaiFavFoodList;

    Context mContext;

    public ThaiFavListViewAdapter(ArrayList<MyFoodList> thaiFavFoodList, Context mContext) {
        this.mContext = mContext;
        this.thaiFavFoodList = thaiFavFoodList;
    }

    private void initInstance() {
        dbHelper = new DbHelper(mContext);
        sqLiteDatabase = dbHelper.getWritableDatabase();
    }


    @Override
    public int getCount() {
        return this.thaiFavFoodList.size(); // num of fav
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
    public View getView(final int position, View convertView, final ViewGroup parent) {

        CustomViewGroupThaiFav fav;

        if (convertView != null) {

            fav = (CustomViewGroupThaiFav) convertView;
            return fav;

        } else {

            initInstance();

            final String id = thaiFavFoodList.get(position).getId();

            fav = new CustomViewGroupThaiFav(parent.getContext());
            fav.setTvCookedFoodFav(thaiFavFoodList.get(position).getFoodName());
            fav.setTvCookFavMg(Integer.toString(thaiFavFoodList.get(position).getSodiumVolume()) + " mg");

            favCheckbox = (CheckBox) fav.findViewById(R.id.checkboxStar);
            favCheckbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                    //checkBoxThaiFavFoodList = dbHelper.getFavThaiFoodList();

                    //TODO: call Function to make update favourite thai food list
                    dbHelper.updateFavFoodList(id, isChecked);

                }
            });
            return fav;
        }
    }


}
