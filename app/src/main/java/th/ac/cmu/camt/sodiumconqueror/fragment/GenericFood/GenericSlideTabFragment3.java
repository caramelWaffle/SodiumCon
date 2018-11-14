package th.ac.cmu.camt.sodiumconqueror.fragment.GenericFood;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.text.InputType;
import android.util.Log;
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
import th.ac.cmu.camt.sodiumconqueror.activity.MainActivity;
import th.ac.cmu.camt.sodiumconqueror.activity.SearchActivity;
import th.ac.cmu.camt.sodiumconqueror.adapter.GenricFoodAdapter.GenericGenericViewAdapter;
import th.ac.cmu.camt.sodiumconqueror.manager.db.dbHelper.DbHelper;
import th.ac.cmu.camt.sodiumconqueror.manager.db.model.MyFoodList;


/**
 * Created by nuuneoi on 11/16/2014.
 */
public class GenericSlideTabFragment3 extends Fragment {

    DbHelper dbHelper;
    ArrayList<MyFoodList> genericFoodList;

    ListView listView;
    GenericGenericViewAdapter adapter;
    FloatingActionButton fab;
    CharSequence searchFood = "";
    View view;

    public GenericSlideTabFragment3() {
        super();
    }

    public static GenericSlideTabFragment3 newInstance() {
        GenericSlideTabFragment3 fragment = new GenericSlideTabFragment3();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onResume() {
        super.onResume();
        Log.i("TAG", "onResume: ");

        genericFoodList = new ArrayList<MyFoodList>();
        genericFoodList = dbHelper.getGenericFood();

        adapter = new GenericGenericViewAdapter(genericFoodList,getContext());
        listView.setAdapter(adapter);

        adapter.notifyDataSetChanged();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_fast_food_tab2, container, false);

        initInstances(rootView);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {

                new MaterialDialog.Builder(getActivity())
                        .content(getString(R.string.dwant_to_eat) +  genericFoodList.get(position).getFoodName() + getString(R.string.what))
                        .positiveText(R.string.ok2)
                        .negativeText(R.string.cancel2)
                        .onPositive(new MaterialDialog.SingleButtonCallback() {
                            @Override
                            public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {


                                MainActivity.fa.finish();
                                Intent intent = new Intent(getActivity(),MainActivity.class);
                                startActivity(intent);
                                getActivity().finish();

                                //Toast.makeText(getContext(),positions + thaiFoodList.get(positions).getFoodName(),Toast.LENGTH_SHORT).show();
                                dbHelper.insertDiary(genericFoodList.get(position));

                                String genericFoodName = genericFoodList.get(position).getFoodName();
                                Snackbar.make(fab,genericFoodName + getString(R.string.add_to_diary), Snackbar.LENGTH_SHORT).show();

                            }
                        })
                        .show();
            }
        });

        Log.i("Show", "onCreateView: ");

        return rootView;
    }




    private void initInstances(View rootView) {

        dbHelper = new DbHelper(getContext());



        // Init 'View' instance(s) with rootView.findViewById here
        listView = (ListView)rootView.findViewById(R.id.GenericList);


        view = (View)rootView.findViewById(R.id.empview2);
        listView.setEmptyView(view);

        fab = (FloatingActionButton)rootView.findViewById(R.id.fab3);
        fab.attachToListView(listView);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new MaterialDialog.Builder(getActivity())
                        .title(R.string.what_do_you_want)
                        .inputRangeRes(3, 25 , R.color.colorPrimary)
                        .inputType(InputType.TYPE_CLASS_TEXT)
                        .input(R.string.input_hint, R.string.input_prefill, new MaterialDialog.InputCallback() {
                            @Override
                            public void onInput(MaterialDialog dialog, CharSequence input) {
                                // Do something

                                    searchFood = input;
                                    //Toast.makeText(getActivity(), searchFood, Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getActivity(), SearchActivity.class);
                                intent.putExtra("search",searchFood);
                                startActivity(intent);
                            }
                        })
                        .positiveText(R.string.go)
                        .show();
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
