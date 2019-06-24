package io.github.seevae.mapper;/*
    name zhang;
    */

import io.github.seevae.po.Items;
import io.github.seevae.po.ItemsCustom;
import io.github.seevae.po.ItemsVO;

import java.util.List;

public interface ItemsCustomMapper {
    public List<ItemsCustom> queryItemsByName(ItemsVO itemsVO) throws Exception;
}
