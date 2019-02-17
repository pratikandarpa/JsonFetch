package com.cryptoapp.cryptoapp;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class RecyclerViewHolders extends RecyclerView.ViewHolder implements View.OnClickListener{
    public TextView Title;
    public TextView Body;

    public TextView name;
    public TextView email;
    public TextView city;
    public TextView lat;
    public TextView phone;
    public TextView companyname;

    public TextView Uid;
    public ImageView img;

    public RecyclerViewHolders(View itemView) {
        super(itemView);
        itemView.setOnClickListener(this);
        Title = (TextView)itemView.findViewById(R.id.text1);
        Body = (TextView)itemView.findViewById(R.id.text2);

        name = itemView.findViewById(R.id.t1);
        email = itemView.findViewById(R.id.t2);
        city = itemView.findViewById(R.id.t3);
        lat = itemView.findViewById(R.id.t4);
        phone = itemView.findViewById(R.id.t5);
        companyname = itemView.findViewById(R.id.t6);

        Uid = itemView.findViewById(R.id.Uid);
        img = itemView.findViewById(R.id.img);
    }
    @Override
    public void onClick(View view) {
    }
}
