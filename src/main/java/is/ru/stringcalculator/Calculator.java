package is.ru.stringcalculator;

import java.util.*;

public class Calculator {

	public static int add(String text){
		if(text.equals(""))
		{
			return 0;
		} else
		{
			String[] numbers = splitInput(text);
			
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

	private static String[] splitInput(String text) {
		String[] numbers = null;
		if(text.startsWith("//")) {
			String delimitor = "";
			text = text.substring(2);				// Remove //
			String[] temp = text.split("\n", 2);	// Split on first \n
			delimitor = temp[0];
			String[] delimArr = delimitor.split("(?!^)");	// Split into array by chars
			// Remove dublicates
			Set<String> delimSet = new HashSet<String>(Arrays.asList(delimArr));
			String delimitors = "";
			// Make regex
			for(String str : delimSet){
	            delimitors += "|[" + str + "]";
	        }
			delimitors = delimitors.substring(1);
			// Split the input
			numbers = temp[1].split(delimitors + "|,|\n");
			// Remove empty elements
			List<String> list = new ArrayList<String>(Arrays.asList(numbers));
			Iterator<String> i = list.iterator();
			while(i.hasNext()) {
				if(i.next().isEmpty()) {
					i.remove();
				}
			}
			numbers = list.toArray(new String[list.size()]);
			return numbers;
		} else {
			numbers = text.split(",|\n");
			return numbers;
		}
	}
}