/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachinespringmvc.dao;

import com.sg.vendingmachinespringmvc.model.Item;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author ss121
 */
public class vendingMachineDaoInMemImpl implements vendingMachineDao {

    private double cash ;
    private Map<Long, Item> itemMap = new HashMap<>();

    @Override
    public List<Item> getAllItems() {
        loadVendingItems();
        Collection<Item> i = itemMap.values();
        return new ArrayList<>(i);
    }

    @Override
    public void updateItem(Item item) {
        itemMap.put(item.getId(), item);
    }

    @Override
    public Item getItemById(long id) {
        return itemMap.get(id);
    }

    @Override
    public String selectItem(long id) {
        if (itemMap.get(id).getQuantity() == 0) {
            return "SOLD OUT!!!";
        }
        return "";
    }

    @Override
    public String makePurchase(long id) {
        Item selectedItem = itemMap.get(id);
        double itemPrice = Double.parseDouble(selectedItem.getPrice());
        if (itemPrice < cash) {
            cash = cash - itemPrice;
            int itemQuantity = selectedItem.getQuantity();
            itemQuantity--;
            selectedItem.setQuantity(itemQuantity);
            return "Thank you!!";
        }
        return "<amount short>";
    }

    @Override
    public String returnChange() {
        String returnAmount="";
        int quarters = (int) (cash / 0.25);
        int dimes = (int) ((cash % 0.25) / 0.10);
        int nickels = (int) (((cash % 0.25) % 0.10) / 0.05);
        if (quarters != 0) {
            returnAmount += quarters + " Quarter/s ";
        }
        if (dimes != 0) {
            returnAmount += dimes + "Dime/s";
        }
        if (nickels != 0) {
            returnAmount += nickels + "Nickel/s";
        }
        return returnAmount;
    }

    @Override
    public double addDollar() {
        cash = cash + 1.00;
        return cash;
    }

    @Override
    public double addQuarter() {
        cash = cash + 0.25;
        return cash;
    }

    @Override
    public double addDime() {
        cash = cash + 0.10;
        return cash;
    }

    @Override
    public double addNickel() {
        cash = cash + 0.05;
        return cash;
    }

    @Override
    public double getCash() {
        return cash;
    }
        @Override
    public void setCash(double cash) {
        this.cash = cash;
    }

    //==========================================================================
    //===========================PRIVATE HELPER METHODS=========================
    private void loadVendingItems() {
        Item item1 = new Item(1, "Snickers", "1.85", 9);
        itemMap.putIfAbsent(item1.getId(), item1);

        Item item2 = new Item(2, "M&Ms", "1.50", 2);
        itemMap.putIfAbsent(item2.getId(), item2);

        Item item3 = new Item(3, "Pringles", "2.10", 5);
        itemMap.putIfAbsent(item3.getId(), item3);

        Item item4 = new Item(4, "Reese's", "1.85", 4);
        itemMap.putIfAbsent(item4.getId(), item4);

        Item item5 = new Item(5, "Pretzels", "1.25", 9);
        itemMap.putIfAbsent(item5.getId(), item5);

        Item item6 = new Item(6, "Twinkies", "1.95", 3);
        itemMap.putIfAbsent(item6.getId(), item6);

        Item item7 = new Item(7, "Doritos", "1.75", 11);
        itemMap.putIfAbsent(item7.getId(), item7);

        Item item8 = new Item(8, "Almond Joy", "1.85", 0);
        itemMap.putIfAbsent(item8.getId(), item8);

        Item item9 = new Item(9, "Trident", "1.95", 6);
        itemMap.putIfAbsent(item9.getId(), item9);

    }

    
}
