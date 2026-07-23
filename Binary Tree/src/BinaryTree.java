import java.util.List;
import java.util.ArrayList;
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;

public class BinaryTree {
    public static class BTNode {
        BTNode left;
        BTNode right;
        int value;

        BTNode(int value) {
            this.value = value;
        }
    }

    private BTNode root;

    public void createBinaryTree() {
        BTNode node1 = new BTNode(1);
        BTNode node2 = new BTNode(2);
        BTNode node3 = new BTNode(3);
        BTNode node4 = new BTNode(4);
        BTNode node5 = new BTNode(5);
        BTNode node6 = new BTNode(6);

        root = node1;
        node1.left = node2;
        node2.left = node3;
        node1.right = node4;
        node4.left = node5;
        node5.right = node6;
    }

    // 前序遍历
    void preOrder(BTNode root) {

        if (root == null) {
            return;
        }
        System.out.println(root.value);
        preOrder(root.left);
        preOrder(root.right);

    }

    // 中序遍历
    void inOrder(BTNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.println(root.value);
        inOrder(root.right);
    }

    // 后序遍历
    void postOrder(BTNode root) {
        if (root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.value);
    }
    // 获取树中节点的个数

    public static int nodeSize = 0;

    //遍历结点来计算结点数
    public int size1(BTNode root) {
        if (root == null) {
            return 0;
        }
        nodeSize++;
        size1(root.left);
        size1(root.right);
        return nodeSize;
    }

    //总个数 = 左子树结点个数 + 右子树结点个数
    public int size2(BTNode root){
        if (root == null){
            return 0;
        }
        return size2(root.left) + size2(root.right) + 1;
    }
    /**
     * 获取叶节点的个数
     */
    public static int leafSize;
    public int getLeafNodeCount(BTNode root){
        if(root == null){
            return -1;
        }
        if(root.left == null && root.right == null){
            leafSize++;
        }
        getLeafNodeCount(root.left);
        getLeafNodeCount(root.right);
        return leafSize;
    }

    // 获取叶子节点个数（递归法，不依赖成员变量）
    public int getLeafNodeCount2(BTNode root){
        if (root == null){
            return 0;
        }
        if(root.left == null && root.right == null){
            return 1;
        }
        return getLeafNodeCount2(root.left) + getLeafNodeCount2(root.right);
    }

    /**
     *  获取第 K 层结点的个数
     */
    public int getKLevelNodeCount(BTNode root,int k){
        //核心逻辑是判断当前结点是否在目标层，如果是目标层才返回数字
        if(root == null){
            return 0;
        }
        if(k == 1){
            return 1;
        }
        return getKLevelNodeCount(root.left,k - 1) + getKLevelNodeCount(root,k - 1);
    }

    /**
     * 计算树的高度(时间复杂度O(n))
     * @param root
     * @return
     */
    public int getHeight(BTNode root){
        //核心逻辑是当前树的左右子树的高度来进行比较再+1返回上一级
        if (root == null){
            return 0;
        }
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);

