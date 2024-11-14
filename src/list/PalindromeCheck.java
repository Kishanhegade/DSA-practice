package list;

import java.util.ArrayList;

public class PalindromeCheck {
    public class ListNode {
     int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    public boolean isPalindrome(ListNode head) {
        ArrayList<ListNode> list = new ArrayList<>();
        ListNode temp = head;
        while(temp!=null)
        {
            list.add(temp);
            temp = temp.next;
        }
        ArrayList<ListNode> rev = new ArrayList<>();
        for(int i=list.size()-1;i>=0;i--)
        {
            rev.add(list.get(i));
        }
        return list.equals(rev);
    }
}
