import java.util.LinkedList;

public class CustomLinkedList<T> implements CustomList<T> {

    private Node<T> head = null;
    private Node<T> tail = null;

    private int size = 0;

    class Node<T> {
        T data;
        Node<T> next;
        Node<T> prev;

        Node(Node<T> prev, T el, Node<T> next) {
            this.prev = prev;
            this.data = el;
            this.next = next;
        }

    }

    private void linkTail(T el) {
        Node<T> t = tail;
        Node<T> newNode = new Node<>(t, el, null);
        tail = newNode;
        if (t == null)
            head = newNode;
        else
            t.next = newNode;
        size++;
    }

    private void linkHead(T el) {
        Node<T> t = head;
        Node<T> newNode = new Node<>(null, el, t);
        tail = newNode;
        if (t == null)
            tail = newNode;
        else
            t.prev = newNode;
        size++;
    }
    public int size(){
        return size;
    }

    @Override
    public void add(T el) {
        linkTail(el);
    }

    private void unlink(Node<T> node){
        if (node.prev == null){
            head = node.next;
        }
        else{
            node.prev.next = node.next;
        }

        if (node.next == null) {
            tail = node.prev;
        } else {
            node.next.prev = node.prev;
        }

        size--;
    }

    @Override
    public boolean delete(T el) {
        return removeFromHead(el);
    }

    public boolean removeFromHead(T el) {
        if(el == null){
            Node<T> node = head;
            while(node != null){
                if (el.equals(node.data)){
                    unlink(node);
                    return true;
                }
                node = node.next;
            }
            return false;
        }

        Node<T> node = head;
        while(node != null){
            if (node.data.equals(el)){
                unlink(node);
                return true;
            }
            node = node.next;
        }
        return false;
    }

    public boolean removeFromTail(T el) {
        if (el == null){
            Node<T> node = tail;
            while(node != null){
                if (node.data == null){
                    unlink(node);
                    return true;
                }
                node = node.prev;
            }
            return false;
        }

        Node<T> node = tail;
        while(node != null){
            if (el.equals(node.data)){
                unlink(node);
                return true;
            }
            node = node.prev;
        }
        return false;
    }

    @Override
    public void sort() {
        System.out.println("sorted");
    }

    public void print(){
        Node<T> t = head;
        while(t != null){
            System.out.print(t.data + " -> ");
            t = t.next;
        }
        System.out.println();
    }
}
