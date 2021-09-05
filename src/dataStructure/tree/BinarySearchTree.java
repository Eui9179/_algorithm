package dataStructure.tree;
/*
* 이진 탐색 트리
* 장점: 탐색 속도 개선
* */

public class BinarySearchTree {
    Node head = null;

    public boolean insertNode(int data) {
        //case 1: Node 가 하나도 없을 떄,
        if (this.head == null) {
            this.head = new Node(data);
        }
        //case 2: Node 가 하나 이상 있을 떄,\
        else {
            Node findNode = this.head; // 처음 노드를 헤드로 둠
            while (true) {
                // case 2-1 현재 Node 의 왼쪽
                if (data < findNode.value) { // 삽입할 값이 현재 노드보다 작다면
                    if (findNode.left != null) {
                        findNode = findNode.left;
                    } else {
                        findNode.left = new Node(data);
                        break;
                    }
                }
                // case 2-2 현재 Node 의 오른쪽
                else {
                    if (findNode.right != null) { // 삽입할 값이 현재 노드보다 크다면
                        findNode = findNode.right;
                    } else {
                        findNode.right = new Node(data);
                        break;
                    }
                }
            }
        }
        return true;
    }

    public Node searchNode(int data) {
        //case 1: Node 가 하나도 없을때
        if (this.head == null) {
            return null;
        }
        //case 2: Node 가 하나 이상 있을 때
        else {
            Node findNode = this.head; //findNode 를 head로 둠
            while (findNode != null) {
                if (findNode.value == data) {
                    return findNode;
                }
                else if (data < findNode.value) {
                    findNode = findNode.left;
                }
                else {
                    findNode = findNode.right;
                }
            }
        }
        return null;
    }

    public boolean deleteNode(int data) {
        return false;
    }
    public static void main(String[] args) {
        BinarySearchTree myTree = new BinarySearchTree();
        myTree.insertNode(5);
        myTree.insertNode(3);
        myTree.insertNode(2);
        myTree.insertNode(1);

        Node node = myTree.searchNode(2);
        System.out.println(node.left.value);

    }

}
