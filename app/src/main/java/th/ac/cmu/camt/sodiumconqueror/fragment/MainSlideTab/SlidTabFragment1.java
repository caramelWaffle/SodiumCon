package th.ac.cmu.camt.sodiumconqueror.fragment.MainSlideTab;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mikhaellopez.circularprogressbar.CircularProgressBar;

import java.text.NumberFormat;
import java.util.Locale;

import th.ac.cmu.camt.sodiumconqueror.R;
import th.ac.cmu.camt.sodiumconqueror.activity.DiaryActivity;
import th.ac.cmu.camt.sodiumconqueror.activity.MainActivity;
import th.ac.cmu.camt.sodiumconqueror.activity.ToDayEatActivity;
import th.ac.cmu.camt.sodiumconqueror.manager.db.dbHelper.DbHelper;
import th.ac.cmu.camt.sodiumconqueror.manager.db.model.TodayReport;
import th.ac.cmu.camt.sodiumconqueror.utils.DiaryUtil;


/**
 * Created by nuuneoi on 11/16/2014.
 */
public class SlidTabFragment1 extends Fragment implements View.OnClickListener {

    CircularProgressBar circularProgressBar;

    DbHelper dbHelper;
    TodayReport todayReport;
    DiaryUtil diaryUtil;

    TextView tvSodiumRemain, tvNet, tvMilli;


    LinearLayout btn_today;
    LinearLayout btn_diary;
    LinearLayout btn_eat;

    public SlidTabFragment1() {
        super();
    }

    public static SlidTabFragment1 newInstance() {
        SlidTabFragment1 fragment = new SlidTabFragment1();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_slide_tab1, container, false);

        initInstances(rootView);
        setInstance();


        return rootView;
    }

    private void initInstances(View rootView) {

        diaryUtil = new DiaryUtil();
        dbHelper = new DbHelper(getContext());

        todayReport = dbHelper.getTodayReport();

        circularProgressBar = (CircularProgressBar) rootView.findViewById(R.id.cir);

        tvSodiumRemain = (TextView) rootView.findViewById(R.id.textLeft);
        tvNet = (TextView) rootView.findViewById(R.id.tvNet);
        tvMilli = (TextView) rootView.findViewById(R.id.tvmilli);

        // Init 'View' instance(s) with rootView.findViewById here
        btn_today = (LinearLayout) rootView.findViewById(R.id.btn_today);
        btn_today.setOnClickListener(this);

        btn_diary = (LinearLayout) rootView.findViewById(R.id.btn_diary);
        btn_diary.setOnClickListener(this);

        btn_eat = (LinearLayout) rootView.findViewById(R.id.btn_eatNow);
        btn_eat.setOnClickListener(this);


    }

    private void setInstance() {

        int toDayTotal = todayReport.getTotalSodium();
        int todayRemain = diaryUtil.calTodayRemain(toDayTotal);

        float progressPercent = diaryUtil.calTodayPercent(toDayTotal);
        String remainVolume = Integer.toString(diaryUtil.calTodayRemain(toDayTotal));

        circularProgressBar.setColor(ContextCompat.getColor(getContext(), diaryUtil.getCircleColor(toDayTotal)));
        circularProgressBar.setProgress(progressPercent);

        if(diaryUtil.isOverLimit(toDayTotal)){
            tvMilli.setText("Over the limit");
            tvSodiumRemain.setTextColor(ContextCompat.getColor(getContext(),R.color.toDayDanger));
        }

        tvSodiumRemain.setText(Integer.toString(Math.abs(todayRemain)));
        tvNet.setText("Consumed " + NumberFormat.getNumberInstance(Locale.US).format(toDayTotal));

    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    /*
     * Save Instance State Here
     */
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        // Save Instance State here
    }

    /*
     * Restore Instance State Here
     */
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (savedInstanceState != null) {
            // Restore Instance State here
        }
    }

    @Override
    public void onClick(View v) {
        if (v == btn_today) {
            Intent intent = new Intent(getActivity(), ToDayEatActivity.class);
            startActivity(intent);

        }
        if (v == btn_diary) {
            Intent intent = new Intent(getActivity(), DiaryActivity.class);
            startActivity(intent);
        }
        if (v == btn_eat) {
            ((MainActivity) getActivity()).GoToFood();
        }
    }
}
