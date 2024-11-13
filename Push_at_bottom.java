import java.util.*;
public class Push_at_bottom{
    public static void push_bot(Stack<Integer>s,int data){
        if(s.isEmpty()){
            s.push(data);
            return;
        }
        int top=s.pop();
        push_bot(s, data);
        s.push(top);
    }
    public static void main(String args[]){
        Stack<Integer>s=new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);
        push_bot(s, 0);
        while(!s.isEmpty()){
            System.out.println(s.pop());
        }
    }
}