package com.company;
/*
    BST Operations:
        1. insertion
        2. search recursive + iterative
        3. deletion
*/
public class BST {
    Node root;

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

        public void displayData()
        {
            System.out.print(data + " ");
        }
    }

    BST() {
        root = null;
    }

    public void insert(int value) {
        root = insertNode(root, value);
    }

    static Node insertNode(Node node, int value) {
        if(node == null) {
           return new Node(value);
        }
        if(value < node.data) {
            node.left = insertNode(node.left, value);
        }
        if(node.data < value) {
            node.right = insertNode(node.right, value);
        }
        return node;
    }

    void deleteKey(int key) {
        root = deleteRec(root, key);
    }

    Node deleteRec(Node root, int data) {
        if(root == null) return root;

        if(data < root.data) {
            root.left = deleteRec(root.left, data);
        } else if(data > root.data) {
            root.right = deleteRec(root.right, data);
        } else {
            // if key is same as root's
            // key, then This is the
            // node to be deleted

            // node with only one child or no child
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            // node with two children: Get the inorder
            // successor (smallest in the right subtree)
            root.data = minValue(root.right);

            // Delete the inorder successor
            root.right = deleteRec(root.right, root.data);
        }
        return root;
    }

    int minValue(Node root)
    {
        int minv = root.data;
        while (root.left != null) {
            minv = root.left.data;
            root = root.left;
        }
        return minv;
    }

    // inorder traversal of BST
    public void inorder(Node node) {
        if(node != null) {
            inorder(node.left);
            node.displayData();
            inorder(node.right);
        }
    }
}
