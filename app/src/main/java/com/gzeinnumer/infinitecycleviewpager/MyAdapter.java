package com.gzeinnumer.infinitecycleviewpager;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MyAdapter extends PagerAdapter {

    Context mContext;
    List<Model> mList;
    View view;

    public MyAdapter(Context context, List<Model> mList) {
        this.mContext = context;
        this.mList = mList;
    }


    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view.equals(o);
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, final int position) {
        view = LayoutInflater.from(mContext).inflate(R.layout.card_item,container, false);
        ImageView imageMovie = view.findViewById(R.id.movieImage);
        TextView textTitle = view.findViewById(R.id.movieTitle);
        TextView textDesc = view.findViewById(R.id.movie_description);
        FloatingActionButton btn_fav =  view.findViewById(R.id.btn_fav);

        imageMovie.setImageResource(mList.get(position).getImage());
        textTitle.setText(mList.get(position).getName());
        textDesc.setText(mList.get(position).getDesc());

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext,""+mList.get(position).getName(),Toast.LENGTH_SHORT).show();
            }
        });
        btn_fav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext,"Favorite "+mList.get(position).getName(),Toast.LENGTH_SHORT).show();
            }
        });
        container.addView(view);
        return view;
    }

    static class Model {
        private String name, desc;
        private int image;

        public Model(String name, String desc, int image) {
            this.name = name;
            this.desc = desc;
            this.image = image;
        }

        public String getName() {
            return name;
        }

        public String getDesc() {
            return desc;
        }

        public int getImage() {
            return image;
        }

    }
}
