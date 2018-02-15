import java.util.Stack;
import java.util.Scanner;

class RPN {
  private Stack<Integer> operands = new Stack<Integer>();

  public RPN() {
	  
//	  operands.push(operands.pop() + operands.pop());
//	  operands.push(operands.pop() * operands.pop());
//	  operands.push(operands.pop() - operands.pop());
//	  operands.push(operands.pop() / operands.pop());
  }


  public void loop() {
    Scanner in = new Scanner(System.in);

    final String prompt = "> ";
    System.out.print(prompt);

    while(in.hasNext()){
      if(in.hasNextInt()) {
        int x = in.nextInt();
        System.out.println("Got an integer: " + x);
      } else {
        String s=in.next();
        if(s.equals("quit")) {
          System.out.println("Quitting");
          break;
        }
        System.out.println("Got a string: " + s);
        if(s.equals("+")) {
        	operands.push(operands.pop() + operands.pop());
        }
        else if(s.equals("-")) {
        	operands.push(operands.pop() - operands.pop());
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
