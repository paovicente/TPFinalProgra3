package paquete;

import java.util.Random;

public class Util
{
	private static Random r = new Random();

	public static void espera(int num)
	{
		try
		{
			Thread.sleep(r.nextInt(num));
		} catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}