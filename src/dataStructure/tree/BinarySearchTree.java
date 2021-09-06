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

    public boolean deleteNode(int value) {
        boolean searched = false;

        Node currParentNode = this.head;
        Node currNode = this.head;

        //case 1: 노드가 없을때
        if (this.head == null) {
            return false;
        }
        else{
            //case 2: 노드가 하나일 때
            if (this.head.value == value && this.head.left == null & head.right == null) {
                this.head = null;
                return true;
            }
            //case 3
            while (currNode != null) {
                if (currNode.value == value) {
                    searched = true;
                    break;
                } else if (value < currNode.value) {
                    currParentNode = currNode;
                    currNode = currNode.left;
                } else {
                    currParentNode = currNode;
                    currNode = currNode.right;
                }
            }
            if (!searched) {
                return false;
            }
        }
        //노드 찾음
        //case 1: 삭제할 노드가 leaf node 인 경우
        return true;
    }
    public static void main(String[] args) {
        BinarySearchTree myTree = new BinarySearchTree();


    }

}
