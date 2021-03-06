
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyLinkedListImproved<T extends Comparable<T>> implements Iterable<T> {

	Node first;
	Node last;
	int size;

	public MyLinkedListImproved() {
		size = 0;
	}

	public boolean add(T value) {

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

	public void add(int index, T value) {

		if (index > size  || index < 0) {
			throw new ArrayIndexOutOfBoundsException();
		}

		if (index == size) {
			add(value);
			return;
		}

		else if (index == 0) {
			Node temp = first;
		    first = new Node(null, temp, value);
		    first.setNext(temp);
		    size+=1;
		}
		else {
		Node temp = getNode(index);
		Node temp2 = temp.getPrev();

		Node a = new Node(temp,temp2,value);

		if (temp2 != null) {
			temp2.setNext(a);
		}

		temp.setPrev(a);

		size+=1;
		}
	}

	public Node getNode(int index) {
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

	public boolean remove(T value) {

		int c = 0;
		Node temp = first;

		while (temp != null) {

			if (temp.getValue() == value) {

				if (c == 0) {
					first = first.getNext();
				}

				if (c == size-1) {
					last = last.getPrev();
				}

				remove(c);
				return true;
			}
			c+=1;
			temp = temp.getNext();
		}
		return false;
	}

	public T remove(int index) {

		if (index >= size || index < 0) {
			throw new IndexOutOfBoundsException();
		}

		Node temp = getNode(index);
		Node temp2 = temp.getPrev();
		Node temp3 = temp.getNext();

		T original = temp.getValue();

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

	public int indexOf(T value) {

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
		first = null;
		last = null;
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

	public String toStringRev() {
		String ans = "[";
		Node temp = last;

		while (temp != null) {

			Node a = temp.getPrev();

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
	public T get(int index) {

		if (index >= size || index < 0) {
			throw new IndexOutOfBoundsException();
		}

		return getNode(index).getValue();
	}

	public T set(int index,T newValue) {

		if (index >= size || index < 0) {
			throw new IndexOutOfBoundsException();
		}

		Node ntemp = getNode(index);

		T temp = ntemp.getValue();


		ntemp.setValue(newValue);
		return temp;
	}

	public int size() {
		return size;
	}

	public Iterator<T> iterator(){
		return new MyIterator();
	}

	// Iterator Class

	public class MyIterator implements Iterator<T>{

		private Node current = first;
		private int count = 0;

		public boolean hasNext() {
			return (current.getNext() != null);
		}

		public T next() {
			if (!hasNext()) {
                throw new NoSuchElementException();
			}
            else {
            		if (count == 0) {
            			T temp = current.data;
                		count +=1;
                		return temp;
            		}
            		current = current.next;
            		return current.data;
            }
		}

	}

	// Node Class

	private class Node{
		Node next,prev;
		T data;

		public Node(Node c,Node a, T b) {
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


		private void setValue(T input) {
			data=input;
		}

		public String toString() {
			return data+"";
		}

		private Node getNext() {
			return next;
		}

		private Node getPrev() {
			return prev;
		}

		private T getValue() {
			return data;
		}
	}

	public int max() {

		if (size == 0) {
			return -1;
		}

		int index = 0;
		T data = first.getValue();
		Node val = first.getNext();

		for (int i = 1; i < size; i++) {
			if (val.getValue().compareTo(data) > 0) {
				data = val.getValue();
				index = i;
			}
			val = val.getNext();
		}
		return index;
	}

	public int min() {

		if (size == 0) {
			return -1;
		}

		int index = 0;
		T data = first.getValue();
		Node val = first.getNext();

		for (int i = 1; i < size; i++) {
			if (val.getValue().compareTo(data) < 0) {
				data = val.getValue();
				index = i;
			}
			val = val.getNext();
		}
		return index;
	}


	public void reverse() {
		MyLinkedListImproved<T> ans = new MyLinkedListImproved<>();
		Node temp = last;

		while (temp != null) {

			Node a = temp.getPrev();

			ans.add(temp.getValue());

			temp = a;
		}
		this.first = ans.first;
		this.last = ans.last;

	}

	public void extend(MyLinkedListImproved<T> data) {
		if (data.size == 0) {
			return;
		}
		if (this.size == 0) {
			this.first = data.first;
			this.size = data.size;
			this.last = data.last;

			data.clear();
			return;
		}
		//System.out.println(data);
		this.last.setNext(data.first);
		this.last = data.last;
		this.size += data.size;

		data.clear();
	}



	public static void main(String[] args) {

		int[] test = {0,6,2,9,2,0,0,1};
		//int[] test1 = {0, 0, 0, 10000};

		//String[] tests = {"hi","there","programmer"};
		MyLinkedListImproved<Integer> a = new MyLinkedListImproved<>();
		//MyLinkedListImproved<Integer> c = new MyLinkedListImproved<>();

		//MyLinkedListImproved<String> b = new MyLinkedListImproved<>();

		for (int x : test) {
			a.add(a.size,x);
		}
		/*
		for (int y : test1) {
			c.add(y);
		}
		*/
		//a.reverse();
		//a.extend(c);

		System.out.println(a);
		/*
		for (String x : tests) {
			b.add(x);
		}

		System.out.println(a);
		System.out.println(b);

		for (Integer x : a) {
			System.out.println(x);
		}

		for (String x : b) {
			System.out.println(x);
		}
		System.out.println(a.max());
		System.out.println(a.min());
		*/


		//System.out.println(a.toString());

		//Integer val = new Integer(0);

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
