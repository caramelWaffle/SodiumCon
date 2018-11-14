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
import th.ac.cmu.camt.sodiumconqueror.view.CustomViewGroupGenericFood;

/**
 * Created by Chart on 20/7/2559.
 */
public class GenericGenericViewAdapter extends BaseAdapter {

    ArrayList<MyFoodList> genericFoodList;

    DbHelper dbHelper;
    SQLiteDatabase sqLiteDatabase;

    CheckBox favCheckbox;

    Context mContext;

    public GenericGenericViewAdapter(ArrayList<MyFoodList> genericFoodList,Context context) {
        this.genericFoodList = genericFoodList;
        this.mContext = context;
    }

    @Override
    public int getCount() {
        return genericFoodList.size(); // num of fav
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
        CustomViewGroupGenericFood genericFood;
        if(convertView != null){

            genericFood = (CustomViewGroupGenericFood) convertView;
            return genericFood;

        }else {

            initInstance();

            final String id = genericFoodList.get(position).getId();

            genericFood = new CustomViewGroupGenericFood(parent.getContext());

            genericFood.setTvGenericFood(genericFoodList.get(position).getFoodName());
            genericFood.setTvGenericMg(Integer.toString(genericFoodList.get(position).getSodiumVolume()) +" mg");

            favCheckbox = (CheckBox)genericFood.findViewById(R.id.checkboxStarThaiFav);

            if(dbHelper.isFavourite(id)){
                favCheckbox.setChecked(true);
            }

            favCheckbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    dbHelper.updateFavFoodList(id,isChecked);
                }
            });


            return genericFood;

        }

    }

    private void initInstance(){
        dbHelper = new DbHelper(mContext);
        sqLiteDatabase = dbHelper.getWritableDatabase();
    }
}
