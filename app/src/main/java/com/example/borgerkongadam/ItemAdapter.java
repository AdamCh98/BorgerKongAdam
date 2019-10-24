package com.example.borgerkongadam;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder> {

    public ArrayList<Item> items;

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }


    //Creating the viewholder
    public static class ItemViewHolder extends RecyclerView.ViewHolder {

        public View view;
        public TextView itemName;
        public ImageView itemImage;

        public ItemViewHolder(View v) {
            super(v);
            view = v;
            itemName = v.findViewById(R.id.item_name);
            itemImage = v.findViewById(R.id.item_photo);
        }

    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);

        ItemViewHolder itemViewHolder = new ItemViewHolder(view);
        return itemViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ItemViewHolder holder, final int position) {
        final Item currentItem = items.get(position);

        holder.itemName.setText(currentItem.getItemName());
        holder.itemImage.setImageResource(currentItem.getImageDrawableId());

        holder.view.setOnClickListener(new View.OnClickListener() {
            public void onClick(View views) {
                //Give data for itemDetail
                Context context = views.getContext();

                Intent startIntent = new Intent(context, ItemDetail.class);
                startIntent.putExtra("itemID", currentItem.getItemID());
                context.startActivity(startIntent);
            }


        });

    }



    @Override
    public int getItemCount() {
        return items.size();
    }


}
