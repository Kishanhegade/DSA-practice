package ds;

public class MyQueue<T> {
    class Node{
        Node next;
        Node prev;
        T data;
        Node(T data){
            this.data = data;
        }
    }
    Node front,rear;
    Integer size;

    public void enqueue(T data){
        Node n = new Node(data);
        if(front==null){
            front=rear= n;
            return;
        }
        size++;
        n.prev = rear;
        rear.next = n;
        rear = n;
    }
    public T dequeue(){
        if(front==null){
            System.out.println("Queue is empty");
            return null;
        }
        T data = front.data;
        front = front.next;

        size--;
        if(front==null)
            rear=null;
        else
            front.prev = null;
        return data;
    }

    public int size(){
        return size;
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        Node temp = front;
        if(temp==null){
            return "Queue is empty";
        }
        while(temp.next!=null){
            res.append(temp.data).append("<=>");
            temp = temp.next;
        }
        res.append(temp.data);
        return res.toString();
    }
}
