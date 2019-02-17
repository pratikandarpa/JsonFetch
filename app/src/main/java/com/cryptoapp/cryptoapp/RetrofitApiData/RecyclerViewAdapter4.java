package com.cryptoapp.cryptoapp.RetrofitApiData;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cryptoapp.cryptoapp.ApiData.PostList2;
import com.cryptoapp.cryptoapp.R;
import com.cryptoapp.cryptoapp.RecyclerViewHolders;

public class RecyclerViewAdapter4 extends RecyclerView.Adapter<RecyclerViewHolders> {

    private final PostList2 postList;
    private Context context;


    public RecyclerViewAdapter4(Context context, PostList2 postList) {
        this.context = context;
        this.postList = postList;

    }


    @Override
    public RecyclerViewHolders onCreateViewHolder(ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.onecard2, null);
        RecyclerViewHolders rcv = new RecyclerViewHolders(layoutView);
        return rcv;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolders holder, int position) {
//        PostList2 postList2 = postList[position];
        holder.name.setText("UserName: " + postList.getUsername());
//        holder.email.setText("Email: " + itemList.get(position).getEmail());
//        holder.city.setText("City: " + itemList.get(position).getAddress().getCity());
//        holder.lat.setText("Lat: " + itemList.get(position).getAddress().getGeo().getLat());
//        holder.phone.setText("Phone: " + itemList.get(position).getPhone());
//        holder.companyname.setText("CompanyName: " + itemList.get(position).getCompany().getName());

    }

    @Override
    public int getItemCount() {
        return 6;
    }
}
