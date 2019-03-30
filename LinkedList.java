
public class LinkedList<T> implements List<T> {
	
	class Node {

		public Node() {
			data = null;
			next = null;
		}
		
		public Node(T d) {
			data = d;
			next = null;
		}
		public T data;
		public Node next;
	}
	
	private Node head;
	private int sz;
	
	public LinkedList() {
		head = new Node();
		sz = 0;
	}

	@Override
	public void add(T item) {
		Node newNode = new Node(item);
		Node ptr = head;
		while (ptr.next != null) {
			ptr = ptr.next;
		}
		ptr.next = newNode;
		sz++;
	}

	@Override
	public void add(int pos, T item) {
		int i = 0;
		Node newNode = new Node(item);
		Node ptr = head;
		while (ptr.next != null && i < pos) {
			ptr = ptr.next;
			i++;
		}
		if (pos == i) {
			newNode.next = ptr.next;
			ptr.next = newNode;
			sz++;
		}
	}

	@Override
	public T get(int pos) {
		int i = 0;
		Node ptr = head.next;
		while (ptr.next != null && i < pos) {
			ptr = ptr.next;
			i++;
		}
		if (pos == i) {
			return ptr.data;
		}
		return null;
	}

	@Override
	public T remove(int pos) {
		T d = get(pos);
		if (d != null) {
			int i = 0;
			Node ptr = head;
			while (ptr.next != null && i < pos) {
				ptr = ptr.next;
				i++;
			}
			ptr.next = ptr.next.next;
			sz--;
		}
		return d;
	}

	@Override
	public int size() {
		return sz;
	}

}
