package link;

import org.w3c.dom.Node;

import static jdk.internal.util.Preconditions.checkIndex;

class Node<E> {
    E data;
    Node<E> next;

    Node(E data) {
        this.data = data;
    }
}

public class Nodelist<E> {
    Node<E> first;
    int size = 0;

    public Nodelist() {
        first = null;

    }

    public void insertFirst(E data) {
        Node<E> newNode = new Node<>(data);
        newNode.next = first;
        first = newNode;
        size++;

    }

    public void deleteFirst() {
        first = first.next;
        size--;
    }

    public boolean inserterlast(E data) {
        if (first == null) {
            insertFirst(data);
        } else {
            Node<E> current = first;
            while (current.next != null) {
                current = current.next;
            }
            Node<E> newNode = new Node<>(data);
            current.next = newNode;
            size++;
        }
        return true;

    }

    public void deleteAfter(Node<E> after) {
        if (after == null) {
            throw new NullPointerException("after is null");
        }
        Node<E> current = first;
        while (current != null && current != after) {
            current = current.next;
        }
        if (current != null && current.next != null) {
            current.next = current.next.next;
            size--;
        }
    }

    void add(E data) {
        inserterlast(data);
    }

    int size() {
        return size;
    }

    public E get(int index) {
        checkIndex(index, size);
        return node(index).data;
    }

    void remove(int index) {
        checkIndex(index, size);
        Node<E> current = first;
        Node<E> previous = null;
        for (int i = 0; i < index; i++) {
            previous = current;
            current = current.next;

        }
        if (previous == null) {
            first = first.next;

        } else {
            previous.next = current.next;

        }
        size--;
    }

    private Node<E> node(int index) {
        checkIndex(index, size);
        Node<E> current = first;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    private void checkIndex(int index, int size) {
        if (index >= size) {
            throw new IndexOutOfBoundsException("index" + index + "out of bounds for length" + size);

        }
    }
}