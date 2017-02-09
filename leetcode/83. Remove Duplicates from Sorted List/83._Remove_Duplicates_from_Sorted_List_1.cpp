/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    ListNode* deleteDuplicates(ListNode* head) {
        ListNode* current = head;
        while( current && current->next ) {
            if( current->val == current->next->val ) {
                auto next = current->next;
                current->next = next->next;
                delete next;
                continue;
            }
            current = current->next;
        }
        return head;
    }
};