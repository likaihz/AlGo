//反转一个单链表。 
//
// 示例: 
//
// 输入: 1->2->3->4->5->NULL
//输出: 5->4->3->2->1->NULL 
//
// 进阶: 
//你可以迭代或递归地反转链表。你能否用两种方法解决这道题？ 
// Related Topics 链表 
// 👍 1231 👎 0

  
package leetcode.editor.cn;

import leetcode.model.ListNode;

public class ReverseLinkedList{
      public static void main(String[] args) {
           Solution solution = new ReverseLinkedList().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    ListNode newHead = null;

    /**
     * 递归实现：时间O(n), 空间O(n)
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if(head == null) return null;
        recr(head);
        head.next = null;
        return newHead;
    }

    private ListNode recr(ListNode node) {
        if(node == null) return null;
        ListNode rTail = recr(node.next);
        if (rTail == null) {
            newHead = node;
        } else {
            rTail.next = node;
        }

        return node;
    }

    /**
     * 非递归实现：时间O(n), 空间O(1)
     *
     * @param head
     * @return
     */
    public ListNode reverseList2(ListNode head) {
        ListNode pre = null, crt = head, next;
        while (crt != null) {
            next = crt.next;
            crt.next = pre;
            pre = crt;
            crt = next;
        }
        return pre;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}