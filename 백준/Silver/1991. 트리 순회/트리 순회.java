
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder preSb = new StringBuilder();
    static StringBuilder inSb = new StringBuilder();
    static StringBuilder postSb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int size = Integer.parseInt(st.nextToken());

        Tree tree = new Tree();

        for (int i = 0; i < size; i++) {
            st = new StringTokenizer(br.readLine());

            tree.createNode(st.nextToken(), st.nextToken(), st.nextToken());
        }

        tree.preOrder(tree.root);
        System.out.println(preSb);

        tree.inOrder(tree.root);
        System.out.println(inSb);

        tree.postOrder(tree.root);
        System.out.println(postSb);
    }

    public static class Tree {
        Node root = new Node(".");

        public void createNode(String mid, String left, String right) {
            if (root.data.equals(".")) {
                root = new Node(mid);
                if (!left.equals(".")) {
                    root.left = new Node(left);
                }
                if (!right.equals(".")) {
                    root.right = new Node(right);
                }
            } else {
                find(root, mid, left, right);
            }

        }

        public void find(Node node, String mid, String left, String right) {

            if (node == null) {
                return;
            } else if (node.data.equals(mid)) {
                if (!left.equals(".")) {
                    node.left = new Node(left);
                }
                if (!right.equals(".")) {
                    node.right = new Node(right);
                }
            }

            find(node.left, mid, left, right);
            find(node.right, mid, left, right);
        }

        public void preOrder(Node node) {
            preSb.append(node.data);

            if (node.left != null) {
                preOrder(node.left);
            }

            if (node.right != null) {
                preOrder(node.right);
            }
        }

        public void inOrder(Node node) {
            if (node.left != null) {
                inOrder(node.left);
            }

            inSb.append(node.data);

            if (node.right != null) {
                inOrder(node.right);
            }
        }

        public void postOrder(Node node) {
            if (node.left != null) {
                postOrder(node.left);
            }

            if (node.right != null) {
                postOrder(node.right);
            }

            postSb.append(node.data);
        }

    }

    public static class Node {
        private String data;
        Node left, right;

        public Node(String data) {
            this.data = data;
        }
    }

}