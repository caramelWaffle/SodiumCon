package th.ac.cmu.camt.sodiumconqueror;

import android.app.Application;

import com.inthecheesefactory.thecheeselibrary.manager.Contextor;
import com.crashlytics.android.Crashlytics;
import io.fabric.sdk.android.Fabric;

/**
 * Created by Chart on 16/7/2559.
 */
public class MainApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Fabric.with(this, new Crashlytics());
        // distribute application context
        Contextor.getInstance().init(getApplicationContext());

    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }

}
