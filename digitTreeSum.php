<?php

/*
We're going to store numbers in a tree.
Each node in this tree will store a single
digit (from 0 to 9), and each path from root
to leaf encodes a non-negative integer.

Given a binary tree t, find the sum of all
the numbers encoded in it.
*/

 //Definition for binary tree:
 class Tree {
   public $value;
   public $left;
   public $right;

   public function __construct($x) {
     $this->value = $x;
     $this->left = null;
     $this->right = null;
   }
 }
 
$t = new Tree(1);
    
	$t2Left = new Tree(0);
	$t->left = $t2Left;
    
		$t3 = $t->left;
		$t3->left = new Tree(3);
        
			$t3->left->{'left'} = null;
			$t3->left->{'right'} = null;
        
        $t3->right = new Tree(1);
            
            $t3->right->{'left'} = null;
			$t3->right->{'right'} = null;
    
	$t2Right = new Tree(4);
	$t->right = $t2Right;
		$t->right->{'left'} = null;
        $t->right->{'right'} = null;
        

digitTreeSum($t);		


function digitTreeSum($t) {
	
	$ultimateArray = array();
	
	$sum = 0;
	
	if ( $t == null )
	{
		return [];
	}
	else
	{
		helper1($t, $sum, $ultimateArray);
	}
	
	for ($i = 0; $i < count($ultimateArray); $i++)
	{
		$sum = $sum + $ultimateArray[ $i ];
	}
	
	//echo $sum;
	return $sum;

}

function helper1($t, $sum, &$u)
{
	
	if ($t->left != null)
	{
		helper1($t->left, $sum . '' . $t->value, $u);
	}
	if ($t->right != null)
	{
		helper1($t->right, $sum . '' . $t->value, $u);
	}
	
	if ( $t->left == null && $t->right == null)
	{
		array_push($u, $sum . '' . $t->value);
	}
}