package datastructure.linkedlist;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

class LinkedListTest {

  @Test
  void shouldAppendNodeToEnd() {
    LinkedList list = new LinkedList(10);

    list.append(20);

    assertEquals(2, list.size());
    assertEquals(10, list.getHead().value);
    assertEquals(20, list.getTail().value);
    assertEquals(20, list.getHead().next.value);
  }

  @Test
  void shouldAppendMultipleNodes() {
    LinkedList list = new LinkedList(10);

    list.append(20);
    list.append(30);
    list.append(40);

    assertEquals(4, list.size());
    assertEquals(10, list.getHead().value);
    assertEquals(40, list.getTail().value);

    assertEquals(20, list.get(1).value);
    assertEquals(30, list.get(2).value);
    assertEquals(40, list.get(3).value);
  }

  @Test
  void shouldUpdateTailAfterAppend() {
    LinkedList list = new LinkedList(1);

    list.append(2);
    list.append(3);

    assertEquals(3, list.getTail().value);
    assertNull(list.getTail().next);
  }

  @Test
  void shouldIncreaseSizeAfterEachAppend() {
    LinkedList list = new LinkedList(10);

    assertEquals(1, list.size());

    list.append(20);
    assertEquals(2, list.size());

    list.append(30);
    assertEquals(3, list.size());

    list.append(40);
    assertEquals(4, list.size());
  }

  @Test
  void shouldRemoveLastNode() {
    LinkedList list = new LinkedList(10);
    list.append(20);
    list.append(30);

    LinkedList.Node removedNode = list.removeLast();

    assertNotNull(removedNode);
    assertEquals(30, removedNode.value);

    assertEquals(2, list.size());
    assertEquals(20, list.getTail().value);
    assertNull(list.getTail().next);

    assertEquals(10, list.getHead().value);
    assertEquals(20, list.get(1).value);
  }

  @Test
  void shouldRemoveLastNodeFromSingleNodeList() {
    LinkedList list = new LinkedList(10);

    LinkedList.Node removedNode = list.removeLast();

    assertNotNull(removedNode);
    assertEquals(10, removedNode.value);

    assertEquals(0, list.size());
    assertNull(list.getHead());
    assertNull(list.getTail());
  }

  @Test
  void shouldPrependNodeToBeginning() {
    LinkedList list = new LinkedList(20);

    list.prepend(10);

    assertEquals(2, list.size());
    assertEquals(10, list.getHead().value);
    assertEquals(20, list.getTail().value);
    assertEquals(20, list.getHead().next.value);
  }

  @Test
  void shouldPrependMultipleNodes() {
    LinkedList list = new LinkedList(30);

    list.prepend(20);
    list.prepend(10);

    assertEquals(3, list.size());
    assertEquals(10, list.getHead().value);
    assertEquals(30, list.getTail().value);

    assertEquals(10, list.get(0).value);
    assertEquals(20, list.get(1).value);
    assertEquals(30, list.get(2).value);
  }

  @Test
  void shouldUpdateHeadAfterPrepend() {
    LinkedList list = new LinkedList(20);

    list.prepend(10);

    assertEquals(10, list.getHead().value);
    assertEquals(20, list.getHead().next.value);
  }

  @Test
  void shouldIncreaseSizeAfterEachPrepend() {
    LinkedList list = new LinkedList(30);

    assertEquals(1, list.size());

    list.prepend(20);
    assertEquals(2, list.size());

    list.prepend(10);
    assertEquals(3, list.size());

    list.prepend(5);
    assertEquals(4, list.size());
  }

  @Test
  void shouldRemoveFirstNode() {
    LinkedList list = new LinkedList(10);
    list.append(20);
    list.append(30);

    LinkedList.Node removedNode = list.removeFirst();

    assertNotNull(removedNode);
    assertEquals(10, removedNode.value);

    assertEquals(2, list.size());
    assertEquals(20, list.getHead().value);
    assertEquals(30, list.getTail().value);

    assertEquals(20, list.get(0).value);
    assertEquals(30, list.get(1).value);
  }

  @Test
  void shouldRemoveFirstNodeFromSingleNodeList() {
    LinkedList list = new LinkedList(10);

    LinkedList.Node removedNode = list.removeFirst();

    assertNotNull(removedNode);
    assertEquals(10, removedNode.value);

    assertEquals(0, list.size());
    assertNull(list.getHead());
    assertNull(list.getTail());
  }

  @Test
  void shouldUpdateHeadAfterRemoveFirst() {
    LinkedList list = new LinkedList(10);
    list.append(20);
    list.append(30);

    list.removeFirst();

    assertEquals(20, list.getHead().value);
    assertEquals(30, list.getTail().value);
    assertEquals(30, list.getHead().next.value);
  }

  @Test
  void shouldDecreaseSizeAfterEachRemoveFirst() {
    LinkedList list = new LinkedList(10);
    list.append(20);
    list.append(30);
    list.append(40);

    assertEquals(4, list.size());

    list.removeFirst();
    assertEquals(3, list.size());

    list.removeFirst();
    assertEquals(2, list.size());

    list.removeFirst();
    assertEquals(1, list.size());

    list.removeFirst();
    assertEquals(0, list.size());
    assertNull(list.getHead());
    assertNull(list.getTail());
  }

}
