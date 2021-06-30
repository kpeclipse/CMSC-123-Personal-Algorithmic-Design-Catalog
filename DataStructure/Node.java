package DataStructure;

public class Node {
    private int value, key;
    private Node leftChild;
    private Node rightChild;

    public Node(int v, int k) {
        value = v;
        key = k;
        leftChild = null;
        rightChild = null;
    }

    public int getValue() {
        return value;
    }

    public int getKey() {
        return key;
    }

    public void setLeftChild(Node left) {
        leftChild = left;
    }

    public void setRightChild(Node right) {
        rightChild = right;
    }

    public void setLeftChild(int value, int key) {
        leftChild = new Node(value, key);
    }

    public void setRightChild(int value, int key) {
        rightChild = new Node(value, key);
    }

    public Node getLeftChild() {
        return leftChild;
    }

    public Node getRightChild() {
        return rightChild;
    }
}