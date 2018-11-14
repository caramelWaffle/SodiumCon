package th.ac.cmu.camt.sodiumconqueror.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ProgressBar;
import android.widget.TextView;

import th.ac.cmu.camt.sodiumconqueror.R;
import th.ac.cmu.camt.sodiumconqueror.fragment.TodayEat.TodayEatFragment;
import th.ac.cmu.camt.sodiumconqueror.manager.db.dbHelper.DbHelper;
import th.ac.cmu.camt.sodiumconqueror.manager.db.model.TodayReport;
import th.ac.cmu.camt.sodiumconqueror.utils.DiaryUtil;

public class ToDayEatActivity extends AppCompatActivity {

    DiaryUtil diaryUtil;

    DbHelper dbHelper;
    TodayReport todayReport;

    Toolbar toolbar;
    ProgressBar progressBar;

    TextView tvNumber;

    int todayTotal = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_day_eat);
        innitinstances();

        todayTotal = todayReport.getTotalSodium();
        tvNumber.setText(todayTotal+ " mg");

        progressBar.setProgress((int)diaryUtil.calTodayPercent(todayTotal));

    }

    private void innitinstances() {

        diaryUtil = new DiaryUtil();

        tvNumber = (TextView)findViewById(R.id.Number);
        dbHelper = new DbHelper(getApplicationContext());

        if(dbHelper.getDiaryReport() != null){
            todayReport = dbHelper.getTodayReport();
        }


        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle(getString(R.string.Todat_eat));

        progressBar = (ProgressBar)findViewById(R.id.ProgressBar);


        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        getSupportFragmentManager().beginTransaction()
                .add(R.id.TodayEatContent, TodayEatFragment.newInstance())
                .commit();


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }


}
