package th.ac.cmu.camt.sodiumconqueror.manager.live500api.http;

import android.content.Context;

import com.inthecheesefactory.thecheeselibrary.manager.Contextor;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by nuuneoi on 11/16/2014.
 */
public class httpManager {

    private static httpManager instance;

    public static httpManager getInstance() {
        if (instance == null)
            instance = new httpManager();
        return instance;
    }

    private Context mContext;

    private Live500ApiService service;
    private httpManager() {
        mContext = Contextor.getInstance().getContext();

        Retrofit  retrofit = new Retrofit.Builder()
                .baseUrl("http://nuuneoi.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        service = retrofit.create(Live500ApiService.class);
    }

    public Live500ApiService getService() {
        return service;
    }

}
