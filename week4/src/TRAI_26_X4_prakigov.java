import fi.uef.cs.tra.BTree;
import fi.uef.cs.tra.BTreeNode;

public class TRAI_26_X4_prakigov implements TRAI_26_X4 {
    /**
     * SELF-EVALUATION HERE:
     * The pseudocode and implementation was quite straightforward. Thanks to the readily-available package built for binary trees, I was able to implement the in-order traversal check without any issues.
     * The only moment of confusion was the recursion which caused the issue of handling of the previousValue and created a shared-state bug across recursive calls and caused the failure of part of the tests.
     * I resolved it by creating a wrapper class to hold the previousValue, ensuring that it is shared correctly across recursive calls.
     * 
     *
     */

    /**
     * PSEUDO CODE:
     * Do an in-order traversal (left, root, right).
     * Remember the previously visited value.
     * If the current value less than the previous value, return false.
     * Each node is visited once, so it runs in O(n).
     * 
    prev = null

    function isInOrder(root):
        prev = null
        return check(root)

    function check(node):
        if node == null:
            return true

        if not check(node.left):        // left subtree
            return false

        if prev != null and node.value <= prev:   // duplicates are not allowed
            return false
        prev = node.value

        return check(node.right)        // right subtree
     *
     */
     
     /* COMPLEXITY ANALYSIS:
     * 
     * TIME: algorithm runs in O(n) time, where n is the number of nodes in the tree. Each node is visited exactly once during the in-order traversal, and the comparison of values is done in constant time. 
     * SPACE: O(k), where k is the height of the tree, due to the recursive call stack. Worst case scenario (skewed tree), the height can be equal to the number of nodes, i.e.,  O(n) space complexity. However, for an average case scenario (balanced tree), height is logarithmic in relation to the number of nodes, i.e.,  O(log n) space complexity.
     * 
     * In conclusion, the overall time complexity is linear time and space complexity is linear in the worst case and logarithmic in the average case.
     * /

    /**
     * Are the elements of a tree in in-order or not.
     * You may write additional methods as well as long as you keep this method header unchanged.
     * @param T binary tree to check
     * @return true if the elements are in in-order, false otherwise
     * @param <E> element type
     */
    @Override
    public <E extends Comparable<? super E>> boolean isInOrdered(BTree<E> T) {
        // base case: if the tree is empty, it is considered in-order
        if (T.isEmpty()) {
            return true;
        }

        BTreeNode<E> root = T.getRoot();
        PreviousValue<E> previousValue = new PreviousValue<>();
        return validateInorder(root, previousValue);
    }

    // wrapper class to hold the previous value during recursion and to prevent shared state issues
    private static class PreviousValue<E> {
        private E value;
    }

    // helper method to perform in-order traversal and check if the elements are in ascending order without duplicates
    private <E extends Comparable<? super E>> boolean validateInorder(
            BTreeNode<E> node, PreviousValue<E> previousValue) {
        // base case: if the node is null, return true
        if (node == null) {
            return true;
        }

        // recursive case: traverse left subtree
        if (!validateInorder(node.getLeftChild(), previousValue)) {
            return false;
        }

        // compares values for duplicates and ascending order
        if (previousValue.value != null
                && node.getElement().compareTo(previousValue.value) <= 0) {
            return false;
        }
        previousValue.value = node.getElement();

        // recursive case: traverse right subtree
        return validateInorder(node.getRightChild(), previousValue);
    }

}