/*
Given a singly linked list of integers l 
and a non-negative integer n, move the last 
n list nodes to the beginning of the linked 
list.
*/

// Definition for singly-linked list:
 class ListNode<T> {
   ListNode(T x) {
     value = x;
   }
   T value;
   ListNode<T> next;
 }

class rearrangeLastN
{
	public static void main(String args[])
	{
		/*
		int[] l = {1, 2, 3, 4, 5};
		int n = 3;
		*/
		/*
		int[] l = {1, 2, 3, 4, 5, 6, 7};
		int n = 1;
		*/
		int[] l = {123, 456, 789, 0};
		int n = 4
		
		ListNode<Integer> temp = null;
		ListNode<Integer> myList = new ListNode<Integer>(l[0]);
		ListNode<Integer> head = myList;
		
		for (int i = 1; i < l.length; i++)
		{
			temp = new ListNode<Integer>(l[i]);
			myList.next = temp;
			myList = temp;			 
		}
				
		//output linked list
		temp = rearrangeLastN(head, n);
		while (temp != null)
		{
			System.out.print(temp.value + " ");
			temp = temp.next;
		}
		
	}
 
	public static ListNode<Integer> rearrangeLastN(ListNode<Integer> l, int n)
	{
		ListNode<Integer> oldHead = l;
		ListNode<Integer> newHead = null;
		ListNode<Integer> temp = l;
		ListNode<Integer> temp2 = null;
		ListNode<Integer> lastNodeOldList = null;
		int numberOfNodes = 0;
		
		while (temp != null)
		{
			numberOfNodes++;
			lastNodeOldList = temp;
			temp = temp.next;
		}
		
		temp = oldHead;
		
		if (n == numberOfNodes) { return oldHead; }
		if ( n == 0) { return oldHead; }
		
		while (temp != null)
		{
			if ( n == numberOfNodes )
			{
				newHead = temp;
				lastNodeOldList.next = oldHead;
			}
			
			if ( n == numberOfNodes - 1)
			{
				temp2 = temp;
				temp = temp.next;
				numberOfNodes--;
				temp2.next = null;
			}
			else
			{
				numberOfNodes--;
				temp = temp.next;
			}
		}
				
		return newHead;
	}
}