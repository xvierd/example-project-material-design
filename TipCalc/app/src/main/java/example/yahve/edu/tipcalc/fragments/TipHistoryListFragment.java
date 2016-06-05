package example.yahve.edu.tipcalc.fragments;


import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import example.yahve.edu.tipcalc.R;
import example.yahve.edu.tipcalc.adapters.TipAdapter;
import example.yahve.edu.tipcalc.models.TipRecord;


/**
 * A simple {@link Fragment} subclass.
 */
public class TipHistoryListFragment extends Fragment implements TipHistoryListFragmentListener {

    @Bind(R.id.recyclerView)
    RecyclerView recyclerView;

    private TipAdapter adapter;

    public TipHistoryListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_tip_history_list, container, false);
        ButterKnife.bind(this,v);
        initAdapter();
        initRecyclerView();
        return v;
    }

    private void initRecyclerView() {
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);
    }

    private void initAdapter() {
        if(adapter==null){
            adapter= new TipAdapter(getActivity().getApplicationContext(),new ArrayList<TipRecord>());
        }
    }


    @Override
    public void addToList(TipRecord record) {
        adapter.add(record);
    }

    @Override
    public void clearList() {
        adapter.clear();
    }
}
