package ru.job4j.tree;

import java.util.*;
import java.util.function.Predicate;

public class SimpleTree<E> implements Tree<E> {
    private final Node<E> root;

    public SimpleTree(final E root) {
        this.root = new Node<>(root);
    }

    @Override
    public boolean add(E parent, E child) {
        Optional<Node<E>> receivedParent = findBy(parent);
        if (findBy(child).isEmpty() && receivedParent.isPresent()) {
            receivedParent.get().children.add(new Node<E>(child));
            return true;
        }
        return false;
    }

    private Optional<Node<E>> findByPredicate(Predicate<Node<E>> condition) {
        Optional<Node<E>> rsl = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (condition.test(el)) {
                rsl = Optional.of(el);
                break;
            }
            data.addAll(el.children);
        }
        return rsl;
    }

    @Override
    public boolean isBinary() {
        return findByPredicate(el -> el.children.size() > 2).isEmpty();
    }

    @Override
    public Optional<Node<E>> findBy(E value) {
        return findByPredicate(el -> el.value.equals(value));
    }
}
