public class Stock_Span{
    public static void stock_span(int stocks[],int span[]){
        java.util.Stack<Integer>s = new java.util.Stack<>();
        span[0]=1;
        s.push(0);
        for(int i=0;i<stocks.length;i++){
            int curr=stocks[i];
            while(!s.isEmpty() && curr>stocks[s.peek()]){
                s.pop();
            }
            if(s.isEmpty()){
                span[i]=i+1;
            }
            else{
                int prevHigh = s.peek();
                span[i] = i-prevHigh;
            }
            s.push(i);
        }
    }
    public static void main(String args[]){
        int stocks[]={100,80,60,70,60,85,100};
        int span[]=new int [stocks.length];
        stock_span(stocks, span);
        for(int i=0;i<span.length;i++){
            System.out.print(span[i]+" ");
        }
    }
}