class Solution {
public:
    ListNode* removeNthFromEnd(ListNode* head, int n) {

        ListNode* dummy = new ListNode(0);
        dummy->next = head;

        ListNode* first = head;
        ListNode* second = dummy;

        // Move first n steps ahead
        for (int i = 0; i < n; i++) {
            first = first->next;
        }

        // Move both pointers simultaneously
        while (first != nullptr) {
            first = first->next;
            second = second->next;
        }

        // Remove nth node from end
        second->next = second->next->next;

        return dummy->next;
    }
};