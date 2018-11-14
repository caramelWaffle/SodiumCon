package th.ac.cmu.camt.sodiumconqueror.adapter.DiaryActivityAdapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

import th.ac.cmu.camt.sodiumconqueror.manager.db.model.Diary;
import th.ac.cmu.camt.sodiumconqueror.view.CustomViewGroupDiary;
import th.ac.cmu.camt.sodiumconqueror.view.CustomViewGroupEatTodayList;

/**
 * Created by Chart on 19/7/2559.
 */
public class DiaryAdapter extends BaseAdapter {

    ArrayList<Diary> reportDiary;

    public DiaryAdapter(ArrayList<Diary> reportDiary) {
        this.reportDiary = reportDiary;
    }

    @Override
    public int getCount() {
        return reportDiary.size(); // num of foods today
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
        CustomViewGroupDiary item;
        if (convertView != null){
            item = (CustomViewGroupDiary) convertView;
        }else{
            item = new CustomViewGroupDiary(parent.getContext());

            item.setTvDate(reportDiary.get(position).getDate());
            item.setTvSoidumVol(Integer.toString(reportDiary.get(position).getSodiumVolume()) + "mg");
        }
    return item;
    }
}
