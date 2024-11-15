public class LinkedList{
    public static class Node{
        int data;
        Node next;
        public Node(int data){
            this.data=data;
            this.next=null;
        }
    }
     //add in the linked list
    public static Node head;
    public static Node tail;
    public static int size;

    public void addfirst(int data){
        //step1
        Node newnode= new Node(data);
        size++;
        if(head==null){
            head=tail=newnode;
            return ;
        }
        //step 2
        newnode.next=head;
        //step3 
        head=newnode;

    }
    public void addlast(int data){
        Node newNode=new Node(data);
        size++;
        if(head==null){
            head=tail=newNode;
            return ;
        }
        tail.next=newNode;
        tail=newNode;
        
    }
    //add index
    public void add(int idx,int data){
       Node newNode=new Node(data);
       size++;
       Node temp=head;
       int i=0;
       while(i<idx-1){
        temp=temp.next;
        i++;
       }
       newNode.next=temp.next;
       temp.next=newNode;

    }
    //remove first
    public int removefirst(){
        if(size==0){
            System.out.println("ll is empty");
            return Integer.MIN_VALUE;
        }
        else if(size==1){
            int val=head.data;
            head=tail=null;
            return val;
        }
        int val=head.data;
        head=head.next;
        size--;
        return val;
    }
    //remove last
    public int removelast(){
        if(size==0){
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;
        }
        else if (size==1){
            int val=head.data;
            head=tail=null;
            size=0;
            return val;
        }
        Node prev=head;
        for(int i=0;i<size-2;i++){
            prev=prev.next;
        }
        int val=prev.next.data;
        prev.next=null;
        tail=prev;
        size--;
        return val;

    }
    //iterative search
    public int itrsearch(int key){
        Node temp=head;
        int i=0;
        while(temp!=null){
            if(temp.data==key){
                return i;
            }
            temp=temp.next;
            i++;
        }
        return -1;
    }
    //recursive search
    public int helper(Node head,int key){
        if(head==null){
            return -1;
        }
        if(head.data==key){
            return 0;
        }
        int idx=helper(head.next,key);
        if(idx==-1){
            return -1;
        }
        return idx+1;
    }
    public int research(int key){
        return helper(head,key);
    }
    //reverse a linked list
    public void reverse(){
        Node prev=null;
        Node curr=tail=head;
        Node next;

        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        head=prev;
    }
    //remove from last
    public void delete(int n){
        int sz=0;
        Node temp=head;
        while(temp!=null){
            temp=temp.next;
        }
        int i=1;
        int itfound=sz-n;
        Node prev=head;
        while(i<itfound){
            prev=prev.next;
            i++;
        }
        prev.next=prev.next.next;
        return;
    }
    //slow-fast 
    private Node findmid(Node head){
        Node slow=head;
        Node fast=head;
        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    public boolean palindrome(){
        if(head==null||head.next==null){
            return true;
        }
        //step 1
        Node prev=null;
        Node curr=findmid(head);
        Node next;
        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        Node right=prev;//right half head
        Node left=head;
        //step 3/check left half and right half
        while(right!=null){
            if(left.data!=right.data){
                return false;
            }
            left=left.next;
            right=right.next;
        }
        return true;
    }
    //loop/cycle
    public static boolean cycle(){
        Node slow=head;
        Node fast=head;
        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                return true;//cycle exists
            }
        }
        return false;//cycle doesnot exists
    }
    //remove loop
    public static void remove(){
        //detect cycle
        Node slow=head;
        Node fast=head;
        boolean cycle=false;
        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(fast==slow){
                cycle=true;
                break;
            }
        }
        if(slow==fast){
            return;
        }
        //find meeting point
        slow=head;
        Node prev=null;//last node
        while(slow!=fast){
            prev=fast;
            slow=slow.next;
            fast=fast.next;
        }
        //remove cycle 
        prev.next=null;

    }
    //merge sort
    private Node getMid(Node head){
        Node slow=head;
        Node fast=head.next;
        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    private Node merge(Node head1,Node head2){
        Node mergedll=new Node(-1);
        Node temp=mergedll;
        while(head1!=null&&head2!=null){
            if(head1.data<=head2.data){
                temp.next=head1;
                head1=head1.next;
                temp=temp.next;
            }
            else{
                temp.next=head2;
                head2=head1.next;
                temp=temp.next;
            }
        }
        while(head1!=null){
            temp.next=head1;
            head1=head1.next;
            temp=temp.next;
        }
        while(head2!=null){

        }
        return mergedll.next;
    }
    public Node mergesort(Node head){

        if(head==null||head.next==null){
            return head;
        }
        //find mid
        Node mid=getMid(head);
        //left and right ms
        Node righthead=mid.next;
        mid.next=null;
        Node newLeft=mergesort(head);
        Node newRight=mergesort(righthead);
        //merge
        return merge(newLeft,newRight);
    }
    //print
    public  void print(){
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.data+"->");
            temp=temp.next;
        }
        System.out.println("null");
    }
    public static void main(String args[]){
        LinkedList ll =new LinkedList();
        ll.addfirst(1);
        ll.addfirst(2);
        ll.print();
    }
}