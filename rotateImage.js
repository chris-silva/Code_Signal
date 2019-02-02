
/*
You are given an n x n 2D matrix that represents an image.
Rotate the image by 90 degrees (clockwise).
*/


function rotateImage(a) {
  var length = a.length;
  
  var b = [];
  
  for (var i = 0; i < length; i++)
  {
	  b[i] = [];
  }
  
  var secondIndex = length - 1;
  for (var i = 0; i < length; i++)
  {
      
      for (var j = 0; j < length; j++)
      {
              
        b[j][secondIndex] = a[i][j];
      }
      secondIndex--;
  }
  
  return b;
}
