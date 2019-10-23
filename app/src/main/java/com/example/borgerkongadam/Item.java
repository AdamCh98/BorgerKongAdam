package com.example.borgerkongadam;

public class Item {

    //class for all the items on menu

    //Declaring itemID, name, cost, description and photo for items on BorgerKong
    private int itemID;
    private String itemName;
    private double itemCost;
    private String itemDescription;
    private int imageDrawableId;

    public Item(int itemID, String itemName, double itemCost, String itemDescription, int imageDrawableId) {
        this.itemID = itemID;
        this.itemName = itemName;
        this.itemCost = itemCost;
        this.itemDescription = itemDescription;
        this.imageDrawableId = imageDrawableId;
    }

    public int getItemID() {
        return itemID;
    }

    public void setItemID(int itemID) {
        this.itemID = itemID;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getItemCost() {
        return itemCost;
    }

    public void setItemCost(double itemCost) {
        this.itemCost = itemCost;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public int getImageDrawableId() {
        return imageDrawableId;
    }

    public void setImageDrawableId(int imageDrawableId) {
        this.imageDrawableId = imageDrawableId;
    }
}
