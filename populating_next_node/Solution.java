public class Solution {
    public void connect(TreeLinkNode root) {
        if(root == null) {
            return;
        }
        TreeLinkNode head = null;
        TreeLinkNode prev = null;
        TreeLinkNode curr = root;
        while(curr != null) {   
            while(curr != null) {
                if(curr.left != null) {
                    if(prev == null) {
                        head = curr.left;
                    } 
                    else {
                        prev.next = curr.left;
                    }
                    prev = curr.left;
                }
                if(curr.right != null) {
                    if(prev == null) {
                        head = curr.right;
                    }else prev.next = curr.right;
                    prev = curr.right;
                }
                curr = curr.next;
            }
            curr = head;
            head = null;
            prev = null;  
        }  
    }
}
