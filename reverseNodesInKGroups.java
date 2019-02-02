/*
Given a linked list l, reverse its nodes 
k at a time and return the modified list. 
k is a positive integer that is less than 
or equal to the length of l. If the number 
of nodes in the linked list is not a multiple 
of k, then the nodes that are left out at the 
end should remain as-is.
*/

// Definition for singly-linked list:
class ListNode<T> {
   ListNode(T x) {
     value = x;
   }
   T value;
   ListNode<T> next;
}
class reverseNodesInKGroups
{
	public static void main(String args[])
	{
		
		int[] list = {1, 2, 3, 4, 5};
		int k = 2;
		
		/*
		int[] list = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
		int k = 4;
		*/
		/*
		int [] list = {239};
		int k = 1;
		*/
		ListNode<Integer> a = new ListNode<Integer>(list[0]);
		ListNode<Integer> temp = a;
		ListNode<Integer> temp2;
		
		for (int i = 1; i < list.length; i++)
		{
			temp.next = new ListNode<Integer>(list[i]);
			temp = temp.next;		
		}
		
		temp2 = reverseNodesInKGroups(a, k);
		
		
		//output linked lists
		while (temp2 != null)
		{
			System.out.print(temp2.value + " ");
			temp2 = temp2.next;
		}
		
	}
	
	public static ListNode<Integer> reverseNodesInKGroups(ListNode<Integer> l, int k)
	{
		ListNode<Integer> head = l;
		ListNode<Integer> myLinkedListNode = l;
		ListNode<Integer> tempNode = null;
		ListNode<Integer> previousNode = null;
		ListNode<Integer> firstInTempList = null;
		ListNode<Integer> lastInTempList = null;
		ListNode<Integer> endInNewList = null;
		ListNode<Integer> testList = null;
		int num = 0;
		int nodesToDealwith = k;
		
		
		boolean firstSet = true;
		
		while (myLinkedListNode != null)
		{		
			while (nodesToDealwith > 0)
			{
						
				tempNode = new ListNode<Integer>(myLinkedListNode.value);
				tempNode.next = previousNode;
                
				if (nodesToDealwith==k)
				{
					lastInTempList = tempNode;
				}
                
				previousNode = tempNode;
				myLinkedListNode = myLinkedListNode.next;
				nodesToDealwith = nodesToDealwith - 1;
				
			}
			
			firstInTempList = tempNode;
			
			if (firstSet)
			{
				head = tempNode;
				firstSet = false;
				endInNewList = lastInTempList;
			}			
			else
			{
				endInNewList.next = firstInTempList;
				endInNewList = lastInTempList;
			}
			
			lastInTempList.next = myLinkedListNode;
			nodesToDealwith = k;
			previousNode = null;
			
			//test to see if remaining nodes are less than k.
			testList = myLinkedListNode;
			while ( testList != null)
			{
				num = num + 1;
				testList = testList.next;
				
			}
			if (num < k) {return head;}
			num = 0;
						
		}
		
		return head;
	}
	
}