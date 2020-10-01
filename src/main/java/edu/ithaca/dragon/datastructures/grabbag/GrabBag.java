package edu.ithaca.dragon.datastructures.grabbag;

public interface GrabBag<T> {
    void putSomethingIn(T item);
    boolean isEmpty();
    T takeSomethingOut();
    /**
     * dumps the GrabBag
     * After calling, all items are removed, the GrabBag is empty
     */
    void makeEmpty();
}
