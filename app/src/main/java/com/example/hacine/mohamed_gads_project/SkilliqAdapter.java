package com.example.hacine.mohamed_gads_project;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hacine.mohamed_gads_project.pojo.SkillIqModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;


public class SkilliqAdapter extends RecyclerView.Adapter<SkilliqAdapter.PostViewHolder> {
    private List<SkillIqModel> skilllist = new ArrayList<>();
    private static final String TAG = "SkilliqAdapter";


    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PostViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.skillitem, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {


        holder.tvskillname.setText(skilllist.get(position).getName());
        holder.tvskillscore.setText(String.valueOf(skilllist.get(position).getScore())+" Skill IQ Score");
        holder.tvskillcountry.setText(skilllist.get(position).getCountry());
        Picasso.get().load(skilllist.get(position).getBadgeUrl()).into(holder.img);
        //Log.d(TAG, "Imageurl is : "+skilllist.get(position).getBadgeUrl());
    }

    @Override
    public int getItemCount() {
        return skilllist.size();
    }

    public void setList(List<SkillIqModel> list) {
        this.skilllist = list;
        notifyDataSetChanged();
    }

    public class PostViewHolder extends RecyclerView.ViewHolder {
        TextView tvskillname, tvskillscore, tvskillcountry;
        ImageView img ;
        public PostViewHolder(@NonNull View itemView) {
            super(itemView);
            img= itemView.findViewById(R.id.idskillimg2);
            tvskillname = itemView.findViewById(R.id.idskillname);
            tvskillscore = itemView.findViewById(R.id.idskillscore);
            tvskillcountry = itemView.findViewById(R.id.idskillcountry);
        }
    }
}