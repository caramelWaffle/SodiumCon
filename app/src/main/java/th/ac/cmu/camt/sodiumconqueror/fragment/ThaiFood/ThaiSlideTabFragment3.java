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

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.melnykov.fab.FloatingActionButton;

import java.util.ArrayList;

import th.ac.cmu.camt.sodiumconqueror.R;
import th.ac.cmu.camt.sodiumconqueror.activity.CustomCookActivity;
import th.ac.cmu.camt.sodiumconqueror.activity.MainActivity;
import th.ac.cmu.camt.sodiumconqueror.adapter.ThaiFoodAdapter.ThaiAllListViewAdapter;
import th.ac.cmu.camt.sodiumconqueror.manager.db.dbHelper.DbHelper;
import th.ac.cmu.camt.sodiumconqueror.manager.db.model.MyFoodList;


/**
 * Created by nuuneoi on 11/16/2014.
 */
public class ThaiSlideTabFragment3 extends Fragment {


    ListView listView;
    ThaiAllListViewAdapter adapter;
    FloatingActionButton fab;
    View emptry;

    DbHelper dbHelper;
    ArrayList<MyFoodList> thaiHomeMadeFoodList;


    public ThaiSlideTabFragment3() {
        super();
    }

    public static ThaiSlideTabFragment3 newInstance() {
        ThaiSlideTabFragment3 fragment = new ThaiSlideTabFragment3();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_thaifood_tab3, container, false);
        initInstances(rootView);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {

                final MyFoodList food = thaiHomeMadeFoodList.get(position);


                new MaterialDialog.Builder(getActivity())
                        .content(getString(R.string.want_to_eat) +  food.getFoodName() + getString(R.string.what))
                        .positiveText(R.string.ok)
                        .negativeText(R.string.cancel)
                        .onPositive(new MaterialDialog.SingleButtonCallback() {
                            @Override
                            public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {

                                dbHelper.insertDiary(food);

                                String foodName = food.getFoodName();
                                Snackbar.make(fab,foodName + " added to diary", Snackbar.LENGTH_SHORT).show();

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

    @Override
    public void onResume() {
        super.onResume();

        dbHelper = new DbHelper(getContext());
        thaiHomeMadeFoodList = dbHelper.getThaiHomeMadeFoodList();

        adapter = new ThaiAllListViewAdapter(thaiHomeMadeFoodList);
        listView.setAdapter(adapter);

        adapter.notifyDataSetChanged();
    }

    private void initInstances(View rootView) {

        // Init 'View' instance(s) with rootView.findViewById here

        listView = (ListView)rootView.findViewById(R.id.CookedAllList);
        emptry = (View)rootView.findViewById(R.id.empview);
        listView.setEmptyView(emptry);

        fab = (FloatingActionButton)rootView.findViewById(R.id.fabCooked);
        fab.attachToListView(listView);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), CustomCookActivity.class);
                startActivity(intent);
            }
        });
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
