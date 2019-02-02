/*
You're given 2 huge integers 
represented by linked lists. 
Each linked list element is a 
number from 0 to 9999 that 
represents a number with 
exactly 4 digits. The represented 
number might have leading zeros. 
Your task is to add up these huge 
integers and return the result 
in the same format.
*/

import java.math.BigInteger;

//Definition for singly-linked list:
class ListNode<T>
{
   ListNode(T x)
   {
     value = x;
   }
   T value;
   ListNode<T> next;
}

class addTwoHugeNumbers
{
	public static void main(String args[])
    {
		
		int[] list1 = {9876, 5432, 1999};
		int[] list2 = {1, 8001};
		
		/*
		int[] list1 = {123, 4, 5};
		int[] list2 = {100, 100, 100};
		*/
		/*
		int[] list1 = {0};
		int[] list2 = {0};
		*/
		ListNode<Integer> head1 = new ListNode<Integer>(null);
		ListNode<Integer> head2 = new ListNode<Integer>(null);
		ListNode<Integer> first;
		ListNode<Integer> next;
		
		first = head1;
		for (int i = 0; i < list1.length; i++)
		{
			first.value = list1[i];
			if ( i != list1.length - 1)
			{
			next = new ListNode<Integer>(null);
			first.next = next;
			first = next;
			}
		}
		
		first = head2;
		for (int i = 0; i < list2.length; i++)
		{
			first.value = list2[i];
			if ( i != list2.length - 1)
			{
			next = new ListNode<Integer>(null);
			first.next = next;
			first = next;
			}
		}
		
		first = addTwoHugeNumbers(head1, head2);
		
		while (first != null)
		{
			System.out.println(first.value);
			first = first.next;
		}
	}
	
	public static ListNode<Integer> addTwoHugeNumbers(ListNode<Integer> a, ListNode<Integer> b)
	{
		ListNode<Integer> first;
		ListNode<Integer> listToReturn = new ListNode<Integer>(null);
		String mys = "";
		String mys2 = "";
		String listString = "";
		String stringToUseForNode = "";
		Integer temp;
		BigInteger num1, num2, total;
		int len = 0;
		first = a;
		int lengthOfFinalNumber = 0, lastIndex = 0;
		int countToFour = 0;
		
		while (first != null)
		{

			temp = first.value;
			mys2 = temp.toString();
			
			len = 4 - mys2.length();
			for (int i = 0; i < len; i++)
			{
				mys2 = "0" + mys2;
			}
			
			mys = mys + mys2;
			first = first.next;
		}
		
		//https://stackoverflow.com/questions/13935167/java-lang-numberformatexception-for-input-string
		
		num1 = new BigInteger(mys);
		mys="";
		mys2="";
		
		first = b;
		
		while (first != null)
		{
			temp = first.value;
			mys2 = temp.toString();
			
			len = 4 - mys2.length();
			for (int i = 0; i < len; i++)
			{
				mys2 = "0" + mys2;
			}
			
			mys = mys + mys2;
			first = first.next;
		}
		
		num2 = new BigInteger(mys);	
		total = num1.add(num2);
    
		listString = total.toString();
		lengthOfFinalNumber = listString.length();
    
		lastIndex = lengthOfFinalNumber - 1;
		
		first = listToReturn;
		for (int i = lastIndex; i >= 0; i--)
		{
			stringToUseForNode = listString.charAt(i) + stringToUseForNode;
			countToFour++;
			if (countToFour == 4)
			{			
				first.value = Integer.parseInt(stringToUseForNode);
				ListNode<Integer> listToReturn2 = new ListNode<Integer>(null);
				
				listToReturn2.next = first;
				first = listToReturn2;
				stringToUseForNode="";
				countToFour = 0;
			}
			if (i == 0)
			{
				if ( stringToUseForNode.length() > 0 )
				{
					first.value = Integer.parseInt(stringToUseForNode);
					ListNode<Integer> listToReturn2 = new ListNode<Integer>(null);
				
					listToReturn2.next = first;
					first = listToReturn2;
				}
			}								
		}
		
		first = first.next;
		return first;

	}
	
}