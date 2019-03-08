package prob1dec15;

public class Main {

	public static void main(String[] args) {
		ArrayQueueImpl q = new ArrayQueueImpl();
		System.out.println("Peek an empty Queue");
		q.peek();
		System.out.println();
		for(int i = 0; i < 6; i ++)
			q.enqueue(i);
		System.out.println("The QUEUE");
		q.display();
		System.out.println("\nSize:" + q.size());
		System.out.println();
		System.out.println("Dequeue from 0 to 4 (less than 4)");
		for(int i = 0; i < 4; i ++)
			q.dequeue();
		System.out.println();
		System.out.println("The QUEUE");
		q.display();
		System.out.println();
		System.out.println("Peek:" + q.peek());
		System.out.println("Size:" + q.size());
		
	}

}
