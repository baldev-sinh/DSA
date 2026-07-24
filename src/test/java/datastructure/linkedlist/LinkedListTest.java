package datastructure.linkedlist;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

  @Test
  void shouldReturnNodeAtGivenIndex() {
    LinkedList list = new LinkedList(10);
    list.append(20);
    list.append(30);
    list.append(40);

    LinkedList.Node node = list.get(2);

    assertNotNull(node);
    assertEquals(30, node.value);
  }

  @Test
  void shouldReturnHeadNodeWhenIndexIsZero() {
    LinkedList list = new LinkedList(10);
    list.append(20);
    list.append(30);

    LinkedList.Node node = list.get(0);

    assertNotNull(node);
    assertEquals(10, node.value);
  }

  @Test
  void shouldReturnTailNodeWhenIndexIsLast() {
    LinkedList list = new LinkedList(10);
    list.append(20);
    list.append(30);

    LinkedList.Node node = list.get(2);

    assertNotNull(node);
    assertEquals(30, node.value);
  }

  @Test
  void shouldReturnNullForNegativeIndex() {
    LinkedList list = new LinkedList(10);
    list.append(20);

    LinkedList.Node node = list.get(-1);

    assertNull(node);
  }

  @Test
  void shouldReturnNullWhenIndexEqualsSize() {
    LinkedList list = new LinkedList(10);
    list.append(20);
    list.append(30);

    LinkedList.Node node = list.get(list.size());

    assertNull(node);
  }

  @Test
  void shouldReturnNullWhenIndexGreaterThanSize() {
    LinkedList list = new LinkedList(10);
    list.append(20);
    list.append(30);

    LinkedList.Node node = list.get(10);

    assertNull(node);
  }

  @Test
  void shouldInsertNodeAtBeginning() {
    LinkedList list = new LinkedList(20);
    list.append(30);

    boolean inserted = list.insert(0, 10);

    assertTrue(inserted);
    assertEquals(3, list.size());
    assertEquals(10, list.getHead().value);
    assertEquals(10, list.get(0).value);
    assertEquals(20, list.get(1).value);
    assertEquals(30, list.get(2).value);
  }

  @Test
  void shouldInsertNodeInMiddle() {
    LinkedList list = new LinkedList(10);
    list.append(30);

    boolean inserted = list.insert(1, 20);

    assertTrue(inserted);
    assertEquals(3, list.size());
    assertEquals(10, list.get(0).value);
    assertEquals(20, list.get(1).value);
    assertEquals(30, list.get(2).value);
  }

  @Test
  void shouldInsertNodeAtEnd() {
    LinkedList list = new LinkedList(10);
    list.append(20);

    boolean inserted = list.insert(2, 30);

    assertTrue(inserted);
    assertEquals(3, list.size());
    assertEquals(30, list.getTail().value);
    assertEquals(10, list.get(0).value);
    assertEquals(20, list.get(1).value);
    assertEquals(30, list.get(2).value);
  }

  @Test
  void shouldReturnFalseForNegativeIndex() {
    LinkedList list = new LinkedList(10);
    list.append(20);

    boolean inserted = list.insert(-1, 5);

    assertFalse(inserted);
    assertEquals(2, list.size());
    assertEquals(10, list.get(0).value);
    assertEquals(20, list.get(1).value);
  }

  @Test
  void shouldReturnFalseWhenIndexGreaterThanSize() {
    LinkedList list = new LinkedList(10);
    list.append(20);

    boolean inserted = list.insert(3, 30);

    assertFalse(inserted);
    assertEquals(2, list.size());
    assertEquals(10, list.get(0).value);
    assertEquals(20, list.get(1).value);
  }

  @Test
  void shouldRemoveFirstNodeUsingIndex() {
    LinkedList list = new LinkedList(10);
    list.append(20);
    list.append(30);

    LinkedList.Node removedNode = list.remove(0);

    assertNotNull(removedNode);
    assertEquals(10, removedNode.value);

    assertEquals(2, list.size());
    assertEquals(20, list.getHead().value);
    assertEquals(30, list.getTail().value);
    assertEquals(20, list.get(0).value);
    assertEquals(30, list.get(1).value);
  }

  @Test
  void shouldRemoveMiddleNodeUsingIndex() {
    LinkedList list = new LinkedList(10);
    list.append(20);
    list.append(30);
    list.append(40);

    LinkedList.Node removedNode = list.remove(2);

    assertNotNull(removedNode);
    assertEquals(30, removedNode.value);

    assertEquals(3, list.size());
    assertEquals(10, list.get(0).value);
    assertEquals(20, list.get(1).value);
    assertEquals(40, list.get(2).value);
    assertEquals(40, list.getTail().value);
  }

  @Test
  void shouldRemoveLastNodeUsingIndex() {
    LinkedList list = new LinkedList(10);
    list.append(20);
    list.append(30);

    LinkedList.Node removedNode = list.remove(2);

    assertNotNull(removedNode);
    assertEquals(30, removedNode.value);

    assertEquals(2, list.size());
    assertEquals(20, list.getTail().value);
    assertNull(list.getTail().next);
  }

  @Test
  void shouldReturnNullWhenRemovingWithNegativeIndex() {
    LinkedList list = new LinkedList(10);
    list.append(20);

    LinkedList.Node removedNode = list.remove(-1);

    assertNull(removedNode);
    assertEquals(2, list.size());
  }

  @Test
  void shouldReturnNullWhenRemovingAtIndexEqualToSize() {
    LinkedList list = new LinkedList(10);
    list.append(20);

    LinkedList.Node removedNode = list.remove(list.size());

    assertNull(removedNode);
    assertEquals(2, list.size());
  }

  @Test
  void shouldReturnNullWhenRemovingAtIndexGreaterThanSize() {
    LinkedList list = new LinkedList(10);
    list.append(20);

    LinkedList.Node removedNode = list.remove(10);

    assertNull(removedNode);
    assertEquals(2, list.size());
  }



}
