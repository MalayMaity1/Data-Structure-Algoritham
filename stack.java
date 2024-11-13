public class stack{
    static class Stack{
        static java.util.ArrayList<Integer>list=new java.util.ArrayList<>();
        //Check if the stack is Empty or not 
        public  boolean isEmpty(){
            return list.size()==0;
        }
        //add data onto the stack
        public  void push(int data){
            list.add(data);
        }
        //remove data fromt the stack
        public  int  pop(){
            int top=list.get(list.size()-1);
            list.remove(list.size()-1);
            return top;
        }
        //return the tops element
        public  int  peek(){
            return list.get(list.size()-1);
        }
    }
    public static void main(String args[]){
        Stack s = new Stack();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        while(!s.isEmpty()){
            System.out.println(s.peek()+" ");
            s.pop();
        }
    }
}