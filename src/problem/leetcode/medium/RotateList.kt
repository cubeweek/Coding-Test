package problem.leetcode.medium


// Example:
// var li = ListNode(5)
// var v = li.`val`
// Definition for singly-linked list.
class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

class RotateList {
    fun rotateRight(head: ListNode?, k: Int): ListNode? {
        if (head == null || head.next == null || k == 0) return head

        var n = 1
        var tail = head
        while (tail?.next != null) {
            tail = tail.next
            n++
        }

        val kMod = k % n
        if (kMod == 0) return head

        tail?.next = head // 순회구조로 변경

        var newTail = head
        repeat (n - kMod - 1) {
            newTail = newTail?.next
        }

        val newHead = newTail?.next
        newTail?.next = null

        return newHead
    }
}