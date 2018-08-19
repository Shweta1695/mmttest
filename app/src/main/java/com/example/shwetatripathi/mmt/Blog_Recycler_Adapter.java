package com.example.shwetatripathi.mmt;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

public class Blog_Recycler_Adapter extends RecyclerView.Adapter<Blog_Recycler_Adapter.ViewHolder> {

    List<BlogOne> blog_list;
    private Context context;

    public Blog_Recycler_Adapter(List<BlogOne> blog_list, Context context) {
        this.blog_list = blog_list;
        this.context = context;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

       View v= LayoutInflater.from(parent.getContext())
               .inflate(R.layout.list_items,parent,false);
            return new ViewHolder(v);

          }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        BlogOne blogO= blog_list.get(position);
        holder.Blog_title.setText(blogO.getBlogName());
      //  holder.Blog_img.setImageURI(Uri.parse(blogO.getImgURL()));
        Glide.with(context)
                .load(blogO.getImgURL())
                .into(holder.Blog_img);


    }

    @Override
    public int getItemCount() {
        return blog_list.size();
    }

    public class ViewHolder extends  RecyclerView.ViewHolder
{
        public TextView Blog_title;
        public ImageView Blog_img;

    public ViewHolder(View itemView) {
        super(itemView);

    Blog_title = itemView.findViewById(R.id.blog_title);
    Blog_img = itemView.findViewById(R.id.blog_img);


    }
}
}
