package com.src.behavioral.chainOfResponsibility;

abstract class RsHandler
{
	RsHandler rsHandler;

	public void nextHandler( RsHandler rsHandler )
	{
		this.rsHandler = rsHandler;
	}

	public abstract void dispatchRs( long requestedAmount );

}



class HundredRsHandler extends RsHandler
{

	public void dispatchRs(long requestedAmount)
	{
		long numberofNotesToBeDispatched = requestedAmount / 100;
		if (numberofNotesToBeDispatched > 0)
		{
			if(numberofNotesToBeDispatched>1)
			{
				System.out.println(numberofNotesToBeDispatched + " ,Hundred Rs notes are dispatched by HundredRsHandler\n");
			}
			else
			{
				System.out.println(numberofNotesToBeDispatched + " ,Hundred Rs note is dispatched by HundredRsHandler\n");

			}
		}

		long pendingAmountToBeProcessed = requestedAmount % 100;

		if (pendingAmountToBeProcessed > 0)
		{
			rsHandler.dispatchRs(pendingAmountToBeProcessed);

		}

	}

}



class FiftyRsHandler extends RsHandler
{
	public void dispatchRs(long requestedAmount)
	{
		long numberofNotesToBeDispatched = requestedAmount / 50;
		if (numberofNotesToBeDispatched > 0)
		{
			if (numberofNotesToBeDispatched > 1)
			{
				System.out.println(numberofNotesToBeDispatched + " ,Fifty Rs notes are dispatched by FiftyRsHandler\n");
			}
			else
			{
				System.out.println(numberofNotesToBeDispatched + " ,Fifty Rs note is dispatched by FiftyRsHandler\n");

			}

		}

		long pendingAmountToBeProcessed = requestedAmount % 50;

		if (pendingAmountToBeProcessed > 0)
		{
			rsHandler.dispatchRs(pendingAmountToBeProcessed);

		}

	}
}




class TwentyRsHandler extends RsHandler
{
	public void dispatchRs(long requestedAmount)
	{
		long numberofNotesToBeDispatched = requestedAmount / 20;

		if (numberofNotesToBeDispatched > 0)
		{

			if (numberofNotesToBeDispatched > 1)
			{
				System.out.println(numberofNotesToBeDispatched + " ,Twenty Rs notes are dispatched by TwentyRsHandler\n");
			}
			else
			{
				System.out.println(numberofNotesToBeDispatched + " ,Twenty Rs note is dispatched by TwentyRsHandler\n");

			}
		}

		long pendingAmountToBeProcessed = requestedAmount % 20;

		if (pendingAmountToBeProcessed > 0)
		{
			rsHandler.dispatchRs(pendingAmountToBeProcessed);

		}

	}
}




class FiveRsHandler extends RsHandler
{
	public void dispatchRs(long requestedAmount)
	{
		long numberofNotesToBeDispatched = requestedAmount / 5;
		if (numberofNotesToBeDispatched > 0)
		{

			if (numberofNotesToBeDispatched > 1)
			{
				System.out.println(numberofNotesToBeDispatched + " ,Five Rs notes are dispatched by FiveRsHandler\n");
			}
			else
			{
				System.out.println(numberofNotesToBeDispatched + " ,Five Rs note is dispatched by FiveRsHandler\n");

			}
		}

		long pendingAmountToBeProcessed = requestedAmount % 5;

		if (pendingAmountToBeProcessed > 0)
		{
			rsHandler.dispatchRs(pendingAmountToBeProcessed);

		}

	}
}




class ATM
{
	private static HundredRsHandler hundredRsHandler = new HundredRsHandler();
	private static FiftyRsHandler   fiftyRsHandler   = new FiftyRsHandler();
	private static TwentyRsHandler  twentyRsHandler  = new TwentyRsHandler();
	private static FiveRsHandler    fiveRsHandler    = new FiveRsHandler();

	static
	{
		// Prepare the chain of Handlers
		hundredRsHandler.nextHandler(fiftyRsHandler);
		fiftyRsHandler.nextHandler(twentyRsHandler);
		twentyRsHandler.nextHandler(fiveRsHandler);
	}

	public void withdraw( long requestedAmount )
	{

		hundredRsHandler.dispatchRs(requestedAmount);
	}
}




public class ChainOfResDemo
{

	public static void main( String[] args )
	{
		ATM atm = new ATM();

		System.out.println("\n ----------------Requested Amount 475-----------------------\n");

		atm.withdraw(475);


		System.out.println("\n ----------------Requested Amount 455-----------------------\n");

		atm.withdraw(455);


		System.out.println("\n ----------------Requested Amount 520-----------------------\n");

		atm.withdraw(520); 


	}

}

