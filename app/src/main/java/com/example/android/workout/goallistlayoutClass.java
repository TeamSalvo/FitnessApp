package com.example.android.workout;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by jesse on 04/26/2018.
 */

public class goallistlayoutClass extends ArrayAdapter<String> {
    private String[] goalNameList;
    private String[] goalMetList;
    private String[] goalDesiredList;
    private Activity context;

    public goallistlayoutClass(Activity context, String[] goalNameList, String[] goalMetList, String[] goalDesiredList) {
        super(context, R.layout.goallistlayout);

        this.goalNameList = goalNameList;
        this.goalMetList = goalMetList;
        this.goalDesiredList = goalDesiredList;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View r = convertView;
        goallistlayoutClass.ViewHolder viewHolder = null;
        if(r==null){
            LayoutInflater layoutInflater = context.getLayoutInflater();
            r=layoutInflater.inflate(R.layout.listview_layout,null,true);
            viewHolder = new goallistlayoutClass.ViewHolder(r);
            r.setTag(viewHolder);
        }
        else {
            viewHolder= (goallistlayoutClass.ViewHolder) r.getTag();
        }


        viewHolder.tvw1.setText(goalNameList[position]);
        viewHolder.tvw2.setText(goalMetList[position]);
        viewHolder.tvw3.setText(goalDesiredList[position]);
        return r;



    }

    class ViewHolder{
        Button btn1;
        TextView tvw1;
        Button btn2;
        TextView tvw2;
        Button btn3;
        TextView tvw3;
        ViewHolder(View v){
            tvw1 = v.findViewById(R.id.goalName);
            tvw2 = v.findViewById(R.id.metGoal);
            tvw3 = v.findViewById(R.id.desiredGoal);
            btn1 = v.findViewById(R.id.removeGoalButton);
            btn2 = v.findViewById(R.id.decrementButton);
            btn3 = v.findViewById(R.id.incrementButton);

            btn2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    // Code here executes on main thread after user presses button
                    Integer tempInt = Integer.parseInt(tvw2.toString());
                    if (tempInt != 0)
                    {
                        tempInt--;
                    }
                    tvw2.setText(tempInt);
                    notifyDataSetChanged();

                }
            });

            btn3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    // Code here executes on main thread after user presses button
                    Integer tempInt = Integer.parseInt(tvw2.toString());
                    tempInt++;
                    tvw2.setText(tempInt);
                    notifyDataSetChanged();
                }
            });

        }


    }
}
