package assignment2;

import java.util.List;
import java.util.LinkedList;

class ModError {
  public static void main(String[] args) {
    List<Integer> numbers = new LinkedList<Integer>();
    for(int i = 0; i < 100; ++i) numbers.add(i);
    
    for (int i = 0 ; i < numbers.size() ; i++) {
        if (numbers.get(i) % 10 == 0) 
        	numbers.remove(i);
      }
  }
}
