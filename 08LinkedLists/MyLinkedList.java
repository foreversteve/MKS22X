
public class MyLinkedList {

	Node first;
	Node last;
	int size;

	public MyLinkedList() {
		size = 0;
	}

	public boolean add(Integer value) {

		if (size == 0) {
			Node a = new Node(null,null,value);
			first = a;
			last = a;
			size=1;
		}
		else {
			Node a = new Node(null,last,value);
			last.setNext(a);
			last = a;
			size+=1;
		}
		return true;
	}

	public void add(int index, Integer value) {

		if (index > size || index < 0) {
			throw new IndexOutOfBoundsException();
		}

		if (index == size ) {
			add(value);
			return;
		}

		Node temp = getNode(index);
		Node temp2 = temp.getPrev();

		Node a = new Node(temp,temp2,value);

		if (temp2 != null) {
			temp2.setNext(a);
		}

		temp.setPrev(a);

		if (index == 0) {
			first = a;
		}

		size+=1;

	}

	private Node getNode(int index) {
		int c = 0;
		Node temp = first;

		while (c < size) {
			if (c == index) {
				return temp;
			}
			c+=1;
			temp=temp.getNext();
		}
		return temp;
	}

	public boolean remove(Integer value) {

		int c = 0;
		Node temp = first;

		while (temp != null) {

			if (temp.getValue() == value) {

				if (c == 0) {
					first = first.getNext();
					first.setPrev(null);
					size-=1;
				}

				else if (c == size-1) {
					last = last.getPrev();
					last.setNext(null);
					size-=1;
				}
				else {
					remove(c);
				}
				return true;
			}
			c+=1;
			temp = temp.getNext();
		}
		return false;
	}

	public Integer remove(int index) {

		if (index >= size || index < 0) {
			throw new IndexOutOfBoundsException();
		}

		Node temp = getNode(index);
		Node temp2 = temp.getPrev();
		Node temp3 = temp.getNext();

		int original = temp.getValue();

		if (temp2 != null) {
			temp2.setNext(temp3);
		}

		if (temp3 != null) {
			temp3.setPrev(temp2);
		}

		if (index == 0) {
			first = temp3;
		}

		if (index == size - 1 ) {
			last = temp2;
		}
		size-=1;
		return original;
	}

	public int indexOf(Integer value) {

		int c = 0;
		Node temp = first;

		while (temp != null) {
			if (temp.getValue() == value) {
				return c;
			}

			temp = temp.getNext();
			c+=1;
		}

		return -1;
	}

	public void clear() {
		Node temp = first;
		while (temp != null) {
			temp.setValue(0);
			temp = temp.getNext();
		}
		size = 0;
	}

	public String toString() {

		String ans = "[";
		Node temp = first;

		while (temp != null) {

			Node a = temp.getNext();

			if (a != null) {
				ans += temp.getValue() + ", ";
			}

			else {
				ans += temp.getValue();
			}

			temp = a;
		}

		return ans + "]";
	}

	public Integer get(int index) {

		if (index >= size || index < 0) {
			throw new IndexOutOfBoundsException();
		}

		return getNode(index).getValue();
	}

	public Integer set(int index,int newValue) {

		if (index >= size || index < 0) {
			throw new IndexOutOfBoundsException();
		}

		Node ntemp = getNode(index);

		int temp = ntemp.getValue();


		ntemp.setValue(newValue);
		return temp;
	}

	public int size() {
		return size;
	}


	// Node Class

	private class Node{
		Node next,prev;
		int data;

		public Node(Node c,Node a, int b) {
			next = c;
			prev = a;
			data = b;
		}


		private void setNext(Node input) {

			next=input;
			if (next != null) {
				if (next.getPrev() != this) {
					next.setPrev(this);
				}
			}

		}

		private void setPrev(Node input) {
			prev = input;
			if (prev != null) {
				if (prev.getNext() != this) {
					prev.setNext(this);
				}
			}
		}


		private void setValue(int input) {
			data=input;
		}

		public String toString() {
			return Integer.toString(data);
		}

		private Node getNext() {
			return next;
		}

		private Node getPrev() {
			return prev;
		}

		private int getValue() {
			return data;
		}
	}

	public static void main(String[] args) {

		int[] test = {0,6,2,9,2,0,0,1};
		MyLinkedList a = new MyLinkedList();

		for (int x : test) {
			a.add(x);
		}

		System.out.println(a.toString());

		Integer val = new Integer(0);

		//Remove Tests
		/*
		a.remove(a.size-1);
		System.out.println(a);
		System.out.println(a.first);
		System.out.println(a.last);
		a.remove(a.size-1);
		System.out.println(a);
		System.out.println(a.first);
		System.out.println(a.last);
		a.remove(0);
		System.out.println(a);
		System.out.println(a.first);
		System.out.println(a.last);
		*/

		/* Add Tests
		a.add(0,2);
		System.out.println(a.toString());
		a.add(a.size-1,2);
		System.out.println(a.toString());
		a.add(0,99);
		System.out.println(a.toString());
		*/

		/* IndexOf
		System.out.println(a.indexOf(1));
		*/

		/* Set
		System.out.println(a.set(7, 99));
		System.out.println(a.toString());
		*/

		/*
		a.clear();
		System.out.println(a.toString());
		*/

	}
}
