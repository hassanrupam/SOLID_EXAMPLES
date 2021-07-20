package com.hassan.after_SRP;

import java.util.ArrayList;
import java.util.List;

public class Order_SRP {
    List<Item> itemList = new ArrayList<>();
    private String orderNumber;

    public Order_SRP(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void add_Item(String _itemName, Double _quantity, Double _price){
        Item _item =  new Item(_itemName,_quantity,_price);
        this.itemList.add(_item);
    }

    public Double totalPrice(){
        Double total = Double.valueOf(0);
        for(Item item: this.itemList){
            total = Double.sum(total, item.getPrice()*item.getQuantity());
        }
        return total.doubleValue();
    }

}
