package th.ac.cmu.camt.sodiumconqueror.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import th.ac.cmu.camt.sodiumconqueror.manager.db.dbHelper.DbHelper;
import th.ac.cmu.camt.sodiumconqueror.manager.db.model.TodayReport;
import th.ac.cmu.camt.sodiumconqueror.view.CustomViewGroupEatTodayList;

/**
 * Created by Chart on 19/7/2559.
 */
public class ToDayEatAdapter extends BaseAdapter {

    DbHelper dbHelper;
    TodayReport todayReport;

    public ToDayEatAdapter(TodayReport todayReport) {
        this.todayReport = todayReport;
    }

    @Override
    public int getCount() {
        return todayReport.getFoodList().size(); // num of foods today
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
        CustomViewGroupEatTodayList item;
        if (convertView != null){
            item = (CustomViewGroupEatTodayList) convertView;
        }else{
            item = new CustomViewGroupEatTodayList(parent.getContext());
            item.setTvFoodListTody(todayReport.getFoodList().get(position).getFoodName());
            item.setTvTodaySodiumVolume(Integer.toString(todayReport.getFoodList().get(position).getSodiumVolume()) +" mg");
        }
    return item;
    }
}
