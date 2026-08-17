class MyCircularQueue{
    int[] q;
    int head=0, tail=-1, count=0, cap;

    public MyCircularQueue(int k){
        cap=k;
        q=new int[cap];
    }
    
    public boolean enQueue(int val){
        if(isFull()) return false;
        tail=(tail+1)%cap;
        q[tail]=val;
        count++;
        return true;
    }
    
    public boolean deQueue(){
        if(isEmpty()) return false;
        head=(head+1)%cap;
        count--;
        return true;
    }
    
    public int Front(){
        return isEmpty()? -1 : q[head];
    }
    
    public int Rear(){
        return isEmpty()? -1 : q[tail];
    }
    
    public boolean isEmpty(){
        return count==0;
    }
    
    public boolean isFull(){
        return count==cap;
    }
}

public class Question1{
    public static void main(String[] args){
        MyCircularQueue cq=new MyCircularQueue(3);
        System.out.println(cq.enQueue(1)); 
        System.out.println(cq.enQueue(2)); 
        System.out.println(cq.enQueue(3)); 
        System.out.println(cq.enQueue(4)); 
        System.out.println(cq.Rear());     
        System.out.println(cq.isFull());   
        System.out.println(cq.deQueue());  
        System.out.println(cq.enQueue(4)); 
        System.out.println(cq.Rear());     
    }
}