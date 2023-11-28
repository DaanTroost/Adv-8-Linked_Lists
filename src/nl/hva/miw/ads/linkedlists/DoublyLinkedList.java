package nl.hva.miw.ads.linkedlists;

/**
 * Doubly linked list.
 *
 * @author michel
 */
public class DoublyLinkedList {

    private class Node {
        int value;

        Node next=null;      // Link to next node
        Node prev=null;      // Link to previous node

        public Node(int value) {
            this.value = value;
        }
    }

    private int size = 0;           // Length of list
    private Node head = null;      // Link to first node

    public DoublyLinkedList() {
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
    public int get( int index ) {
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
    public void add( int index, int value ) {
        if (index < 0 || index > size){
            return;
        }
        // Implement, create a new Node for this entry.

        Node n = new Node( value );
        size++;

        // Implement the rest

        if (index == 0){
            if (head != null) {
                head.prev = n;
            }
            n.next = head;
            head = n;
            return;
        }

        Node current = head;
        for (int i = 0; i < index - 1; i++) {
            current = current.next;
        }

        n.next = current.next;
        n.prev = current;

        if (current.next != null){
            current.next.prev = n;
        }
        current.next = n;
    }

    /**
     * Remove an elmeent from the list at position index, if it exists.
     *
     * @param index
     */
    public void remove( int index ) {

        if (index < 0 || index >= size) {
            return;
        }

        Node current = head;
        size--;

        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        if (current.next != null){
            current.next.prev = current.prev;
        }
        if (current.prev != null){
            current.prev.next = current.next;
        }

        if (index == 0){
            head = current.next;
        }
    }

    public void removeAll(){
        Node temp = new Node(0);
        while (head != null){
            temp = head;
            head = head.next;
            temp = null;
        }
        size = 0;
    }


    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();

        sb.append("DoublyLinkedList{size=").append(size).append("}");

        Node current = this.head;
        while ( current != null ) {
            sb.append(" ");
            sb.append( current.value );
            current = current.next;
        }

        return sb.toString();
    }



}