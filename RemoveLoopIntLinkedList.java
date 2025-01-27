**/
Remove loop in Linked List
Difficulty: MediumAccuracy: 27.66%Submissions: 498K+Points: 4
Given the head of a linked list that may contain a loop.  A loop means that the last node of the linked list is connected back to a node in the same list. The task is to remove the loop from the linked list (if it exists).

Custom Input format:

A head of a singly linked list and a pos (1-based index) which denotes the position of the node to which the last node points to. If pos = 0, it means the last node points to null, indicating there is no loop.

The generated output will be true if there is no loop in list and other nodes in the list remain unchanged, otherwise, false.

Examples:

Input: head = 1 -> 3 -> 4, pos = 2
Output: true
Explanation: The linked list looks like

A loop is present in the list, and it is removed.
Input: head = 1 -> 8 -> 3 -> 4, pos = 0
Output: true
Explanation: 

The Linked list does not contains any loop. 
Input: head = 1 -> 2 -> 3 -> 4, pos = 1
Output: true
Explanation: The linked list looks like 

A loop is present in the list, and it is removed.
Constraints:
1 ≤ size of linked list ≤ 105

**/

//{ Driver Code Starts
// driver code

import java.io.*;
import java.lang.*;
import java.util.*;

class Node {
    int data;
    Node next;
}

class GFG {
    public static Node newNode(int data) {
        Node temp = new Node();
        temp.data = data;
        temp.next = null;
        return temp;
    }

    public static void makeLoop(Node head, int x) {
        if (x == 0) return;
        Node curr = head;
        Node last = head;

        int currentPosition = 1;
        while (currentPosition < x) {
            curr = curr.next;
            currentPosition++;
        }

        while (last.next != null) last = last.next;
        last.next = curr;
    }

    public static boolean detectLoop(Node head) {
        Node hare = head.next;
        Node tortoise = head;
        while (hare != tortoise) {
            if (hare == null || hare.next == null) return false;
            hare = hare.next.next;
            tortoise = tortoise.next;
        }
        return true;
    }

    public static int length(Node head) {
        int ret = 0;
        while (head != null) {
            ret += 1;
            head = head.next;
        }
        return ret;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {

            String str[] = read.readLine().trim().split(" ");
            int n = str.length;

            int num = Integer.parseInt(str[0]);
            Node head = newNode(num);
            Node tail = head;

            for (int i = 1; i < n; i++) {
                num = Integer.parseInt(str[i]);
                tail.next = newNode(num);
                tail = tail.next;
            }

            int pos = Integer.parseInt(read.readLine());
            makeLoop(head, pos);

            Solution x = new Solution();
            x.removeLoop(head);

            if (detectLoop(head) || length(head) != n)
                System.out.println("false");
            else
                System.out.println("true");

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


/*
class Node
{
    int data;
    Node next;
}
*/

class Solution {
    // Function to remove a loop in the linked list.
    public static void removeLoop(Node head) {
        // code here
        Node slow=head;
        Node fast=head;
        Node s=head;
        while(fast!=null && fast.next!=null){
            if(slow!=head)s=slow;
            slow=slow.next;
            fast=fast.next.next;
            
            if(slow==fast){
                    Node p=head;

                    while(p!=slow){
                        s=s.next;
                        p=p.next;
                        slow=slow.next;
                    }
                   
                    s.next=null;
            }
        }
    }
}