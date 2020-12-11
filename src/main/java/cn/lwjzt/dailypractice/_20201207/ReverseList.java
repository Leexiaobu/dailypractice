package cn.lwjzt.dailypractice._20201207;

public class ReverseList {
    public ListNode reverseList(ListNode head) {
        ListNode cur=head;
        ListNode temp=null;

        while(cur!=null){
            ListNode next= cur.next;
            cur.next=temp;
            temp=cur;
            cur=next;
        }
        return temp;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
