/*
Given a string s, find and return the first
instance of a non-repeating character in it.
If there is no such character, return '_'.
*/


function firstNotRepeatingCharacter($s) {
  $length = strlen($s);
  $b = [];
  $characterToReturn = null;
  for ( $i = 0; $i < $length; $i++)
  {
      $b[$s[$i]]++;
     
  }
  
  foreach ($b as $k => $v) {
    if ($v == 1)
    {
         $characterToReturn = $k;
      break;
    }
}
  if (isset($characterToReturn))
  {
      return $characterToReturn;
  }
  else
  {
      return "_";
  }
}

