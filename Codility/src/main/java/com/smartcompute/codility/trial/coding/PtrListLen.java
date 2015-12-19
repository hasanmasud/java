package com.smartcompute.codility.trial.coding;

public class PtrListLen {

	class IntList {
		public int value;
		public IntList next;
	}

	public int solution(IntList L) {
		if (L == null) {
			return 0;
		}
		if (L.next == null) {
			return 1;
		}
		int count = 0;
		while (L.next != null) {
			count++;
			L = L.next;
		}
		return count + 1;
	}
	
	
	public static void main(String ...args){
		
		PtrListLen obj = new PtrListLen();
		
		System.out.println(obj.solution(null));
		
		IntList l1 = obj.new IntList();
		l1.value = 0;
		
		System.out.println(obj.solution(l1));
		
		
		IntList l2 = obj.new IntList();
		l2.value = 0;
		l2.next = l1;
		System.out.println(obj.solution(l2));
		
		
		IntList l3 = obj.new IntList();
		l3.value = 0;
		l3.next = l2;
		System.out.println(obj.solution(l3));
		
		
		
		
	}

}
