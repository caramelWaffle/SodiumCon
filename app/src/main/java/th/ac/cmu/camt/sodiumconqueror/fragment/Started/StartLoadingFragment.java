package th.ac.cmu.camt.sodiumconqueror.fragment.Started;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import th.ac.cmu.camt.sodiumconqueror.R;


/**
 * Created by nuuneoi on 11/16/2014.
 */
public class StartLoadingFragment extends Fragment {
    TextView logoText1;
    TextView logoText2;
    TextView logoText3;

    public StartLoadingFragment() {
        super();
    }

    public static StartLoadingFragment newInstance() {
        StartLoadingFragment fragment = new StartLoadingFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_start_loading, container, false);
        initInstances(rootView);
        return rootView;
    }

    private void initInstances(View rootView) {
        Typeface font = Typeface.createFromAsset(getActivity().getAssets(), "fonts/roboto.ttf");
        // Init 'View' instance(s) with rootView.findViewById here

        // set custom fonts


        logoText1 = (TextView)rootView.findViewById(R.id.LogoFont);
        logoText1.setTypeface(font);

        logoText2 = (TextView)rootView.findViewById(R.id.LogoFont3);
        logoText2.setTypeface(font);

        logoText3 = (TextView)rootView.findViewById(R.id.LogoFont4);
        logoText3.setTypeface(font);
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
