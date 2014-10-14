package is.ru.stringcalculator;

public class Calculator {

	public static int add(String text){
		if(text.equals(""))
		{
			return 0;
		} else
		{
			String[] numbers = text.split(",|\n");
			int calc = 0;
			for(int i = 0; i < numbers.length; i++)
			{
				calc += parse(numbers[i]);
			}
			
			return calc;
		}
	}

	private static int parse(String c)
	{
		return Integer.parseInt(c);
	}
}