package th.ac.cmu.camt.sodiumconqueror.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.CountDownTimer;

import com.akexorcist.localizationactivity.LocalizationActivity;

import th.ac.cmu.camt.sodiumconqueror.R;
import th.ac.cmu.camt.sodiumconqueror.fragment.Started.StartFirstFragment;
import th.ac.cmu.camt.sodiumconqueror.fragment.Started.StartLoadingFragment;
import th.ac.cmu.camt.sodiumconqueror.manager.db.dbHelper.DbHelper;

public class StartActivity extends LocalizationActivity {

    DbHelper dbHelper;
    SQLiteDatabase mDb;
    String s ;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        s = getLanguage();
        setLanguage(s);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        innit();
        initDatabase();


    }

    private void innit() {
        final String PREFS_NAME = "MyPrefsFile";

        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);


        if (settings.getBoolean("my_first_time", true)) {
            //the app is being launched for first time, do something
            //Toast.makeText(StartActivity.this,"First Time",Toast.LENGTH_LONG).show();

            // first time task



            getSupportFragmentManager().beginTransaction()
                    .add(R.id.StartContainer, StartFirstFragment.newInstance())
                    .commit();






        }else {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.StartContainer, StartLoadingFragment.newInstance())
                    .commit();

            //Count Time
            new CountDownTimer(2000, 1000) {

                public void onTick(long millisUntilFinished) {
                    //Nothing here
                }

                public void onFinish() {
                    // redirect
                    initDatabase();
                    Intent intent = new Intent(StartActivity.this,MainActivity.class);
                    startActivity(intent);
                    finish();
                }

            }.start();
        }


    }

    private void initDatabase(){
        dbHelper = new DbHelper(this);
        mDb = dbHelper.getWritableDatabase();
    }



}
