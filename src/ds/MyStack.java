package ds;

public class MyStack<T>{
    class Node
    {
        T data;
        Node next;
        Node prev;
        Node(T data){
            this.data = data;
        }
    }
    Node top;
    Integer size = 0;
    @Override
    public String toString(){
       StringBuilder res = new StringBuilder();
       if(top==null){
           return "Stack is empty";
       }
       Node temp = top;
       while(temp.next!=null){
           res.append(temp.data).append("<->");
           temp=temp.next;
       }
       res.append(temp.data);
       return res.toString();
    }
    public void push(T data){
        Node n = new Node(data);
        if(top==null){
            top=n;
            return;
        }
        n.next = top;
        top.prev = n;
        top = n;
        size++;
    }

    public T pop(){
        if(top==null){
            System.out.println("Stack is empty");
            return null;
        }
        T data = top.data;

        top = top.next;
        if(top!=null)
            top.prev = null;
        size--;
        return data;
    }
    public T peek(){
        if(top==null){
            System.out.println("Stack is empty");
            return null;
        }
        return top.data;
    }
    public int size(){
        return size;
    }
}

class TestStack{
    public static void main(String[] args) {
        MyStack<Integer> stack = new MyStack<>();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println(stack);
        stack.pop();
        stack.pop();
        System.out.println(stack);
    }
}