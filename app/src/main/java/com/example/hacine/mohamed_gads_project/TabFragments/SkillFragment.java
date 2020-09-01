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
import com.example.hacine.mohamed_gads_project.SkilliqAdapter;
import com.example.hacine.mohamed_gads_project.pojo.SkillIqModel;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class SkillFragment extends Fragment {
    DataViewModel viewmodel ;
    private RecyclerView recyclerView;

    public SkillFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,  Bundle savedInstanceState) {



        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_blank, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.skilliqrecyclerview);
        viewmodel = new ViewModelProvider(this).get(DataViewModel.class);

        viewmodel.getTopSkill();

        final SkilliqAdapter adapter = new SkilliqAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);

        viewmodel.skillmutabledata.observe((LifecycleOwner) getContext(), new Observer<List<SkillIqModel>>() {
            @Override
            public void onChanged(List<SkillIqModel> postModels) {
                adapter.setList(postModels);
            }
        });
    }
}
