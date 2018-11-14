package th.ac.cmu.camt.sodiumconqueror.fragment.Started;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import th.ac.cmu.camt.sodiumconqueror.R;
import th.ac.cmu.camt.sodiumconqueror.activity.BasicInfomation;
import th.ac.cmu.camt.sodiumconqueror.activity.TermActivity;


/**
 * Created by nuuneoi on 11/16/2014.
 */
public class StartFirstFragment extends Fragment implements View.OnClickListener {
    Button btn;
    TextView textView;

    public StartFirstFragment() {
        super();
    }

    public static StartFirstFragment newInstance() {
        StartFirstFragment fragment = new StartFirstFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_start_first, container, false);
        initInstances(rootView);
        return rootView;
    }

    private void initInstances(View rootView) {

        // Init 'View' instance(s) with rootView.findViewById here
        Typeface font = Typeface.createFromAsset(getActivity().getAssets(), "fonts/roboto.ttf");
        btn = (Button) rootView.findViewById(R.id.btn_getStarted);
        btn.setTypeface(font);
        btn.setOnClickListener(this);

        textView = (TextView)rootView.findViewById(R.id.TvTerm2);
        textView.setOnClickListener(this);
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
        if (v == btn) {
            // if button is pressed

            Intent intent = new Intent(getActivity(), BasicInfomation.class);
            startActivity(intent);

        }
        if (v == textView){
            Intent intent = new Intent(getActivity(), TermActivity.class);
            startActivity(intent);
        }
    }

}
