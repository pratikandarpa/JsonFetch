package com.cryptoapp.cryptoapp.WithImage;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.cryptoapp.cryptoapp.R;
import com.cryptoapp.cryptoapp.RecyclerViewHolders;

import java.util.List;

public class RecyclerViewAdapter3 extends RecyclerView.Adapter<RecyclerViewHolders> {

    private List<PostList3> itemList;
    private Context context;

    public RecyclerViewAdapter3(Context context, List<PostList3> itemList) {
        this.itemList = itemList;
        this.context = context;
    }

    @Override
    public RecyclerViewHolders onCreateViewHolder(ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.onecard3, null);
        RecyclerViewHolders rcv = new RecyclerViewHolders(layoutView);
        return rcv;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolders holder, int position) {
        holder.Uid.setText("UserID: " + itemList.get(position).getId());
        Glide.with(context).load(itemList.get(position).getThumbnailUrl()).into(holder.img);
    }

    @Override
    public int getItemCount() {
        return this.itemList.size();
    }
}