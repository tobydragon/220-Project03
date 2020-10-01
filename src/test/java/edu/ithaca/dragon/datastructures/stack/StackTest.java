package edu.ithaca.dragon.datastructures.stack;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class StackTest {
    
    @Test
    public void testStacks(){
        List<Stack<String>> emptyStacksToTest = new ArrayList<>();
        //TODO: add your different kinds of stacks to the list here
        emptyStacksToTest.add(new RightTopListStack<>());
        emptyStacksToTest.add(new LeftTopListStack<>());
       
        assertTrue(emptyStacksToTest.size() > 0);
        for (Stack<String> stackToTest : emptyStacksToTest){
            testPopOnEmpty(stackToTest);
            pushPopTest(stackToTest);
            testMakeEmpty(stackToTest);
        }
    }

    public void testPopOnEmpty(Stack<String> emptyStack){
        assertTrue(emptyStack.isEmpty());
        assertThrows(EmptyStackException.class, () -> {
            emptyStack.pop();
        });
    }

    public void pushPopTest(Stack<String> myStack){
        assertTrue(myStack.isEmpty());
        for (int i=0; i<10; i++){
            myStack.push(Integer.toString(i));
            assertFalse(myStack.isEmpty());
        }
        for (int i=9; i>=0; i--){
            assertFalse(myStack.isEmpty());
            assertEquals(Integer.toString(i), myStack.pop());
        }
        assertTrue(myStack.isEmpty());

        myStack.push("a");
        myStack.push("b");
        myStack.push("c");
        assertFalse(myStack.isEmpty());
        assertEquals("c", myStack.pop());
        assertEquals("b", myStack.pop());
        assertFalse(myStack.isEmpty());
        myStack.push("x");
        myStack.push("y");
        assertFalse(myStack.isEmpty());
        assertEquals("y", myStack.pop());
        assertEquals("x", myStack.pop());
        assertEquals("a", myStack.pop());
        assertTrue(myStack.isEmpty());
    }

    public void testMakeEmpty(Stack<String> myStack){
        assertTrue(myStack.isEmpty());
        for (int i=0; i<10; i++){
            myStack.push(Integer.toString(i));
            assertFalse(myStack.isEmpty());
        }
        myStack.makeEmpty();
        testPopOnEmpty(myStack);
        pushPopTest(myStack);
    }

}
