import java.io.*;
import java.util.*;

class Node {
    String value;
    Node leftChild;
    Node rightChild;

    public Node (String value) {
        this.value = value;
    }
}

class Tree {
    Node root;

    public void addNode(String value, String leftChild, String rightChild) {
        if (root == null) {
            root = new Node(value);
            
            if (!leftChild.equals(".")) {
                root.leftChild = new Node(leftChild);
            }

            if (!rightChild.equals(".")) {
                root.rightChild = new Node(rightChild);
            }
        }
        else {
            searchNode(root, value, leftChild, rightChild);
        }
    }

    public void searchNode (Node node, String value, String leftChild, String rightChild) {
        if (node == null) return;

        else if (node.value.equals(value)) {
            if (!leftChild.equals(".")) {
                node.leftChild = new Node(leftChild);
            }
            if (!rightChild.equals(".")) {
                node.rightChild = new Node(rightChild);
            }
        }

        else {
            searchNode(node.leftChild, value, leftChild, rightChild);
            searchNode(node.rightChild, value, leftChild, rightChild);
        }
    }

    public void preorder(Node node) {
        if (node != null) {
            System.out.print(node.value);
            if (node.leftChild!=null) preorder(node.leftChild);
            if (node.rightChild!=null) preorder(node.rightChild);
        }
    }

    public void inorder(Node node) {
        if (node != null) {
            if (node.leftChild!=null) inorder(node.leftChild);
            System.out.print(node.value);
            if (node.rightChild!=null) inorder(node.rightChild);
        }
    }

    public void postorder(Node node) {
        if (node != null) {
            if (node.leftChild!=null) postorder(node.leftChild);
            if (node.rightChild!=null) postorder(node.rightChild);
            System.out.print(node.value);
        }
    }
}

public class Solution_for_1991 {
    static int N;
    static Tree tree = new Tree();
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        for (int n = 0; n < N; n++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            String value = st.nextToken();
            String leftChild = st.nextToken();
            String rightChild = st.nextToken();

            tree.addNode(value, leftChild, rightChild);
            // System.out.printf("value: %s, leftChild: %s, rightChild: %s \n", value, leftChild, rightChild);
        }
        tree.preorder(tree.root);
        System.out.println();
        tree.inorder(tree.root);
        System.out.println();
        tree.postorder(tree.root);
    }
}