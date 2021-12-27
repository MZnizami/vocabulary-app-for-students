package com.example.itc335;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {
    private Context context;
    private Activity activity;
    private ArrayList fname;
    private ArrayList lname;
    private ArrayList uname;
    private ArrayList email;
    private ArrayList pass;
    CustomAdapter(Activity activity, Context context, ArrayList fname, ArrayList lname, ArrayList uname,
                  ArrayList email, ArrayList pass){
        this.activity = activity;
        this.context = context;
        this.fname = fname;
        this.lname = lname;
        this.uname = uname;
        this.email = email;
        this.pass = pass;
    }
    @NonNull
    @Override
    public com.example.itc335.CustomAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.listviewadapter, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull com.example.itc335.CustomAdapter.MyViewHolder holder, int position) {
        holder.fnamev.setText(String.valueOf(fname.get(position)));
        holder.lnamev.setText(String.valueOf(lname.get(position)));
        holder.unamev.setText(String.valueOf(uname.get(position)));
        holder.emailv.setText(String.valueOf(email.get(position)));
        holder.passv.setText(String.valueOf(pass.get(position)));
        //Recyclerview onClickListener
//        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(context, UpdateActivity.class);
//                intent.putExtra("id", String.valueOf(book_id.get(position)));
//                intent.putExtra("title", String.valueOf(book_title.get(position)));
//                intent.putExtra("author", String.valueOf(book_author.get(position)));
//                intent.putExtra("pages", String.valueOf(book_pages.get(position)));
//                activity.startActivityForResult(intent, 1);
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return fname.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView fnamev, lnamev, unamev, emailv, passv;
        LinearLayout mainLayout;
        public MyViewHolder(@NonNull View view) {
            super(view);
            fnamev = view.findViewById(R.id.fnamev);
            lnamev = view.findViewById(R.id.lnamev);
            unamev = view.findViewById(R.id.unamev);
            emailv = view.findViewById(R.id.emailv);
            passv = view.findViewById(R.id.passwordv);
            mainLayout = itemView.findViewById(R.id.mainLayout);
            Animation translate_anim = AnimationUtils.loadAnimation(context, R.anim.translate_anim);
            mainLayout.setAnimation(translate_anim);
        }
    }
}
