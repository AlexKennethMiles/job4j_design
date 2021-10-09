package ru.job4j.tree;

import java.util.ArrayList;
import java.util.Optional;

public interface Tree<E> {

    boolean add(E parent, E child);

    Optional<Node<E>> findBy(E value);

    boolean isBinary();

    class Node<E> {
        final E value;
        final ArrayList<Node<E>> children = new ArrayList<>();

        public Node(E value) {
            this.value = value;
        }
    }
}
