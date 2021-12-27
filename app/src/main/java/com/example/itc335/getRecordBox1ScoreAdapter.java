package com.example.itc335;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class getRecordBox1ScoreAdapter extends RecyclerView.Adapter<getRecordBox1ScoreAdapter.MyViewHolder> {
   private Context context;
   private ArrayList name,date, score;
    getRecordBox1ScoreAdapter(Context context,ArrayList name,ArrayList date, ArrayList score){
        this.context=context;
        this.name=name;
        this.date=date;
        this.score=score;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View view =inflater.inflate(R.layout.activity_display_row_box1,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull com.example.itc335.getRecordBox1ScoreAdapter.MyViewHolder holder, int position) {
holder.name_txt.setText(String.valueOf(name.get(position)));
holder.date_txt.setText(String.valueOf(date.get(position)));
holder.score_txt.setText(String.valueOf(score.get(position)));
    }

    @Override
    public int getItemCount() {
        return name.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView  name_txt,date_txt,score_txt;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name_txt=itemView.findViewById(R.id.name);
            date_txt=itemView.findViewById(R.id.date);
            score_txt=itemView.findViewById(R.id.score);

        }
    }
}
