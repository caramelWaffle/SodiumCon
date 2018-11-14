package th.ac.cmu.camt.sodiumconqueror.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.akexorcist.localizationactivity.LocalizationActivity;

import th.ac.cmu.camt.sodiumconqueror.R;
import th.ac.cmu.camt.sodiumconqueror.adapter.ViewPagerAdapterGeneric;
import th.ac.cmu.camt.sodiumconqueror.utils.SlidinTabLayoutGeneric;

public class GenericFoodActivity extends LocalizationActivity {
    Toolbar toolbar;
    ViewPager pager;
    ViewPagerAdapterGeneric adapter;
    SlidinTabLayoutGeneric tabs;
    CharSequence Titles[] = {"FAVOURITE","GENERIC"};
    int Numboftabs =2;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generic_food);
        innit();
    }

    private void innit() {
        if (getLanguage().equals("th")){
             Titles = new CharSequence[]{"รายการโปรด", "อาหารทั่วไป"};
        }
        toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle(getString(R.string.Generic_Food));
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        pager = (ViewPager)findViewById(R.id.pager2);
        adapter = new ViewPagerAdapterGeneric(getSupportFragmentManager(),Titles,Numboftabs);
        pager.setAdapter(adapter);
        tabs = (SlidinTabLayoutGeneric)findViewById(R.id.tabs2);
        tabs.setDistributeEvenly(true);
        tabs.setCustomTabView(R.layout.custom_tab2, 0);

        tabs.setCustomTabColorizer(new SlidinTabLayoutGeneric.TabColorizer() {
            @Override
            public int getIndicatorColor(int position) {
                return getResources().getColor(R.color.fastfoodslidetab);
            }
        });

        tabs.setViewPager(pager);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        } if(item.getItemId() == R.id.setting){

            Intent intent = new Intent(GenericFoodActivity.this,SettingActivity.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}