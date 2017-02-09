/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        int k = lists.length, doneCounter = 0;
        Heap h = new Heap(k);
        ListNode head = null, current = null;
        boolean isHead = true;
        
        for(int i=0; i<lists.length; i++) {
            if( lists[i] == null) {
                k--;
                continue;
            }
            h.insert(lists[i], i);
            lists[i] = lists[i].next;
        }
        if( h.position == 0)
            return head;
        while( doneCounter != k) {
            HeapNode temp = h.extractMin();
            if( isHead ) {
                head = temp.val;
                current = head;
                isHead = false;
            }
            else {
                ListNode next = temp.val;
                current.next = next;
                current = current.next;
            }
            if( current.next != null ) {
                int nextListId = temp.from;
                h.insert(lists[nextListId], nextListId);
                lists[nextListId] = lists[nextListId].next;
            }
            else {
                doneCounter++;
            }
        }
        
        return head;
        
    }
    public class Heap {
        public HeapNode[] heap;
        public int size;
        public int position;
        
        public Heap(int size) {
            this.size = size;
            heap = new HeapNode[size+1];
            position = 0;
            heap[0] = new HeapNode( new ListNode(0), -1); //dummy node
        }
        
        public HeapNode extractMin() {
            HeapNode output = heap[1];
            delete(1);
            return output;
        }
        public void insert(ListNode val, int from) {
            heap[++position] = new HeapNode(val, from);
            heapifyUp(position);
        }
        
        public void delete(int delIndex) {
            if( delIndex > 0) {
                if( delIndex != position) {
                    heap[delIndex] = heap[position];
                }
                position--;
                
                heapifyUp(delIndex);
                heapifyDown(delIndex);
            }
        }
        
        public void heapifyDown(int index) {
            int length = this.position, targetIndex = index;
            if( 2*index > length)
                return;
            else if (2*index < length) {
                int left = 2*index, right = 2*index+1;
                targetIndex = ( heap[left].val.val < heap[right].val.val) ? left : right; 
            }
            else if (2*index == length) {
                targetIndex = 2*index;
            }
            if( heap[targetIndex].val.val < heap[index].val.val ) {
                HeapNode temp = heap[index];
                heap[index] = heap[targetIndex];
                heap[targetIndex] = temp;
                heapifyDown(targetIndex);
            }
                
        }
        
        public void heapifyUp(int index) {
            if( index > 1) {
                int parentIndex = index/2;
                if( heap[index].val.val < heap[parentIndex].val.val) {
                    HeapNode temp = heap[index];
                    heap[index] = heap[parentIndex];
                    heap[parentIndex] = temp;
                    heapifyUp(parentIndex);
                }
            }
        }
        
        
    }
    public class HeapNode {
        ListNode val;
        int from;
        
        public HeapNode(ListNode val, int from) {
            this.val = val;
            this.from = from;
        }
    }
}
