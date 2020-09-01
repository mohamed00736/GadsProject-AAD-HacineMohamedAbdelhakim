package com.example.hacine.mohamed_gads_project.data;


import com.example.hacine.mohamed_gads_project.pojo.SkillIqModel;
import com.example.hacine.mohamed_gads_project.pojo.TopLearnerModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PostInterface {
    @GET("api/skilliq")
    public Call<List<SkillIqModel>>   getTopSkill();

    @GET("api/hours")
    public Call<List<TopLearnerModel>>   getTopLearners();
//
//    @POST("posts")
//    public Call <PostModel>   creatPosts(@Body Post post);
}
