package datastructures.linkedlist;

/**
 * Created by Sharukh Hasan on 9/30/16.
 *
 * Linked List Data Structure
 */
public class ListNode<T> {
    private T data;
    private ListNode<T> next;

    public ListNode(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public ListNode<T> getNext() {
        return next;
    }

    public void setNext(ListNode<T> next) {
        this.next = next;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) {
            return true;
        }

        if(!(o instanceof ListNode)) {
            return false;
        }

        ListNode listNode = (ListNode) o;
        if(!data.equals(listNode.data)) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        return data.hashCode();
    }

    @Override
    public String toString() {
        return "ListNode{" + "data=" + data + ", next=" + next + '}';
    }
}
