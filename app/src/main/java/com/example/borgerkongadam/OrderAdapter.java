package com.example.borgerkongadam;

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

import static com.example.borgerkongadam.OrderActivity.itemPrice;
import static com.example.borgerkongadam.OrderActivity.itemQuantity;
import static com.example.borgerkongadam.OrderActivity.noItemsNotif;
import static com.example.borgerkongadam.OrderActivity.orderList;
import static com.example.borgerkongadam.OrderActivity.totalCost;
import static com.example.borgerkongadam.OrderActivity.totalCostDisplay;


public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.OrderViewHolder> {

    public ArrayList<Item> orderItems;


    //Creating the viewHolder
    public static class OrderViewHolder extends RecyclerView.ViewHolder {

        public View view;
        public ImageView itemPhoto;
        public TextView itemName;
        public TextView itemPriceDisplay;
        public Button removeButton;
        public TextView itemQuantityDisplay;
        public TextView subtotal;

        public OrderViewHolder(View v) {

            super(v);
            view = v;
            itemPhoto = v.findViewById(R.id.item_order_photo);
            itemName = v.findViewById(R.id.item_order_name);
            itemPriceDisplay = v.findViewById(R.id.item_order_price);
            removeButton = v.findViewById(R.id.item_order_remove);
            itemQuantityDisplay = v.findViewById(R.id.item_order_quantity);
            subtotal = v.findViewById(R.id.item_order_subtotal);

        }

    }

    public OrderAdapter(ArrayList<Item> orderList) {
        orderItems = orderList;
    }

    @NonNull
    @Override
    public OrderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_order, parent, false);

        OrderViewHolder orderViewHolder = new OrderViewHolder(view);

        return orderViewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull final OrderViewHolder holder, final int position) {
        final Item currentItem = orderItems.get(position);

        //Setting all the layout elements
        holder.itemName.setText(currentItem.getItemName());
        String itemCostString = String.format("%,.2f", currentItem.getItemCost());
        holder.itemPriceDisplay.setText("$" + itemCostString);
        holder.itemPhoto.setImageResource(currentItem.getImageDrawableId());
        holder.itemQuantityDisplay.setText(Integer.toString(itemQuantity.get(position)));

        //Getting the subtotal:
        double subtotalDisplay = currentItem.getItemCost() * itemQuantity.get(position);
        String subTotalDisplayRounded = String.format("%,.2f",subtotalDisplay);
        holder.subtotal.setText("$" + subTotalDisplayRounded);

        holder.removeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Delete from ArrayList
                orderList.remove(currentItem);
                itemPrice.remove(position);
                itemQuantity.remove(position);
                notifyItemRemoved(position);

                //adjusting the total costs:
                if (orderList.size() < 1) {
                    // no order
                    totalCostDisplay = 0;
                    totalCost.setText("$0.00");
                    noItemsNotif.setVisibility(TextView.VISIBLE);

                } else {
                    //Resetting
                    totalCostDisplay = 0;

                    for (int i = 0;  i < orderList.size(); i++) {
                        totalCostDisplay = totalCostDisplay + (itemPrice.get(i) * itemQuantity.get(i));

                    }
                    String totalCostRounded = String.format("%,.2f", totalCostDisplay);

                    totalCost.setText("$" + totalCostRounded);
                }
            }
        });



    }


    @Override
    public int getItemCount() {

        return orderItems.size();
    }


}
