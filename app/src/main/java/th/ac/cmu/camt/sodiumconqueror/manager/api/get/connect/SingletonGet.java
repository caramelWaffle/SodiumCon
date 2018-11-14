package th.ac.cmu.camt.sodiumconqueror.manager.api.get.connect;

import android.content.Context;

import com.inthecheesefactory.thecheeselibrary.manager.Contextor;

import th.ac.cmu.camt.sodiumconqueror.manager.api.get.model.FoodDetail;

/**
 * Created by nuuneoi on 11/16/2014.
 */
public class SingletonGet {

    FoodDetail foodDetail;

    private static SingletonGet instance;

    public static SingletonGet getInstance() {
        if (instance == null)
            instance = new SingletonGet();
        return instance;
    }

    private Context mContext;

    private SingletonGet() {
        mContext = Contextor.getInstance().getContext();
    }

    public FoodDetail getFoodDetail() {
        return foodDetail;
    }

    public void setFoodDetail(FoodDetail foodDetail) {
        this.foodDetail = foodDetail;
    }
}
