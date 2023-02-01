package com.company;

import java.util.ArrayList;
import java.util.List;

public class testList {
   Node head;

    static class Node {
        int data;
        Node next;

        Node(int d) {
            this.data = d;
            this.next = null;
        }
    }

    public void reverse() {
        Node curr = head;
        Node prev = null, next = null;

        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    public int ncr(int n, int r) {
        if(n==r | r==0) {
            return 1;
        }
        return ncr(n-1, r-1) + ncr(n-1, r);
    }

    public int iterative_fib(int n) {
        if(n <= 1) {
            return n;
        }
        int s =0, t0 =0, t1 = 1;

        for(int i=2; i<n; i++) {
            s = t0+t1;
            t0 = t1;
            t1 = s;
        }

        return s;
    }

    public int removeDuplicates(int nums[]) {
        int uniqueCounts = 1;
        for(int i=1; i<nums.length; i++) {
            if(nums[i] != nums[i-1]) {
                nums[uniqueCounts] = nums[i];
                uniqueCounts += 1;
            }
        }
        return uniqueCounts;
    }

    // Pascel's Triangle
    public List<List<Integer>> generatePascel(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();

        if(numRows == 0) return  triangle;

        List<Integer> first_row = new ArrayList<>();
        first_row.add(1);
        triangle.add(first_row);


        for(int i=1; i<numRows; i++) {
            List<Integer> prev_row = triangle.get(i-1);
            List<Integer> row = new ArrayList<>();

            row.add(1);

            for(int j=1; j<i; j++) {
                row.add(prev_row.get(j-1) + prev_row.get(j));
            }
            row.add(1);
            triangle.add(row);
        }
        return triangle;
    }

    // Pascel's Triangle Practice
    public List<List<Integer>> pascelTriangle(int numRows) {
       List<List<Integer>> triangle = new ArrayList<>();
       if(numRows == 0) return triangle;

       List<Integer> firstRow = new ArrayList<>();
       firstRow.add(1);
       triangle.add(firstRow);
       for(int i=1; i<numRows; i++) {
           List<Integer> prev_row = triangle.get(i-1);
           List<Integer> curr_row = new ArrayList<>();

           curr_row.add(1);
           for(int j=1; j<i; j++) {
               curr_row.add(prev_row.get(j-1) + prev_row.get(j));
           }
           curr_row.add(1);
           triangle.add(curr_row);
       }
        return triangle;
    }

//    Given an integer rowIndex, return the rowIndexth (0-indexed) row of the Pascal's triangle.
public List<Integer> pascelTriangleIndexthRow(int rowIndex) {
    List<List<Integer>> triangle = new ArrayList<>();

    int numRows = 34;
    if(numRows == 0) return triangle.get(0);

    List<Integer> firstRow = new ArrayList<>();
    firstRow.add(1);
    triangle.add(firstRow);

    for(int i=1; i<numRows; i++) {
        List<Integer> prev_row = triangle.get(i-1);
        List<Integer> curr_row = new ArrayList<>();

        curr_row.add(1);
        for(int j=1; j<i; j++) {
            curr_row.add(prev_row.get(j-1) + prev_row.get(j));
        }
        curr_row.add(1);
        triangle.add(curr_row);
    }
    return triangle.get(rowIndex);
}


}
