/*
Sudoku is a number-placement puzzle. The objective 
is to fill a 9 × 9 grid with numbers in such a way 
that each column, each row, and each of the nine 3 × 3 
sub-grids that compose the grid all contain all of the 
numbers from 1 to 9 one time.

Implement an algorithm that will check whether the 
given grid of numbers represents a valid Sudoku puzzle 
according to the layout rules described above. Note that 
the puzzle represented by grid does not have to be solvable.
*/

function sudoku2(grid) {

    var numbers = [false, false, false, false, false, false, false, false, false, false];
    
    //row
    for (var i = 0; i < 9; i++)
    {
        for (var j = 0; j < 9; j++)
        {
            if ( !(grid[i][j] == ".") )
            {
                if ( numbers[ Number(grid[i][j]) ] == false )
                {
                    numbers[ Number(grid[i][j]) ] = true;
                }
                else
                {
                    return false;
                }
            }
        }
		
		numbers = [false, false, false, false, false, false, false, false, false, false];
    }
    
    numbers = [false, false, false, false, false, false, false, false, false, false];
    
    //column
    for ( var i = 0; i < 9; i++ )
    {
        for ( var j = 0; j < 9; j++)
        {
			if ( !(grid[j][i] == ".") )
            {
                if ( numbers[ Number(grid[j][i]) ] == false )
                {
                    numbers[ Number(grid[j][i]) ] = true;
                }
                else
                {
                    return false;
                }
            }
        }
		numbers = [false, false, false, false, false, false, false, false, false, false];
    }
    
    numbers = [false, false, false, false, false, false, false, false, false, false];
    
    //grid
    var i, j = 0, count = 0, gridNumber = 0;
    for (i = 0; i < 9; i++)
    {      
        while(count < 3)
        {
            if ( !(grid[i][j+count] == ".") )
            {
                if ( numbers[ grid[i][j+count] ] == false )
                {
                    numbers[ grid[i][j+count] ] = true;
                }
                else
                {
                    return false;
                }
            }
            count++;
        }
		//document.write("<br>"); //first 3 numbers of a grid
        count = 0

		if ( (i+1)%3 == 0 )
        {         
           j = 3 + j;
            i = i - 3;
			//document.write("<br>"); //separates grids
			gridNumber++;
			numbers = [false, false, false, false, false, false, false, false, false, false];
			
        }
		
		if ( gridNumber % 3 == 0 && gridNumber != 0 )
		{
			i = i + 3;
			j = 0;
			gridNumber = 0;
		}
    }		
		
    return true;

}
