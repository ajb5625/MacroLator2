public class List {
    public Node head;
   // public Node tail;

    public List() {
        this.head = null;
//        this.tail = null;
    }

    public boolean isEmpty(List x) {
        if (x.head == null) {
            return false;
        }
        return true;
    }

    public int size(List x) {
        int count = 0;
        Node temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    public void prepend(Node x) {
        x.next = head;
        head = x;
    }

    public void remove(List x, String name) {
        if (x.head == null) {
            System.out.println("This user was not present in the list.");
            return;
        }
        Node temp = x.head;
        if (x.head.name.equals(name)) {
            if (x.head != null && x.head.next != null) {
                System.out.println("The user was removed.");
                x.head = x.head.next;
            }
            else {
                x.head = null;
                System.out.println("The user was removed.");
                return;
            }
            if (x.head.next.next != null) {
                System.out.println("The user was removed.");
                x.head.next = x.head.next.next;
            }
            return;
        }
        else {
            Node prev = temp;
            while (prev.next != null && !prev.next.name.equals(name)) {
                prev = prev.next;
            }
            if (prev.next == null) {
                System.out.println("This user was not present in the list.");
            }
            else {
                prev.next = prev.next.next;
                System.out.println("The user was removed.");
            }
            return;
        }
    }
}
