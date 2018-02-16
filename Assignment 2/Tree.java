package assignment2;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Tree<Item extends Comparable<Item>> {
  // If the tree is empty, root is a null reference.
  protected Node<Item> root;

  // A node of a tree contains a label, and optionally
  // references to the roots of its left and right subtrees,
  // which might be null if the subtrees are empty.
  protected static class Node<Item> {
    public Node<Item> left;
    public Node<Item> right;
    public Item el;
  }

  public int size() {
	  return size1(root);
  }
  private int size1(Node node) {
	  int size = 0;
	  if(node == null) {
	  }
	  else {
		  size = size1(node.left) + 1 + size1(node.right);
	  }
	  return size;
  }

  // This method constructs the following
  // example tree with 5 in the root:
  //
  //      __5__
  //     /     \
  //    /       \
  //   1         8
  //    \       / \
  //     2     1   3
  //          / \
  //          5 7
  public static Tree<Integer> exampleTree() {
    Node<Integer> t = new Node<Integer> ();
    t.el = 5;
    Node<Integer> t1 = new Node<Integer> ();
    t.left = t1;
    t1.el = 1;
    Node<Integer> t2 = new Node<Integer> ();
    t.right = t2;
    t2.el = 8;
    Node<Integer> t12 = new Node<Integer> ();
    t1.right = t12;
    t12.el = 2;
    Node<Integer> t21 = new Node<Integer> ();
    t2.left = t21;
    t21.el = 1;
    Node<Integer> t22 = new Node<Integer> ();
    t2.right = t22;
    t22.el = 3;
    Node<Integer> t211 = new Node<Integer> ();
    t21.left = t211;
    t211.el = 5;
    Node<Integer> t212 = new Node<Integer> ();
    t21.right = t212;
    t212.el = 7;

    Tree<Integer> res = new Tree<Integer>();
    res.root = t;
    return res;
  }

  // Return the height of the tree
  public int height() {
	  return height(root);
  }
  private int height(Node node) {
	  int height = 0;
	  if(node == null) {
	  }
	  else {
		  int leftHeight = height(node.left);
		  int rightHeight = height(node.right);
		  if(leftHeight > rightHeight) {
			  height = leftHeight +1 ;
		  }
		  else {
			  height = rightHeight +1 ;
		  }
	  }
	  return height;
  }

  // Return the label of the leftmost node of a tree
  public Item leftMost() {
    throw new UnsupportedOperationException();
  }

  // Replace the tree with its mirror image
  public void mirror() {
	  mirror(root);
  }
  public void mirror(Node root){
	  if(root != null){
	  Node<Item> tmp = root.left;
	  root.left = root.right;
	  root.right = tmp;
	  }
	  mirror(root.right);
	  mirror(root.left);
  }

  // Print the nodes of the tree in depth-first order
  public void printDFS() {
	  if(root == null)
		  return;
	  Stack<Node> stack = new Stack<Node>();
	  stack.push(root);
	  
	  while(!stack.isEmpty()) {
		  Node node = stack.pop();
		  System.out.println(node.el + " ");
		  
		  if(node.right != null) {
			  stack.push(node.right);
		  }
		  if(node.left != null) {
			  stack.push(node.left);
		  }
	  }
    // Use Sytem.out.println() and el.toString() to print the elements
  }

  // Here is how to create a generic static method
  //private static <Item> int doSomething(Node<Item> n) {
  //}


  // Print the nodes of the tree in breadth-first order
 public void printBFS() {
  printBFS(root);
  }
  
  private void printBFS(Node<Item> root) {
    if(root.equals(null))
       return;
    
    ArrayDeque<Node> treeList = new ArrayDeque<>();
    treeList.add(root);
    
    while(! treeList.isEmpty()){
      Node<Item> node = treeList.peek();
      System.out.println(node.el);
      treeList.remove();
      if(node.left!= null)
        treeList.add(node.left);
      if(node.right!= null)
        treeList.add(node.right);
    }
    
  }

  // Print the nodes of the tree in breadth-first order
  public static  <Item extends Comparable<Item>> Tree<Item> BuildDFS(List list) {
	  Tree newTree = new Tree();
	  preOrder(list,newTree.root);
	  return newTree;
	 
  }
  public static Node preOrder(List list, Node node){
	  Node newNode = new Node();
	  Object el;
	  while(list.isEmpty() == false) {
		  el = list.get(0);
		  list.remove(0);
		  node = newNode;
		  node.el = el;
		  node.left = preOrder(list,node.left);
		  node.right = preOrder(list,node.right);
	  }
	  return node;
  }
//  private static void printDFS(Node root) {
//	    if(root == null) {
//	   
//	    }
//	    ArrayDeque<Node> treeList = new ArrayDeque<>();
//	    treeList.add(root);
//	    
//	    while(! treeList.isEmpty()){
//	      Node node = treeList.peek();
//	      System.out.println(node.el);
//	      treeList.remove();
//	      if(node.left!= null)
//	        treeList.add(node.left);
//	      if(node.right!= null)
//	        treeList.add(node.right);
//	    }
//	    
//	  }
  
  
  // Return the n-th element in DFS order.
  // Throw an exception if index out of range.
  public Item nthDFS(int n) {
	  Stack stack = new Stack();
	  Node current = root;
	  stack.add(root);
	  int count = 0;
	  while(stack.isEmpty() == false && count != n) {
		  current = (Node) stack.pop();
		  count++;
		  if(current.right != null) {
			  stack.push(current.right);
		  }
		  else if(current.left != null) {
			  stack.push(current.left);
		  }
		 
	  }
	  if(count == n) {
		  return (Item) current.el;
	  }
     throw new UnsupportedOperationException();
  }

  
  
  // Check if the tree is a binary search tree
  public boolean isBST() {
    throw new UnsupportedOperationException();
  }

  // Check if item i exists in the binary search tree
  public boolean findBST(Item i) {
    throw new UnsupportedOperationException();
  }
  
  // Remove i from a binary search tree
  public void removeBST(Item i) {
	  remove(i,root);
  }
  
  private Node remove(Item x, Node node) {
	  if(node == null) {
		  throw new UnsupportedOperationException();
	  }
	  else if(x < node.el) {
		  remove(x,node.left);
	  }
	  else if(x > node.el) {
		  remove(x,node.right);
	  }
	  else {
		  if(node.left == null) {
			  return node.right;
		  }else if(node.right == null) {
			  return node.left;
		  }else {
			  Node min = new Node();
			  min = node.right;
			  while(min.left != null) {
				  min = min.left;
			  }
			  node.el = min.el;
			  min = null;
		  }
	  }
  }

  

  // Insert i into a binary search tree
public void insertBST(Item i) {
    root = insertBST(root, i);
  }
  private Node<Item> insertBST (Node<Item> root, Item key){
    if(root == null) {
      root = new Node<>();
      root.el = key;
      return root;
    }
    if(root.el.compareTo(key) > 0)
      root.left = insertBST(root.left, key);
    else if(root.el.compareTo(key) < 0)
      root.right  = insertBST(root.right, key);
    
    return root;
  }


  
  
  public static void main(String[] args) {
    Tree<Integer> t = exampleTree();

    System.out.println(t.size());
    List newlist = new ArrayList();
    newlist.add(1);
    newlist.add(2);
    newlist.add(4);
    newlist.add(5);
    newlist.add(3);
    System.out.println(newlist);
    Tree newTree = BuildDFS(newlist);
    System.out.println(newTree.root.el);
    
  }

}
