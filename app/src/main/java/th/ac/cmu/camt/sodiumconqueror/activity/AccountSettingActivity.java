package th.ac.cmu.camt.sodiumconqueror.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import th.ac.cmu.camt.sodiumconqueror.R;

public class AccountSettingActivity extends AppCompatActivity {
    Toolbar toolbar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_setting);
        init();
        setInnit();
    }

    private void init() {
        toolbar = (Toolbar)findViewById(R.id.toolbarAccount);
        setSupportActionBar(toolbar);
        setTitle(getString(R.string.Account_setting));
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    private void setInnit() {
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
