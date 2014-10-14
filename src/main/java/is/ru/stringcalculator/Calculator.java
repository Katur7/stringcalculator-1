package is.ru.stringcalculator;

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
			calc += parse(arr[i]);
		}
		
		return calc;
	}
}