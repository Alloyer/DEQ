package com.company;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Deque<Item> implements Iterable<Item> {
    private int n;          // size of list
    private Node first;     // top of list
    private Node last;      // end of list

    private class Node {
        private Item item;
        private Node next;
        private Node previous;
    }

    public Deque() {
        first = null;
        last = null;
        n = 0;
    }

    public boolean isEmpty() {
        return first == null && last == null;
    }
    
    public int size() {
        return n;
    }

    public void addLast(Item item) {


        Node inserted = new Node();
        inserted.item = item;
        inserted.next = last;
        if(last != null)
        {
            last.previous = inserted;
        }
        last = inserted;
        inserted.previous = null;
        if(n == 0) first = last;
        n++;
    }

    public void addFirst(Item item) {

        Node inserted = new Node();
        inserted.item = item;
        inserted.previous = first;
        if(first != null)
        {
            first.next = inserted;
        }
        first = inserted;
        inserted.next = null;
        if(n == 0) last = first;
        n++;
    }

    public Item removeFirst() {
        if (isEmpty()) throw new NoSuchElementException("Deque underflow");
        Item item = first.item;
        if(n == 1)
        {
            first = null;
            last = null;
            n--;
            return item;
        }
        else
        {
            first = first.previous;
            first.next = null;
            n--;
            return item;
        }
    }

    public Item removeLast() {
        if (isEmpty()) throw new NoSuchElementException("Deque underflow");
        Item item = last.item;
        if(n == 1)
        {
            first = null;
            last = null;
            n--;
            return item;
        }
        else
        {
            last = last.next;
            last.previous = null;
            n--;
            return item;
        }
    }

    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {
        private Node current = last;
        public boolean hasNext() {
            return current != null;
        }
        public void remove() {
            throw new UnsupportedOperationException();
        }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
}

