package th.ac.cmu.camt.sodiumconqueror.adapter.ThaiFoodAdapter;

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
import th.ac.cmu.camt.sodiumconqueror.view.CustomViewGroupThaiOrder;

/**
 * Created by Chart on 20/7/2559.
 */
public class ThaiOrderListViewAdapter extends BaseAdapter {

    DbHelper dbHelper;
    SQLiteDatabase sqLiteDatabase;

    CheckBox favCheckbox;


    ArrayList<MyFoodList> thaiFoodList;
    ArrayList<MyFoodList> checkBoxThaiFavFoodList;


    Context mContext;

    public ThaiOrderListViewAdapter(ArrayList<MyFoodList> thaiFoodList,Context mContext) {
        this.thaiFoodList = thaiFoodList;
        this.mContext = mContext;
    }

    private void initInstance(){
        dbHelper = new DbHelper(mContext);
        sqLiteDatabase = dbHelper.getWritableDatabase();
    }

    @Override
    public int getCount() {
        return this.thaiFoodList.size(); // num of fav
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
    public View getView(final int position, View convertView, ViewGroup parent) {

        CustomViewGroupThaiOrder fav;

        if(convertView != null){
            fav = (CustomViewGroupThaiOrder) convertView;
            return fav;
        }else {

            initInstance();

            final String id = thaiFoodList.get(position).getId();
            final String foodNameAtPosition = thaiFoodList.get(position).getFoodName();
            String sodiumVolumeAtPosition = Integer.toString(thaiFoodList.get(position).getSodiumVolume())+" mg";

            fav = new CustomViewGroupThaiOrder(parent.getContext());

            fav.setTvCookedFoodall(foodNameAtPosition);
            fav.setTvFoodAllMg(sodiumVolumeAtPosition);

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

    @Override
    public int getViewTypeCount() {

        return getCount();
    }

    @Override
    public int getItemViewType(int position) {

        return position;
    }
}
