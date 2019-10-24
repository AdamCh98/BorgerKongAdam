package com.example.borgerkongadam;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ItemDetail extends AppCompatActivity {
    public TextView itemDetailName;
    public TextView itemDetailPrice;
    public ImageView itemDetailPhoto;
    public TextView itemDetailDescription;
    public EditText itemDetailQuantity;
    public Button itemDetailAddBtn;
    public int quantity;
    public String itemName;

    public String itemDetailNameArray;
    public Double itemDetailPriceArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_detail);


        Intent intent = getIntent();
        int itemID = intent.getIntExtra("itemID", 0);
        final Item thisItem = BorgerKongDatabase.getItemById(itemID);

        //If there isn't a defaultvalue - display as per the itemID. ELSE, go back to mainactivity (i.e when user presses back button)
        if (itemID !=0) {

            itemDetailName = findViewById(R.id.item_detail_name);
            itemDetailPrice = findViewById(R.id.item_detail_price);
            itemDetailPhoto = findViewById(R.id.item_detail_photo);
            itemDetailDescription = findViewById(R.id.item_detail_description);
            itemDetailQuantity = findViewById(R.id.item_detail_orderquantity);
            itemDetailAddBtn = findViewById(R.id.item_detail_addbutton);


            itemDetailName.setText(thisItem.getItemName());
            itemDetailNameArray = thisItem.getItemName();
            itemName = thisItem.getItemName();

            itemDetailPhoto.setImageResource(thisItem.getImageDrawableId());

            String itemCostString = String.format("%,.2f", thisItem.getItemCost());
            itemDetailPrice.setText("$" + itemCostString);
            itemDetailPriceArray = thisItem.getItemCost();


            itemDetailDescription.setText(thisItem.getItemDescription());

            itemDetailAddBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    //If user doesn't click on any number/value
                    if (itemDetailQuantity.getText().toString().equals("")) {
                        quantityToast(v);
                    } else {

                        //Getting quantity
                        quantity = Integer.parseInt(itemDetailQuantity.getText().toString());

                        //Adding these into arrayList
                        OrderActivity.itemPrice.add(itemDetailPriceArray);
                        OrderActivity.itemQuantity.add(quantity);
                        //adding item into orderList
                        OrderActivity.orderList.add(thisItem);
                        confirmToast(v);

                    }


                }
            });
        } else {
           Intent exitIntent = new Intent(ItemDetail.this, MainActivity.class);
            startActivity(exitIntent);
       }

        }

        //Order confirmation
    public void confirmToast(View v) {
        Toast.makeText(ItemDetail.this, "You have ordered " + quantity + " " + itemName + "(s)", Toast.LENGTH_SHORT).show();
    }

    public void quantityToast(View v) {
        Toast.makeText(ItemDetail.this, "You must enter a valid quantity", Toast.LENGTH_SHORT).show();
    }
}
