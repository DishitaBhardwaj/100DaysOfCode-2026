class MyCircularQueue {
    int front;
    int rear;
    int currsize;
    int k;
    int arr[] ;

    public MyCircularQueue(int k) {
        this.k = k;
        arr=new int[k];
        front=0;
        rear=-1;
        currsize=0;

        

        
    }
    
    public boolean enQueue(int value) {
        
        if(currsize==k){
            return false;
        }
        
        rear=(rear+1)%k;
        arr[rear]=value;
        currsize++;
        return true;
    }
    
    public boolean deQueue() {
        if(currsize==0){
            return false;
        }
        
            front=(front+1)%k;
            currsize--;
        
        return true;
        
    }
    
    public int Front() {
if(currsize==0){
    return -1;
}
return arr[front];


        
    }
    
    public int Rear() {
        if(currsize==0){
            return -1;
        }
        return arr[rear];
        
    }
    
    public boolean isEmpty() {
        if(currsize==0){
            return true;
        }
        return false;
        
    }
    
    public boolean isFull() {
        if(currsize==k){
            return true ;
        }
        return false;
        
    }
}