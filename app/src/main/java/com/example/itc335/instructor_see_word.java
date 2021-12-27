package com.example.itc335;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class instructor_see_word extends RecyclerView.Adapter<instructor_see_word.MyViewHolder> {
    private Context context;
    private ArrayList id, word, meaning;

    instructor_see_word(Context context,ArrayList id,ArrayList word, ArrayList meaning){
        this.context=context;
        this.id=id;
        this.word=word;
        this.meaning=meaning;

    }
    @NonNull
    @Override
    public instructor_see_word.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View view =inflater.inflate(R.layout.vocabulary_cell,parent,false);

        return new instructor_see_word.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull com.example.itc335.instructor_see_word.MyViewHolder holder, int position) {
        holder.id_txt.setText(String.valueOf(id.get(position)));
        holder.word_txt.setText(String.valueOf(word.get(position)));
        holder.meaning_txt.setText(String.valueOf(meaning.get(position)));

    }

    @Override
    public int getItemCount() {
        return id.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView id_txt, word_txt,meaning_txt;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            id_txt=itemView.findViewById(R.id.idTxt);
            word_txt=itemView.findViewById(R.id.wordTxt);
            meaning_txt=itemView.findViewById(R.id.meaningTxt);


        }
    }
}
