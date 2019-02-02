import java.util.*;

/*
Given a singly linked list of integers, 
determine whether or not it's a palindrome.
*/

// Definition for singly-linked list:
class ListNode<T>
{
	ListNode(T x)
	{
		value = x;
	}
	T value;
	ListNode<T> next;
 }

class isListPalindrome
{
	public static void main(String args[])
	{
	
		int[] list = {1, 1000000000, -1000000000, -1000000000, 1000000000, 1};
		
		ListNode<Integer> head = new ListNode<Integer>(null);
		ListNode<Integer> first = head;
		ListNode<Integer> next;
		
		first.value = list[0];
		for (int i = 1; i < list.length; i++)
		{
			next = new ListNode<Integer>(list[i]);
			first.next = next;
			first = next;
	
		}

		System.out.print(isListPalindrome(head));
	}
	
	public static boolean isListPalindrome(ListNode<Integer> l)
	{
		ListNode<Integer> first = l;
		ArrayList<Integer> myList = new ArrayList<Integer>(0);
		
		while (first != null)
		{
			myList.add(first.value);
			first = first.next;
		}
		
		Integer x, y;
		
		int last = myList.size() - 1;
		for (int i = 0; i < myList.size() / 2; i++)
		{
			x = myList.get(i);
			y = myList.get(last);
			if ( !(x.equals(y)) ) {return false;}
			last--;
		}
		
		return true;
	}
}
