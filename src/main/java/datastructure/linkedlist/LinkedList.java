package datastructure.linkedlist;

import java.util.Objects;

public class LinkedList {
  private Node head;
  private Node tail;
  private int length;


  public static class Node {
    int value;
    Node next;

    public Node(int value){
      this.value = value;
    }
  }

  public LinkedList(int value){
    Node newNode = new Node(value);
    head = newNode;
    tail = newNode;
    length = 1;
  }

  public void append(int value){
    Node newNode = new Node(value);
    if(length == 0){
      head = newNode;
    }
    else {
      tail.next = newNode;
    }
    tail = newNode;
    length++;
  }

  public Node removeLast() {
    if(length == 0) return null;

    Node pre = head;
    Node temp = head;

    while (temp.next != null){
      pre = temp;
      temp = temp.next;
    }
    tail = pre;
    tail.next = null;
    length--;

    // edge case: if list contains only 1 node; length = 0
    if(length == 0){
      head = null;
      tail = null;
    }

    return temp;
  }

  public void prepend(int value){
    Node newNode = new Node(value);
    if(length == 0){
      head = newNode;
      tail = newNode;
    }
    else {
      newNode.next = head;
      head = newNode;
    }
    length++;
  }

  public Node removeFirst(){
    if(length == 0) return null;

    Node temp = head;
    head = head.next;
    temp.next = null;
    length--;

    if(length == 0){
      tail = null;
    }
    return temp;
  }

  public Node get(int index){
    if(index < 0 || index >= length){
      return null;
    }

    Node temp = head;
    for (int i = 0; i < index; i++) {
      temp = temp.next;
    }
    return temp;
  }

  public boolean set(int index, int value){
    Node temp = get(index);
    if(temp != null){
      temp.value = value;
      return true;
    }
    return false;
  }

  public boolean insert(int index, int value){
    if(index < 0 || index > length) return false;
    if(index == 0){
      prepend(value);
      return true;
    }
    if(index == length){
      append(value);
      return true;
    }
    Node prev = get(index - 1);
    Node newNode = new Node(value);
    newNode.next = prev.next;
    prev.next = newNode;
    length++;
    return true;
  }

  public Node remove(int index){
    if(index < 0 || index >= length) return null;
    if(index == 0) return removeFirst();
    if(index == length - 1) return removeLast();
    Node previous = get(index - 1);
    Node current = previous.next;
    previous.next = current.next;
    current.next = null;
    length--;
    return current;
  }

  public void reverse(){
    Node temp = head;
    head = tail;
    tail = temp;

    Node before = null;
    Node after = temp.next;

    for (int i = 0; i < length; i++) {
      after = temp.next;
      temp.next = before;
      before = temp;
      temp = after;
    }
  }

  public static boolean areEqual(Node head1, Node head2) {

    if (head1 == head2) {
      return true;
    }

    while (head1 != null && head2 != null) {
      if (head1.value != head2.value) {
        return false;
      }

      head1 = head1.next;
      head2 = head2.next;
    }

    return head1 == null && head2 == null;
  }



  public void printList(){
    Node temp = head;
    while (temp != null){
      System.out.println(temp.value);
      temp = temp.next;
    }
  }



  public Node getHead() {
    return head;
  }

  public Node getTail() {
    return tail;
  }

  public int size() {
    return length;
  }

}
