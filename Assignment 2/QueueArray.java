package assignment2;



class QueueArray<Item> {
  private final int initial_size = 4;
  private int size = 0;
  private Item[] arr;
  private int front;
  private int back = -1;


  // We need this pragma to avoid warnings triggerred by
  // the unsafe cast to Item[].
  @SuppressWarnings("unchecked")
  public QueueArray() {
    arr = (Item [])new Object[initial_size];
  }

  public int size() {
    return this.size;

  }
/*
insert a new item to the queue, if the queue is full then we double the size.
*/
  public void enqueue(Item x) {
    if(size == arr.length)
      resize(arr.length * 2);
    back = increment (back);
    arr[back] = x;
    size++;
  }
/*
This method deques the first element in the queue, and checks the size of the queue, if it is smaller than 25 of the array size,
it divides it to smaller size in order to save space. 
*/
  public void dequeue() {
    if (isEmpty()){
      throw new IllegalArgumentException("Queue size must be non-negative");
    }
    if(size < arr.length/4){
      resize(arr.length/2);
    }
    size--;
    front = increment(front);
    
  }
/*
Retruns the first element in the queue. 
*/
  public Item getFront() {
    if (isEmpty())
      throw new IllegalArgumentException("Queue size must be non-negative");
    return arr[front];
  }

  public boolean isEmpty (){
    return size == 0;
  }
/*
This method wraparound the front or back when either of them reaches the end of the array, or moves them 1 step forward. 
*/
  private int increment (int x){
    if(++x == arr.length)
      x = 0;
    return x; 
  }

  private void resize (int capacity){
    Item [] newArray;
    newArray = (Item []) new Object [capacity];

    // copy elements that are in the queue, starting from the font. 
    for(int i = 0; i < size ; front = increment(front)){
      newArray[i] = arr[front];
    } 

    arr = newArray ;
    front = 0;
    back = size -1;

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
    QueueArray<Integer> q = new QueueArray<Integer>();
    q.enqueue(4);
    q.enqueue(5);
    System.out.println(q.getFront());
    q.dequeue();
    q.enqueue(2);
    System.out.println(q.getFront());
    q.dequeue();
    System.out.println(q.getFront());
    q.enqueue(9);
    q.enqueue(10);
    q.dequeue();
    System.out.println(q.getFront());
  }
}
