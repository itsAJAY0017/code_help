class Linkedlist{
    Node head;
    class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    public void addFirst(int data){
        Node newNode = new Node(data);
        if (head == null){
            head = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    public void addLast(int data){
        Node newNode = new Node(data);
        if (head == null){
            head = newNode;
            return;
        }
        Node currNode = head;
        while(currNode.next != null){
            currNode = currNode.next;
        }
        currNode.next = newNode;
    }

    public void addMiddle(int data, int index){
        Node newNode = new Node(data);
        Node currNode = head;
        for(int i=0;i<index-1;i++){
            currNode = currNode.next;
        }
        newNode.next = currNode.next;
        currNode.next = newNode;
    }

    public void deleteFirst(){
        if(head == null || head.next == null){
            head = null;
            return;
        }
        head = head.next;
    }

    public void deleteLast(){
        if(head == null || head.next == null){
            head = null;
            return;
        }
        Node currNode = head;
        while(currNode.next.next != null){
            currNode = currNode.next;
        }
        currNode.next = null;
    }

    public void deleteMid(int index){
        Node currNode = head;
        for(int i =0; i<index-1;i++){
            currNode = currNode.next;
        }
        currNode.next = currNode.next.next;
    }

    public int searchList(int n){
        Node currNode = head;
        int pos = 1;
        while(currNode != null){
            if(currNode.data == n){
                return pos;
            }
            pos++;
            currNode = currNode.next;
        }
        return -1;
    }

    public void sortedIns(int data){
        Node newNode = new Node(data);
        if (head == null){
            head = newNode;
            return;
        }
        Node currNode = head;
        while(currNode.next != null && currNode.next.data < data){
            currNode = currNode.next;
        }
        newNode.next = currNode.next;
        currNode.next = newNode;
    }

    public int middleIteration(){
        Node fast = head;
        Node slow = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow.data;
    }

    public int nFromEnd(int n){
        Node fast = head;
        Node slow = head;
        for(int i =0; i<n;i++){
            fast = fast.next;
        }
        while(fast != null){
            fast = fast.next;
            slow = slow.next;
        }
        return slow.data;
    }

    public void reverseIte(){
        Node currNode = head;
        Node prevNode = null;
        while(currNode != null){
            Node next = currNode.next;
            currNode.next = prevNode;
            prevNode = currNode;
            currNode = next;
        }
        head = prevNode;
    }

    public void removeDups(){
        Node currNode = head;
        while(currNode != null && currNode.next != null){
            if(currNode.data == currNode.next.data){
                currNode.next = currNode.next.next;
                continue;
            }
            else{
                currNode = currNode.next;
            }
        }
    }

    public void reverseRecursion(Node head){
       System.out.println(head.data);
       System.out.println(head.next.data);
       System.out.println(head.next.next.data);
       System.out.println(head.next.next.next.data);
        Node Nx = head;
        Node prevNode = null;
        while(Nx != null){
            Node next = Nx.next;
            Nx.next = prevNode;
            prevNode = Nx;
            Nx = next;
            System.out.println(Nx.data);
            Nx = Nx.next;
        }

    }

    public Node reverseK(Node head, int k){
        Node curr = head, next = null, prev = null;
        int count = 0;
        while (curr != null && count<k){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count++;
        }
        if(next != null){
            Node rest_head = reverseK(next,k);
            head.next = rest_head;
        }
        return prev;
    }


    public void reverseRec(Node head){
        Node prev;
        Node forw;
        prev = head;
        System.out.println(prev.data);
        forw = prev.next.next;
        System.out.println(forw.data);
        head = forw;
        System.out.println(head.data);
        prev.next.next = head;
        System.out.println(head.data);
    }

    public void printList(){
        if(head == null){
            System.out.println("This list is empty");
            return;
        }
        Node currNode = head;
        while(currNode != null){
            System.out.print(currNode.data + " -> " );
            currNode = currNode.next;
        }
        System.out.print("NULL");
    }

    public static void main(String[] args) {
        Linkedlist list = new Linkedlist();
        list.addFirst(2);
        list.addFirst(1);
        list.addMiddle(3,2);
        list.addLast(5);
        list.printList();
        System.out.println();
        list.reverseRec(list.head);
        System.out.println();
        list.printList();
//        System.out.println();
//        list.reverseK(list.head,2);


//        list.deleteFirst();
//        list.deleteLast();
//        list.deleteMid(2);
//        System.out.println(list.searchList(3));
//        list.sortedIns(4);
//        list.sortedIns(4);
//        list.sortedIns(6);
//        list.sortedIns(6);
//        System.out.println(list.middleIteration());
//        System.out.println(list.nFromEnd(2));
//        list.printList();
//        System.out.println();
//        list.removeDups();
//        list.printList();
//        System.out.println();
//        list.reverseIte();
//        list.printList();
//        System.out.println();
//        list.reverseRecursion(list.head, 3);
//        list.printList();
    }
}