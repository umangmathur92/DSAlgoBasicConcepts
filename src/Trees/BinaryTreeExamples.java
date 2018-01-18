package Trees;

public class BinaryTreeExamples {

    static Node myBinaryTree = new Node(20);

    public static void main(String[] args) {
        myBinaryTree.left = new Node(10, new Node(5), new Node(15));
        myBinaryTree.right = new Node(30,new Node(25),new Node(35));
        insertNode(myBinaryTree, 27);
        printInOrderTraversal(myBinaryTree);
        System.out.println("\n");
        printPreOrderTraversal(myBinaryTree);
        System.out.println("\n");
        printPostOrderTraversal(myBinaryTree);
        System.out.println(contains(myBinaryTree, 10));
    }

    private static void insertNode(Node node, int data) {
        if (data <= node.data) {
            if (node.left == null) {
                node.left = new Node(data);
            } else {
                insertNode(node.left, data);
            }
        } else {
            if (node.right == null) {
                node.right = new Node(data);
            } else {
                insertNode(node.right, data);
            }
        }
    }

    private static boolean contains(Node node, int data) {
        if (node.data == data) {
            return true;
        } else if (data < node.data) {
            if (node.left == null) {
                return false;
            } else {
                return contains(node.left, data);
            }
        } else {
            if (node.right == null) {
                return false;
            } else {
                return contains(node.right, data);
            }
        }
    }

    private static void printInOrderTraversal(Node node) {
        if (node.left != null) {
            printInOrderTraversal(node.left);
        }
        System.out.print(node.data + " ");
        if (node.right != null) {
            printInOrderTraversal(node.right);
        }
    }

    private static void printPostOrderTraversal(Node node) {
        if (node.left != null) {
            printPostOrderTraversal(node.left);
        }
        if (node.right != null) {
            printPostOrderTraversal(node.right);
        }
        System.out.print(node.data + " ");
    }

    private static void printPreOrderTraversal(Node node) {
        System.out.print(node.data + " ");
        if (node.left != null) {
            printPreOrderTraversal(node.left);
        }
        if (node.right != null) {
            printPreOrderTraversal(node.right);
        }
    }

}
