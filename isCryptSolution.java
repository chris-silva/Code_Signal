/*
A cryptarithm is a mathematical puzzle for which 
the goal is to find the correspondence between letters 
and digits, such that the given arithmetic equation 
consisting of letters holds true when the letters are 
converted to digits.

You have an array of strings crypt, the cryptarithm, 
and an an array containing the mapping of letters and 
digits, solution. The array crypt will contain three 
non-empty strings that follow the structure: [word1, 
word2, word3], which should be interpreted as the 
word1 + word2 = word3 cryptarithm.

If crypt, when it is decoded by replacing all of the 
letters in the cryptarithm with digits using the mapping 
in solution, becomes a valid arithmetic equation containing 
no numbers with leading zeroes, the answer is true. If it 
does not become a valid arithmetic solution, the answer is false.
*/


class isCryptSolution
{
    public static void main(String args[])
    {		
		String[] crypt = {"AAAAAAAAAAAAAA", "BBBBBBBBBBBBBB", "CCCCCCCCCCCCCC"};
		char[][] solution = {{'A','1'}, {'B','2'}, {'C','3'}};
		System.out.print( isCryptSolution(crypt, solution) );
	
    }
	static
///////////////////////////////////////////////////////////////////////////////////////	

    boolean isCryptSolution(String[] crypt, char[][] solution)
	{
		String firstWord = crypt[0], secondWord = crypt[1], thirdWord = crypt[2];
		String firstWordinNumber="", secondWordinNumber="", thirdWordinNumber="";
		long num1, num2, num3;
		char letter;
		
		//first word
		for (int i = 0; i < firstWord.length(); i++)
		{
			letter = firstWord.charAt(i);
			for (int j = 0; j < solution.length; j++)
			{
				if (solution[j][0] == letter)
				{
					firstWordinNumber = firstWordinNumber + solution[j][1];
				}
			}
		}		
		if ( firstWordinNumber.charAt(0) == '0' && firstWordinNumber.length() > 1) {return false;}
				
		//second word
		for (int i = 0; i < secondWord.length(); i++)
		{
			letter = secondWord.charAt(i);
			for (int j = 0; j < solution.length; j++)
			{
				if (solution[j][0] == letter)
				{
					secondWordinNumber = secondWordinNumber + solution[j][1];
				}
			}
		}		
		
		if ( secondWordinNumber.charAt(0) == '0' && secondWordinNumber.length() > 1) {return false;}
				
		//third word
		for (int i = 0; i < thirdWord.length(); i++)
		{
			letter = thirdWord.charAt(i);
			for (int j = 0; j < solution.length; j++)
			{
				if (solution[j][0] == letter)
				{
					thirdWordinNumber = thirdWordinNumber + solution[j][1];
				}
			}
		}		
		
		if ( thirdWordinNumber.charAt(0) == '0' && thirdWordinNumber.length() > 1) {return false;}
				
		num1 = Long.parseLong(firstWordinNumber);			
		num2 = Long.parseLong(secondWordinNumber);			
		num3 = Long.parseLong(thirdWordinNumber);

		if ( (num1 + num2) != num3) {return false;}
        		
		return true;
	}

////////////////////////////////////////////////////////////////////////////////////
}