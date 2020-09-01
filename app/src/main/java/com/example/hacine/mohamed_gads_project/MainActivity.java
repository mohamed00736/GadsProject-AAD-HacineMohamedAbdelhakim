package com.example.hacine.mohamed_gads_project;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.hacine.mohamed_gads_project.TabFragments.SkillFragment;
import com.example.hacine.mohamed_gads_project.TabFragments.TopLearnerFragment;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    ViewPager viewPager;
    TabLayout tabLayout;
    TextView submit ;

    SkillFragment skillFragment;
    TopLearnerFragment topLearnerFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_main);
                Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
                setSupportActionBar(toolbar);

                viewPager = findViewById(R.id.viewPager);
                tabLayout = findViewById(R.id.tabLayout);

                skillFragment = new SkillFragment();
                topLearnerFragment = new TopLearnerFragment();
            submit = findViewById(R.id.tvsubmit);
            submit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                startActivity(new Intent(MainActivity.this , SubmitProject.class));
                }
            });
                MyPagerAdapter myPagerAdapter = new MyPagerAdapter(getSupportFragmentManager());

                tabLayout.setupWithViewPager(viewPager);
                viewPager.setAdapter(myPagerAdapter);

                viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {

            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });


    }





    class MyPagerAdapter extends FragmentPagerAdapter {

        String[] fragmentNames = {" Learning Leader ", "Skill IQ Leader"};

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {

            switch (position) {
                case 0:
                    return topLearnerFragment;
                case 1:
                    return skillFragment;

            }
            return null;
        }

        @Override
        public int getCount() {
            return fragmentNames.length;
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return fragmentNames[position];
        }
    }

}
