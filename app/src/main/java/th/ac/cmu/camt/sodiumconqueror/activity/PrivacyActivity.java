package th.ac.cmu.camt.sodiumconqueror.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import th.ac.cmu.camt.sodiumconqueror.R;

public class PrivacyActivity extends AppCompatActivity {
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_privacy);
        innit();
    }

    private void innit() {
        toolbar = (Toolbar)findViewById(R.id.toolbarPrivacy);
        setSupportActionBar(toolbar);
        setTitle(getString(R.string.Privacy));
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
