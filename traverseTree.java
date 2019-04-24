/*
Given a binary tree of integers t, return its node values in the following format:

    The first element should be the value of the tree root;
	
    The next elements should be the values of the nodes at
	height 1 (i.e. the root children), ordered from the leftmost
	to the rightmost one;
	
    The elements after that should be the values of the nodes
	at height 2 (i.e. the children of the nodes at height 1)
	ordered in the same way;
*/

import java.util.*;

// Definition for binary tree:
 class Tree<T> {
	Tree(T x)
	{
		value = x;
	}
	T value;
	Tree<T> left;
	Tree<T> right;
}

class traverseTree
{
	public static void main(String[] args)
	{
		/*
			 1
		  /    \
		 2      4 
		  \    /
		   3  5		//height two
		*/
		
		//test1
		Tree<Integer> t = new Tree<Integer>(1);
		
			t.left = new Tree<Integer>(2);
			Tree<Integer> forHeightTwo1 = t.left;
			
			
				forHeightTwo1.left = null;
				forHeightTwo1.right = new Tree<Integer>(3);
				Tree<Integer> forHeightThree1 = forHeightTwo1.right;
				
					forHeightThree1.left = null;
					forHeightThree1.right = null;
				
			
			t.right = new Tree<Integer>(4);
			Tree<Integer> forHeightTwo2 = t.right;
			
			
				forHeightTwo2.left = new Tree<Integer>(5);
				Tree<Integer> forHeightThree2 = forHeightTwo2.left;
				
					
					forHeightThree2.left = null;
					forHeightThree2.right = null;
				
				forHeightTwo2.right = null;
		
		int[] myArray = traverseTree(t);
		
		for (int i = 0; i < myArray.length; i++)
		{
			System.out.print(myArray[i] + " ");
		}
		
	}
	
	public static int[] traverseTree(Tree<Integer> t)
	{
		Tree<Integer> temp = t;
		ArrayList<Integer> tempArray = new ArrayList<Integer>();
		
		Queue<Tree<Integer>> q = new LinkedList<Tree<Integer>>();
		q.add(temp);
		
		while( temp != null)
		{
			tempArray.add(temp.value);
			
			q.remove();
			if (temp.left != null) {q.add(temp.left);}
			if (temp.right != null) {q.add(temp.right);}
			temp = q.peek();
			
		}
		
		int[] result = new int[tempArray.size()];
		for (int i = 0; i < tempArray.size(); i++)
		{
            result[i] = tempArray.get(i); 
		}
		
		return result;
	}
}

