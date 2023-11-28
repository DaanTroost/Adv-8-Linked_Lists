package nl.hva.miw.ads.linkedlists;

import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.Assert.assertEquals;

public class DoubleEndedLinkedListTest {

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
        String expected = "DoubleEndedLinkedList{size=5} 100 200 300 400 500";
        String actual = l.toString();
        assertEquals(expected, actual);
    }
}