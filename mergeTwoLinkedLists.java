class ListNode<T>
{
   ListNode(T x)
   {
     value = x;
   }
   T value;
   ListNode<T> next;
}

class mergeTwoLinkedLists
{
	public static void main(String args[])
	{
		/*
		int[] l1 = {1, 1, 2, 4};
		int[] l2 = {0, 3, 5};
		*/
		/*
		int[] l1 = {1, 2, 3};
		int[] l2 = {4, 5, 6};
		*/
		/*
		int[] l1 = {5, 10, 15, 40};
		int[] l2 = {2, 3, 20};
		*/
		/*
		int[] l1 = {1, 1};
		int[] l2 = {2, 4};
		*/
		/*
		int[] l1 = {};
		int[] l2 = {1, 1, 2, 2, 4, 7, 7, 8};
		*/
		/*
		int[] l1 = {-1, -1, 0, 1};
		int[] l2 = {-1, 0, 0, 1, 1};
		*/
		
		int[] l1 = {-780, -670, -404, 242, 731};
		int[] l2 = {-815, -426, 437, 520};
		
		ListNode<Integer> headL1 = new ListNode<Integer>(l1[0]);
		ListNode<Integer> next;
		ListNode<Integer> previous = headL1;
		for (int i = 1; i < l1.length; i++)
		{
			next = new ListNode<Integer>(l1[i]);
			previous.next = next;
			previous = next;
		}
		
		ListNode<Integer> headL2 = new ListNode<Integer>(l2[0]);
		previous = headL2;
		for (int i = 1; i < l2.length; i++)
		{
			next = new ListNode<Integer>(l2[i]);
			previous.next = next;
			previous = next;
		}
		
		next = mergeTwoLinkedLists(headL1, headL2);
		while(next != null)
		{
			System.out.print(next.value + " ");
			next = next.next;
		}
		
	}
	
	public static ListNode<Integer> mergeTwoLinkedLists(ListNode<Integer> l1, ListNode<Integer> l2)
	{
		ListNode<Integer> headL1 = l1;
		ListNode<Integer> headL2 = l2;
		ListNode<Integer> previous1, previous2;
		ListNode<Integer> next1, next2, temp1 = null, temp2;
		
		if ( headL1 == null || headL2 == null)
		{
			if ( headL1 == null) { return headL2;}
			else if ( headL2 == null ) { return headL1; }
		}
		else
		{
			previous1 = headL1;
			previous2 = headL2;
			temp2 = previous2;
			while (previous2 != null)
			{				
				if ( previous1.value > previous2.value )
				{
					previous2 = previous2.next;
					temp2.next = previous1;
										
					if (temp1 == null)
					{
						previous1 = temp2;
						headL1 = temp2;
						temp2 = previous2;
					}
					else
					{
						temp1.next = temp2;
                        temp1 = temp2;
						temp2 = previous2;
					}					
				}
				else
				{
					temp1 = previous1;
					previous1 = previous1.next;
					if ( previous1 == null)
					{
						temp1.next = previous2;
						break;
					}					
				}
			}
		}
		return headL1;   
	}
	
}
