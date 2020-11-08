package com.company;

public class BinTree {
    Node root;
    BinTree(int rootValue){
        root = new Node(rootValue);
    }

    private Node addNode(int value, Node curNode){
        if (curNode == null ){
            curNode = new Node(value);
        }
        if (value < curNode.value){
            curNode.left = addNode(value, curNode.left);
        }
        else if (value > curNode.value){
            curNode.right = addNode(value, curNode.right);
        }
        else{
            return curNode;
        }
        return curNode;
    }

    public void add(int value){
        root = addNode(value, root);
    }

    private Node delNode(int value, Node curNode){
        if (curNode == null ){
            return null;
        }
        if (value < curNode.value){
            curNode.left = delNode(value, curNode.left);
        }
        else if (value > curNode.value){
            curNode.right = delNode(value, curNode.right);
        }
        else{
            if (curNode.left == null & curNode.right == null) {
                return null;
            }
            else if (curNode.left == null){
                return  curNode.right;
            }
            else if (curNode.right == null){
                return curNode.left;
            }
            else{
                curNode.value = smallestNode(curNode.right);
                curNode.right = delNode(curNode.value, curNode.right);
            }
        }
        return curNode;
    }
    private int smallestNode(Node node){
        if (node.left == null){
            return node.value;
        }
        return smallestNode(node.left);
    }
    public void del(int value){
        root = delNode(value, root);
    }
    private void printTreeNode(Node node) {
        if (node != null) {
            printTreeNode(node.left);
            System.out.print(" " + node.value);
            printTreeNode(node.right);
        }
    }
    public void printTree(){
        printTreeNode(root);
        System.out.println();
    }
    public boolean contNode(int value, Node curNode) {
        if (curNode == null) {
            return false;
        }
        if (value < curNode.value){
            return contNode(value, curNode.left);
        }
        else if (value > curNode.value){
            return contNode(value, curNode.right);
        }
        else{
            return true;
        }
    }
    public boolean contains(int value) {
        return contNode(value, root);
    }
}
