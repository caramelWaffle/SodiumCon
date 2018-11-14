package th.ac.cmu.camt.sodiumconqueror.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.Random;

import de.hdodenhof.circleimageview.CircleImageView;
import th.ac.cmu.camt.sodiumconqueror.R;
import th.ac.cmu.camt.sodiumconqueror.adapter.ViewPagerAdapte;
import th.ac.cmu.camt.sodiumconqueror.manager.db.dbHelper.DbHelper;
import th.ac.cmu.camt.sodiumconqueror.manager.db.model.User;
import th.ac.cmu.camt.sodiumconqueror.utils.SlidingTabLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    User user;
    DbHelper dbHelper;
    TextView tvUsername;
    String userName;

    public static MainActivity fa;
    String url;
    RelativeLayout btns1, btns2, btns3, btns5, btns6;
    String imgUrl;
    ImageView imageView;
    Toolbar toolbar;
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;
    int positionx;
    int back = 0;
    ViewPager pager;
    ViewPagerAdapte adapter;
    SlidingTabLayout tabs;
    CharSequence Titles[] = {"TAB1", "Events", "tab3eie", "tab4riri"};  // not in use <ICON insteaded>
    int Numboftabs = 4;
    CircleImageView circleImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fa = this;
        InnitInstances();
        setInstance();
    }

    private void InnitInstances() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle(R.string.app_name);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        actionBarDrawerToggle = new ActionBarDrawerToggle(
                MainActivity.this,
                drawerLayout,
                R.string.openDrawer,
                R.string.closeDrawer
        );

        tvUsername = (TextView) findViewById(R.id.drawe_name);
        dbHelper = new DbHelper(this);

        drawerLayout.setDrawerListener(actionBarDrawerToggle);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        // Creating The ViewPagerAdapter and Passing Fragment Manager, Titles fot the Tabs and Number Of Tabs.
        adapter = new ViewPagerAdapte(getSupportFragmentManager(), Titles, Numboftabs);
        pager = (ViewPager) findViewById(R.id.pager);
        pager.setAdapter(adapter);
        tabs = (SlidingTabLayout) findViewById(R.id.tab);
        tabs.setDistributeEvenly(true);
        tabs.setCustomTabView(R.layout.custom_tab, 0);

        // Setting Custom Color for the Scroll bar indicator of the Tab View
        tabs.setCustomTabColorizer(new SlidingTabLayout.TabColorizer() {
            @Override
            public int getIndicatorColor(int position) {
                //slide color
                return getResources().getColor(R.color.colorPrimary);
            }
        });

        // Setting the ViewPager For the SlidingTabsLayout
        tabs.setViewPager(pager);

        imageView = (ImageView) findViewById(R.id.drawerImg);


        Random rand = new Random();
        int n = rand.nextInt(9);
        switch (n) {
            case 0:
                url = "http://becteroradio.com/2011/uploads/news/3556.jpg";
                break;
            case 1:
                url = "http://www.vidafit.com/wp-content/uploads/2014/09/nutritious.png";
                break;
            case 2:
                url = "http://thebalancedlifeonline.com/wp-content/uploads/2014/10/Wild-Rice.jpg";
                break;
            case 3:
                url = "http://d1ujpofy5vmb70.cloudfront.net/wp-content/uploads/featured_image/CrabLouisSalad_article.jpg";
                break;
            case 4:
                url = "http://d1ujpofy5vmb70.cloudfront.net/wp-content/uploads/2013/06/ChickenWithPeanutSauce.jpg";
                break;
            case 5:
                url = "http://d1ujpofy5vmb70.cloudfront.net/wp-content/uploads/featured_image/HoneyCranberryChicken_article.jpg";
                break;
            case 6:
                url = "https://s3-ap-southeast-1.amazonaws.com/photo.wongnai.com/photos/2015/11/30/8dc4a691b820415e8fe6c17f3679bd37.jpg";
                break;
            case 7:
                url = "https://www.samitivejhospitals.com/th/wp-content/uploads/sites/2/2015/04/cleanfood.jpg";
                break;
            case 8:
                url = "http://d1ujpofy5vmb70.cloudfront.net/wp-content/uploads/2013/06/ChickenWithPeanutSauce.jpg";
                break;
            case 9:
                url = "https://i.ytimg.com/vi/FSHrFiwzYvc/maxresdefault.jpg";
                break;
        }


        Glide.with(MainActivity.this)
                .load(url)
                //   .load("https://scontent.fbkk11-1.fna.fbcdn.net/v/t1.0-9/10616276_10203316753940904_4414348131513879475_n.jpg?oh=9c9ff21b6853706e49a33363dbe25b97&oe=57E8AA92")
                .error(R.drawable.drawer_top)
                .into(imageView);


        btns1 = (RelativeLayout) findViewById(R.id.row1);
        btns1.setOnClickListener(this);
        btns2 = (RelativeLayout) findViewById(R.id.row2);
        btns2.setOnClickListener(this);
        btns3 = (RelativeLayout) findViewById(R.id.row3);
        btns3.setOnClickListener(this);
        btns5 = (RelativeLayout) findViewById(R.id.row5);
        btns5.setOnClickListener(this);
        btns6 = (RelativeLayout) findViewById(R.id.row6);
        btns6.setOnClickListener(this);


        circleImageView = (CircleImageView) findViewById(R.id.profile_image);
        circleImageView.setOnClickListener(this);

    }


    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        actionBarDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        actionBarDrawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        } else if (item.getItemId() == R.id.setting) {

            Intent intent = new Intent(MainActivity.this, SettingActivity.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        if (back == 0) {
            Toast.makeText(MainActivity.this, "Press back again to exit", Toast.LENGTH_SHORT).show();
            back++;
            new CountDownTimer(3000, 1000) {

                public void onTick(long millisUntilFinished) {
                    //Nothing here
                }

                public void onFinish() {
                    // redirect
                    back = 0;
                }

            }.start();
        } else {
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_HOME);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);

        return true;
    }

    public void GoToFood() {
        tabs.mViewPager.setCurrentItem(1);
    }

    private void setInstance() {

        user = dbHelper.getUser();

        if(user.getName() != null){
            userName = user.getName();
        }else {
            userName = "";
        }

        tvUsername.setText(userName);
    }

    @Override
    public void onClick(View v) {
        if (v == btns1) {
            Intent intent = new Intent(MainActivity.this, HealInfomationActivity.class);
            startActivity(intent);
        } else if (v == btns2) {
            int reqcode = 100;
            int from = 100;
            Intent intent = new Intent(MainActivity.this, BasicInfomation.class);
            intent.putExtra("from", from);
            startActivityForResult(intent, reqcode);
        } else if (v == btns3) {
            Intent intent = new Intent(MainActivity.this, TutorialActivity.class);
            startActivity(intent);
        } else if (v == btns5) {
            Intent intent = new Intent(MainActivity.this, AboutActivity.class);
            startActivity(intent);
        } else if (v == btns6) {
            Intent intent = new Intent(MainActivity.this, SettingActivity.class);
            startActivity(intent);
        } else if (v == circleImageView) {
            // Toast.makeText(MainActivity.this,"Not Available nowsss",Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MainActivity.this, AccountSettingActivity.class);
            startActivity(intent);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100) {
            if (resultCode == RESULT_OK) {
                Toast.makeText(MainActivity.this, "DONEEEEE", Toast.LENGTH_LONG).show();
            }

        }
    }


}
