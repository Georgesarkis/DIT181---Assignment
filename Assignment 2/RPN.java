package assignment2;

import java.util.Stack;
import java.util.Scanner;

class RPN {
  private Stack<Integer> operands = new Stack<Integer>();

  public RPN() {
  }


  public void loop() {
    Scanner in = new Scanner(System.in);

    final String prompt = "> ";
    System.out.print(prompt);

    while(in.hasNext()){
      if(in.hasNextInt() ) {
        int x = in.nextInt();
        System.out.println("Got an integer: " + x);
        operands.push(x);
      } else {
        String s=in.next();
        if(s.equals("quit")) {
          System.out.println("Quitting");
          break;
        }
        System.out.println("Got a string: " + s);
        if(s.equals("+")) {
        	operands.push(operands.pop() + operands.pop());
        	System.out.println(operands.pop());
        }
        if(s.equals("-")) {
        	operands.push(operands.pop() - operands.pop());
        	System.out.println(operands.pop());
        }
        if(s.equals("/")) {
        	operands.push(operands.pop() / operands.pop());
        	System.out.println(operands.pop());
        }
        if(s.equals("*")) {
        	operands.push(operands.pop() * operands.pop());
        	System.out.println(operands.pop());
        }
      }
      System.out.print(prompt);
    }

  }

  public static void main (String[] args) {
    RPN calc = new RPN();
    calc.loop();
  }
}
