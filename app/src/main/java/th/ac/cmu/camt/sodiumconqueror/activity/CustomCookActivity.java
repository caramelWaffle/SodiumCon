package th.ac.cmu.camt.sodiumconqueror.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.aigestudio.wheelpicker.WheelPicker;
import com.melnykov.fab.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import th.ac.cmu.camt.sodiumconqueror.R;
import th.ac.cmu.camt.sodiumconqueror.manager.api.get.model.FoodDetail;
import th.ac.cmu.camt.sodiumconqueror.manager.db.dbHelper.DbHelper;
import th.ac.cmu.camt.sodiumconqueror.manager.db.model.MyFoodList;

public class CustomCookActivity extends AppCompatActivity {

    EditText edtFoodName;   // TODO: Wrong format
    String edtFoodNameString;


    Toolbar toolbar;
    TextView total;
    WheelPicker picker,picker2,picker3;
    FloatingActionButton fab;

    int flavouring = 500;
    int amount = 2;
    int teaspoon = 3;
    int netSoduim;

    DbHelper dbHelper;
    FoodDetail thaiHomeMadeFood;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_cook);
        init();
    }

    private void init() {
        toolbar = (Toolbar)findViewById(R.id.toolbarCustom);
        setSupportActionBar(toolbar);
        setTitle(getString(R.string.Add_food));
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        total = (TextView)findViewById(R.id.text_total) ;
        picker = (WheelPicker)findViewById(R.id.pickerMethod);
        picker.setSelectedItemPosition(2);

        edtFoodName = (EditText)findViewById(R.id.Customfoodname);  // TODO : Wrong
        edtFoodNameString = edtFoodName.getText().toString();

        dbHelper = new DbHelper(this);
        thaiHomeMadeFood = new FoodDetail();

        List<String> data = new ArrayList<>();
        data.add("เกลือ");
        data.add("น้ำปลา");
        data.add("ผงปรุงรส");
        data.add("ผงชูรส");
        data.add("ซีอิ๊วขาว");
        data.add("ซอสปรุงรส");
        data.add("ผงฝู");
        data.add("ซอยหอยนางรม");
        data.add("น้ำจิ๋มสุกี๊");
        data.add("ซอสพริก");
        data.add("น้ำจิ๋มไก่");
        data.add("ซอสมะเขือเทศ");


        picker.setData(data);
        picker.setOnItemSelectedListener(new WheelPicker.OnItemSelectedListener() {
            @Override
            public void onItemSelected(WheelPicker picker, Object data, int position) {
                if (position == 0){
                    flavouring = 2000;
                }else
                if (position == 1){
                    flavouring = 500;
                }else
                if (position == 2){
                    flavouring = 500;
                }else
                if (position == 3){
                    flavouring = 490;
                }else
                if (position == 4){
                    flavouring = 400;
                }else
                if (position == 5){
                    flavouring = 400;
                }else
                if (position == 6){
                    flavouring = 340;
                }else
                if (position == 7){
                    flavouring = 450;
                }else
                if (position == 8){
                    flavouring = 280;
                }else
                if (position == 9){
                    flavouring = 220;
                }else
                if (position == 10){
                    flavouring = 210;
                }else
                if (position == 11) {
                    flavouring = 140;
                }
                int sum = (flavouring * amount * teaspoon );
                total.setText(getString(R.string.sodium_amount)+ " " + sum + " mg");
            }
        });

        //----------------------------------------------------------------------------------------------------------
        picker2 = (WheelPicker)findViewById(R.id.pickerNumber);
        picker2.setSelectedItemPosition(2);

        List<Integer> data2 = new ArrayList<>();
        for (int i=0 ; i<101;i++){
            data2.add(i);
        }

        picker2.setData(data2);
        picker2.setOnItemSelectedListener(new WheelPicker.OnItemSelectedListener() {
            @Override
            public void onItemSelected(WheelPicker picker, Object data, int position) {
                amount = (int)data;
                int sum = (flavouring * amount * teaspoon );
                total.setText(getString(R.string.sodium_amount)+ " "  + sum + " mg");
            }
        });


        //---------------------------------------------------------------------------------------------------------

        picker3 = (WheelPicker)findViewById(R.id.pickerUnit);
        picker3.setSelectedItemPosition(1);
        List<String> data3 = new ArrayList<>();
        data3.add("ช้อนชา");
        data3.add("ช้อนโต๊ะ");
        data3.add("ถ้วยตวง");
        picker3.setData(data3);
        picker3.setOnItemSelectedListener(new WheelPicker.OnItemSelectedListener() {
            @Override
            public void onItemSelected(WheelPicker picker, Object data, int position) {
                if (position == 2){

                    teaspoon = 48;
                }else if (position == 1){

                    teaspoon = 3;
                }else if (position == 0){

                    teaspoon = 1;
                }

                int sum = (flavouring * amount * teaspoon );
                total.setText(getString(R.string.sodium_amount)+ " "  +sum + " mg");
            }
        });

        //------------------------------------------------------------------------------------------------------------





        fab = (FloatingActionButton)findViewById(R.id.fabCustom);
        fab.hide(false);

        edtFoodName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(count == start){
                    fab.hide();
                }else {
                    fab.show();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                new MaterialDialog.Builder(CustomCookActivity.this)
                        .content(getString(R.string.want_to_eat)+ " "+  edtFoodName.getText().toString() +" "+ getString(R.string.what))
                        .positiveText(R.string.ok)
                        .negativeText(R.string.cancel)
                        .onPositive(new MaterialDialog.SingleButtonCallback() {
                            @Override
                            public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {

                                netSoduim = (flavouring * amount * teaspoon );  // for you pai

                                thaiHomeMadeFood.setFoodName(edtFoodName.getText().toString());
                                thaiHomeMadeFood.setSodiumVolume(netSoduim);

                                dbHelper.insertThaiHomeMadeFoodList(thaiHomeMadeFood);

                                MyFoodList thisFood = new MyFoodList();
                                thisFood.setFoodName(thaiHomeMadeFood.getFoodName());
                                thisFood.setSodiumVolume(thaiHomeMadeFood.getSodiumVolume());
                                thisFood.setType("THAI");
                                thisFood.setFav("FALSE");
                                thisFood.setSource("HOMEMADE");

                                dbHelper.insertDiary(thisFood);

                                MainActivity.fa.finish();
                                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                                startActivity(intent);
                                finish();

                            }
                        })
                        .show();




                //Toast.makeText(CustomCookActivity.this,"Done TODO: SAVE TO DB",Toast.LENGTH_SHORT).show();
                //finish();
            }
        });




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
