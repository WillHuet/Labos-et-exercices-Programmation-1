package com.huet.datastructures;

public class TreeNode<E extends Comparable<E>> {
    TreeNode<E> leftNode;
    E data;
    TreeNode<E> rightNode;

    public TreeNode(E nodeData) {
        data = nodeData;
        leftNode = rightNode = null;
    }

    public void insert(E insertValue){
        if (insertValue.compareTo(data) < 0) {
            if (leftNode == null) {
                leftNode = new TreeNode<>(insertValue);
            }
            else{
                leftNode.insert(insertValue);
            }
        }
        else if (insertValue.compareTo(data) > 0) {
            if (rightNode == null) {
                rightNode = new TreeNode<>(insertValue);
            }
            else {
                rightNode.insert(insertValue);
            }
        }
    }
}
