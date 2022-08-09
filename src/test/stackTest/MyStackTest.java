package test.stackTest;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

//import org.junit.Assert;

import main.stack.IStack;
import main.stack.MyStack;

public class MyStackTest {
    @Test
    public void basic() {
        IStack<Integer> given = new MyStack<>();
        for (int i = 0; i < 50; i++) {
            given.push(i);
            assertEquals((int)given.peek(), i);
            assertEquals(given.size(), i + 1);
        }
        for (int i = 49; i > -1; i--) {
            assertEquals((int)given.pop(), i);
            assertEquals(given.size(), i);
        }
    }
}
