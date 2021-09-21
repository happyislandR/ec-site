package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Item;
import com.example.service.ShowItemDetailService;

@Controller
@RequestMapping("/showDetail")
public class ShowItemDetailController {

	@Autowired
	private ShowItemDetailService showDetailService;

	/**
	 * 商品詳細画面を表示します.
	 *
	 * @param id 商品ID
	 * @param model モデル
	 * @return 商品詳細画面
	 */
	@RequestMapping("/showItemDetail")
	public String showItemDetail(Integer id, Model model) {
		Item item = showDetailService.showDetail(id);
		model.addAttribute("item", item);
		return "item_detail";
	}
}
