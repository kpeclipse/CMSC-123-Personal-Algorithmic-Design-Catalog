package AlgorithmDesignTechniques.DivideAndConquer.BinaryTreeTraversals;

import DataStructure.BinaryTree;
import DataStructure.Node;

public class BinaryTreeTraversals {
    private BinaryTree tree;

    public static void main(String[] args) {
        new BinaryTreeTraversals();
    }

    public BinaryTreeTraversals() {
        tree = new BinaryTree();
        tree.add(1);
        tree.add(2);
        tree.add(3);
        tree.add(4);
        tree.add(5);
        tree.add(6);
        tree.add(7, 8);
        tree.setTree();

        System.out.println("BINARY TREE TRAVERSALS\n");

        System.out.print("Preorder Traversal: ");
        traversePreOrder(tree.getRoot());
        System.out.println("\n");

        System.out.print("Inorder Traversal: ");
        traverseInOrder(tree.getRoot());
        System.out.println("\n");

        System.out.print("Postorder Traversal: ");
        traversePostOrder(tree.getRoot());
        System.out.println("\n");
    }

    public void traverseInOrder(Node tree) {
        if (tree != null) {
            traverseInOrder(tree.getLeftChild());
            if (tree.getValue() > 0)
                System.out.print(tree.getValue() + " ");
            traverseInOrder(tree.getRightChild());
        }
    }

    public void traversePreOrder(Node tree) {
        if (tree != null) {
            if (tree.getValue() > 0)
                System.out.print(tree.getValue() + " ");
            traversePreOrder(tree.getLeftChild());
            traversePreOrder(tree.getRightChild());
        }
    }

    public void traversePostOrder(Node tree) {
        if (tree != null) {
            traversePostOrder(tree.getLeftChild());
            traversePostOrder(tree.getRightChild());
            if (tree.getValue() > 0)
                System.out.print(tree.getValue() + " ");
        }
    }
}