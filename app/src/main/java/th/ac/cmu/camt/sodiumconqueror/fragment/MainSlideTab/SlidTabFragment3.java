package th.ac.cmu.camt.sodiumconqueror.fragment.MainSlideTab;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import th.ac.cmu.camt.sodiumconqueror.R;
import th.ac.cmu.camt.sodiumconqueror.adapter.TipAdapter.TipAdapter;


/**
 * Created by nuuneoi on 11/16/2014.
 */
public class SlidTabFragment3 extends Fragment {
    ListView listView;
    TipAdapter adapter;


    public SlidTabFragment3() {
        super();
    }

    public static SlidTabFragment3 newInstance() {
        SlidTabFragment3 fragment = new SlidTabFragment3();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_slide_tab3, container, false);
        initInstances(rootView);

        return rootView;
    }



    private void initInstances(View rootView) {
        // Init 'View' instance(s) with rootView.findViewById here
        listView = (ListView)rootView.findViewById(R.id.listTip);
        adapter = new TipAdapter();
        listView.setAdapter(adapter);
        listView.deferNotifyDataSetChanged();

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
