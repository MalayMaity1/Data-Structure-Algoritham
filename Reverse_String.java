public class Reverse_String{
    public static String reverse(String str){
        int idx=0;
        java.util.Stack<Character>s=new java.util.Stack<>();
        while(idx<str.length()){
            s.push(str.charAt(idx));
            idx++;
        }
        StringBuilder result = new StringBuilder();
        while(!s.isEmpty()){
            char curr=s.pop();
            result.append(curr);
        }
        return result.toString();
    }
    public static void main(String args[]){
        String str="abcd";
        String result=reverse(str);
        System.out.println(result);
    }
}