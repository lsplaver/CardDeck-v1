package cardDeck;

import java.util.Scanner;

public class Console 
{
	private static Scanner sc = new Scanner(System.in);
	
	public static String getString(String prompt)
	{
		System.out.print(prompt);
		return sc.nextLine();
	}
	
	public static int getInt(String prompt)
	{
		while (true)
		{
			System.out.print(prompt);
			try
			{
				return Integer.parseInt(sc.nextLine());
			}
			catch (NumberFormatException e)
			{
				System.out.println("Error!  Invalid integer value");
			}
		}
	}
}
