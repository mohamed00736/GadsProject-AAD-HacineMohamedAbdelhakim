package com.example.hacine.mohamed_gads_project;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hacine.mohamed_gads_project.pojo.TopLearnerModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;


public class TopLearnersAdapter extends RecyclerView.Adapter<TopLearnersAdapter.learnerViewHolder> {
    private List<TopLearnerModel> toplearnerlist = new ArrayList<>();

    @NonNull
    @Override
    public learnerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new learnerViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.toplearneritem, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull learnerViewHolder holder, int position) {


        holder.tvlearnname.setText(toplearnerlist.get(position).getName());
        holder.tvskillhours.setText(String.valueOf(toplearnerlist.get(position).getHours())+" Learning hours");
        holder.tvlearncountry.setText(toplearnerlist.get(position).getCountry());
        Picasso.get().load(toplearnerlist.get(position).getBadgeUrl()).fit().centerCrop().into(holder.img2);
    }

    @Override
    public int getItemCount() {
        return toplearnerlist.size();
    }

    public void setList(List<TopLearnerModel> list) {
        this.toplearnerlist = list;
        notifyDataSetChanged();
    }

    public class learnerViewHolder extends RecyclerView.ViewHolder {
        TextView tvlearnname, tvskillhours, tvlearncountry;
        ImageView img2 ;
        public learnerViewHolder(@NonNull View itemView) {
            super(itemView);
            img2= itemView.findViewById(R.id.idlearnimg);
            tvlearnname = itemView.findViewById(R.id.idlearnname);
            tvskillhours = itemView.findViewById(R.id.idlearnshours);
            tvlearncountry = itemView.findViewById(R.id.idlearncountry);
        }
    }
}