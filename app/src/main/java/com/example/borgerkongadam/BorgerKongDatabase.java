package com.example.borgerkongadam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class BorgerKongDatabase {

    //Database for 15 different items - name, cost, description and image

public static Item getItemById(int itemID) { return items.get(itemID);}

    public static ArrayList<Item> getAllItems() {
        return new ArrayList<Item>((List) Arrays.asList(items.values().toArray()));
    }

    private static final HashMap<Integer, Item> items = new HashMap<>();


    static {
        items.put(1,new Item(
                1,
                "Mighty Whopper",
                4.50,
                "BorgerKong's iconic burger - has everything in it",
                R.drawable.burger1

        ));

        items.put(2,new Item(
                2,
                "Cheese burger",
                3.50,
                "Classical cheeseburger - can't go wrong!",
                R.drawable.burger2

        ));

        items.put(3,new Item(
                3,
                "Double-sliced Hamburger",
                3.50,
                "Classical hamburger with two layers of lettuce- can't go wrong!",
                R.drawable.burger3

        ));

        items.put(4,new Item(
                4,
                "Lamb burger",
                4.00,
                "Lamb burger with two layers of lamb and melted cheese - can't go wrong!",
                R.drawable.burger4

        ));

        items.put(5,new Item(
                5,
                "Hamburger",
                3.50,
                "Classical hamburger - can't go wrong!",
                R.drawable.burger5

        ));

        items.put(6,new Item(
                6,
                "Filet-o-Fish Burger",
                4.00,
                "Classic fish-burger with satay sauce!",
                R.drawable.burger6

        ));

        items.put(7,new Item(
                7,
                "Vegetarian burger",
                5.00,
                "For vegetarians, two layers of synthetic meat and cucumber!",
                R.drawable.burger7

        ));

        items.put(8,new Item(
                8,
                "Chicken Wrap",
                7.50,
                "Delicious wrap with roasted chicken, cheese, lettuce, tomato and avocado!",
                R.drawable.wrap8

        ));

        items.put(9,new Item(
                9,
                "Caesar Salad",
                5.00,
                "Salad comprising of a variety of vegetables and chicken!",
                R.drawable.salad9

        ));

        items.put(10,new Item(
                7,
                "Onion Rings",
                3.00,
                "5 rings per serving",
                R.drawable.ring10

        ));

        items.put(11,new Item(
                11,
                "Fries",
                3.00,
                "Classic chips - 120g per serving",
                R.drawable.fries11

        ));

        items.put(12,new Item(
                12,
                "Coke",
                3.50,
                "Classic coke to cool your thirst!",
                R.drawable.drink12

        ));

        items.put(13,new Item(
                13,
                "Mount Franklin Water",
                4.00,
                "Water for healthy folks",
                R.drawable.drink13

        ));

        items.put(14,new Item(
                14,
                "Orange Juice",
                4.00,
                "Spring Valley Orange Juice variety",
                R.drawable.drink14

        ));

        items.put(15,new Item(
                15,
                "Coffee Frappe",
                6.00,
                "Iced coffee served with ice-cream topping and whipped cream",
                R.drawable.drink15

        ));

        items.put(16,new Item(
                16,
                "Sundae Ice-cream",
                0.50,
                "Soft-serve ice-cream for a hot Summer's day",
                R.drawable.dessert16

        ));


    }
}
