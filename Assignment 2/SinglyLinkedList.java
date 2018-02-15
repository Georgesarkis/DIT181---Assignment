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
	Node<Item> current;
	Node<Item> prev;
	Node<Item> prevprev;
	boolean hasNext;
	public void itorator(SinglyLinkedList<Item> c){
		  list = c; 
		  current = c.first;
		  prev = null;
		  prevprev = null;
	  }
	public Item next() {
    	if(current.next == null) {
    		hasNext = false;
    		prev = current;
    		current = current.next;
    		return prev.el;
    	}
    	else {
    		prevprev = prev;
    		prev = current;
	    	current = current.next;
	    	return prev.el;
    	}
    	
    }
    public boolean hasNext() {
    	return current !=null && current.next != null;
    }
    public void insert(Item e) {
    	Node<Item> newNode = new Node<Item>();
    	newNode.el = e;
    	if(current == null && prev== null) {
    		list.first = newNode;
    		current = newNode;
    	}
    	else if(prev == null) {
			newNode.next = list.first;
			list.first = newNode;
    	}
    	else {
    		prev.next = newNode;
    		newNode.next = current;
    	}
    	list.size++;
    }
    
    public void remove() {
    	if(current == list.first ) {
    		list.first = list.first.next;
    		current = list.first;
    	}
    	else if(prevprev == null) {
    		list.first = list.first.next;
    		prev.next = null;
    	}
    	else if(current == null) {
    		prevprev.next = null;
    	}
    	else if(current.next == null) {
    		prevprev.next = current;
    		prev.next = null;
    	}
    	else {
    		prevprev.next = current;
    		current.next = null;
    	}
    	list.size--;
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
   first = reverse(first);
  }
   private Node<Item> reverse (Node<Item> node){
	  Node<Item> prev = null;
	  Node<Item> current = node;
	  Node<Item> next = null;
	  while (current != null) {
          next = current.next;
          current.next = prev;
          prev = current;
          current = next;
      }
      node = prev;
      return node;
	
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
    l.insertAt(0, 1);
    l.insertAt(1, 2);
    Iterator iterator = new Iterator();
    iterator.itorator(l);
    System.out.println(iterator.hasNext());
    System.out.println(iterator.next());
    System.out.println(iterator.next());
    iterator.insert(1);
    System.out.println(iterator.hasNext());
    System.out.println(iterator.next());
    
//    System.out.println(l.first.el);
//    System.out.println(l.first.next.el);
//    System.out.println(l.first.next.next.el);
//    System.out.print(l.size());
//    Iterator newIterator = new Iterator();
//    newIterator.itorator(l);
//    newIterator.remove();
  }
}
