package com.example.simplifyv2.deliciousfood.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.simplifyv2.deliciousfood.Models.CommentModel;
import com.example.simplifyv2.deliciousfood.R;

import java.util.List;

public class AdapterDetailActivity extends RecyclerView.Adapter<AdapterDetailActivity.MyHolder> {
    List<CommentModel> commentModelList;
    Context context;

    public AdapterDetailActivity(List<CommentModel> commentModelList, Context context) {
        this.commentModelList = commentModelList;
        this.context = context;
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        TextView txtNameComment, txtContentComment;
        public MyHolder(@NonNull View itemView) {
            super(itemView);
            txtNameComment = itemView.findViewById(R.id.txtNameComment);
            txtContentComment = itemView.findViewById(R.id.txtContentComment);
        }
    }
    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new MyHolder(LayoutInflater.from(context).inflate(R.layout.custom_comment_detail, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder myHolder, int i) {
        CommentModel commentModel = commentModelList.get(i);
        myHolder.txtNameComment.setText(commentModel.getUserModelList().get(commentModel.getId_khachhang()).getHoten());
        myHolder.txtContentComment.setText(commentModel.getNoidung());
    }

    @Override
    public int getItemCount() {
        return commentModelList.size();
    }
}