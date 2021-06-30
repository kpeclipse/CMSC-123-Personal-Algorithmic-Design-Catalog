package DataStructure;

import java.util.ArrayList;

public class BinaryTree {
    private Node root;
    private ArrayList<Integer> keys = new ArrayList<Integer>();

    public BinaryTree() {
        root = null;
    }

    public Node getRoot() {
        return root;
    }

    public void setTree() {
        root = setNode(null, 0);
    }

    public Node setNode(Node parent, int index) {
        if (index < keys.size()) {
            parent = new Node(keys.get(index), index);
            parent.setLeftChild(setNode(parent.getLeftChild(), 2 * index + 1));
            parent.setRightChild(setNode(parent.getRightChild(), 2 * index + 2));
        }

        return parent;
    }

    public void add(int value) {
        keys.add(value);
    }

    public void add(int value, int key) {
        while (keys.size() < key)
            keys.add(0);
        keys.add(key, value);
    }
}