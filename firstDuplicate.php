/*
Given an array a that contains only numbers in the range from 1
to a.length, find the first duplicate number for which the second
occurrence has the minimal index. In other words, if there are more
than 1 duplicated numbers, return the number for which the second
occurrence has a smaller index than the second occurrence of the
other number does. If there are no such elements, return -1.
*/


function firstDuplicate($a) {

    $length = count($a);
    
    $duplicate = false;
    $b = [];
    
    for ($i = 1; $i <= $length; $i++)
    {
        $b[$i] = 0;
    }
    
    $smallestIndex = $length - 1;
    
    for ($i = 0; $i < $length; $i++)
    {
       $b[$a[$i]]++;
        if ( $b[$a[$i]] == 2)
        {
            $duplicate = true;
            if ( $i <= $smallestIndex )
            {
                $smallestIndex = $i;
            }
        }
    }
    
    if ($duplicate)
    {
        return $a[$smallestIndex];
    }
    else
    {
        return -1;
    }
}

