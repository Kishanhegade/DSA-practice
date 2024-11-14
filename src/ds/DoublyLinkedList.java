package ds;

public class DoublyLinkedList {
    class Node {
        Object data;
        Node next;
        Node prev;
        Node(Object data){
            this.data = data;
        }
    }
    Node head;

    @Override
    public String toString(){
        Node temp = head;
        String res = "";
        if(temp==null){
            return "List is empty";
        }
        while(temp.next!=null){
            res=res+temp.data+"<->";
            temp = temp.next;
        }
        res=res+temp.data;
        return res;
    }
    public void addFirst(Object data){
        Node n = new Node(data);
        if(head==null){
            head=n;
            return;
        }
        n.next = head;
        head.prev = n;
        head = n;
    }

    public void add(Object data){
        Node n = new Node(data);
        if(head==null){
            addFirst(data);
            return;
        }
        Node temp = head;
        while(temp.next!=null){
            temp = temp.next;
        }
        temp.next = n;
        n.prev = temp;
    }

    public void delete(int ind){
        if(head.next==null){
            head=null;
            return;
        }
        if(ind==0){
            head.next.prev=null;
            head=head.next;
            return;
        }
        Node temp = head;
        while(temp!=null && ind>1) {
            temp = temp.next;
            ind--;
        }
        if(temp!=null && temp.next!=null) {
            temp.next = temp.next.next;
            if(temp.next!=null)
                temp.next.prev = temp;
        }
    }
    public void deleteFirst(){
        if(head==null){
            System.out.println("List is empty");
            return;
        }
        head = head.next;
        if(head!=null)
            head.prev = null;

    }
    public void deleteLast(){
        if(head==null){
            System.out.println("List is empty");
            return;
        }
        Node temp = head;
        while(temp.next!=null){
            temp = temp.next;
        }
        if(temp.prev!=null)
            temp.prev.next = null;
        else{
            head=null;
        }
    }

//    public void add(Object data, int ind){
//        Node n = new Node(data);
//        if(head==null){
//            head=n;
//            return;
//        }
//        if(ind==0){
//            n.next=head;
//            head.prev = n;
//            head = n;
//            return;
//        }
//        Node temp = head;
//        for(int i=0;i<ind-1;i++){
//            if(temp==null)
//                break;
//            temp = temp.next;
//        }
//        if(temp!=null && temp.next!=null) {
//            n.next = temp.next;
//            temp.next.prev = n;
//            temp.next = n;
//            n.prev = temp;
//        }
//        else{
//            System.out.println("Index out of bounds");
//        }
//    }

    public void add1(Object data,int ind){
        Node n = new Node(data);
        Node temp = head;
        while(temp!=null && ind>1){
            temp = temp.next;
            ind--;
        }
        if(temp==null || temp.next==null){
            System.out.println("Index out of bounds");
            return;
        }
        n.next = temp.next;
        temp.next=n;
        n.prev = temp;
        if(n.next!=null)
            n.next.prev = n;
    }

    public void reverse(){
        Node temp = head;
        while(temp!=null){
           Node prev = temp.prev;
           temp.prev = temp.next;
           temp.next = prev;
           if(temp.prev==null)
               head=temp;
           temp = temp.prev;
        }

    }
}

class Tester{
    public static void main(String[] args) {
        DoublyLinkedList dl = new DoublyLinkedList();
        dl.add(10);
        dl.add(20);
        dl.add(30);
        dl.add(50);
        System.out.println(dl);
        dl.add1(40,3);
        System.out.println(dl);
        System.out.println(dl);
        dl.delete(2);
        System.out.println(dl);
        dl.reverse();
        System.out.println(dl);
    }
}
