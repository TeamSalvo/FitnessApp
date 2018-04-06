package com.example.android.workout;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.workout.R;

/**
 * Created by pures on 4/5/2018.
 */

public class CustomListView extends ArrayAdapter<String>{

    private String[] workout;
    private String[] desc;
    private Integer[] imgId;
    private Activity context;

    public CustomListView(Activity context,String[] workout, String[] desc, Integer[] imgId)  {
        super(context, R.layout.listview_layout,workout);

        this.context = context;
        this.workout = workout;
        this.desc = desc;
        this.imgId = imgId;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View r = convertView;
        ViewHolder viewHolder = null;
        if(r==null){
            LayoutInflater layoutInflater = context.getLayoutInflater();
            r=layoutInflater.inflate(R.layout.listview_layout,null,true);
            viewHolder = new ViewHolder(r);
            r.setTag(viewHolder);
        }
        else {
            viewHolder= (ViewHolder) r.getTag();
        }

        viewHolder.ivw.setImageResource(imgId[position]);
        viewHolder.ivw.setMaxHeight(10);
        viewHolder.ivw.setMaxWidth(10);
        viewHolder.tvw1.setText(workout[position]);
        viewHolder.tvw2.setText(desc[position]);
        return r;




    }
    class ViewHolder{
        TextView tvw1;
        TextView tvw2;
        ImageView ivw;
        ViewHolder(View v){
            tvw1 = v.findViewById(R.id.cardioExercises);
            tvw2 = v.findViewById(R.id.cardioDesc);
            ivw = v.findViewById(R.id.cardioImages);
        }
    }
}
