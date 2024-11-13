public class Stack_using_LinkedList{
    static class Node{
        int data;
        Node next;
        public Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    static class Stack{
        static Node top=null;
        //Check if the Stack is empty or not 
        public boolean isEmpty(){
            return top==null;
        }
        //push operation
        public  void push(int data){
            Node newNode = new Node(data);
            if(isEmpty()){
                top=newNode;
                return;
            }
            newNode.next=top;
            top=newNode;
        }
        //pop operation
        public  int pop(){
            if(isEmpty()){
                return -1;
            }
            int pop=top.data;
            top=top.next;
            return pop;
        }
        //peek operation
        public  int peek(){
            if(isEmpty()){
                return -1;
            }
            return top.data;
        }

    }
    public static void main(String args[]){
        Stack s=new Stack();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);
        while(!s.isEmpty()){
            System.out.println(s.peek()+ " ");
            s.pop();
        }
    }
}