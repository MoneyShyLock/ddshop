package com.zdp.ddshop.service;

import com.zdp.ddshop.common.dto.TreeNode;

import java.util.List;

public interface ItemCatService {
    public List<TreeNode> listItemCats(Long parentId);
}
