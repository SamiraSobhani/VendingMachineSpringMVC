/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachinespringmvc.dao;

import com.sg.vendingmachinespringmvc.model.Item;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author ss121
 */
public interface vendingMachineDao {

    public List<Item> getAllItems();

    public void updateItem(Item item);

    public Item getItemById(long id);
    
    public String selectItem(long id);

    public double addDollar();

    public double addQuarter();

    public double addDime();

    public double addNickel();
    
   public String makePurchase(long id);
   
   public String returnChange();
   
   public double getCash(); 
        
   public void setCash(double cash);

}
