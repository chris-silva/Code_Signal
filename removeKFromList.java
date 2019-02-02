/*
Given a singly linked list of integers l and
an integer k, remove all elements from list l
that have a value equal to k.
*/

class ListNode<T>
{
	ListNode(T x)
	{
		value = x;
	}
	T value;
	ListNode<T> next;
}

class removeKFromList
{	
    public static void main(String args[])
    {				
		
		int k = 3;
		int[] list = {3, 1, 2, 3, 4, 5};
		
		ListNode<Integer> head = new ListNode<Integer>(list[0]);
		ListNode<Integer> first = head;
		ListNode<Integer> node;
		
		for (int i = 1; i < list.length; i++)
		{
			node = new ListNode<Integer>(list[i]);
			head.next = node;
			head = node;			
		}	
		
		first = removeKFromList(first, k);
				
		//output linked list
		while ( first != null)
		{
			System.out.print(first.value + " ");
			first = first.next;
		} 
				
    }
		
	public static ListNode<Integer> removeKFromList(ListNode<Integer> l, int k)
	{
		ListNode<Integer> nodeToReturn = l;
		ListNode<Integer> current = nodeToReturn;
		ListNode<Integer> previous = null;
		
		if (l == null) {nodeToReturn = null; return nodeToReturn;}
		
		//for only one node
		if (current.next == null)
		{
			if (current.value == k)
			{
				return null;
			}
		}
    
		while (current.next != null)
		{
			if (current.value == k)
			{
				//for first node
				if (previous == null)
				{				
					nodeToReturn = current.next;
					current = nodeToReturn;
                    
					if (current.value == k && previous != null) { previous.next = null; }
					if  (current.value == k && previous == null) { nodeToReturn = null; }         
					continue;
				}
				else //for the rest of the nodes
				{
					previous.next = current.next;
					
					if (current == null) { return nodeToReturn;}
				}
			}
			else
			{
				previous = current;
			}
			
			if (current.next != null) {current = current.next;}
					
			//for last node
			if (current.next == null)
			{
				if (current.value == k && previous != null) { previous.next = null; }
				if  (current.value == k && previous == null) { nodeToReturn = null; }			
			}						
		}
        
		return nodeToReturn;
	}
	
}


	
