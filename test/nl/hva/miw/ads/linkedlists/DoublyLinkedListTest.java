package nl.hva.miw.ads.linkedlists;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;

import static org.junit.jupiter.api.Assertions.*;

public class DoublyLinkedListTest {
    private static DoublyLinkedList l = new DoublyLinkedList();

    @BeforeEach
    public void initAll(){
        l.add(0, 400);
        l.add(0, 100);
        l.add(1, 200);
        l.add(2, 300);
        l.add(4, 500);
    }

    @AfterEach
    public void cleanUpAfterEach(){
        l.removeAll();
    }

    @Test
    public void add() {
        String expected = "DoublyLinkedList{size=5} 100 200 300 400 500";
        String actual = l.toString();
        assertEquals(expected, actual);
    }

    @Test
    public void removeLastElement(){
        l.remove(4);
        String expected = "DoublyLinkedList{size=4} 100 200 300 400";
        String actual = l.toString();
        assertEquals(expected, actual);
    }

    @Test
    public void removeMiddleElement(){
        l.remove(2);
        String expected = "DoublyLinkedList{size=4} 100 200 400 500";
        String actual = l.toString();
        assertEquals(expected, actual);
    }

    @Test
    public void removeMultipleElements(){
        l.remove(1);
        l.remove(3);
        String expected = "DoublyLinkedList{size=3} 100 300 400";
        String actual = l.toString();
        assertEquals(expected, actual);
    }
}