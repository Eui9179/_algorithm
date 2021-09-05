package dataStructure.tree;

public class Node{
    public Node left;
    public Node right;
    public int value;

    public Node(int data) {
        this.value = data;
        this.left = null;
        this.right = null;
    }
}