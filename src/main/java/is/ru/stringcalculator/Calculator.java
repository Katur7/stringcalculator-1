package is.ru.stringcalculator;

public class Calculator {

	public static int add(String text){
		if(text.equals(""))
		{
			return 0;
		} else
		{
			String[] numbers = text.split(",");
			int calc = parse(numbers[0]);
			if(numbers.length > 1)
			{
				calc += parse(numbers[1]);
			}
			return calc;
		}
	}

	private static int parse(String c)
	{
		return Integer.parseInt(c);
	}
}