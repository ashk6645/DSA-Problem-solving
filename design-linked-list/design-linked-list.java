class MyLinkedList {
     ListNode head;
    int size;

    public MyLinkedList() {
         head = null;
        size = 0;
       
        
    }
    
    public int get(int index) {
         if (index < 0 || index >= size)
            return -1;
        ListNode current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.val;
        
    }
    
    public void addAtHead(int val) {
         ListNode newNode = new ListNode(val);
        newNode.next = head;
        head = newNode;
        size++;
        
    }
    
    public void addAtTail(int val) {
         if (head == null) {
            addAtHead(val);
            return;
         }
         ListNode newNode = new ListNode(val);
        ListNode current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
        size++;
        
    }
    
    public void addAtIndex(int index, int val) {
         if (index < 0 || index > size)
            return;
        if (index == 0) {
            addAtHead(val);
            return;
        }
        if (index == size) {
            addAtTail(val);
            return;
        }
        ListNode newNode = new ListNode(val);
        ListNode prev = null;
        ListNode current = head;
        for (int i = 0; i < index; i++) {
            prev = current;
            current = current.next;
        }
        prev.next = newNode;
        newNode.next = current;
        size++;
        
    }
    
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size)
            return;
        if (index == 0) {
            head = head.next;
            size--;
            return;
        }
        ListNode prev = null;
        ListNode current = head;
        for (int i = 0; i < index; i++) {
            prev = current;
            current = current.next;
        }
        prev.next = current.next;
        size--;
        
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */