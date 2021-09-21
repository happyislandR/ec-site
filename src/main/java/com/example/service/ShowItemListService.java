package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.Item;
import com.example.repository.ItemRepository;

/**
 * 商品情報を操作するサービス.
 * 
 * @author fukushima
 *
 */
@Service
public class ShowItemListService {
	@Autowired
	private ItemRepository repository;
	
	/**
	 * 商品情報を全件検索する.
	 * 
	 * @return 全件の商品
	 */
	public List<Item> showItemList() {
		List<Item> itemList = repository.findAll();
		return itemList;
	}
}
