package th.ac.cmu.camt.sodiumconqueror.utils;

import th.ac.cmu.camt.sodiumconqueror.R;

/**
 * Created by Bitwarp on 7/23/2016.
 */
public class DiaryUtil {

    public static final int SODIUM_LIMIT = 2400;



    public float calTodayPercent(int sodiumVolume){

        float percent;

        percent = (sodiumVolume*100)/2400;

        return percent;
    }

    public int calTodayRemain(int sodiumVolume){

        int remain;
        remain = 2400 - sodiumVolume;

        return remain;
    }

    public int getCircleColor(int sodiumVolume){

        if(sodiumVolume > 2400){
            return R.color.toDayDanger;
        }else if(sodiumVolume > 1500){
            return R.color.toDayWarning;
        }else
            return R.color.todaySafe;
    }

    public boolean isOverLimit(int sodiumVolume){
        if(sodiumVolume > SODIUM_LIMIT){
            return true;
        }else
            return false;
    }



}
