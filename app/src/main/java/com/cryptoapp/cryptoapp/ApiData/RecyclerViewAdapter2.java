package com.cryptoapp.cryptoapp.ApiData;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.cryptoapp.cryptoapp.R;
import com.cryptoapp.cryptoapp.RecyclerViewHolders;

import java.util.List;

public class RecyclerViewAdapter2 extends RecyclerView.Adapter<RecyclerViewHolders> {

    private List<PostList2> itemList;
    private Context context;
    public RecyclerViewAdapter2(Context context, List<PostList2> itemList) {
        this.itemList = itemList;
        this.context = context;
    }


    @Override
    public RecyclerViewHolders onCreateViewHolder(ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.onecard2, null);
        RecyclerViewHolders rcv = new RecyclerViewHolders(layoutView);
        return rcv;
    }
    @Override
    public void onBindViewHolder(RecyclerViewHolders holder, int position) {

        holder.name.setText("UserName: " + itemList.get(position).getUsername());
        holder.email.setText("Email: " + itemList.get(position).getEmail());
        holder.city.setText("City: " + itemList.get(position).getAddress().getCity());
        holder.lat.setText("Lat: " + itemList.get(position).getAddress().getGeo().getLat());
        holder.phone.setText("Phone: " + itemList.get(position).getPhone());
        holder.companyname.setText("CompanyName: " + itemList.get(position).getCompany().getName());

    }
    @Override
    public int getItemCount() {
        return this.itemList.size();
    }
}
