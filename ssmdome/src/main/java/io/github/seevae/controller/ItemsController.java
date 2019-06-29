package io.github.seevae.controller;

import io.github.seevae.mapper.ItemsMapper;
import io.github.seevae.po.Items;
import io.github.seevae.po.ItemsCustom;
import io.github.seevae.po.ItemsVO;
import io.github.seevae.service.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.WebParam;
import java.util.Iterator;
import java.util.List;


@Controller
public class ItemsController {

    @Autowired
    private ItemsService itemsService;

    @RequestMapping(value = "/zhang")
    public ModelAndView queryUserById() throws Exception {

        //调用service层去查询数据
        List<ItemsCustom> list = itemsService.queryItemsByName(null);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("itemsListKey",list);
        modelAndView.setViewName("itemsList");
        return modelAndView;
    }

    @RequestMapping(value="/modifyInfoShow")
    public String modifyInfoShow(Model model,@RequestParam(value = "id")Integer id) throws Exception{
        //去查询数据
        Items items = itemsService.selectByPrimaryKey(id);
        System.out.println(items);
        model.addAttribute("itemsCustomKey",items);
        return "edit";
    }

    @RequestMapping(value = "/editSubmit")
    public String editSubmit(@RequestParam(value = "id")Integer id,Items items) throws  Exception{
        System.out.println(items);
        itemsService.updateByPrimaryKeyWithBLOBs(id,items);
        //请求转发
        return "forward:zhang.action";
    }


    //使方法仅仅返回void实现修改或者查询
    


}
