/*
Given an array of integers nums and an integer k, 
determine whether there are two distinct indices 
i and j in the array where nums[i] = nums[j] and 
the absolute difference between i and j is less 
than or equal to k.
*/
import java.util.*;
class containsCloseNums
{
	public static void main(String[] args)
	{
		/*
		int[] nums = {0, 1, 2, 3, 5, 2};
		int k = 3;
		*/
		/*
		int[] nums = {0, 1, 2, 3, 5, 2};
		int k = 2;
		*/
		/*
		int[] nums = {};
		int k = 0;
		*/
		/*
		int[] nums = {99, 99};
		int k = 2;
		*/
		/*
		int[] nums = {2, 2};
		int k = 3;
		*/
		/*
		int[] nums = {1, 2};
		int k = 2;
		*/
		/*
		int[] nums = {1, 2, 1};
		int k = 2;
		*/
		
		int[] nums = {1, 0, 1, 1};
		int k = 1;
		
		/*
		int[] nums = {1, 2, 1};
		int k = 0;
		*/
		/*
		int[] nums = {1, 2, 1};
		int k = 1;
		*/
		System.out.println( containsCloseNums(nums, k) );
	}

	public static boolean containsCloseNums(int[] nums, int k)
	{
		Hashtable<Integer, Integer> ht = new Hashtable<Integer, Integer>();
		int x, y;
		for (int i = 0; i < nums.length; i++)
		{
			if (!ht.containsKey(nums[i]))
			{
				//constructs hash table with integer array value as key and the index of array as value
				ht.put(nums[i], i);
			}
			else
			{
				x = ht.get(nums[i]);
				y = i;
				if ( k >= Math.abs(x-y) ) {return true;}
				else { ht.put(nums[i], i); }
			}
			
		}
		
		return false;
	}
}


