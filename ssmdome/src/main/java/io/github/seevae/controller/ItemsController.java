package io.github.seevae.controller;

import io.github.seevae.po.ItemsCustom;
import io.github.seevae.po.ItemsVO;
import io.github.seevae.service.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Iterator;
import java.util.List;


@Controller
public class ItemsController {

    @Autowired
    private ItemsService itemsService;

    @RequestMapping(value = "/zhang")
    public ModelAndView queryUserById() throws Exception {

        ItemsVO itemsVO = new ItemsVO();
        ItemsCustom itemsCustom = new ItemsCustom();
        itemsCustom.setName("ovo");
        itemsVO.setItemsCustom(itemsCustom);

        //调用service层去查询数据
        List<ItemsCustom> list = itemsService.queryItemsByName(itemsVO);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("itemsListKey",list);
        modelAndView.setViewName("itemsList");
        return modelAndView;
    }

}
