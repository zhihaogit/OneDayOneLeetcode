// 对链表进行插入排序。

// 插入排序的动画演示如上。从第一个元素开始，该链表可以被认为已经部分排序（用黑色表示）。
// 每次迭代时，从输入数据中移除一个元素（用红色表示），并原地将其插入到已排好序的链表中。

// 插入排序算法：
// 插入排序是迭代的，每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。
// 每次迭代中，插入排序只从输入数据中移除一个待排序的元素，找到它在序列中适当的位置，并将其插入。
// 重复直到所有输入数据插入完为止。

// 示例 1：
// 输入: 4->2->1->3
// 输出: 1->2->3->4

// 示例 2：
// 输入: -1->5->3->4->0
// 输出: -1->0->3->4->5

/**
 * Definition for singly-linked list.
 */
class ListNode {
  int val;
  ListNode next;

  ListNode() {
  }

  ListNode(int val) {
    this.val = val;
  }

  ListNode(int val, ListNode next) {
    this.val = val;
    this.next = next;
  }
}

class Solution {
  /**
   * 链表的插入排序
   * 
   * 不需要像数组的插入排序一样挪动后续元素的位置，只需要修改节点的连接
   * 
   * 大致为遍历链表的同时，判断当前元素与后续位置的大小
   * 
   * 如果后续位置一直小于或者等于当前元素，后续位置一直向后更新
   * 
   * 大于当前元素，则从链表首位开始寻找合适的插入位置（大于当前元素的值），找到后通过修改连接进行插入
   * 
   * @param head
   * @return
   */
  public ListNode insertionSortList(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }

    // 1. 初始化模板首位，next指向真实首部
    ListNode tmpHead = new ListNode(0);
    tmpHead.next = head;
    // 初始化最近有序节点，表示前面的节点都比遍历的当前节点小
    ListNode lastSorted = head;
    // 初始化遍历使用的节点
    ListNode currentSort = head.next;
    while (currentSort != null) {
      if (lastSorted.val <= currentSort.val) {
        // 2-1. 如果当前遍历到的节点比最近有序节点大，则一直更新有序节点的位置
        lastSorted = lastSorted.next;
      } else {
        // 2-2. 如果最近有序节点比当前节点大，则从第一位开始寻找合适的位置用于插入
        // 初始化一个节点代替模板首部
        ListNode first = tmpHead;
        // 2-3. 持续比较，持续更新位置
        while (first.next.val <= currentSort.val) {
          first = first.next;
        }
        // 2-4. 此时说明找到了合适的位置，通过修改链表的连接进行插入
        lastSorted.next = currentSort.next;
        currentSort.next = first.next;
        first.next = currentSort;
      }
      // 3. 这个时候当前节点的前面链表都是有序的，更新当前节点
      currentSort = lastSorted.next;
    }
    return tmpHead.next;
  }
}
