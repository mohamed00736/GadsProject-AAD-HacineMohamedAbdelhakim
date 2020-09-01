package com.example.hacine.mohamed_gads_project.data;

import com.example.hacine.mohamed_gads_project.pojo.SkillIqModel;
import com.example.hacine.mohamed_gads_project.pojo.TopLearnerModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PostClient {

    private static final String BASE_URL = "https://gadsapi.herokuapp.com/";
    private PostInterface postInterface;
    private static PostClient INSTANCE;
    public PostClient( ) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        postInterface = retrofit.create(PostInterface.class);
    }


    // Singelton

    public static PostClient getINSTANCE() {
        if (null == INSTANCE){
            INSTANCE = new PostClient();
        }
        return INSTANCE;
    }
    public Call<List<SkillIqModel>>getTopSkill(){
        return postInterface.getTopSkill();
    }
    public Call<List<TopLearnerModel>>getTopLearners(){ return postInterface.getTopLearners(); }
}
