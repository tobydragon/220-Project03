package edu.ithaca.dragon.datastructures.queue;

public interface Queue<T> {
    
    /**
     * puts an item onto the "end" of the queue
     */
    void enqueue(T item);

    /**
     * removes an item from the "front" of the queue
     * @return the item removed
     */
    T dequeue();

    /**
     * @return true if the queue has no items, false otherwise
     */
    boolean isEmpty();

    /**
     * all items are removed, after calling this Queue is empty
     */
    void makeEmpty();

    
}
