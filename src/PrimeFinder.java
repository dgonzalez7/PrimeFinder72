
public class PrimeFinder implements Runnable
{
	public long target;
	public long prime;
	public boolean finished = false;
	
	private Thread runner;
	
	PrimeFinder(long inTarget)
	{
		target = inTarget;
		if (runner == null)
		{
			runner = new Thread(this);
			runner.start();
		}
	}
	
	// start() calls run()
	public void run()
	{
		long numPrimes = 0;
		long candidate = 2;
		while (numPrimes < target)
		{
			if (isPrime(candidate))
			{
				numPrimes++;
				prime = candidate;
			}
			candidate++;
		}
		finished = true;
	}
		
	boolean isPrime(long checkNum)
	{
		double root = Math.sqrt(checkNum);
		for (int i = 2; i <= root; i++)
		{
			if (checkNum % i == 0)
			{
				return false;
			}
		}
		return true;
	}
}
