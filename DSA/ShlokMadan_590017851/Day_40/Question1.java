import java.util.LinkedList;
public class Question1 
{
    static class FrontMiddleBackQueue 
    {
        LinkedList<Integer> list;
        public FrontMiddleBackQueue() 
        {
            list=new LinkedList<>();
        }
        public void pushFront(int val) 
        {
            list.addFirst(val);
        }
        public void pushMiddle(int val) 
        {
            list.add(list.size()/2,val);
        }
        public void pushBack(int val) 
        {
            list.addLast(val);
        }
        public int popFront() 
        {
            if(list.isEmpty()) 
                {
                return -1;
            }
            return list.removeFirst();
        }
        public int popMiddle() 
        {
            if(list.isEmpty()) 
                {
                return -1;
            }
            return list.remove((list.size()-1)/2);
        }
        public int popBack() 
        {
            if(list.isEmpty()) 
                {
                return -1;
            }
            return list.removeLast();
        }
    }
    public static void main(String[] args) 
    {
        FrontMiddleBackQueue q=new FrontMiddleBackQueue();
        q.pushFront(1);
        q.pushBack(2);
        q.pushMiddle(3);
        q.pushMiddle(4);
        System.out.println(q.popFront());
        System.out.println(q.popMiddle());
        System.out.println(q.popMiddle());
        System.out.println(q.popBack());
        System.out.println(q.popFront());
    }
}