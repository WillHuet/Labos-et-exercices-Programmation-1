package com.huet.datastructures;

import java.util.NoSuchElementException;

public class List<E> {
    private ListNode<E> firstNode;
    private ListNode<E> lastNode;
    private String name;

    public List() {this("list");}

    public List(String listName) {
        name = listName;
        firstNode = lastNode = null;
    }

    public void insertAtFront(E insertItem) {
        if (isEmpty()){
            firstNode = lastNode = new ListNode<E>(insertItem);
        }
        else{
            firstNode = new ListNode<E>(insertItem, firstNode);
        }
    }

    public void insertAtBack(E insertItem) {
        if (isEmpty()){
            firstNode = lastNode = new ListNode<E>(insertItem);
        }
        else{
            lastNode = lastNode.nextNode = new ListNode<E>(insertItem);
        }
    }

    public E removeFromFront() throws NoSuchElementException {
        if (isEmpty()){
            throw new NoSuchElementException(name + " is empty");
        }

        E removedItem = firstNode.data;

        if (firstNode == lastNode) {
            firstNode = lastNode = null;
        }
        else {
            firstNode = firstNode.nextNode;
        }

        return removedItem;
    }

    public E removeFromBack() throws NoSuchElementException {
        if (isEmpty()){
            throw new NoSuchElementException(name + " is empty");
        }

        E removedItem = lastNode.data;

        if (firstNode == lastNode) {
            firstNode = lastNode = null;
        }
        else {
            ListNode<E> current = firstNode;

            while (current.nextNode != lastNode) {
                current = current.nextNode;
            }

            lastNode = current;
            current.nextNode = null;
        }

        return removedItem;
    }

    public boolean isEmpty() {return firstNode == null;}

    public void print(){
        if (isEmpty()){
            System.out.printf("Empty %s%n", name);
            return;
        }

        System.out.printf("The %s is: ", name);
        ListNode<E> current = firstNode;

        while (current != null){
            System.out.printf("%s ", current.data);
            current = current.nextNode;
        }
        System.out.println();
    }
}
