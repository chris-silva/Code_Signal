/*
You have a collection of coins, and 
you know the values of the coins and 
the quantity of each type of coin in 
it. You want to know how many distinct 
sums you can make from non-empty groupings 
of these coins.

For coins = [10, 50, 100] and 
quantity = [1, 2, 1], the output should be
possibleSums(coins, quantity) = 9.

Here are all the possible sums:

    50 = 50;                    0 1 0
    10 + 50 = 60;               1 1 0
    50 + 100 = 150;             0 1 1
    10 + 50 + 100 = 160;        1 1 1
    50 + 50 = 100;              0 2 0
    10 + 50 + 50 = 110;         1 2 0
    50 + 50 + 100 = 200;        0 2 1
    10 + 50 + 50 + 100 = 210;   1 2 1
    10 = 10;                    1 0 0
    100 = 100;                  0 0 1
    10 + 100 = 110.             1 0 1

As you can see, there are 9 distinct 
sums that can be created from non-empty 
groupings of your coins.

*/

import java.util.*;
class possibleSums
{
	public static void main(String[] args)
	{	
		int[] coins = {1, 2};
		int[] quantity = {50000, 2};
		//50004
		
		System.out.println( possibleSums(coins, quantity) );
	}
	
	public static int possibleSums(int[] coins, int[] quantity)
	{
		Hashtable<Integer, Integer > master = new Hashtable<Integer, Integer >();
		Map<Integer, Integer> map = new HashMap();
		ArrayList<Integer> temp = new ArrayList<Integer>();
		
		int sizeOfMaster = 0;
		int keyTemp = 0;
		int coinMultiple;
		
		master.put(0, 0);
		
		int numberForEachCoin;
		int coinHolder;
		Set<Integer> keys;
		for (int i = 0; i < coins.length; i++)
		{
			numberForEachCoin = quantity[i];
			
			sizeOfMaster = master.size();
			Enumeration keysOfMaster = master.keys();
			ArrayList aList = Collections.list(keysOfMaster);
			
			for ( int j = 1; j <= numberForEachCoin; j++)
			{
				coinHolder = coins[i];
				
				for (int k = 0; k < sizeOfMaster; k++)
				{
					keyTemp = (int)aList.get(k);
					master.put(coinHolder * j + keyTemp, coinHolder * j + keyTemp );
				}
			}
		}
		
		master.remove(0);
		return master.size();
	
    
	}
}
