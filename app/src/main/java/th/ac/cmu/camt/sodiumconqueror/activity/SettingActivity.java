package th.ac.cmu.camt.sodiumconqueror.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.afollestad.materialdialogs.MaterialDialog;
import com.akexorcist.localizationactivity.LocalizationActivity;

import th.ac.cmu.camt.sodiumconqueror.R;

public class SettingActivity extends LocalizationActivity {
    Toolbar toolbar;
    RelativeLayout btnLang;
    TextView textView;
    String s ;
    int index;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);


        init();
        setInit();
    }

    private void init() {
        toolbar = (Toolbar)findViewById(R.id.toolbarSetting);
        btnLang = (RelativeLayout)findViewById(R.id.btn_lang);
        textView = (TextView)findViewById(R.id.tv_lang);

    }

    private void setInit() {
        setSupportActionBar(toolbar);
        setTitle(R.string.setting);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        if (getLanguage().equals("th")){
            index = 1;
            textView.setText("ภาษา");
        }else {
            index = 0;
            textView.setText("Language");
        }

        btnLang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new MaterialDialog.Builder(SettingActivity.this)
                        .title(R.string.addlang)
                        .items(R.array.lang_items)
                        .itemsCallbackSingleChoice(index, new MaterialDialog.ListCallbackSingleChoice() {
                            @Override
                            public boolean onSelection(MaterialDialog dialog, View view, int which, CharSequence text) {
                                /**
                                 * If you use alwaysCallSingleChoiceCallback(), which is discussed below,
                                 * returning false here won't allow the newly selected radio button to actually be selected.
                                 **/
                                 s = (String) text;
                                if (s.equals("English") ){
                                    setDefaultLanguage("en");
                                    setLanguage("en");
                                }else {
                                    setLanguage("th");
                                    setDefaultLanguage("th");
                                }

                               return false;
                            }
                        })
                        .positiveText(R.string.ok)
                        .show();
            }
        });
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Intent intent = new Intent(SettingActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
                return true;
        }
                return super.onOptionsItemSelected(item);

    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);

    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(SettingActivity.this,MainActivity.class);
        startActivity(intent);
        finish();
    }
}
