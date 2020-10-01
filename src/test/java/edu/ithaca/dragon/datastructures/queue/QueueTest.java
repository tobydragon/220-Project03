package edu.ithaca.dragon.datastructures.queue;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class QueueTest {
    @Test
    public void testQueues(){
        List<Queue<String>> emptyQueuesToTest = new ArrayList<>();
        //Add all your different kinds of queues to the list here
        emptyQueuesToTest.add(new RightEndListQueue<>());
        emptyQueuesToTest.add(new LeftEndListQueue<>());
        
        assertTrue(emptyQueuesToTest.size() > 0);
        for (Queue<String> queueToTest : emptyQueuesToTest){
            testDequeueOnEmpty(queueToTest);
            pushPopTest(queueToTest);
            testMakeEmpty(queueToTest);
        }
    }

    public void testDequeueOnEmpty(Queue<String> emptyQueue){
        assertTrue(emptyQueue.isEmpty());
        assertThrows(EmptyQueueException.class, () -> {
            emptyQueue.dequeue();
        });
    }

    public void pushPopTest(Queue<String> myQueue){
        assertTrue(myQueue.isEmpty());
        for (int i=0; i<10; i++){
            myQueue.enqueue(Integer.toString(i));
            assertFalse(myQueue.isEmpty());
        }
        for (int i=0; i<10; i++){
            assertFalse(myQueue.isEmpty());
            assertEquals(Integer.toString(i), myQueue.dequeue());
        }
        assertTrue(myQueue.isEmpty());

        myQueue.enqueue("a");
        myQueue.enqueue("b");
        myQueue.enqueue("c");
        assertEquals("a", myQueue.dequeue());
        assertEquals("b", myQueue.dequeue());
        myQueue.enqueue("x");
        myQueue.enqueue("y");
        assertEquals("c", myQueue.dequeue());
        assertEquals("x", myQueue.dequeue());
        assertEquals("y", myQueue.dequeue());
    }

    public void testMakeEmpty(Queue<String> myQueue){
        assertTrue(myQueue.isEmpty());
        for (int i=0; i<10; i++){
            myQueue.enqueue(Integer.toString(i));
            assertFalse(myQueue.isEmpty());
        }
        myQueue.makeEmpty();
        testDequeueOnEmpty(myQueue);
        pushPopTest(myQueue);
    }
}
