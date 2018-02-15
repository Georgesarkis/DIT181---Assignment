package assignment2;

class SinglyLinkedList<Item> {
  private int size = 0;
  private Node<Item> first;
  

  private static class Node<Item> {
    public Node<Item> next;
    public Item el;

  }

  public static class Iterator<Item>{
	SinglyLinkedList list;
	Node<Item> current = list.first;
	boolean hasNext;
	public void  itorator(SinglyLinkedList<Item> c){
		  list = c; 
	  }
	public Item next() {
    	if(current.next == null) {
    		hasNext = false;
    		return null;
    	}
    	else {
	    	current = current.next;
	    	return current.el;
    	}
    	
    }
    public boolean hasNext() {
    	return current !=null && current.next != null;
    }
    public void insert(Item e) {
    	Node<Item> newNode = new Node<Item>();
    	newNode.el = e;
    	if(current == null) {
    		list.first = newNode;
    		current = newNode;
    	}
    	else if(hasNext) {
			newNode.next = current.next;
			current.next = newNode;
    	}
    	else {
    		current.next = newNode;
    		newNode.next = null;
    	}
    	list.size++;
    }
    
    public void remove() {
    	if(current == list.first) {
    		list.first = current.next;
    	}
    	else {
	    	Node toRemove = list.first;
	    	while(toRemove.next != current) {
	    		toRemove = toRemove.next;
	    	}
	    	toRemove.next = current.next;
    	}
    }
  }
  
  public SinglyLinkedList() {
  }

  public int size() {
    return size;
  }


  public Item get(int n) {

    if (n >= size || n < 0){
        throw new IndexOutOfBoundsException("Index ouf of bounds");
      }
      
      Node<Item> current = first;
      
      for(int i = 0; i< n; i++)
        current = current.next;
    
  
  return current.el;
  
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
	  }
	  else if(n == size) {
		 while(current.next != null) {
		 current = current.next;
		 }
		 current.next = new_node;
		 new_node.next = null;
	  }
		 
	  else {
		  int position = 0;
		  while(current.next != null && position != n) {
			  current = current.next;
			  position++;
		  }
		  new_node.next = current.next;
		  current.next = new_node;  
	  }
	  size++;
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
//    l.insertAt(0, 1);
//    l.insertAt(1, 2);
//    l.insertAt(2, 3);
//    System.out.println(l.first.el);
//    System.out.println(l.first.next.el);
//    System.out.println(l.first.next.next.el);
//    System.out.print(l.size());
//    Iterator newIterator = new Iterator();
//    newIterator.itorator(l);
//    newIterator.remove();
  }
}
