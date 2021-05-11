package tree.binarytree;

/**
 * 二叉树排序
 * 
 */
public class BinaryTreeSort {

    private Node root;

    public BinaryTreeSort() {
        root = null;
    }

    public Node getRoot() {
        return root;
    }

    /**
     * 往树中添加数据
     */
    public void insertSort(int[] source) {
        for (int i = 0; i < source.length; i++) {
            int value = source[i];
            Node node = new Node(value);
            if (root == null) {
                root = node;
            } else {
                Node current = root;
                Node parent;
                boolean insertedOK = false;
                while (!insertedOK) {
                    parent = current;
                    if (value < current.value) {
                        current = current.leftChild;
                        if (current == null) {
                            parent.leftChild = node;
                            insertedOK = true;
                        }
                    } else {
                        current = current.rightChild;
                        if (current == null) {
                            parent.rightChild = node;
                            insertedOK = true;
                        }
                    }
                }

            }
        }
    }

    /**
     * 中序遍历
     */
    public void sortOutPut(Node current) {
        if (current != null) {
            sortOutPut(current.leftChild);
            System.out.print(current.value + " ");
            sortOutPut(current.rightChild);
        }
    }

    public static void main(String[] args) {
        // 测试数据
        int[] source = new int[] { 35, 47, 25, 78, 12, 5, 9, 30, 27, 26, 29 };
        BinaryTreeSort sort = new BinaryTreeSort();
        sort.insertSort(source);
        sort.sortOutPut(sort.getRoot());
    }
}

/**
 * 二叉树节点
 * 
 */
class Node {
    public int value;
    Node leftChild;
    Node rightChild;

    public Node(int val) {
        value = val;
    }
}