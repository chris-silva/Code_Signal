<?php

/*
You have a binary tree t. Your task is to find the
largest value in each row of this tree. In a tree,
a row is a set of nodes that have equal depth. For
example, a row with depth 0 is a tree root, a row
with depth 1 is composed of the root's children, etc.

Return an array in which the first element is the
largest value in the row with depth 0, the second
element is the largest value in the row with depth 1,
the third element is the largest element in the row
with depth 2, etc.
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
 
//test1
$t = new Tree(-1); 

	$t2Left = new Tree(5);
    $t->left = $t2Left;
        
        $t2Left->left = null;
        $t2Left->right = null;
    
	$t2Right = new Tree(7);
    $t->right = $t2Right;
        
        $t2Right->left = null;
        $t2Right->right = new Tree(1);
            
			$t2Right->right->{'left'} = null;
			$t2Right->right->{'right'} = null;

/*
//test2
$t = null;            
*/

largestValuesInTreeRows($t);		


function largestValuesInTreeRows($t) {
	
	$ultimateArray = array();
	
	$row = 0;
	
	if ( $t == null )
	{
		return [];
	}
	else
	{
		helper1($t, $row, $ultimate);
	}
	
	//print_r($ultimate);
	
	return $ultimate;

}

function helper1($t, $row, &$u)
{
	if ( isset($u[$row]) )
	{
		if ( $t->value > $u[$row])
		{
			$u[$row] = $t->value;
		}
	}
	else
	{
		$u[$row] = $t->value;
	}
	
	if ($t->left != null)
	{
		helper1($t->left, $row + 1, $u);
	}
	if ($t->right != null)
	{
		helper1($t->right, $row + 1, $u);
	}
}