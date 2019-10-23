package com.example.borgerkongadam;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class OrderActivity extends AppCompatActivity {

    public RecyclerView orderRecyclerView;
    public RecyclerView.LayoutManager orderLayoutManager;
    public Button clearOrderButton;
    public static TextView totalCost;
    public static double totalCostDisplay = 0;
    public  static ArrayList<Double> itemPrice = new ArrayList<>();
    public  static ArrayList<Integer> itemQuantity  = new ArrayList<>();
    public static ArrayList<Item> orderList  = new ArrayList<>();
    public static TextView noItemsNotif;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        orderRecyclerView = findViewById(R.id.activity_order_rv);

        //orderRecyclerView.setHasFixedSize(true);

        clearOrderButton = findViewById(R.id.activity_order_clear);
        totalCost = findViewById(R.id.activity_order_cost);
        noItemsNotif = findViewById((R.id.activity_order_noitemsnotif));
        noItemsNotif.setVisibility(TextView.INVISIBLE);

        clearOrderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                orderList.clear();
                itemPrice.clear();
                itemQuantity.clear();
                totalCostDisplay = 0;

                //Restart
                startActivity(getIntent());
                finish();
                overridePendingTransition(0,0);
            }
        });

        //
        if (orderList.size() < 1) {
            // no order
            totalCostDisplay = 0;
            noItemsNotif.setVisibility(TextView.VISIBLE);

            totalCost.setText("$0.00");

        } else {
            orderLayoutManager = new LinearLayoutManager(this);
            orderRecyclerView.setLayoutManager(orderLayoutManager);
            OrderAdapter orderAdapter = new OrderAdapter(OrderActivity.orderList);
            orderRecyclerView.setAdapter(orderAdapter);

            //Sum amount of total costs:
            totalCostDisplay = 0;

            for (int i = 0;  i < orderList.size(); i++) {

               totalCostDisplay = totalCostDisplay + (itemPrice.get(i) * itemQuantity.get(i));

            }

            String totalCostRounded = String.format("%,.2f", totalCostDisplay);

            totalCost.setText("$" + totalCostRounded);



        }




    }

}
