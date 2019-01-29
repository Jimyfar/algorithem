package binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
    private Node tree;
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        System.out.println("test binary tree:");
        System.out.println("tree root is null: delete print  supposed no result");
        tree.delete(3);
        tree.printByBFS();
        System.out.println("insert tree only one value: test insert one, delete one, print  result 3");
        tree.insert(3);
        tree.printByBFS();
        tree.delete(3);
        tree.printByBFS();
        System.out.println("insert 3 nodesLL");
        tree.insert(3);
        tree.insert(2);
        tree.insert(5);
        tree.printByBFS();
        tree.delete(3);
        tree.printByBFS();
    }

    public class Node{
        private int data;
        private Node left;
        private Node right;
        public Node(int data, Node left, Node right){
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    public boolean search(int value) {
        if (tree == null) return false;
        Node p = tree;
        while (p != null) {
            if (p.data == value) return true;
            if (value < p.data) {
                p = p.left;
            } else {
                p = p.right;
            }
        }
        return false;
    }

    public void insert(int value){
        if (tree == null) {
            tree = new Node(value, null, null);
            return;
        }
        Node p = tree;
        while(true){
            if (value < p.data) {
                if(p.left == null) {
                    p.left = new Node(value, null, null);
                    return;
                }
                p = p.left;
            } else {
                if (p.right == null){
                    p.right = new Node(value, null, null);
                    return;
                }
                p = p.right;
            }
        }
    }

    public boolean delete(int value) {
        Node pre = null;
        Node p = tree;
        while (p != null && p.data != value) {
            if (value > p.data) {
                pre = p;
                p = p.left;
            }
            if (value < p.data) {
                pre = p;
                p = p.right;
            }
        }
        if (p == null) return false;
        if (p.left != null && p.right != null) {
            Node ppre = p;
            Node pp = ppre.right;
            while (pp.left != null) {
                ppre = pp;
                pp = pp.left;
            }
            p.data = pp.data;
            p = pp;
            pre = ppre;
        }
        Node child;
        if (p.left != null) child = p.left;
        if (p.right != null) child = p.right;
        else child = null;
        if (pre == null) {
            tree = child ;
            return true;
        }
        if (pre.left == p) pre.left = child;
        else pre.right = child;
        return true;
    }
    public void printByBFS(){
        if (tree == null) return;
        Queue<Node> queue = new LinkedList<>();
        queue.add(tree);
        while (queue.size() != 0){
            Node q = queue.poll();
            System.out.print(" " + q.data);
            if (q.left != null) {
                queue.add(q.left);
            }
            if (q.right != null) {
                queue.add(q.right);
            }
        }
    }


}