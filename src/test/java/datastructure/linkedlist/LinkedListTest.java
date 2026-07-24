package datastructure.linkedlist;

import static org.junit.jupiter.api.Assertions.assertEquals;
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

}
