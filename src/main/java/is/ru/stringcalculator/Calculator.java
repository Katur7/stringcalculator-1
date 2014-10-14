package is.ru.stringcalculator;

import java.util.*;

public class Calculator {

	public static int add(String text){
		if(text.equals(""))
		{
			return 0;
		} else
		{
			String[] numbers = null;
			String delimitor = "";
			if(text.startsWith("//"))
			{
				text = text.substring(2);				// Remove //
				String[] temp = text.split("\n", 2);	// Split on first \n
				delimitor = temp[0];
				numbers = temp[1].split(delimitor + "|,|\n");
			} else
			{
				numbers = text.split(",|\n");
			}
			// Check for negatives
			negativesBad(numbers);
			
			return calc(numbers);
		}
	}

	private static int parse(String c)
	{
		return Integer.parseInt(c);
	}

	private static int calc(String[] arr)
	{
		int calc = 0;
		for(int i = 0; i < arr.length; i++)
		{
			int next = parse(arr[i]);
			if(next <= 1000)
			{
				calc += next;
			}
		}
		
		return calc;
	}

	private static void negativesBad(String[] numbers)
	{
		List<String> negatives = new ArrayList<String>();
		for(int i = 0; i < numbers.length; i++)
		{
			if(numbers[i].matches("-.*"))
			{
				negatives.add(numbers[i]);
			}
		}

		if(!negatives.isEmpty())
		{
			String neglist = negatives.get(0);
			for(int i = 1; i < negatives.size(); i++)
			{
				neglist += "," + negatives.get(i);
			}
			throw new IllegalArgumentException("Negatives not allowed: " + neglist);
		}
	}
}