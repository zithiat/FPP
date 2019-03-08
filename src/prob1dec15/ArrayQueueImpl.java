package prob1dec15;

import java.util.Arrays;

public class ArrayQueueImpl {

	private int[] arr = new int[1];
	private int front = -1;
	private int rear = 0;

	public int peek() {
		int value = -1;
		try {
			if (isEmpty()) {
				throw new QueueException("Queue empty");
			}
			value = arr[front + 1];
		} catch (QueueException e) {
			System.out.println(e.getMessage());
		}
		return value;
	}
	
	/**
	 * Add the element to the position pointed to by the variable rear
	 * @param obj
	 */
	public void enqueue(int obj) {
		if (rear == arr.length - 1) {
			resize();
		}
		arr[rear] = obj;
		rear++;
	}

	/**
	 *  Remove the element in the position pointed to by the variable front
	 * @return
	 */
	public int dequeue() {
		int value = -1;
		try {
			if (isEmpty()) 
				throw new QueueException("Queue empty");
			else {
				if (front == rear) {
					throw new QueueException("Queue empty");
				}
				front++;
				value = arr[front];
			}
		} catch(QueueException e) {
			System.out.println(e.getMessage());
		}
		return value;
	}

	public boolean isEmpty() {
		if (rear == 0) {
			return true;
		}
		return false;
	}

	public int size() {
		if (front == -1)
			return rear;
		else 
			return rear - front - 1;
	}
	
	private void resize() {
		this.arr = Arrays.copyOf(arr, arr.length + 1);
	}
	
	public void display() {
		System.out.println("Front:" + front + "<>Rear:" + rear);
		for (int i = front + 1; i < rear; i++) {
			System.out.print(arr[i] + " ");
		}
	}
}
