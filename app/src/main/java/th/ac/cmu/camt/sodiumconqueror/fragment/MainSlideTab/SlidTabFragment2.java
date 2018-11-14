package th.ac.cmu.camt.sodiumconqueror.fragment.MainSlideTab;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import th.ac.cmu.camt.sodiumconqueror.R;
import th.ac.cmu.camt.sodiumconqueror.activity.GenericFoodActivity;
import th.ac.cmu.camt.sodiumconqueror.activity.ThaiFoodActivity;


/**
 * Created by nuuneoi on 11/16/2014.
 */
public class SlidTabFragment2 extends Fragment implements View.OnClickListener {
    RelativeLayout btn_fast;
    RelativeLayout btn_cooked;

    public SlidTabFragment2() {
        super();
    }

    public static SlidTabFragment2 newInstance() {
        SlidTabFragment2 fragment = new SlidTabFragment2();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_slide_tab2, container, false);
        initInstances(rootView);
        return rootView;
    }

    private void initInstances(View rootView) {
        // Init 'View' instance(s) with rootView.findViewById here
        btn_fast = (RelativeLayout)rootView.findViewById(R.id.btn_fast);
        btn_fast.setOnClickListener(this);

        btn_cooked = (RelativeLayout)rootView.findViewById(R.id.btn_cooked);
        btn_cooked.setOnClickListener(this);
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
        if (v == btn_fast){



            /*
            Get food detail : Get by food id
             */
//            ConnectGet connectGet = new ConnectGet();
//            ConnectGet.AsyncGet asyncGet = connectGet.new AsyncGet();
//            asyncGet.execute(60637);


            Intent intent = new Intent(getActivity(), GenericFoodActivity.class);
            startActivity(intent);

        }else
        if (v == btn_cooked){

            Intent intent = new Intent(getActivity(), ThaiFoodActivity.class);
            startActivity(intent);

        }



    }

}
