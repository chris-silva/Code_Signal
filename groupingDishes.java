/*
You have a list of dishes. Each dish is 
associated with a list of ingredients 
used to prepare it. You want to group 
the dishes by ingredients, so that for 
each ingredient you'll be able to find 
all the dishes that contain it (if there 
are at least 2 such dishes).

Return an array where each element is a 
list with the first element equal to the 
name of the ingredient and all of the other 
elements equal to the names of dishes that 
contain this ingredient. The dishes inside 
each list should be sorted lexicographically. 
The result array should be sorted lexicographically 
by the names of the ingredients in its elements.

For

dishes = [["Salad", "Tomato", "Cucumber", "Salad", "Sauce"],
            ["Pizza", "Tomato", "Sausage", "Sauce", "Dough"],
            ["Quesadilla", "Chicken", "Cheese", "Sauce"],
            ["Sandwich", "Salad", "Bread", "Tomato", "Cheese"]]

the output should be			
			
			groupingDishes(dishes) = [["Cheese", "Quesadilla", "Sandwich"],
                            ["Salad", "Salad", "Sandwich"],
                            ["Sauce", "Pizza", "Quesadilla", "Salad"],
                            ["Tomato", "Pizza", "Salad", "Sandwich"]]
For
							
dishes = [["Pasta", "Tomato Sauce", "Onions", "Garlic"],
            ["Chicken Curry", "Chicken", "Curry Sauce"],
            ["Fried Rice", "Rice", "Onions", "Nuts"],
            ["Salad", "Spinach", "Nuts"],
            ["Sandwich", "Cheese", "Bread"],
            ["Quesadilla", "Chicken", "Cheese"]]

the output should be
			
groupingDishes(dishes) = [["Cheese", "Quesadilla", "Sandwich"],
                            ["Chicken", "Chicken Curry", "Quesadilla"],
                            ["Nuts", "Fried Rice", "Salad"],
                            ["Onions", "Fried Rice", "Pasta"]]
			
*/

import java.util.*;
class groupingDishes
{
	public static void main(String[] args)
	{
		/*
		String[][] dishes = {
			{"Salad", "Tomato", "Cucumber", "Salad", "Sauce"},
			{"Pizza", "Tomato", "Sausage", "Sauce", "Dough"},
			{"Quesadilla", "Chicken", "Cheese", "Sauce"},
			{"Sandwich", "Salad", "Bread", "Tomato", "Cheese"}
		};
		*/
		
		String[][] dishes = {
			{"Pasta","Tomato Sauce","Onions","Garlic"}, 
			{"Chicken Curry","Chicken","Curry Sauce"}, 
			{"Fried Rice","Rice","Onion","Nuts"}, 
			{"Salad","Spinach","Nut"}, 
			{"Sandwich","Cheese","Bread"}, 
			{"Quesadilla","Chickens","Cheeseeee"}
		};
		
		groupingDishes(dishes);
	}
		
	public static String[][] groupingDishes(String[][] dishes)
	{
		
		String tempIngredient = "";
		ArrayList<String> ingredients = organizeIngredients(dishes);
		Collections.sort(ingredients);
		ArrayList<ArrayList<String>> outer = new ArrayList<ArrayList<String>>();
		
		for (int x = 0; x < ingredients.size(); x++)
		{
			tempIngredient = ingredients.get(x);
			ArrayList<String> inner = new ArrayList<String>();
			inner.add(tempIngredient);
			
			for (int y = 0; y < dishes.length; y++)
			{
				for (int z = 1; z < dishes[y].length; z++)
				{
					if (tempIngredient.equals(dishes[y][z]) )
					{
						inner.add( dishes[y][0] );
					}
				}
			}		
			outer.add(inner);
		}
		
		//remove ArrayLists that have less than 2 dishes
		ArrayList<String> tempArrayList;
		int fixedArraySize = outer.size();
		for (int i = 0; i < outer.size(); i++)
		{
			tempArrayList = outer.get(i);
			
			if (tempArrayList.size() < 3)
			{
				outer.remove(i);
				i = i - 1;
			}
		}
		
		//sort dishes in final table
		ArrayList<String> tempArrayList2;
		String tempS = "";
		for (int i = 0; i < outer.size(); i++)
		{
			tempArrayList2 = outer.get(i);
			tempS = tempArrayList2.get(0);
			tempArrayList2.remove(0);
			Collections.sort(tempArrayList2);
			tempArrayList2.add(0, tempS);
		}
		
		String[][] finalArray = new String[outer.size()][];
		String[] s;
		ArrayList<String> tempArrayList3;
		for (int i = 0; i < outer.size(); i++)
		{
			tempArrayList3 = outer.get(i);
			s = new String[tempArrayList3.size()];
			for (int j = 0; j < tempArrayList3.size(); j++)
			{
				s[j] = tempArrayList3.get(j);
			}
			finalArray[i] = s;
		}
		
		return finalArray;
	}
	
	public static ArrayList<String> organizeIngredients(String[][] dishes)
	{
		ArrayList<String> ingredients = new ArrayList<String>();
		
		for (int i = 0; i < dishes.length; i++)
		{
			for (int j = 1; j < dishes[i].length; j++)
			{
				if (!ingredients.contains(dishes[i][j]))
				{
					ingredients.add(dishes[i][j]);
				}
			}		
		}
		
		return ingredients;
	}
	
}