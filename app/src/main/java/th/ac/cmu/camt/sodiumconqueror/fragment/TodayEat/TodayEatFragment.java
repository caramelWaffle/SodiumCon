package th.ac.cmu.camt.sodiumconqueror.fragment.TodayEat;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import th.ac.cmu.camt.sodiumconqueror.R;
import th.ac.cmu.camt.sodiumconqueror.adapter.ToDayEatAdapter;
import th.ac.cmu.camt.sodiumconqueror.manager.db.dbHelper.DbHelper;
import th.ac.cmu.camt.sodiumconqueror.manager.db.model.TodayReport;


/**
 * Created by nuuneoi on 11/16/2014.
 */
public class TodayEatFragment extends Fragment {

    ListView listView;
    ToDayEatAdapter adapter;

    DbHelper dbHelper;
    TodayReport todayReport;

    public TodayEatFragment() {
        super();
    }

    public static TodayEatFragment newInstance() {
        TodayEatFragment fragment = new TodayEatFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_today_eat, container, false);
        initInstances(rootView);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });


        return rootView;
    }

    private void initInstances(View rootView) {
        // Init 'View' instance(s) with rootView.findViewById here

        dbHelper = new DbHelper(rootView.getContext());
        todayReport = dbHelper.getTodayReport();

        listView = (ListView)rootView.findViewById(R.id.TodayEatLisview);

        adapter = new ToDayEatAdapter(todayReport);
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
