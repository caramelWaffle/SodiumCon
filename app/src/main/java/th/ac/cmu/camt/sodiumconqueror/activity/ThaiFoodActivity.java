package th.ac.cmu.camt.sodiumconqueror.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.akexorcist.localizationactivity.LocalizationActivity;

import th.ac.cmu.camt.sodiumconqueror.R;
import th.ac.cmu.camt.sodiumconqueror.adapter.ViewPagerAdapterThaiFood;
import th.ac.cmu.camt.sodiumconqueror.utils.SlidinTabLayoutCooked;

public class ThaiFoodActivity extends LocalizationActivity {
    Toolbar toolbar;
    ViewPager pager;
    ViewPagerAdapterThaiFood adapter;
    SlidinTabLayoutCooked tabs;
    CharSequence Titles[]={"FAVOURITE","RESTAURANT","HOMEMADE"};
    int Numboftabs =3;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cooked_food);
        innit();

    }

    private void innit() {
        if (getLanguage().equals("th")){
            Titles = new CharSequence[]{"รายการโปรด", "อาหารตามสั่ง","อาหารทำเอง"};
        }
        toolbar = (Toolbar)findViewById(R.id.toolbarCooked);
        setSupportActionBar(toolbar);
        setTitle(getString(R.string.thai_foods));
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        adapter = new ViewPagerAdapterThaiFood(getSupportFragmentManager(),Titles,Numboftabs);
        pager = (ViewPager)findViewById(R.id.pagerCooked);
        pager.setAdapter(adapter);

        tabs = (SlidinTabLayoutCooked)findViewById(R.id.tabsCooked);
        tabs.setDistributeEvenly(true);
        tabs.setCustomTabView(R.layout.custom_tab3, 0);

        tabs.setCustomTabColorizer(new SlidinTabLayoutCooked.TabColorizer() {
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

            Intent intent = new Intent(ThaiFoodActivity.this,SettingActivity.class);
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
