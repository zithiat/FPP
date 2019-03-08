package prob1dec14;

public class DoublyLinkedList {

	Node header;

	DoublyLinkedList() {
		header = new Node();
	}

	// adds to the end of the list
	public void addLast(String item) {
		if (header == null) {
			header = new Node(item);
		} else {
			Node n;
			if (header.next == null) {
				n = new Node(item);
				header.next = n;
				n.previous = header;
			} else {
				n = header.next;
				while (n.next != null){
					n = n.next;
				}
				Node end = new Node(item);
				n.next = end;
				end.previous = n;
			}
		}
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		toString(sb, header);
		return sb.toString();
	}

	private void toString(StringBuilder sb, Node n) {
		if (n == null)
			return;
		if (n.value != null)
			sb.append(" " + n.value);
		toString(sb, n.next);
	}

	class Node {
		String value;
		Node next;
		Node previous;

		public Node() {
		}
		
		public Node(String value) {
			this.value = value;
		}
		
		public String toString() {
			return value == null ? "null" : value;
		}
	}

	public static void main(String[] args) {
		DoublyLinkedList list = new DoublyLinkedList();
		list.addLast("Bob");
		list.addLast("Harry");
		list.addLast("Steve");
		System.out.println(list);
	}
}
