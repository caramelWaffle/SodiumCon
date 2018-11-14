package th.ac.cmu.camt.sodiumconqueror.adapter.TipAdapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import th.ac.cmu.camt.sodiumconqueror.R;
import th.ac.cmu.camt.sodiumconqueror.view.CustomViewGroupTip;

/**
 * Created by Chart on 19/7/2559.
 */
public class TipAdapter extends BaseAdapter {
    int[] id = {
            R.drawable.b1,
            R.drawable.b2,
            R.drawable.b3,
            R.drawable.b4,
            R.drawable.b5,
            R.drawable.b6,
            R.drawable.b7,
            R.drawable.b8,
            R.drawable.b9,
            R.drawable.b10,
            R.drawable.b11,
            R.drawable.b12,
            R.drawable.b13,
            R.drawable.b14,
            R.drawable.b15,
            R.drawable.b16,
            R.drawable.b17,
            R.drawable.b18,
            R.drawable.b19,
            R.drawable.b20
    };


    @Override
    public int getCount() {
        return 20; // num of foods today
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
        CustomViewGroupTip item;



        if (convertView != null){
            item = (CustomViewGroupTip) convertView;
            item.setImgResource(id[position]);

        }else{
            item = new CustomViewGroupTip(parent.getContext());
            item.setImgResource(id[position]);

        }
    return item;
    }
}
