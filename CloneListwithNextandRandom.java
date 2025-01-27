/**Clone List with Next and Random
Difficulty: HardAccuracy: 64.8%Submissions: 107K+Points: 8
You are given a special linked list with n nodes where each node has two pointers a next pointer that points to the next node of the singly linked list, and a random pointer that points to the random node of the linked list.

Construct a copy of this linked list. The copy should consist of the same number of new nodes, where each new node has the value corresponding to its original node. Both the next and random pointer of the new nodes should point to new nodes in the copied list, such that it also represent the same list state. None of the pointers in the new list should point to nodes in the original list.

Return the head of the copied linked list.

NOTE : Original linked list should remain unchanged.

Examples:

Input: head = [[1, 3], [3, 3], [5, NULL], [9, 3]] 
      
Output: head = [[1, 3], [3, 3], [5, NULL], [9, 3]] 
Explanation: 
Node 1 points to Node 2 as its NEXT and Node 3 as its RANDOM.
Node 2 points to Node 3 as its NEXT and Node 3 as its RANDOM.
Node 3 points to Node 4 as its NEXT and NULL as its RANDOM.
Node 4 points to NULL as its NEXT and Node 3 as its RANDOM.
Input: head = [[1, 3], [2, 1], [3, 5], [4, 3], [5, 2]]
  
 
Output: head = [[1, 3], [2, 1], [3, 5], [4, 3], [5, 2]]
Explanation: 
Node 1 points to Node 2 as its NEXT and Node 3 as its RANDOM.
Node 2 points to Node 3 as its NEXT and Node 1 as its RANDOM.
Node 3 points to Node 4 as its NEXT and Node 5 as its RANDOM.
Node 4 points to Node 5 as its NEXT and Node 3 as its RANDOM.
Node 5 points to NULL as its NEXT and Node 2 as its RANDOM.
Input: head = [[7, NULL], [7, NULL]]
Output: head = [[7, NULL], [7, NULL]]
Explanation: 
Node 1 points to Node 2 as its NEXT and NULL as its RANDOM.
Node 2 points to NULL as its NEXT and NULL as its RANDOM.
Constraints:
1 <= n <= 100
0 <= node->data <= 1000

**/

//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

class Node {
    int data;
    Node next;
    Node random;

    Node(int x) {
        data = x;
        next = null;
        random = null;
    }
}

public class Main {
    public static void print(Node root) {
        Map<Node, Integer> link = new HashMap<>();
        Node temp = root;
        int index = 0;

        // Store node addresses and their index
        while (temp != null) {
            link.put(temp, index++);
            temp = temp.next;
        }

        temp = root;
        System.out.print("[");
        while (temp != null && temp.next != null) {
            if (temp.random == null) {
                System.out.print("[" + temp.data + ", NULL], ");
            } else {
                System.out.print("[" + temp.data + ", " + (link.get(temp.random) + 1) +
                                 "], ");
            }
            temp = temp.next;
        }
        if (temp != null) {
            if (temp.random == null) {
                System.out.print("[" + temp.data + ", NULL]]\n");
            } else {
                System.out.print("[" + temp.data + ", " + (link.get(temp.random) + 1) +
                                 "]]\n");
            }
        }
    }

    public static Node buildLinkedList(List<int[]> v, Map<Node, Integer> orgAddress) {
        List<Node> address = new ArrayList<>(v.size());
        Node head = new Node(v.get(0)[0]);
        address.add(head);
        orgAddress.put(head, 0);
        Node temp = head;

        for (int i = 1; i < v.size(); i++) {
            Node newNode = new Node(v.get(i)[0]);
            orgAddress.put(newNode, i);
            address.add(newNode);
            temp.next = newNode;
            temp = temp.next;
        }

        temp = head;
        for (int i = 0; i < v.size(); i++) {
            int randomIndex = v.get(i)[1];
            if (randomIndex != -1) {
                temp.random = address.get(randomIndex - 1);
            }
            temp = temp.next;
        }

        return head;
    }

    public static boolean validateInput(Map<Node, Integer> orgAddress, Node head,
                                        List<int[]> v) {
        List<Node> address = new ArrayList<>(v.size());
        Node temp = head;

        for (int i = 0; i < v.size(); i++) {
            if (!orgAddress.containsKey(temp) || orgAddress.get(temp) != i) {
                return false;
            }
            address.add(temp);
            temp = temp.next;
        }

        if (temp != null) {
            return false;
        }

        temp = head;
        for (int i = 0; i < v.size(); i++) {
            int value = v.get(i)[0];
            int randomIndex = v.get(i)[1];

            if (randomIndex == -1) {
                if (temp.random != null) {
                    return false;
                }
            } else {
                Node tempNode = address.get(randomIndex - 1);
                if (temp.random != tempNode) {
                    return false;
                }
            }
            temp = temp.next;
        }
        return true;
    }

    public static boolean validation(Node res, Map<Node, Integer> orgAddress) {
        Node temp = res;
        while (temp != null) {
            if (orgAddress.containsKey(temp)) {
                return false;
            }
            if (orgAddress.containsKey(temp.random)) {
                return false;
            }
            temp = temp.next;
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            List<int[]> v = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                int x = sc.nextInt();
                String y = sc.next();
                int randomIndex = y.equals("NULL") || y.equals("N") ||
                                          y.equals("null") || y.equals("n") ||
                                          y.equals("Null")
                                      ? -1
                                      : Integer.parseInt(y);
                v.add(new int[] {x, randomIndex});
            }
            Map<Node, Integer> orgAddress = new HashMap<>();
            Node head = buildLinkedList(v, orgAddress);

            Solution solution = new Solution();
            Node res = solution.cloneLinkedList(head);

            // Validate if input is modified
            if (validateInput(orgAddress, head, v)) {
                if (validation(res, orgAddress)) {
                    print(res);
                } else {
                    System.out.println("Pointing to the original list");
                }
            } else {
                System.out.println("Input list modified");
            }
            System.out.println("~");
        }
        sc.close();
    }
}
// } Driver Code Ends


/*linked list node
class Node {
    int data;
    Node next;
    Node random;

    Node(int x) {
        data = x;
        next = null;
        random = null;
    }
}
*/
class Solution {
    public Node cloneLinkedList(Node head) {
        // code here
          Map<Node,Integer> m=new HashMap<>();
          Node n=head;
          int i=1;
          while(n!=null){
              m.put(n,i++);
              n=n.next;
          }
          Node nn=new Node(head.data);
             n=head;
             n=n.next;
           Node na=nn;
         
           while(n!=null){
               Node nnn=new Node(n.data);
               na.next=nnn;
               na=nnn;
               n=n.next;
           }
             Map<Integer,Node> mm=new HashMap<>();
           i=1;
           n=nn;
           while(n!=null){
               mm.put(i++,n);
               n=n.next;
           }
           n=head;
         Node nnn=nn;
           while(n!=null){
               if(n.random!=null){
                   int a=m.get(n.random);
                   nnn.random=mm.get(a);
               }
               n=n.next;
               nnn=nnn.next;
           }
           
          
         
      return nn;
    }
}