package th.ac.cmu.camt.sodiumconqueror.fragment.GenericFood;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.melnykov.fab.FloatingActionButton;

import java.util.ArrayList;

import th.ac.cmu.camt.sodiumconqueror.R;
import th.ac.cmu.camt.sodiumconqueror.adapter.GenricFoodAdapter.GenericFavListViewAdapter;
import th.ac.cmu.camt.sodiumconqueror.manager.db.dbHelper.DbHelper;
import th.ac.cmu.camt.sodiumconqueror.manager.db.model.MyFoodList;


/**
 * Created by nuuneoi on 11/16/2014.
 */
public class GenericSlideTabFragment1 extends Fragment {
    ListView listView;
    GenericFavListViewAdapter adapter;
    FloatingActionButton fab;
    View view;

    DbHelper dbHelper;
    ArrayList<MyFoodList> favFoodList;



    public GenericSlideTabFragment1() {
        super();
    }

    public static GenericSlideTabFragment1 newInstance() {
        GenericSlideTabFragment1 fragment = new GenericSlideTabFragment1();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_fast_food_tab1, container, false);
        initInstances(rootView);
        return rootView;
    }

    private void initInstances(View rootView) {
        // Init 'View' instance(s) with rootView.findViewById here


        dbHelper = new DbHelper(rootView.getContext());
        favFoodList = dbHelper.getFavGenericFoodList();

        listView = (ListView)rootView.findViewById(R.id.favList);
        adapter = new GenericFavListViewAdapter(favFoodList,getContext());
        listView.setAdapter(adapter);

        view = (View)rootView.findViewById(R.id.empviewFastFav);
        listView.setEmptyView(view);

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
