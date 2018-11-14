package th.ac.cmu.camt.sodiumconqueror.fragment.Diary;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

import th.ac.cmu.camt.sodiumconqueror.R;
import th.ac.cmu.camt.sodiumconqueror.adapter.DiaryActivityAdapter.DiaryAdapter;
import th.ac.cmu.camt.sodiumconqueror.manager.db.dbHelper.DbHelper;
import th.ac.cmu.camt.sodiumconqueror.manager.db.model.Diary;


/**
 * Created by nuuneoi on 11/16/2014.
 */
public class DiaryFragment extends Fragment {

    ArrayList<Diary> diariesReport;
    DbHelper dbHelper;

    ListView listView;
    DiaryAdapter adapter;

    public DiaryFragment() {
        super();
    }

    public static DiaryFragment newInstance() {
        DiaryFragment fragment = new DiaryFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_diary, container, false);
        initInstances(rootView);
        return rootView;
    }

    private void initInstances(View rootView) {
        // Init 'View' instance(s) with rootView.findViewById here
        dbHelper = new DbHelper(rootView.getContext());
        diariesReport = dbHelper.getDiaryReport();

        listView = (ListView)rootView.findViewById(R.id.diart_listView);

        adapter = new DiaryAdapter(diariesReport);
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
