package com.cryptoapp.cryptoapp.RetroKrunal;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.cryptoapp.cryptoapp.ApiData.InsideActivity;
import com.cryptoapp.cryptoapp.R;
import java.util.List;

public class Recycle_adapter extends RecyclerView.Adapter<Recycle_adapter.MyViewHolder> {

    private final List<Datum> data;
    Context context;


    public Recycle_adapter(InsideActivity insideActivity, List<Datum> data) {
        this.context = insideActivity;
        this.data = data;
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView name;
        public ImageView imageView;
        public TextView price;
        public TextView marketcap;

        public MyViewHolder(View v) {
            super(v);
            name = v.findViewById(R.id.id_name);
            imageView = v.findViewById(R.id.id_symbol);
            price = v.findViewById(R.id.id_price);
            marketcap = v.findViewById(R.id.id_marketcap);
        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                           int viewType) {
        View v = (View) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_view, parent, false);
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        Datum allVideo1 = data.get(position);
        holder.name.setText(allVideo1.getName());
        holder.price.setText(allVideo1.getCountry());
        holder.marketcap.setText(allVideo1.getCity());

        String url = allVideo1.getImgURL();
        Glide.with(context).load(url).into(holder.imageView);


    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}

