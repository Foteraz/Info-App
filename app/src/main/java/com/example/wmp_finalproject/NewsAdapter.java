package com.example.wmp_finalproject;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
public class NewsAdapter extends  RecyclerView.Adapter<NewsAdapter.ViewHolder>{
    private Context context;
    private ArrayList<News> newsArrayList;

    // creating constructor for our adapter class
        public NewsAdapter(ArrayList<News> newsArrayList, Context context) {
            this.newsArrayList = newsArrayList;
            this.context = context;
        }

        @NonNull
        @Override
        public NewsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            // passing our layout file for displaying our card item
            return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.news_card_view, parent, false));
        }

        @Override
        public void onBindViewHolder(@NonNull NewsAdapter.ViewHolder holder, int position) {
            // setting data to our text views from our modal class.
            News news = newsArrayList.get(position);
            holder.newsArticleShow.setText(news.getArticle());
            holder.newsTitleShow.setText(news.getTitle());

            Glide.with(context)
                    .load(news.getImageUrl()) // You need to have a method like getImageUrl() in your News class
                    .override(350, 268 )
                    .into(holder.newsImageShow);

        }

        @Override
        public int getItemCount() {
            // returning the size of our array list.
            return newsArrayList.size();
        }

        class ViewHolder extends RecyclerView.ViewHolder {
            // creating variables for our text views.
            private final ImageView newsImageShow;
            private final TextView newsArticleShow;
            private final TextView newsTitleShow;
            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                // initializing our text views.
                newsImageShow = itemView.findViewById(R.id.ImageNewsFill);
                newsArticleShow = itemView.findViewById(R.id.idArticleFill);
                newsTitleShow = itemView.findViewById(R.id.newsTitleFill);
            }
        }
    }

