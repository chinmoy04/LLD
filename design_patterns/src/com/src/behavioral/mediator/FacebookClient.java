package com.src.behavioral.mediator;


import java.util.ArrayList;
import java.util.List;


interface FacebookGroupMediator
{

	public void sendMessage( String msg, User user );

	void registerUser( User user );
}



class FacebookGroupMediatorImpl implements FacebookGroupMediator
{

	private List<User> users;

	public FacebookGroupMediatorImpl()
	{
		this.users = new ArrayList<User>();
	}

	@Override
	public void registerUser( User user )
	{
		this.users.add(user);
	}

	@Override
	public void sendMessage( String msg, User user )
	{
		for( User u : this.users )
		{
			// message should not be received by the user sending it
			if( u != user )
			{
				u.receive(msg);
			}
		}
	}

}



abstract class User
{
	protected FacebookGroupMediator mediator;
	protected String       name;

	public User( FacebookGroupMediator mediator, String name )
	{
		this.mediator = mediator;
		this.name = name;
	}

	public abstract void send( String msg );

	public abstract void receive( String msg );
}



class UserImpl extends User
{

	public UserImpl( FacebookGroupMediator mediator, String name )
	{
		super(mediator, name);
	}

	@Override
	public void send( String msg )
	{
		System.out.println(this.name + ": Sending Message=" + msg+"\n");
		mediator.sendMessage(msg, this);
	}

	@Override
	public void receive( String msg )
	{
		System.out.println(this.name + ": Received Message:" + msg);
	}

}



public class FacebookClient
{

	public static void main( String[] args )
	{
		FacebookGroupMediator facebookMediator = new FacebookGroupMediatorImpl();
		User dave = new UserImpl(facebookMediator, "Dave");
		User ram = new UserImpl(facebookMediator, "Ram");
		User raj = new UserImpl(facebookMediator, "Raj");
		User anu = new UserImpl(facebookMediator, "Anu");
		User rahul = new UserImpl(facebookMediator, "Rahul");
		User steve = new UserImpl(facebookMediator, "Steve");
		User raju = new UserImpl(facebookMediator, "Raju");


		facebookMediator.registerUser(dave);
		facebookMediator.registerUser(ram);
		facebookMediator.registerUser(raj);
		facebookMediator.registerUser(anu);
		facebookMediator.registerUser(rahul);
		facebookMediator.registerUser(steve);
		facebookMediator.registerUser(raju);

		dave.send("ramj2ee.blogspot.com - this blog is very good blog ");

		System.out.println("##############################################################################");

		ram.send("what is Design Patterns? Please explain ");

	}

}

