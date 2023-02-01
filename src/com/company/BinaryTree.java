package com.company;
/*
    Binary Tree Operations:
        1. Insertion
        2. Search
        3. Deletion - deleteDeepestNode, delete specific node, delete root node
        4. Traversion
*/
public class BinaryTree {

    public Node root;
    public static boolean flag = false;

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }

        public void displayData()
        {
            System.out.print(data + " ");
        }
    }

    public BinaryTree() {
        this.root = null;
    }

    public  void insert(int value) {
        root = insertNode(root, value);
    }
    public  void search(int value) {
         searchNode(root, value);
    }

    public Node insertNode(Node node, int value) {
        if(root == null) {
          return new Node(value);
        }
        else if(node.data > value) {
            if(node.left != null) {
                insertNode(node.left, value);
            } else {
                node.left = new Node(value);
            }
        } else if(node.data < value)  {
            // value is greater than node data
            if(node.right != null) {
                insertNode(node.right, value);
            } else {
                node.right = new Node(value);
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

            if(flag == false && temp.left != null) {
                searchNode(temp.left, value);
            }

            if(flag == false && temp.right != null) {
                searchNode(temp.right, value);
            }
        }
        return -1;
    }
    // Search node in binary search tree
    public Node find(int searchedValue)
    {
        Node current = root;
        while(current.data != searchedValue)
        {
            if(searchedValue < current.data)
                // Move to the left if searched value is less
                current = current.left;
            else
                // Move to the right if searched value is >=
                current = current.right;
            if(current == null)
            {
                return null;
            }
        }
        return current;
    }


    // For traversing in order
    public void inOrder(Node node)
    {
        if(node != null)
        {
            inOrder(node.left);
            node.displayData();
            inOrder(node.right);
        }
    }
    // Preorder traversal
    public void preOrder(Node node)
    {
        if(node != null){
            node.displayData();
            preOrder(node.left);
            preOrder(node.right);
        }
    }
    // Postorder traversal
    public void postOrder(Node node)
    {
        if(node != null)
        {
            postOrder(node.left);
            postOrder(node.right);
            node.displayData();
        }
    }
}
