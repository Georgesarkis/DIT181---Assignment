package assignment3;

import java.util.Random;

class HashTable {
  // The hash table implements a set of integers.
  // Empty buckets are null, occupied ones
  // store the relevant integer
  protected Integer[] arr;
  protected int size = 0; // Number of (occupied) elements

  public HashTable(int capacity) {
    arr = new Integer[capacity];
  }

  public double loadFactor() {
    return ((double) size) / arr.length;
  }


  public int size() {
    return size;
  }

  // Insert an integer into the hash table
  public void insert(int x) {
	  int position = getPosition(x);
	  while(arr[position] != null) {
		  position++;
		  if(position > arr.length) {
			  position = position - arr.length;
		  }
	  }
	  arr[position] = x;
	  size++;
  }

  // Insert an integer into the hash table, returning
  // the cost of insertion.
  public int insertCost(int x) {
	  int position = getPosition(x);
	  int insertCost = 0;
	  while(arr[position] != null) {
		  position++;
		  if(position > arr.length) {
			  position = position - arr.length;
		  }
		  insertCost++;
	  }
	  arr[position] = x;
	  size++;
//	  System.out.println(insertCost);
	  return insertCost;
  }
  
  public int getPosition(int num) {
//      int sum = 0;
//      while (num > 0) {
//          sum = sum + num % 10;
//          num = num / 10;
//          }
////      System.out.println( sum % for09);
      return num % arr.length;
  }
 
  public static void main(String[] args) {
	  int min = 0;
	  int max = 0;
	  double sumInsertCost = 0;
	  double NUMBER_OF_ELEMENTS = 10000;
	  int insertCost;
	  int for01 = 100003;int for02 = 50021;int for03 = 33343;int for04 = 25013;int for05 = 20011;int for06 = 16673;int for07 = 14293;int for08 = 12503;int for09 = 11113;
	  HashTable hash = new HashTable(for09);
	  for(int i = 0; i < NUMBER_OF_ELEMENTS; i++) {
		  Random rand = new Random();
		  int num = Math.abs(rand.nextInt());
//		  System.out.print("number: " + num + " , insertCost: ");
		  insertCost = hash.insertCost(num);
		  sumInsertCost = sumInsertCost + insertCost;
		  if(insertCost < min) {
			  min = insertCost;
		  }
		  if(insertCost > max) {
			  max = insertCost;
		  }

	  }
	  System.out.println("minimum is = " + min);
	  System.out.println("maximum is = " + max);
	  System.out.println("aveage is = " + sumInsertCost / NUMBER_OF_ELEMENTS);
	  System.out.println(hash.size);
	  System.out.println(hash.loadFactor());
  }

}
