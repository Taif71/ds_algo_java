package com.company;

public class LinkedList {
    Node head;

//    LinkedList() {
//        this.head = null;
//    }

    static class Node {
        int data;
        Node next;

        Node(int d) {
            this.data = d;
            this.next = null;
        }

    }

    public void printList() {
        Node n = head;
        while(n != null) {
            System.out.println(n.data + " " );
            n = n.next;
        }
    }

    public boolean iSearch(Node head, int x) {
        Node currNode = head;
        while(currNode != null) {
            if(currNode.data == x) {
                return true;
            }
            currNode = currNode.next;
        }
        return false;
    }

    public void pushToFront(int val) {
        Node newNode = new Node(val);
        newNode.next = head;
        head = newNode;
    }

    // insertion by ascending or descending order

    // insert value
    public void insert(int val) {
        // inserting data at the end of node
        Node curr = head;
        Node newNode = new Node(val);

        while(curr != null) {
            if(head == null) {
                head = newNode;
            } else if(curr.next == null) {
                curr.next = newNode;
                break;
            }
            curr = curr.next;
        }
    }

    // *********** COUNT NODES ************
    public int countNodes() {
        int count = 0;
        Node temp = head;

        while(temp != null) {
            temp = temp.next;
            count++;
        }
        return count;
    }

    public int recursiveCountNodes(Node node)
    {
        // Base case
        if (node == null)
            return 0;

        // Count is this node plus rest of the list
        return 1 + recursiveCountNodes(node.next);
    }

    // Insertion at a particular index
    public void insertAtIndex(int val, int index) {

    }

    // ***** REVERSE LINKED LIST *************
    public void reverse() {
        Node prev =null;
        Node next = null;
        Node current = head;

        while(current != null) {
            next = current.next; // next = 2
            current.next = prev; // prev == null, current.next = NULL
            prev = current;
            current = next;
        }
        head = prev;
    }

     // there are recursive approaches to this. learn those as well


    // ******** DELETION ***********

    // ********* GET Nth nodes
    public int GetNth(int index)
    {
        Node current = head;
        int count = 0; /* index of Node we are
                          currently looking at */
        while (current != null)
        {
            if (count == index)
                return current.data;
            count++;
            current = current.next;
        }

        /* if we get to this line, the caller was asking
        for a non-existent element so we assert fail */
        assert (false);
        return 0;
    }

    // recursive approach:
    public int RGetNth(Node head, int n)
    {
        int count = 0;
        if (head == null) // edge case - if head is null
            return -1;
        // if count equal too n return node.data
        if (count == n)
            return head.data;

        // recursively decrease n and increase
        // head to next pointer
        return RGetNth(head.next, n - 1);
    }


    public Node mergeTwoLists(Node node1, Node node2) {
        Node newNode = new Node(0);
        Node tail = newNode;

        while(node1 != null && node2 != null) {
            if(node1.data < node2.data) {
                tail.next = node1;
                node1 = node1.next;
            } else {
                tail.next = node2;
                node2 = node2.next;
            }
            tail = tail.next;
        }

        if(node1 != null) {
            tail.next = node1;
        }
        if(node2 != null) {
            tail.next = node2;
        }
        return tail;
    }


}
