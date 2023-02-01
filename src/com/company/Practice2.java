package com.company;

public class Practice2 {
    // implement search, insert for Binary Tree

    static class Node {
        int data;
        Node prev;
        Node next;

        Node(int data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    Node root;
    public static boolean flag = false;

    Practice2() {
        this.root = null;
    }

    public void insert(int value)
    {
        root = insertNode(root, value);
    }

    public void search(int value) {
        searchNode(root, value);
    }
    public Node insertNode(Node node, int value) {
        if(root == null) {
            return new Node(value);
        } else {
            if(node.prev != null) {
                insertNode(node.prev, value);
            } else {
                node.prev = new Node(value);
            }

            if(node.next != null) {
                insertNode(node.next, value);
            } else {
                node.next = new Node(value);
            }
        }
        return node;
    }

    public int searchNode(Node temp, int value) {
        if(root == null) {
            System.out.println("Tree is empty");
            return -1;
        } else {
            if(temp.data == value) {
                flag = true;
                return value;
            }
            if(temp.prev != null) {
                searchNode(temp.prev, value);
            }
            if(temp.next != null) {
                searchNode(temp.next, value);
            }
        }
        return -1;
    }
}
