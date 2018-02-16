package Assignment2;

public interface MyStack<Item> {
	public boolean isEmpty();
	public void makeEmpty();
	public void push(Item element);
	public void pop();
	public Item top();
	public Item topAndPop();
	

}
