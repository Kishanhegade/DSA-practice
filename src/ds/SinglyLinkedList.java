package ds;

public class SinglyLinkedList {
    class Node{
        Node next;
        Object data;
        Node(Object data){
            this.data =  data;
        }
    }
    Node head;
    public void add(Object data){
        Node n = new Node(data);
        if(head==null){
            head = n;
            return;
        }
        Node temp = head;
        while(temp.next!=null){
            temp=temp.next;
        }
        temp.next = n;
    }

    public void display(){
        if(head==null){
            System.out.println("List is empty");
            return;
        }
        Node temp = head;
        while(temp.next!=null){
            System.out.print(temp.data+"->");
            temp = temp.next;
        }
        System.out.println(temp.data);
    }

    public void addFirst(Object data){
        Node n = new Node(data);
        if(head==null){
            head = n;
            return;
        }
        n.next = head;
        head = n;
    }
    public Object deleteFirst(){
        if(head==null){
            System.out.println("List is empty");
            return null;
        }
        Object data = head.data;
        head = head.next;
        return data;
    }
    public Object deleteLast(){
        if(head==null){
            System.out.println("List is empty");
            return null;
        }
        Node temp = head;
        Node prev = null;
        while(temp.next!=null){
            prev = temp;
            temp = temp.next;
        }
        Object data = temp.data;
        if(prev==null){
            head = null;
        }
        else {
            prev.next = null;
        }
        return data;
    }
    public void add(Object data, int ind){
        Node n = new Node(data);
        if(ind==0){
            n.next=head;
            head = n;
        }
        else{
            Node temp = head;
            for(int i=0;i<ind-1;i++){
                if(temp!=null)
                    temp=temp.next;
                else
                    break;
            }
            if(temp==null){
                System.out.println("Index out of bounds");
                return;
            }
            n.next=temp.next;
            temp.next=n;
        }
    }

//    public void add(Object data, int ind)
//    {
//        Node n = new Node(data);
//        if(ind==0){
//            n.next=head;
//            head=n;
//            return;
//        }
//        Node temp=head;
//        while(ind>1 && temp!=null){
//            temp=temp.next;
//            ind--;
//        }
//        if(temp==null){
//            System.out.println("Index out of bounds");
//            return;
//        }
//        n.next=temp.next;
//        temp.next=n;
//    }
    public void delete(int ind){
        if(head==null){
            System.out.println("List is empty");
            return;
        }
        if(ind==0){
            head = head.next;
            return;
        }
        Node temp=head;
        for(int i=0;i<ind-1;i++){
            if(temp==null)
                break;
            temp = temp.next;
        }
        if(temp==null||temp.next==null){
            System.out.println("Index out of bounds");
            return;
        }
        temp.next=temp.next.next;
    }

    public void reverse(){
        Node current = head;
        Node previous = null;
        while(current!=null){
            Node temp = current.next;
            current.next = previous;
            previous = current;
            current = temp;
        }
        head = previous;
    }

    public boolean search(Object obj){
        Node temp = head;
        while(temp!=null){
            if(temp.data.equals(obj))
                return true;
            temp = temp.next;
        }
        return false;
    }
}

class Test{
    public static void main(String[] args) {
        SinglyLinkedList sl = new SinglyLinkedList();
        sl.add(10);
        sl.add(20);
        sl.add(30);
        sl.add(35,2);
        sl.display();
        sl.reverse();
        sl.display();
    }
}