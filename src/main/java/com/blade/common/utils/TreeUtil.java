package com.blade.common.utils;

import com.blade.common.vo.TreeNode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 树结构工具类
 *
 * @author lyq
 * @create 9/26/19
 */
public class TreeUtil {

    public static <T extends TreeNode> List<T> build(List<T> treeNodes, String root) {
        if (root == null) {
            return null;
        } else {
            List<T> trees = new ArrayList();
            Iterator iterator = treeNodes.iterator();

            while(iterator.hasNext()) {
                TreeNode treeNode = (TreeNode)iterator.next();
                if (root.equals(treeNode.getParentId())) {
                    trees.add((T) treeNode);
                    iterator.remove();
                }
                Iterator var5 = treeNodes.iterator();
                while(var5.hasNext()) {
                    T it = (T) var5.next();
                    if (it.getParentId().equals(treeNode.getId())) {
                        if (treeNode.getChildren() == null) {
                            treeNode.setChildren(new ArrayList());
                        }
                        treeNode.add(it);
                    }
                }
            }
            return trees;
        }
    }

}
