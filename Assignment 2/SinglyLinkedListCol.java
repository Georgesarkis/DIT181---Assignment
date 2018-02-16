package Assignment2;

import java.util.Collection;

import Assignment2.SinglyLinkedList.Iterator;


class SinglyLinkedListCol<Item> implements Collection<Item> {
  private int size = 0;
  private Node<Item> first;
  

  private static class Node<Item> {
    public Node<Item> next;
    public Item el;

  }

  public static class Iterator<Item>{
	SinglyLinkedListCol list;
	Node<Item> current = list.first;
	boolean hasNext;
	public void  itorator(SinglyLinkedListCol<Item> c){
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
    SinglyLinkedListCol<Integer> l = new SinglyLinkedListCol<Integer>();

    System.out.println("the size of list now is "+l.size());
    
    l.insertAt(0, 1);
    l.insertAt(1, 2);
    l.insertAt(2, 3);
    
    System.out.println("The element at index 0 is"+l.get(0));
    System.out.println("The element at index 1 is"+l.get(1));
    System.out.println("The element at index 2 is"+l.get(2));
    
   l.reverse();
   
   System.out.println("The element at index 0 is"+l.get(0));
   System.out.println("The element at index 1 is"+l.get(1));
   System.out.println("The element at index 2 is"+l.get(2));
   
   System.out.println("the size of list now is "+l.size());
   
   l.remove(3);
  
   
   System.out.println("the size of list now is "+l.size());
   System.out.println(l.contains(3));
   
   
//  
//    l.push(10);
//    System.out.println("The element at index 0 is"+l.get(0));
//    System.out.println("the size of list now is "+l.size());
//    
//    
//    l.push(100);
//    l.pop();
//    
//    System.out.println("The element at index 0 is"+l.get(0));
//    System.out.println("the size of list now is "+l.size());
//    
//    l.push(4000);
//    System.out.println("The top of the stack is "+ l.top());
    
  
   
   
    
    
  
    
//  System.out.print(l.size());
// Iterator newIterator = new Iterator();
//  newIterator.itorator(l);
//  newIterator.remove();
    
  }


@Override
public boolean isEmpty() {
	// TODO Auto-generated method stub
	return false;
}


@Override
public boolean contains(Object o) {
	o = (Item) o;
	Node<Item> current = first;
	if(current==null)
		return false;
	while(current != null) {
		if(current.el==o)
			return true;
		current = current.next;
	}
	return false;
}


@Override
public java.util.Iterator<Item> iterator() {
	// TODO Auto-generated method stub
	return null;
}


@Override
public Object[] toArray() {
	// TODO Auto-generated method stub
	return null;
}


@Override
public <T> T[] toArray(T[] a) {
	// TODO Auto-generated method stub
	return null;
}


@Override
public boolean add(Item e) {
	Iterator<Item> newNode = new Iterator<>();
	newNode.insert(e);
	return true;
}


@Override
public boolean remove(Object o ) {
	o = (Item) o;
	Node current = first , prev =null;
	
	if(current != null && current.el== o) {
		first = current.next;
		size--;
		return true;
	}
	
	while( current!= null && current.el!= o) {
		prev = current;
		current = current.next;
	}
	
	if(current == null)
		return false;
	else {
		prev.next = current.next;
		size--;
		return true;
	}
		
	
}


@Override
public boolean containsAll(Collection<?> c) {
	// TODO Auto-generated method stub
	
	return false;
}


@Override
public boolean addAll(Collection<? extends Item> c) {
	// TODO Auto-generated method stub
	return false;
}


@Override
public boolean removeAll(Collection<?> c) {
	// TODO Auto-generated method stub
	return false;
}


@Override
public boolean retainAll(Collection<?> c) {
	// TODO Auto-generated method stub
	
	return false;
}


@Override
public void clear() {
	this.first = null;
}



}