        return Math.max(leftHeight,rightHeight)+1;
    }
    // 检测值为value的元素是否存在
    BTNode findValue(BTNode root, int value){
        if(root == null){
            return null;
        }
        BTNode left = findValue(root.left,value);
        if(left != null){
            return left;
        }
        BTNode right = findValue(root.right,value);
        if(right != null){
            return right;
        }
        return null;
    }
    /**
     * 假设 p的节点树为m, q的节点树为n
     * 时间复杂度：O(min(m,n))
     * @param p
     * @param q
     * @return
     */
    public boolean isSameTree(BTNode p, BTNode q) {
        //1.先判断结构是否是一样的
        if(p != null && q == null || p == null && q != null) {
            return false;
        }
        //上述if语句 如果没有执行，意味着两个引用 同时为空 或者同时不为空
        if(p == null && q == null) {
            return true;
        }
        //都不为空 判断值是否一样
        if(p.value != q.value) {
            return false;
        }
        //都不为空且值一样
        return isSameTree(p.left,q.left)
            && isSameTree(p.right,q.right);
    }

    /**
     * root共有节点r个，subRoot共有节点s个
     * 时间复杂度：O(r*s)
     * @param root
     * @param subRoot
     * @return
     */
    public boolean isSubtree(BTNode root, BTNode subRoot) {
        if(root == null) {
            return false;
        }
        if(isSameTree(root,subRoot)) return true;
        if(isSubtree(root.left,subRoot))  return true;
        if(isSubtree(root.right,subRoot))  return true;
        return false;
    }


    // 翻转二叉树（将每个节点的左右子树交换）
    public BTNode invertTree(BTNode root) {
        if(root == null) {
            return null;
        }
        // if(root.left == null && root.right == null) {
        //     return root;
        // }
        BTNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

    // 判断一棵树是否为对称二叉树
    public boolean isSymmetric(BTNode root) {
        if(root == null) {
            return true;
        }
        return isSymmetricChild(root.left,root.right);
    }

    // 辅助方法：递归判断两棵子树是否对称
    public boolean isSymmetricChild(BTNode leftTree,BTNode rightTree) {
        if(leftTree != null && rightTree == null || leftTree == null && rightTree != null) {
            return false;
        }

        if(leftTree == null && rightTree == null) {
            return true;
        }

        if(leftTree.value != rightTree.value) {
            return false;
        }

        return isSymmetricChild(leftTree.left,rightTree.right)
            && isSymmetricChild(leftTree.right,rightTree.left);
    }


    /**
     * 时间复杂度：O(N^2)
     * @param root
     * @return
     */
    public boolean isBalanced(BTNode root) {
        if(root == null) return true;
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);

        return Math.abs(leftHeight-rightHeight) < 2
            && isBalanced(root.left) && isBalanced(root.right);
    }



    // 判断二叉树是否为平衡二叉树（优化版，后序遍历时提前剪枝）
    public boolean isBalanced2(BTNode root) {
        if(root == null) return true;
        return getHeight2(root) >= 0;
    }

    // 辅助方法：计算树高，若不平衡则返回-1（用于 isBalanced2 剪枝）
    public int getHeight2(BTNode root) {
        if(root == null) {
            return 0;
        }
        int leftHeight = getHeight2(root.left);
        if(leftHeight < 0) {
            return -1;
        }
        int rightHeight = getHeight2(root.right);
        if(rightHeight >= 0 && Math.abs(leftHeight-rightHeight) <= 1) {
            return Math.max(leftHeight,rightHeight) + 1;
        }else {
            return -1;
        }
    }

    BTNode prev = null;

    // 将二叉搜索树转换为有序双向链表
    public BTNode Convert(BTNode pRootOfTree) {
        if (pRootOfTree == null) {
            return null;
        }
        ConvertChild(pRootOfTree);
        BTNode head = pRootOfTree;
        while(head.left != null) {
            head = head.left;
        }
        return head;
    }

    // 辅助方法：中序遍历并连接节点，构建双向链表
    public void ConvertChild(BTNode root) {
        if (root == null) return ;
        ConvertChild(root.left);
        //打印
        root.left = prev;
        if (prev != null) {
            prev.right = root;
        }
        prev = root;
        ConvertChild(root.right);
    }

    // 层序遍历二叉树（广度优先）
    public void levelOrder(BTNode root) {
        if(root == null) {
            return;
        }
        Queue<BTNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            BTNode cur = queue.poll();
            System.out.print(cur.value+" ");
            if(cur.left != null) {
                queue.offer(cur.left);
            }
            if(cur.right != null) {
                queue.offer(cur.right);
            }
        }
        System.out.println();
    }
    // 层序遍历，按层分组返回节点值列表
    public List<List<Character>> levelOrder2(BTNode root) {
        List<List<Character>> ret = new ArrayList<>();
        if(root == null) {
            return ret;
        }
        Queue<BTNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();//3
            List<Character> list = new ArrayList<>();
            while (size != 0) {
                BTNode cur = queue.poll();
                list.add((char) cur.value);
                //System.out.print(cur.value + " ");
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
                size--;
            }
            ret.add(list);
        }
        return ret;
    }
    // 判断一棵树是不是完全二叉树
    public boolean isCompleteTree(BTNode root) {
        if(root == null) {
            return true;
        }
        Queue<BTNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            BTNode cur = queue.poll();
            if(cur != null) {
                queue.offer(cur.left);
                queue.offer(cur.right);
            }else {
                break;
            }
        }

        while (!queue.isEmpty()) {
            BTNode peek = queue.peek();
            if(peek != null) {
                return false;
            }
            queue.poll();
        }
        return true;
    }

    // 查找二叉树中两个节点的最近公共祖先（递归法）
    public BTNode lowestCommonAncestor(BTNode root,  BTNode p, BTNode q) {
        if(root == null) {
            return null;
        }
        if(root ==p || root == q) {
            return root;
        }
        BTNode leftTree = lowestCommonAncestor(root.left,p,q);
        BTNode rightTree = lowestCommonAncestor(root.right,p,q);
        if(leftTree != null && rightTree != null) {
            return root;
        }else if(leftTree != null) {
            return leftTree;
        }else {
            return rightTree;
        }
    }

    /**
     *
     * @param root
     * @param node 找的节点
     * @param stack 存储到栈当中
     */
    public boolean getPath(BTNode root,
                           BTNode node,
                           Stack<BTNode> stack) {
        if(root == null) {
            return false;
        }
        stack.push(root);
        if(root == node) {
            return true;
        }
        boolean ret = getPath(root.left,node,stack);
        if(ret) {
            return true;
        }
        ret = getPath(root.right,node,stack);
        if(ret) {
            return true;
        }
        stack.pop();
        return false;
    }


    // 查找最近公共祖先（栈方法：获取根到节点的路径再比较）
    public BTNode lowestCommonAncestor2(BTNode root, BTNode p, BTNode q) {
        if(root == null) {
            return null;
        }
        //1.获取路径上的所有节点
        Stack<BTNode> stackP = new Stack<>();
        Stack<BTNode> stackQ = new Stack<>();
        getPath(root,p,stackP);
        getPath(root,q,stackQ);

        //2. 比较两个栈的大小，多的出size个
        int sizeP = stackP.size();
        int sizeQ = stackQ.size();
        if(sizeP > sizeQ) {
            int size = sizeP - sizeQ;
            while (size != 0) {
                stackP.pop();
                size--;
            }
        }else {
            int size = sizeQ - sizeP;
            while (size != 0) {
                stackQ.pop();
                size--;
            }
        }
        //3. 每次出数据 看栈顶元素是否一样
        while (!stackP.isEmpty() && !stackQ.isEmpty()) {
            if (stackP.peek() == stackQ.peek()) {
                return stackP.peek();
            } else {
                stackQ.pop();
                stackP.pop();
            }
        }

        return null;
    }

    // 将二叉树转换为括号表示的字符串
    public String tree2str(BTNode root) {
        if(root == null) {
            return null;
        }

        StringBuilder stringBuilder = new  StringBuilder();
        tree2strChild(root,stringBuilder);
        return stringBuilder.toString();

    }

    // 辅助方法：递归构建括号字符串
    public void tree2strChild(BTNode t,StringBuilder stringBuilder) {
        if(t == null) return;
        stringBuilder.append(t.value);//1

        if(t.left != null) {
            stringBuilder.append("(");
            tree2strChild(t.left,stringBuilder);
            stringBuilder.append(")");
        }else {
            if(t.right == null) {
                return;
            }else {
                stringBuilder.append("()");
            }
        }

        if(t.right != null) {
            stringBuilder.append("(");
            tree2strChild(t.right,stringBuilder);
            stringBuilder.append(")");
        }else {
            return;
        }

    }

}
