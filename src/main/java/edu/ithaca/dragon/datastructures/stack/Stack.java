package edu.ithaca.dragon.datastructures.stack;

public interface Stack<T> {

    /**
     * puts an item onto the "top" of the stack
     */
    void push(T item);

    /**
     * removes an item from the "top" of the stack
     * @return the item removed
     */
    T pop();

    /**
     * @return true if the stack has no items, false otherwise
     */
    boolean isEmpty();

    /**
     * all items are removed, after calling this Stack is empty
     */
    void makeEmpty();

}
