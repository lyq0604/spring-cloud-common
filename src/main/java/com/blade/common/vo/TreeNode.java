package com.blade.common.vo;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * 树节点
 *
 * @author lyq
 * @create 9/26/19
 */
@Data
public class TreeNode {

    private String id;
    private String parentId;
    private List<TreeNode> children = new ArrayList();

    public TreeNode() {
    }

    public void add(TreeNode node) {
        this.children.add(node);
    }

}
