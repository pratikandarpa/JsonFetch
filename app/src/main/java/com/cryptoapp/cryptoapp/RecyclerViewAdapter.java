package com.cryptoapp.cryptoapp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewHolders> {

    private List<PostList> itemList;
    private Context context;
    public RecyclerViewAdapter(Context context, List<PostList> itemList) {
        this.itemList = itemList;
        this.context = context;
    }
    @Override
    public RecyclerViewHolders onCreateViewHolder(ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.onecard, null);
        RecyclerViewHolders rcv = new RecyclerViewHolders(layoutView);
        return rcv;
    }
    @Override
    public void onBindViewHolder(RecyclerViewHolders holder, int position) {
        holder.Title.setText("Title: " + itemList.get(position).getTitle());
        holder.Body.setText("Body: " + itemList.get(position).getBody());
    }
    @Override
    public int getItemCount() {
        return this.itemList.size();
    }
}