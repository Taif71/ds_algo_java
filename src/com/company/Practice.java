package com.company;


public class Practice {
    Node root;

    static class Node {
        int data;
        Node right;
        Node left;

        Node (int d) {
            this.data = d;
            this.left = null;
            this.right = null;

        }

        public void displayData() {
            System.out.println(data + " ");
        }
    }

    Practice() {
        root = null;
    }

    public void insert(int data) {
        root = insertNode(root, data);
    }

    public void delete(int data) {
        root = this.deleteNode(root, data);
    }

    static Node insertNode(Node node, int value) {
        if(node == null) {
            return new Node(value);
        }

        if(value < node.data) {
            node.left = insertNode(node.left, value);
        } else if(value > node.data) {
            node.right = insertNode(node.right, value);
        }
        return node;
    }

     Node deleteNode(Node node, int value) {
        if(node == null) return node;

        if(value < node.data) {
            node.left = deleteNode(node.left, value);
        } else if(value > node.data) {
            node.right = deleteNode(node.right, value);
        } else {
            // for single or zero child nodes
            if(node.left == null) {
                return node.right;
            } else if(node.right == null) {
                return node.left;
            }

            // for a node with 2 children
            node.data = minValue(node);

            root.right = deleteNode(node.right, node.data);
        }
        return node;
    }

    int minValue(Node root) {
        int minVal = root.data;
        while(root.left != null) {
            minVal = root.left.data;
            root = root.left;
        }
        return minVal;
    }

}


// Array, String
// Stack - array and linked list
// Linked-List
// Recursion
// Tree, BT, BST, AVL tree, etc
// Graph, MST, DFS, BFS
// Hashing , Hashtables / hashmaps
// Tries

/* Algorithms
  1. Sorting algos:
  2. Graph Algos
  3. Dynamic Programming
  4. Greedy algos
 */

