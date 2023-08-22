import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringBuilder sb;
	public static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		sb = new StringBuilder();

		for (int test_case = 1; test_case <= 10; test_case++) {
			MyLinkedList linkedList = new MyLinkedList();

			int N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				linkedList.insertNode(Integer.parseInt(st.nextToken()));
			}

			int M = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			while (st.hasMoreTokens()) {
				int inLoc = 0;
				int R = 0;
				String s = st.nextToken();
				if (s.equals("I")) {
					inLoc = Integer.parseInt(st.nextToken());
					R = Integer.parseInt(st.nextToken());
				}

				MyLinkedList tempLinked = new MyLinkedList();
				for (int i = 0; i < R; i++) {
					tempLinked.insertNode(Integer.parseInt(st.nextToken()));
				}
				linkedList.insertLinkedList(inLoc-1, tempLinked);
			}
			
			sb.append("#").append(test_case).append(" ");
			linkedList.printList10(sb);
			sb.append("\n");
		}
		System.out.println(sb);
	}
}

class MyLinkedList {
	private ListNode head;
	private ListNode tail = head;

	public MyLinkedList() {
		head = null;
	}

	void insertLinkedList(int index, MyLinkedList list) {
		if (index > -1) {
			ListNode current = searchNode(index);
			ListNode nextNode = current.link;
			current.link = list.head;
			list.tail.link = nextNode;
		} else {
			ListNode current = searchNode(0);
			ListNode nextNode = current.link;
			this.head = list.head;
			list.tail.link = current;
			
		}
	}

	public void insertNode(int data) {
		ListNode newNode = new ListNode(data);
		if (head == null) {
			this.head = newNode;
			this.tail = newNode;
		} else {
			ListNode tempNode = head;
			while (tempNode.link != null) {
				tempNode = tempNode.link;
			}
			tempNode.link = newNode;
			this.tail = newNode;
		}
	}

	public ListNode searchNode(int r) {
		if (r < 0) {
			return null;
		}

		ListNode currNode = this.head;
		for (int i = 0; i < r; i++) {
			if (currNode.link == null)
				break;
			currNode = currNode.link;
		}
		return currNode;
	}

	public void printList10(StringBuilder sb) {
		ListNode tempNode = this.head;
		for (int i = 0; i < 10; i++) {
			if (tempNode != null) {
				sb.append(tempNode.getData() + " ");
				tempNode = tempNode.link;
			}
		}
	}

	public void printListAll(StringBuilder sb) {
		ListNode tempNode = this.head;
		while (tempNode != null) {
			sb.append(tempNode.getData() + " ");
			tempNode = tempNode.link;
		}
	}

	public ListNode printTail() {
		return tail;
	}
}

class ListNode {
	private int data;
	public ListNode link;

	public ListNode() {
		this.data = 0;
		this.link = null;
	}

	public ListNode(int data) {
		this.data = data;
		this.link = null;
	}

	public ListNode(int data, ListNode link) {
		this.data = data;
		this.link = link;
	}

	public int getData() {
		return this.data;
	}
}