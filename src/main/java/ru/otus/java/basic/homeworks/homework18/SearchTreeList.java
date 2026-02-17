package ru.otus.java.basic.homeworks.homework18;

import java.util.ArrayList;
import java.util.List;

public class SearchTreeList<T extends Comparable<T>> implements SearchTree<T> {

    private Node root;

    private class Node {
        T value;
        Node left;
        Node right;

        public Node(T value) {
            this.value = value;
        }
    }

    @Override
    public T find(T element) {
        return find(root, element);
    }

    @Override
    public List<T> getSortedList() {
        List<T> sortedList = new ArrayList<>();
        inOrder(root, sortedList);
        return sortedList;
    }

    private void inOrder(Node node, List<T> list) {
        if (node == null) return;
        inOrder(node.left, list);
        list.add(node.value);
        inOrder(node.right, list);

    }

    private T find(Node node, T element) {
        if (node == null) return null;
        int cmp = element.compareTo(node.value);
        if (cmp < 0) {
            return find(node.left, element);
        }
        if (cmp > 0) {
            return find(node.right, element);
        }
        return node.value;

    }

    public SearchTreeList(List<T> list) {
        root = buildTree(list, 0, list.size() - 1);
    }

    private Node buildTree(List<T> list, int start, int end) {
        if (start > end) return null;
        int mid = start + (end - start) / 2;
        Node node = new Node(list.get(mid));
        node.left = buildTree(list, start, mid - 1);
        node.right = buildTree(list, mid + 1, end);
        return node;
    }
}