package th.ac.cmu.camt.sodiumconqueror.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;

import java.util.ArrayList;

import th.ac.cmu.camt.sodiumconqueror.R;
import th.ac.cmu.camt.sodiumconqueror.adapter.SearchAdapter.AdapterSearch;
import th.ac.cmu.camt.sodiumconqueror.manager.api.get.connect.ConnectGet;
import th.ac.cmu.camt.sodiumconqueror.manager.api.get.connect.SingletonGet;
import th.ac.cmu.camt.sodiumconqueror.manager.api.get.model.FoodDetail;
import th.ac.cmu.camt.sodiumconqueror.manager.api.search.connect.ConnectSearch;
import th.ac.cmu.camt.sodiumconqueror.manager.api.search.connect.SearchListSingleton;
import th.ac.cmu.camt.sodiumconqueror.manager.api.search.model.SearchFood;
import th.ac.cmu.camt.sodiumconqueror.manager.db.dbHelper.DbHelper;
import th.ac.cmu.camt.sodiumconqueror.manager.db.model.MyFoodList;

public class SearchActivity extends AppCompatActivity {


    SearchListSingleton searchListSingleton;
    FoodDetail foodAtPositionDetail;
    SingletonGet getSingleton;

    DbHelper dbHelper;

    ArrayList<FoodDetail> foodDetails;
    ArrayList<SearchFood> sFoods;

    ProgressDialog progressDialog;
    LinearLayout linearLayout;
    Toolbar toolbar;
    CharSequence search;
    ListView listView;
    AdapterSearch adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        innit();

    }

    @Override
    protected void onResume() {
        super.onResume();

//        ConnectGet cGet = new ConnectGet();
//        ConnectGet.AsyncGet aGet = cGet.new AsyncGet();
//        aGet.execute(5145);

        progressDialog = new ProgressDialog(SearchActivity.this);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.setMessage(getString(R.string.load));
        progressDialog.setIndeterminate(true);
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.show();

        searchListSingleton = SearchListSingleton.getInstance();
        getSingleton = SingletonGet.getInstance();

        ConnectSearch cSearch = new ConnectSearch();
        ConnectSearch.AsyncSearch aSearch = cSearch.new AsyncSearch();
        aSearch.execute(search.toString());



        new CountDownTimer(3000, 1000) {
            public void onTick(long millisUntilFinished) {
            }

            public void onFinish() {
                progressDialog.cancel();
                sFoods = searchListSingleton.getFood();


                if (sFoods != null) {
                    for (SearchFood f : sFoods) {

                        FoodDetail food = new FoodDetail();

                        food.setId(f.getFoodID());
                        food.setFoodName(f.getFoodName());

                        foodDetails.add(food);

                        listView = (ListView) findViewById(R.id.SearchList);
                        adapter = new AdapterSearch(foodDetails);
                        listView.setAdapter(adapter);

                        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, final View view, final int position, long id) {

                                new MaterialDialog.Builder(SearchActivity.this)
                                        .content(getString(R.string.add) + foodDetails.get(position).getFoodName() + getString(R.string.to_list))
                                        .positiveText(R.string.add2)
                                        .negativeText(R.string.cancel3)
                                        .onPositive(new MaterialDialog.SingleButtonCallback() {
                                            @Override
                                            public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {

                                                ConnectGet cGet = new ConnectGet();
                                                ConnectGet.AsyncGet aGet = cGet.new AsyncGet();
                                                aGet.execute(Integer.parseInt(foodDetails.get(position).getId()));

                                                progressDialog = new ProgressDialog(SearchActivity.this);
                                                progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                                                progressDialog.setMessage(getString(R.string.loading));
                                                progressDialog.setIndeterminate(true);
                                                progressDialog.setCanceledOnTouchOutside(false);
                                                progressDialog.show();



                                                new CountDownTimer(3000, 1000) {

                                                    public void onTick(long millisUntilFinished) {}

                                                    public void onFinish() {

                                                        progressDialog.cancel();

                                                        foodAtPositionDetail = getSingleton.getFoodDetail();
                                                        String genericFoodName = foodAtPositionDetail.getFoodName();

                                                        if (!dbHelper.isGenericFoodExist(foodAtPositionDetail)) {
                                                            Snackbar.make(view, "\"" + genericFoodName + "\"" + " added to list", Snackbar.LENGTH_INDEFINITE).show();
                                                            dbHelper.insertGenericFoodList(foodAtPositionDetail);
                                                            MyFoodList thisFood = new MyFoodList();

                                                            new MaterialDialog.Builder(SearchActivity.this)
                                                                    .content(getString(R.string.want_to_eat)+ " "+  genericFoodName +" "+ getString(R.string.what))
                                                                    .positiveText(R.string.ok)
                                                                    .negativeText(R.string.cancel)
                                                                    .onPositive(new MaterialDialog.SingleButtonCallback() {
                                                                        @Override
                                                                        public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {

                                                                            // ThaiFoodActivity activity = new ThaiFoodActivity();
                                                                            // activity.returnIntent();
                                                                            MyFoodList thisFood = new MyFoodList();
                                                                            thisFood.setFoodName(foodAtPositionDetail.getFoodName());
                                                                            thisFood.setSodiumVolume(foodAtPositionDetail.getSodiumVolume());
                                                                            thisFood.setType("GENERIC");
                                                                            thisFood.setFav("FALSE");
                                                                            thisFood.setSource("API");

                                                                            dbHelper.insertDiary(thisFood);

                                                                            MainActivity.fa.finish();
                                                                            Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                                                                            startActivity(intent);
                                                                            finish();

                                                                        }
                                                                    })
                                                                    .show();

                                                        } else {
                                                            Snackbar.make(view, "\"" + genericFoodName + " already existed", Snackbar.LENGTH_LONG).setAction("DISMISS", new View.OnClickListener() {
                                                                @Override
                                                                public void onClick(View v) {

                                                                }
                                                            }).show();
                                                        }
                                                    }
                                                }.start();
                                            }
                                        }).show();
                            }
                        });
                    }
                }

                if (searchListSingleton.getSearch_status().equals(ConnectSearch.CONNECT_ERROR_STATUS)) {
                    Snackbar.make(linearLayout, "Connect error, check internet connection", Snackbar.LENGTH_INDEFINITE).setAction("Retry", new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                        }
                    }).show();
                }

                if (searchListSingleton.getSearch_status().equals(ConnectSearch.SEARCH_NOT_FOUND)) {
                    Snackbar.make(linearLayout, "\"" + search + "\"" + " not found, try again", Snackbar.LENGTH_INDEFINITE).setAction("Retry", new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                        }
                    }).show();
                }

            }
        }.start();

    }


    private void innit() {

        foodDetails = new ArrayList<FoodDetail>();
        dbHelper = new DbHelper(getApplicationContext());

        linearLayout = (LinearLayout) findViewById(R.id.linearLayout);
        toolbar = (Toolbar) findViewById(R.id.toolbarSearch);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Intent intent = getIntent();
        search = intent.getCharSequenceExtra("search");
        setTitle(getString(R.string.result) + "\"" + search + "\"");


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
