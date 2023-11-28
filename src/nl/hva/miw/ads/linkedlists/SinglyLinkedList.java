package nl.hva.miw.ads.linkedlists;

/**
 * Singly linked list.
 *
 * @author michel
 */
public class SinglyLinkedList {

    private class Node {
        int value;

        Node next = null;      // Link to next node

        public Node(int value) {
            this.value = value;
        }
    }

    private int size = 0;           // Length of list
    private Node head = null;      // Link to first node

    public SinglyLinkedList() {
    }

    public int getSize() {
        return size;
    }

    /**
     * Return the value in the list at position index.
     *
     * @param index
     * @return
     */
    public int get(int index) {
        if (index < 0 || index > size){
            return Integer.MAX_VALUE;
        }
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.value;
    }

    /**
     * Add an element to the list at position index.
     *
     * @param index
     * @param value
     */
    public void add(int index, int value) {
        // Implement, create a new Node for this entry.

        Node n = new Node(value);
        size++;

        // Implement the rest
        Node current = head;

        if (index == 0) {
            n.next = current;
            head = n;
            return;
        }

        for (int i = 0; i < index - 1; i++) {
            current = current.next;
        }

        n.next = current.next;
        current.next = n;
    }


    /**
     * Remove an elmeent from the list at position index, if it exists.
     *
     * @param index
     */
    public void remove(int index) {
        if (index < 0 || index > size) {
            return;
        }

        Node current = head;
        Node newNextNode = null;
        size--;

        if (index == 0) {
            head = current.next;
            return;
        }

        for (int i = 0; i < index - 1; i++) {
                current = current.next;
        }
        newNextNode = current.next.next;
        current.next = newNextNode;
    }


    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();

        sb.append("SinglyLinkedList{size=").append(size).append("}");

        Node current = this.head;
        while (current != null) {
            sb.append(" ");
            sb.append(current.value);
            current = current.next;
        }

        return sb.toString();
    }
}