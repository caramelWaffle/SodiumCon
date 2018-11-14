package th.ac.cmu.camt.sodiumconqueror.fragment.ThaiFood;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;

import java.util.ArrayList;

import th.ac.cmu.camt.sodiumconqueror.R;
import th.ac.cmu.camt.sodiumconqueror.activity.MainActivity;
import th.ac.cmu.camt.sodiumconqueror.adapter.ThaiFoodAdapter.ThaiOrderListViewAdapter;
import th.ac.cmu.camt.sodiumconqueror.manager.db.dbHelper.DbHelper;
import th.ac.cmu.camt.sodiumconqueror.manager.db.model.MyFoodList;


/**
 * Created by nuuneoi on 11/16/2014.
 */
public class ThaiSlideTabFragment2 extends Fragment {

    RelativeLayout relativeLayout;

    DbHelper dbHelper;
    ArrayList<MyFoodList> thaiFoodList;
    int positions;
    ListView listView;
    ThaiOrderListViewAdapter adapter;

    public ThaiSlideTabFragment2() {
        super();
    }

    public static ThaiSlideTabFragment2 newInstance() {
        ThaiSlideTabFragment2 fragment = new ThaiSlideTabFragment2();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_thaifood_tab2, container, false);
        initInstances(rootView);



        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                    positions = position;
                new MaterialDialog.Builder(getActivity())
                        .content(getString(R.string.want_to_eat)+  thaiFoodList.get(position).getFoodName() + getString(R.string.what))
                        .positiveText(R.string.ok)
                        .negativeText(R.string.cancel)
                        .onPositive(new MaterialDialog.SingleButtonCallback() {
                            @Override
                            public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {

                               // ThaiFoodActivity activity = new ThaiFoodActivity();
                               // activity.returnIntent();

                                dbHelper.insertDiary(thaiFoodList.get(positions));

                                String thaiFoodListName = thaiFoodList.get(position).getFoodName();
                                Snackbar.make(relativeLayout,thaiFoodListName + " added to Diary", Snackbar.LENGTH_SHORT).show();


                                MainActivity.fa.finish();
                                Intent intent = new Intent(getActivity(),MainActivity.class);
                                startActivity(intent);
                                getActivity().finish();

                            }
                        })
                        .show();


            }
        });

        return rootView;
    }

    private void initInstances(View rootView) {

        dbHelper = new DbHelper(rootView.getContext());
        thaiFoodList = dbHelper.getThaiFood();



        // Init 'View' instance(s) with rootView.findViewById here
        relativeLayout = (RelativeLayout)rootView.findViewById(R.id.relativeLayout);
        listView = (ListView)rootView.findViewById(R.id.CookedOrderList);
        adapter = new ThaiOrderListViewAdapter(thaiFoodList,getContext());
        listView.setAdapter(adapter);
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
}
