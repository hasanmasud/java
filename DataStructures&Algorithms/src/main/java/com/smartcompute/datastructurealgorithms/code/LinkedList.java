package com.smartcompute.datastructurealgorithms.code;


public class LinkedList{
	
		private Node head;
		private Node tail;
		
		public LinkedList(){
			this.head = new Node("head");
			this.tail = head;
		}
		
		public Node head() {
			return this.head;
		}

		public void add(Node node){
			this.tail.next = node;
			this.tail = node;
		}
		
		public static class Node{
			private Node next;
			private String data;
			public Node(String data){
				this.data = data;
			}
			public Node next(){
				return this.next;
			}
			public void setNext(Node node){
				this.next = node;
			}
			public void setData(String data){
				this.data = data;
			}
			public String getData(){
				return this.data;
			}
		}
	}
	