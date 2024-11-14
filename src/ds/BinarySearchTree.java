package ds;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree<T extends Comparable<T>> {

    public class Node {
        Node left;
        Node right;
        T data;

        Node(T data) {
            this.data = data;
        }
    }

    private Node root;

    public boolean add(T data) {
        Node n = new Node(data);
        if (root == null) {
            root = n;
            return true;
        }
        Node temp = root;
        while (true) {
            if (temp.data.compareTo(n.data) > 0) {
                if (temp.left == null) {
                    temp.left = n;
                    return true;
                }
                temp = temp.left;
            } else if (temp.data.compareTo(n.data) < 0) {
                if (temp.right == null) {
                    temp.right = n;
                    return true;
                }
                temp = temp.right;
            } else {
                return false;
            }
        }
    }

    public boolean addR(T data) {
        Node n = new Node(data);
        if (root == null) {
            root = n;
            return true;
        }
        return addR(root, n);
    }

    private boolean addR(Node currentNode, Node n) {
        if (currentNode.data.compareTo(n.data) > 0) {
            if (currentNode.left == null) {
                currentNode.left = n;
                return true;
            }
            return addR(currentNode.left, n);
        } else if (currentNode.data.compareTo(n.data) < 0) {
            if (currentNode.right == null) {
                currentNode.right = n;
                return true;
            }
            return addR(currentNode.right, n);
        } else {
            return false;
        }
    }

    public Node lookup(T data) {
        Node temp = root;
        while (temp != null) {
            if (temp.data.compareTo(data) > 0) {
                temp = temp.left;
            } else if (temp.data.compareTo(data) < 0) {
                temp = temp.right;
            } else {
                return temp;
            }
        }
        return null;
    }

    public Node deleteNode1(T key) {
        Node parent = null;
        Node current = root;

        // Find the node to delete and its parent
        while (current != null && current.data.compareTo(key) != 0) {
            parent = current;
            if (key.compareTo(current.data) < 0) {
                current = current.left;
            } else {
                current = current.right;
            }
        }

        // If the node was not found, return null
        if (current == null) {
            return root;
        }

        // Case 1: Node to be deleted has no children (leaf node)
        if (current.left == null && current.right == null) {
            if (current != root) {
                if (parent.left == current) {
                    parent.left = null;
                } else {
                    parent.right = null;
                }
            } else {
                root = null; // If the tree only has one node
            }
        }

        // Case 2: Node to be deleted has two children
        else if (current.left != null && current.right != null) {
            Node successorParent = current;
            Node successor = current.right;

            // Find the in-order successor (leftmost child in the right subtree)
            while (successor.left != null) {
                successorParent = successor;
                successor = successor.left;
            }

            // Copy the successor's value to the current node
            current.data = successor.data;

            // Delete the successor
            if (successorParent != current) {
                successorParent.left = successor.right;
            } else {
                successorParent.right = successor.right;
            }
        }

        // Case 3: Node to be deleted has one child
        else {
            Node child = (current.left != null) ? current.left : current.right;

            if (current != root) {
                if (current == parent.left) {
                    parent.left = child;
                } else {
                    parent.right = child;
                }
            } else {
                root = child; // Update root if the node to delete is the root
            }
        }

        return root;
    }

    public Node deleteNode(T key) {
        if (root == null) {
            return null;
        }

        Node current = root;
        Node parent = null;

        // Find the node to delete, keeping track of the parent node
        while (current != null && !current.data.equals(key)) {
            parent = current;
            if (key.compareTo(current.data) < 0) {
                current = current.left;
            } else {
                current = current.right;
            }
        }

        // If the key is not found, return the original root
        if (current == null) {
            return root;
        }

        // Helper method handles different deletion cases
        Node nodeToDelete = deleteHelper(current);

        // If the node to delete is the root, update the root directly
        if (parent == null) {
            root = nodeToDelete;
        } else {
            // Otherwise, link the updated subtree back to the parent node
            if (parent.left == current) {
                parent.left = nodeToDelete;
            } else {
                parent.right = nodeToDelete;
            }
        }

        return root;
    }

    // Helper method to handle the deletion cases
    private Node deleteHelper(Node node) {
        if (node.left == null) {
            return node.right;
        } else if (node.right == null) {
            return node.left;
        } else {
            // Find the rightmost node in the left subtree
            Node rightChild = node.right;
            Node lastRight = findLastRight(node.left);
            lastRight.right = rightChild;
            return node.left;
        }
    }

    // Helper method to find the rightmost node
    private Node findLastRight(Node node) {
        if (node.right == null) {
            return node;
        }
        return findLastRight(node.right);
    }



    public List<T> DFSInOrder() {
        return traverseInOrder(root, new ArrayList<>());
    }

    private List<T> traverseInOrder(Node node, List<T> list) {
        if (node != null) {
            traverseInOrder(node.left, list);
            list.add(node.data);
            traverseInOrder(node.right, list);
        }
        return list;
    }
}

class TestBST {
    public static void main(String[] args) {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        bst.add(8);
        bst.add(5);
        bst.add(12);
        bst.add(2);
        bst.add(7);
        bst.add(10);
        bst.add(13);
        bst.add(1);
        bst.add(3);
        bst.add(6);
        bst.add(9);
        List<Integer> res = bst.DFSInOrder();
        System.out.println("In-order traversal before deletion: " + res);
        BinarySearchTree<Integer>.Node node = bst.deleteNode(3);
        List<Integer> res2 = bst.DFSInOrder();
        System.out.println("In-order traversal after deletion: " + res2);
        System.out.println(node.data);
    }
}
