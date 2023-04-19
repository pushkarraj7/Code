class MyLinkedList {
  private class Node {
    int val;
    Node next;
    public Node(int val) {
      this.val = val;
      this.next = null;
    }
  }
  private Node head;
  private int size;
  public MyLinkedList() {
    head = null;
    size = 0;
  }
  public int get(int index) {
    if (index < 0 || index >= size) {
      return -1;
    }
    Node curr = head;
    for (int i = 0; i < index; i++) {
      curr = curr.next;
    }
    return curr.val;
  }
  public void addAtHead(int val) {
    Node node = new Node(val);
    node.next = head;
    head = node;
    size++;
  }
  public void addAtTail(int val) {
    if (head == null) {
      addAtHead(val);
    } else {
      Node node = new Node(val);
      Node curr = head;
      while (curr.next != null) {
        curr = curr.next;
      }
      curr.next = node;
      size++;
    }
  }
  public void addAtIndex(int index, int val) {
    if (index < 0 || index > size) {
      return;
    }
    if (index == 0) {
      addAtHead(val);
    } else if (index == size) {
      addAtTail(val);
    } else {
      Node node = new Node(val);
      Node curr = head;
      for (int i = 0; i < index - 1; i++) {
        curr = curr.next;
      }
      node.next = curr.next;
      curr.next = node;
      size++;
    }
  }
  public void deleteAtIndex(int index) {
    if (index < 0 || index >= size) {
      return;
    }
    if (index == 0) {
      head = head.next;
    } else {
      Node curr = head;
      for (int i = 0; i < index - 1; i++) {
        curr = curr.next;
      }
      curr.next = curr.next.next;
    }
    size--;
  }
}