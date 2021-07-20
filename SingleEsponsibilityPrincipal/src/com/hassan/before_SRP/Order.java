package com.hassan.before_SRP;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

public class Order {
    List<Item> itemList = new ArrayList<>();
    private String oderNumber;
    private Boolean isPaid = false;

    public Order(String _oderNumber) {
        this.oderNumber = _oderNumber;
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


    public void payment(String _type, String _security_code){
        if(_type.equals("Debit")){
            System.out.println("Processing Debit Payment");
            System.out.println("Security Code for order : "+ this.oderNumber +" is : " + _security_code);
            this.isPaid =  true;
        }else if(_type.equals("Credit")){
            System.out.println("Processing Credit Payment");
            System.out.println("Security Code for order : "+ this.oderNumber +" is : " + _security_code);
            this.isPaid =  true;
        }else{
            System.out.println("Unknown Payment Type");
        }
    }

    public void isPaid(){
        if (this.isPaid.equals(true)) {
            System.out.println("Payment is Paid");
        } else {
            System.out.println("Payment is Pending");
        }
    }







}
