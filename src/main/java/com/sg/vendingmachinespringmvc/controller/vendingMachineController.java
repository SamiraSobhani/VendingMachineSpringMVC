/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachinespringmvc.controller;

import com.sg.vendingmachinespringmvc.dao.vendingMachineDao;
import com.sg.vendingmachinespringmvc.model.Item;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author ss121
 */
@Controller
public class vendingMachineController {

    vendingMachineDao dao;
    NumberFormat formatter = NumberFormat.getCurrencyInstance();

    @Inject
    public vendingMachineController(vendingMachineDao dao) {
        this.dao = dao;
    }

    @RequestMapping(value = "/displayItems", method = RequestMethod.GET)
    public String displayItems(Model model) {
        List<Item> itemList = dao.getAllItems();
        model.addAttribute("itemList", itemList);
        String moneyInput = formatter.format(dao.getCash());
        model.addAttribute("moneyInput", moneyInput);
        return "Items";
    }

    @RequestMapping(value = "/addDollar", method = RequestMethod.GET)
    public String addDollar(Model model) {
        String moneyInput = formatter.format(dao.addDollar());
        model.addAttribute("moneyInput", moneyInput);
        return "redirect:displayItems";
    }

    @RequestMapping(value = "/addQuarter", method = RequestMethod.GET)
    public String addQuarter(Model model) {
        String moneyInput = formatter.format(dao.addQuarter());
        model.addAttribute("moneyInput", moneyInput);
        return "redirect:displayItems";
    }

    @RequestMapping(value = "/addDime", method = RequestMethod.GET)
    public String addDime(Model model) {
        String moneyInput = formatter.format(dao.addDime());
        model.addAttribute("moneyInput", moneyInput);
        return "redirect:displayItems";
    }

    @RequestMapping(value = "/addNickel", method = RequestMethod.GET)
    public String addNickel(Model model) {
        String moneyInput = formatter.format(dao.addNickel());
        model.addAttribute("moneyInput", moneyInput);
        return "redirect:displayItems";
    }

    @RequestMapping(value = "/selectItem", method = RequestMethod.GET)
    public String selectItem(HttpServletRequest request, Model model) {
        String itemId = request.getParameter("id");
        long id = Long.parseLong(itemId);
        String selectMessage = dao.selectItem(id);
        model.addAttribute("selectMessage", selectMessage);
        model.addAttribute("itemId", itemId);
        modelAttribute(model);
        return "Items";
    }

    @RequestMapping(value = "/makePurchase", method = RequestMethod.GET)
    public String makePurchase(HttpServletRequest request, Model model) {
        String itemId = request.getParameter("id");
        long id = Long.parseLong(itemId);
        String selectMessage = dao.makePurchase(id);
        model.addAttribute("selectMessage", selectMessage);
        model.addAttribute("itemId", itemId);
        modelAttribute(model);
        return "Items";

    }
    
    @RequestMapping(value="/returnChange", method = RequestMethod.GET)
    public String returnChange(Model model){
        String returnAmount = dao.returnChange();
        dao.setCash(0.00);
        model.addAttribute("returnAmount", returnAmount);
        modelAttribute(model);
        return "Items";
    }

    private void modelAttribute(Model model) {
        List<Item> itemList = dao.getAllItems();
        model.addAttribute("itemList", itemList);
        String moneyInput = formatter.format(dao.getCash());
        model.addAttribute("moneyInput", moneyInput);
    }
}

