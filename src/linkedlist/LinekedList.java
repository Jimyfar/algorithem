package linkedlist;

public class LinekedList{
    private Node head;
    private int count = 0;
    public static void main(String[] args) {

    }

    public class Node{
        private int data;
        private Node next;

        public Node(int data, Node next){
            this.data = data;
            this.next = next;
        }
    }

    public Node createNode(int data, Node p){
        Node newNode = new Node(data, p);
        return newNode;
    }

    public void insertToHead(int value){
        Node newNode = createNode(value, null);
        insertToHead(newNode);
    }
    public void insertToHead(Node newNode){
        if (head == null) head = newNode;
        newNode.next = head.next;
        head = newNode;
    }

    public void insertBefore(Node newNode){
        if (head == newNode) {
            insertToHead(newNode);
            return;
        }
        if (newNode == null) return;
        Node p = head;
        while(p.next != newNode && p.next != null) {
            p = p.next;
        }
        newNode.next = p.next;
        p.next = newNode;
    }

    public Node inverse(Node list){
        Node headNode = null;
        Node p = head;
        Node next = null;
        while(p != list ) {
            next = p.next;
            p.next = headNode;
            headNode = p;
            p = next;
        }
        p.next = headNode;
        return p;

    }

    public boolean TFresults(Node left, Node right){
        while(left.data == right.data && left != null && right != null){
            left = left.next;
            right = right.next;
        }

        if (left == null && right == null) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isPalindrome() {
        if (head == null) {
            return false;
        } else {
            if(head.next == null)
                return true;
        }

        Node fast = head;
        Node slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return false;
    }
}