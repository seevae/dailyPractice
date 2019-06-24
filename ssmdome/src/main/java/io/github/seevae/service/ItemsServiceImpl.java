package io.github.seevae.service;/*
    name zhang;
    */

import io.github.seevae.mapper.ItemsCustomMapper;
import io.github.seevae.po.ItemsCustom;
import io.github.seevae.po.ItemsVO;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ItemsServiceImpl implements ItemsService{

    @Autowired
    private ItemsCustomMapper itemsCustomMapper;

    @Override
    public List<ItemsCustom> queryItemsByName(ItemsVO itemsVO) throws Exception {
        List<ItemsCustom> list = itemsCustomMapper.queryItemsByName(itemsVO);
        return list;
    }

}
