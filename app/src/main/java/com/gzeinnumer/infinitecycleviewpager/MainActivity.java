package com.gzeinnumer.infinitecycleviewpager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.gigamole.infinitecycleviewpager.HorizontalInfiniteCycleViewPager;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    HorizontalInfiniteCycleViewPager viewPager;
    List<MyAdapter.Model> movieList =  new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);


        setContentView(R.layout.activity_main);
        initData();
        viewPager =findViewById(R.id.view_pager);
        MyAdapter adapter = new MyAdapter(this, movieList);
        viewPager.setAdapter(adapter);
    }

    private void initData() {
        movieList.add(new MyAdapter.Model("M. Fadli Zein",getString(R.string.long_text),R.drawable._1));
        movieList.add(new MyAdapter.Model("Cybertech",getString(R.string.long_text),R.drawable._2));
        movieList.add(new MyAdapter.Model("Dewan Kehormatan",getString(R.string.long_text),R.drawable._3));
    }


}
