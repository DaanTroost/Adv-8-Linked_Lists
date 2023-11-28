package nl.hva.miw.ads.linkedlists;

/**
 * DoubleEnded Doubly linked list.
 *
 * @author michel
 */
public class DoubleEndedLinkedList {

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
    private Node tail = null;      // Link to last node

    public DoubleEndedLinkedList() {
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
        if (index < 0 || index > size) {
            return Integer.MAX_VALUE;
        }
        Node returnNode = head;
        if (index == 0){
            return returnNode.value;
        } else if (index + 1 == size){
            returnNode = tail;
        } else {
            for (int i = 0; i < index; i++) {
                returnNode = returnNode.next;
            }
        }
        return returnNode.value;
    }

    /**
     * Add an element to the list at position index.
     *
     * @param index
     * @param value
     */
    public void add( int index, int value ) {
        // Implement, create a new Node for this entry.

        Node n = new Node( value );

        // Implement the rest
        if (index == 0){
            n.next = head;
            head.prev = n;
            head = n;
            return;
        } else if (index + 1 == size) {
            tail.next = n;
            n.prev = tail;
            tail = n;
            return;
        }
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        current.next = n;
        n.prev = current;
        if (current.next != null){
            current.next.prev = n;
        }
        if (current.prev != null){
            current.prev.next = n;
        }

    }

    /**
     * Remove an elmeent from the list at position index, if it exists.
     *
     * @param index
     */
    public void remove( int index ) {
        // Implement, remove the corresponding node from the linked list.
    }

    public void removeAll() {
        tail = null;
        head = null;
    }


    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();

        sb.append("DoubleEndedLinkedList{size=").append(size).append("}");

        Node current = this.head;
        while ( current != null ) {
            sb.append(" ");
            sb.append( current.value );
            current = current.next;
        }

        return sb.toString();
    }
}