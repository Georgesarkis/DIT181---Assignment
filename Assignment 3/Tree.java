package assignment3;


class Tree<Item extends Comparable<Item>> {
  // If the tree is empty, root is a null reference.
  protected Node<Item> root;

  // A node of a tree contains a label, and optionally
  // references to the roots of its left and right subtrees,
  // which might be null if the subtrees are empty.
  protected static class Node<Item> {
    public Node<Item> left;
    public Node<Item> right;
    public int el;
  }

  // This method constructs the following
  // example tree with 5 in the root:
  //
  //      __4__
  //     /     \
  //    /       \
  //   1         8
  //    \       / \
  //     2     6   9
  //          / \
  //          5 7
  public static Tree<Integer> exampleTree() {
    Node<Integer> t = new Node<Integer> ();
    t.el = 4;
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
    t21.el = 6;
    Node<Integer> t22 = new Node<Integer> ();
    t2.right = t22;
    t22.el = 9;
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

  // You may reuse your implementations from Assignment 2
  // Return the size of the tree
  public int size() {
    return size(root);
  }
  public int size(Node node) {
	  if(node == null) {
		  return 0;
	  }
	  int left = size(node.left);
	  int right = size(node.right);
	  return left+right+1;
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

  // Check if the tree is a binary search tree
  public boolean isBST() {
	  return isBST(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
  }
  public boolean isBST(Node node,int min  , int max) {
	  if(node == null) {
		  return true;
	  }
	  if(node.el < min) {
		  return false;
	  }
	  if(node.el > max) {
		  return false;
	  }
	  return (isBST(node.left,min,node.el-1) && isBST(node.right,node.el-1,max));
  }

  // Check if item i exists in the binary search tree
  public boolean findBST(int i) {
	  if(findBST(i,root) == null) {
		 return false;
	  }
    return true;
  }
  private Node findBST(int i , Node node) {
	  if(node == null) {
		  return null;
	  }
	  else if(i < node.el) {
		  return (findBST(i,node.left));
	  }
	  else if(i > node.el) {
		  return findBST(i,node.right);
	  }
	  else {
		 return node;
	  }
  }


  // Check if the tree is an AVL binary search tree
  public boolean isAVL() {
	  if(isBST(root,Integer.MIN_VALUE,Integer.MAX_VALUE) == false) {
		  return false;
	  }
	return isAVL(root);
  }
  public boolean isAVL(Node node) {
	  if(node == null) {
		  return true;
	  }
	  int left = height(node.left);
	  int right = height(node.right);
	  if((Math.abs(left-right)==1 || Math.abs(left-right) == 0) && isAVL(node.left) == true && isAVL(node.right) == true) {
		  return true;
	  }
	  return false;
  }

  // Remove i from an AVL binary search tree
  public void removeAVL(int i) {
	  if(findBST(i) == true) {
		  removeAVL(root,i);
	  }
	  else {
		  throw new UnsupportedOperationException();
	  }
  }

  public void removeAVL(Node root, int i) {
	Node newNode = remove(i,root);
	if(isAVL(newNode) == false) {
		ballanceTree(newNode);
	}
  }
  
  private Node remove(int i, Node<Item> node) {
	  if(node == null) {
		  throw new UnsupportedOperationException();
	  }
	  else if(node.el < i) {
		  remove(i,node.right);
	  }
	  else if(node.el > i) {
		  remove(i,node.left);
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
	return node;
  }
  private Node ballanceTree(Node node) {
		if(height(node.left) < height(node.right)) {
			node = leftRotation(node);
		}
		else if(height(node.left) > height(node.right)) {
			node = rightRotation(node);	
		}
		return node;
  }
  private Node rightRotation(Node node){
//		y 						x
//	   / \					   / \
//	  x   T3 		====>	  T1  y
//	 / \						 / \
//  T1  T2						T2  T3
	  Node y = node;				
	  Node x = y.left;					
	  Node T2 = y.left.right;				
	  x.left = y;
	  y.left = T2;
	  return x;
  }
  private Node leftRotation(Node node) {
//		y 						x
//	   / \					   / \
//	  x   T3 		<====	  T1  y
//	 / \						 / \
// T1  T2						T2  T3
	  Node x = node;				
	  Node y = x.right;	
	  Node T2 = x.right.left;	
	  y.left = x;
	  x.right = T2;
	  return y;
  }

  
 // Insert i into an AVL binary search tree
  public void insertAVL(int i) {
	  root = insertAVL(root,i);
  }
  private Node insertAVL(Node node , int i) {
	  if(node == null) {
		  Node newNode = new Node();
		  newNode.el = i;
		  node = newNode;
		  return node;
	  }
	  else if(i < node.el) {
		  node.left = insertAVL(node.left,i);
	  }
	  else if(i > node.el){
		  node.right = insertAVL(node.right, i);
	  }
	  int balance = height(node.left) - height(node.right);
	  if(balance > 1 && i < node.left.el) {			//left left case
		  return rightRotation(node);
	  }
	  else if(balance < -1 && i > node.right.el) {	//right right case
		  return leftRotation(node);
	  }
	  else if(balance > 1 && i > node.left.el) {	//left right case
		  node.left = leftRotation(node.left);
		  return rightRotation(node);
	  }
	  else if(balance < -1 && i < node.right.el) {	//right left case
		  node.right = rightRotation(node.right);
		  return leftRotation(node);
	  }
	  
	  return node;
  }

  public static void main(String[] args) {
    Tree<Integer> t = exampleTree();
    System.out.println(t.isAVL());
//    t.removeAVL(5);
//    System.out.println(t.isAVL());
//    t.removeAVL(2);
//    System.out.println(t.isAVL());
//    t.insertAVL(10);
//    System.out.println(t.isAVL());
//    t.insertAVL(11);
//    System.out.println(t.isAVL());
//    t.insertAVL(12);
//    System.out.println(t.isAVL());
//    t.insertAVL(13);
//    System.out.println(t.isAVL());
//    t.insertAVL(50);
//    System.out.println(t.isAVL());
//    
//    System.out.println(t.isAVL());
//    t.insertAVL(55);
//    System.out.println(t.isAVL());
  }

}
