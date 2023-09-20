package MaximumDepthOfBinaryTree;

public class Main {
    public static void main(String[] args) {

    }

    public int maxDepth(TreeNode root) {
        int count = 1;

        return countNodes(root,count);
    }

    public int countNodes(TreeNode treeNode, int count) {

        if (treeNode.left != null) {
            count++;
            treeNode = treeNode.left;
            countNodes(treeNode, count);
        } else if (treeNode.right != null) {
            count++;
            treeNode = treeNode.right;
            countNodes(treeNode, count);
        }

        return count;
    }

    public void traverseInOrder(TreeNode node) {
        if (node != null) {
            traverseInOrder(node.left);
            System.out.print(" " + node.val);
            traverseInOrder(node.right);
        }
    }
}

