public class Tree_Traversal{
    static class Node{
        int data;
        Node left;
        Node right;
        public Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
     
    }

    //Inorder traversal
    public static void inorder(Node root){
        if(root==null){
            return;
        }
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }
    //preorder traversal
    public static void preOrder(Node root){
        if(root== null){
            return;
        }
        System.out.print(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);
    }
    //postorder traversal
    public static void postOrder(Node root){
        if(root==null){
            return ;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data+" ");
        
    }
    //Lverl order traversal
    public static void levelOrder(Node root){
        if(root==null){
            return;
        }
        java.util.Queue<Node>q=new java.util.LinkedList<>();
        q.add(root);
        q.add(null);
        while(!q.isEmpty()){
            Node currNode=q.remove();
            if(currNode==null){
                System.out.println();
                if(q.isEmpty()){
                    break;
                }
                else{
                    q.add(null);
                }
            }
            else{
                System.out.print(currNode.data+" ");
                if(currNode.left!=null){
                    q.add(currNode.left);
                }
                if(currNode.right!=null){
                    q.add(currNode.right);
                }
            }
        }
    }
    public static void main(String args[]){
        Node newNode=new Node(1);
        newNode.left=new Node(2);
        newNode.right=new Node(3);
        newNode.left.left=new Node(4);
        newNode.left.right=new Node(5);
        newNode.right.left=new Node(6);
        newNode.right.right=new Node(7);
        inorder(newNode);
        preOrder(newNode);
        postOrder(newNode);
        levelOrder(newNode);
    }
}