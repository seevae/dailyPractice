package com.qi.controller;

import com.qi.po.Items;
import com.qi.service.ItemsServiceI;
import com.qi.service.impl.ItemsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
public class ItemsController {


	private ItemsServiceI itemsServiceImpl = new ItemsServiceImpl();

	@RequestMapping("/show.do")
	public ModelAndView addItem() {
		System.out.println("来到了后端");
		List<Items> list = itemsServiceImpl.findAllItems();
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("list",list);
		modelAndView.setViewName("/jsp/index01.jsp");
		return modelAndView;
	}
}
