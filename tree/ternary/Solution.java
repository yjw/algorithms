/*
When I see a '?', it's my left child, so add to my left and go left.

If I see ':', then:

Go to my parent
If right is not null and parent is not not null, keep going to my parent
My right child is empty. Add right. Go to right.
Note: You will never go back to the root if it has a right child.
*/

public class Solution {
    public TreeNode convertTtoBT (char[] values) {
        TreeNode n = new TreeNode (values[0]);

        for (int i = 1; i < values.length; i += 2) {
            if (values[i] == '?') {
                n.left = new TreeNode (values[i + 1]);
                n = n.left;
            }
            else if (values[i] == ':') {
                n = n.parent;
                while (n.right != null && n.parent != null ) {
                    n = n.parent;
                }                    
                n.right = new TreeNode (values[i + 1]);
                n = n.right;
            }
        }
        return n;
    }
}
