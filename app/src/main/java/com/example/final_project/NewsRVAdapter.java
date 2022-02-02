package com.example.final_project;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class NewsRVAdapter extends RecyclerView.Adapter<NewsRVAdapter.ViewHolder> {


    private ArrayList<NewsModal> newsModalArrayList;
    private Context context;


    public NewsRVAdapter(ArrayList<NewsModal> newsModalArrayList, Context context) {
        this.newsModalArrayList = newsModalArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public NewsRVAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new NewsRVAdapter.ViewHolder(LayoutInflater.from(context).inflate(R.layout.news_rv_item, parent, false));

    }

    @Override
    public void onBindViewHolder(@NonNull NewsRVAdapter.ViewHolder holder, int position) {

        NewsModal modal = newsModalArrayList.get(position);
        holder.newsDescTV.setText(modal.getNewsDesc());
        holder.newsTitleTV.setText(modal.getNewsTitle());
    }

    @Override
    public int getItemCount() {

        return newsModalArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {


        private TextView newsTitleTV, newsDescTV;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            newsTitleTV = itemView.findViewById(R.id.idTVNewsTitle);
            newsDescTV = itemView.findViewById(R.id.idTVNewsDesc);
        }
    }
}