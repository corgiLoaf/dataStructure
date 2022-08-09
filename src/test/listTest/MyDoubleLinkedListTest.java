package test.listTest;

import org.junit.Test;

import java.util.Random;
import org.junit.Assert;

import org.junit.Assert.*;

import main.list.IList;
import main.list.MyDoubleLinkedList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class MyDoubleLinkedListTest {
    @Test
    public void add() {
        IList<Integer> given = new MyDoubleLinkedList<>();
        for (int i = 0; i < 50; i++) {
            given.add(i);
            assertEquals(i + 1, given.size());
            assertEquals(i, (int)given.get(i));
        }
        given.insert(10, 999);
        assertEquals(51, given.size());
        assertEquals(999, (int)given.get(10));
        given.insert(47, 998);
        assertEquals(52, given.size());
        assertEquals(998, (int)given.get(47));
    }
    @Test
    public void get() {
        IList<Integer> given = new MyDoubleLinkedList<>();
        for (int i = 0; i < 50; i++) {
            given.add(i);
        }

        assertEquals(49, (int)given.get(49));

        for (int i = 0; i < 50; i++) {
            assertEquals(i, (int)given.get(i));
        }
    }

    @Test
    public void insert() {
        IList<Integer> given = new MyDoubleLinkedList<>();
        given.add(9);
        given.add(8);
        given.add(7);

        given.insert(0, 1);
        assertEquals(given.size(), 4);
        assertEquals(1, (int)given.get(0));

        given.insert(4, 10);
        assertEquals(given.size(), 5);
        assertEquals(10, (int)given.get(4));
    }

    @Test
    public void indexOf() {
        IList<Integer> given = new MyDoubleLinkedList<>();
        for (int i = 0; i < 50; i++) {
            given.add(i);
        }
        for (int i = 0; i < 50; i++) {
            int idx = given.indexOf(i);
            assertEquals(i, idx);
        }
    }

    @Test
    public void insert2() {
        IList<Integer> given = new MyDoubleLinkedList<>();
        given.insert(0, 1);
        assertEquals(1, given.size());

        given.insert(1, 2);
        assertEquals(2, given.size());

        assertEquals(1, (int)given.get(0));
        assertEquals(2, (int)given.get(1));
    }

    @Test
    public void insert_exception() {
        IList<Integer> given = new MyDoubleLinkedList<>();
        Assert.assertThrows(IndexOutOfBoundsException.class, () -> {
            given.insert(2, 1);
        });
    }

    @Test
    public void clear() {
        IList<Integer> given = new MyDoubleLinkedList<>();
        for (int i = 0; i < 100; i++) {
            given.add(i);
        }
        assertEquals(100, given.size());
        assertFalse(given.isEmpty());
        given.clear();
        assertEquals(0, given.size());
        assertTrue(given.isEmpty());
    }

    @Test
    public void deleteByIndex() {
        IList<Integer> given = new MyDoubleLinkedList<>();
        for (int i = 0; i < 100; i++) {
            given.add(i);
        }
        Random random = new Random();
        int givenIndex = random.nextInt(99);
        int expected = given.get(givenIndex + 1);
        given.deleteByIndex(givenIndex);

        assertEquals(expected, (int)given.get(givenIndex));
    }

    @Test
    public void deleteByIndex2() {
        IList<Integer> given = new MyDoubleLinkedList<>();
        for (int i = 0; i < 100; i++) {
            given.add(i);
        }
        given.deleteByIndex(99);
        assertEquals(98, (int)given.get(98));

        given.deleteByIndex(1);
        assertEquals(2, (int)given.get(1));
    }

    @Test
    public void delete() {
        IList<Integer> given = new MyDoubleLinkedList<>();
        for (int i = 0; i < 100; i++) {
            given.add(i);
        }
        Random random = new Random();
        Integer target = random.nextInt(99);
        assertEquals(100, given.size());
        assertTrue(given.contains(target));
        assertEquals((int)target, (int)given.indexOf(target));
        given.delete(target);
        assertEquals(99, given.size());
        assertFalse(given.contains(target));
        assertEquals(-1, given.indexOf(target));
    }
}

