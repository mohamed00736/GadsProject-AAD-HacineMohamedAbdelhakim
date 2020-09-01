package com.example.hacine.mohamed_gads_project.TabFragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hacine.mohamed_gads_project.DataViewModel;
import com.example.hacine.mohamed_gads_project.R;
import com.example.hacine.mohamed_gads_project.TopLearnersAdapter;
import com.example.hacine.mohamed_gads_project.pojo.TopLearnerModel;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class TopLearnerFragment extends Fragment {

    DataViewModel viewmodel ;
    private RecyclerView recyclerView;
    public TopLearnerFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_blank_fragment2, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.toplearnrecyclerview);
        viewmodel = new ViewModelProvider(this).get(DataViewModel.class);

        viewmodel.getToplearners();

        final TopLearnersAdapter adapter = new TopLearnersAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);
        viewmodel.toplearnermutabledata.observe((LifecycleOwner) getContext(), new Observer<List<TopLearnerModel>>() {
            @Override
            public void onChanged(List<TopLearnerModel> postModels) {
                adapter.setList(postModels);
            }
        });
    }
}
