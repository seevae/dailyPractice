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
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;
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


    //去添加页面
    //添加查询: 去添加页面
    @RequestMapping(value = "/addItems")
    public String addItesmController(){
        // how do I to do it?
        return "redirect:/jsp/addItems.jsp";
    }


    @RequestMapping(value = "/addItemsOperator")
    public void addItesmController1(HttpServletRequest request,
                                    HttpServletResponse response) throws Exception{

        String myFormat = "yyyy-MM-dd HH:mm:ss";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(myFormat);
        String strDate = request.getParameter("itemsTime");
        Date myDate = simpleDateFormat.parse(strDate);
        ItemsCustom itemsCustom = new ItemsCustom();
        itemsCustom.setName(request.getParameter("itemsName"));
        itemsCustom.setPrice(Float.valueOf(request.getParameter("itemsPrice")));
        itemsCustom.setCreatetime(myDate);
        itemsCustom.setDetail(request.getParameter("itemsInfo"));
        itemsService.addItems(itemsCustom);
        request.getRequestDispatcher("/zhang.action").forward(request,response);
    }


    //删除
    @RequestMapping(value = "/delete")
    public String deleteById(Integer id) throws Exception {
        System.out.println(id);
        itemsService.deleteByID(id);
        return "redirect:zhang.action";
    }

    //删除一组ID值
    @RequestMapping(value = "/deleteAll")
    public void deleteItemsByIds(HttpServletRequest request,
                                 HttpServletResponse response)throws Exception{
        //call by service
        String [] ids = request.getParameterValues("selItem");
        Integer [] idss = new Integer[ids.length];
        for (int i = 0 ; i < ids.length; i++) {
            idss[i] = Integer.valueOf(ids[i]);
        }
        itemsService.deleteids(idss);
        request.getRequestDispatcher("/zhang.action").forward(request,response);
    }

}
