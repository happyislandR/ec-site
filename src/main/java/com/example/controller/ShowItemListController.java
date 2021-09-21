package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Item;
import com.example.service.ShowItemListService;

/**
 * 商品情報を操作するコントローラー.
 * 
 * @author fukushima
 *
 */
@Controller
@RequestMapping("/")
public class ShowItemListController {

	@Autowired
	private ShowItemListService service;

	@RequestMapping("")
	public String showItemList(Model model) {
		
		List<Item> itemList = service.showItemList();
		List<List<Item>> itemList3 = new ArrayList<>();
		List<Item> itemList2 = new ArrayList<>();
		
		int roopCount = 0;
		for(Item item : itemList) {
			itemList2.add(item);
			roopCount++;
			
			if(roopCount %3 == 0) {
				itemList3.add(itemList2);
				itemList2 = new ArrayList<>();
			}
		}
		
		model.addAttribute("itemList3", itemList3);
		
		return "item_list";
	}
}
