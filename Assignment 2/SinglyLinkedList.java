package assignment2;

class SinglyLinkedList<Item> {
  private int size = 0;
  private Node<Item> first;

  private static class Node<Item> {
    public Node<Item> next;
    public Item el;
  }

  public static class Iterator<Item>{
	public Item next(Node<Item> current) {
    	return current.next.el;
    }
    public boolean hasNext(Node<Item> current) {
    	if(current.next != null) {
    		return true;
    	}
    	return false;
    }
    public Node<Item> insert(Item e,Node<Item> first) {
    	Node<Item> new_node = new Node<Item>();
    	Node<Item> current = new Node<Item>();
    	current = first;
    	new_node.el = e;
    	new_node.next = null;
    	while(current.next != null) {
    		current = current.next;
    	}
    	current.next = new_node;
    	return first;
    }
    public Node<Item> remove(Node<Item> first) {
    	Node<Item> current = new Node<Item>();
    	current = first;
    	while(current.next.next !=null) {
    		current = current.next;
    	}
    	current.next = null;
    	return first;
    }
  }
  
  public SinglyLinkedList() {
  }

  public int size() {
    return size;
  }

  public Item get(int n) {
  //  if (...)
  //    throw new IllegalArgumentException("Index ouf of bounds");
    throw new UnsupportedOperationException();
  }

  // Insert element x at index n in the list
  public void insertAt(int n, Item x) {
	  Node<Item> current = first;
	  Node<Item> new_node = new Node<Item>();
	  new_node.el = x;
	  if(n < 0 || n > size) {
		throw new IllegalArgumentException("Index ouf of bounds");
	  }
	  else if(n == 0) {
		  new_node.next = first;
		  first = new_node;
		  size++;
	  }
	  else if(n == size) {
		 for(int i = 0; i <= n; i++) {
			 current = current.next;
		 }
		 current.next = new_node;
		 new_node.next = null;
		 size++;
	  }
	  else {
		  for(int i = 0 ; i < n ; i++) {
			  current = current.next;
		  }
		  new_node.next = current.next;
		  current.next = new_node;
		  size++;
	  }
  }   

  // Remove the element at index n from the list
  public void removeAt(int n) {
  //  if (...)
  //    throw new IllegalArgumentException("Index ouf of bounds");
    throw new UnsupportedOperationException();
  }

  // Reverse the list
  public void reverse() {
  //  if (...)
  //    throw new IllegalArgumentException("Queue size must be non-negative");
    throw new UnsupportedOperationException();
  }

  public Iterator<Item> first() {
    throw new UnsupportedOperationException();
  }

  // Represent the contents of the list as a String
  /*
  public String toString() {
    StringBuilder res = new StringBuilder("{");
    if (size > 0) {
      res.append(firstEl.toString());
      for (int i = 1; i < size; ++i) {
        res.append(", ");
        res.append(el.toString());
      }
    }
    res.append("}");
    return res.toString();
  }*/


  public static void main (String[] args) {
    SinglyLinkedList<Integer> l = new SinglyLinkedList<Integer>();
    System.out.println(l.size());
  }
}
