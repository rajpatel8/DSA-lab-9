// import java.util.Scanner;

class Node
{
    int value ;
    Node left ;
    Node right ;

    Node(int value)
    {
        this.value = value ;
        right = null ;
        left  = null ;
    }
}

class BST 
{
    Node root ;
    
    private Node Insert(Node currentNode, int value )
    {
        if (currentNode == null) 
        {
            return new Node(value) ;
        }

        if (value  < currentNode.value) {
            currentNode.left = Insert(currentNode.left, value) ;
        }
        else if (value > currentNode.value)
        {
            currentNode.right = Insert(currentNode.right, value) ;
        }
        return currentNode ;
    }

    public void insert (int value)
    {
        this.root  = Insert(root, value) ;
    }

    private void pinorder(Node root) {
        if (root==null) {
            return;
        }
        pinorder(root.left) ;
        System.out.print(root.value + " ");
        pinorder(root.right) ;
    }

    private void ppreorder(Node root) {
        if (root == null ) {
            return ;
        }
        System.out.print(root.value + " ");
        ppreorder(root.left);
        ppreorder(root.right);
    }

    private void printPostorder(Node node)
    {
        if (node == null)
            return;

        printPostorder(node.left);
 
        printPostorder(node.right);

        System.out.print(node.value + " ");
    }

    public void Postorder()
    {
        printPostorder(root);
    }

    public void inorder() {
        pinorder(root);
    }

    public void preorder() {
        ppreorder(root);
    }

    private int in_suc(Node root)
    {
        int k = 0 ;
        Node j = null ;
        while (root.right!=null) {
            j = root ;
            root = root.right ;
            k = root.value ;
        }
        j.right = null;
        return k ;
    }

    private void del(Node root) {
        if (root==null) {
            return ;
        }
        else if (root.left==null&&root.right!=null) {
            root=root.right;
            root.right=null;
        }
        else if (root.left!=null&&root.right==null) {
            root=root.left;
            root.left=null;
        }
        else if (root.left!=null&&root.right!=null) {
            root.value=in_suc(root);
        }
    }

    public void delete(int value)
    {
        Node c = search(value) ;
        if (c==null) {
            System.out.println("Element is not present in Tree");
        }
        else
        {
            del(c);
        }
    }

    public Node search(int value) {
        Node k = root ;
        Node t = null;
        while (k!=null&&k.value!=value&&(k.left!=null||k.right!=null)) {
            if (k.value<value) {
                t=k;
                k=k.right;
            }
            else {t=k;k=k.left;}
        }
        return k ;
    } 
    public Node ser(int value) {
        Node k = root ;
        Node t = null;
        while (k!=null&&k.value!=value&&(k.left!=null||k.right!=null)) {
            if (k.value<value) {
                t=k;
                k=k.right;
            }
            else {t=k;k=k.left;}
        }
        return t ;
    } 

    public void min() {
        if (ser(Integer.MIN_VALUE).value<root.value) {
            System.out.println("Minimum value in Tree is "+ser(Integer.MIN_VALUE).value); 
        }
        else
        {
            System.out.println(root.value);
        }
        
    }

    public void max() {
        if (ser(Integer.MAX_VALUE).value>root.value) {
            System.out.println("Maximum value in Tree is "+ser(Integer.MAX_VALUE).value); 
        }
        else
        {
            System.out.println("Maximum value in Tree is "+root.value);
        }
        
    }

    private int maxDepth(Node node)
    {
        if (node == null)
            return -1;
        else
        {
            int lDepth = maxDepth(node.left);
            int rDepth = maxDepth(node.right);
  
            if (lDepth > rDepth)
                return (lDepth + 1);
             else
                return (rDepth + 1);
        }
    }

    public int height() {
        return maxDepth(root);
    }

    public void largest(int k) {
        
    }
    
}