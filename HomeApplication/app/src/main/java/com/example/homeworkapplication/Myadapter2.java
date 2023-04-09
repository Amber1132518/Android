package com.example.homeworkapplication;


import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Myadapter2 extends RecyclerView.Adapter<Myadapter2.ViewHolder> {

    private List<News> mNewsList;
    private Context mContext;
    private OnItemClickListener listener;

    public Myadapter2(List<News> data, Context context) {
        mNewsList = data;
        mContext = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_news, parent, false);
        ViewHolder holder = new ViewHolder(view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                News news = mNewsList.get(position);
                Intent intent = new Intent(mContext, newsdetail.class);
                intent.putExtra("title", news.getTitle());
                intent.putExtra("date", news.getDate());
                mContext.startActivity(intent);
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        News news = mNewsList.get(position);
        holder.title.setText(news.getTitle());
        holder.date.setText(news.getDate());
    }

    @Override
    public int getItemCount() {
        return mNewsList.size();
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }


    public interface OnItemClickListener {
        void OnItemClick(View view, int position);
        void onItemLongClick(View view, int pos);
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        TextView date;

        ViewHolder(View view) {
            super(view);
            title = view.findViewById(R.id.title);
            date = view.findViewById(R.id.date);
        }
    }
}


