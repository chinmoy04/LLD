package com.src.structural.proxy;


class User
{

	private String userName;
	private String passWord;
	private String designation;

	public User(String userName, String passWord, String designation)
	{
		super();
		this.userName = userName;
		this.passWord = passWord;
		this.designation = designation;
	}

	public String getUserName()
	{
		return userName;
	}

	public void setUserName(String userName)
	{
		this.userName = userName;
	}

	public String getPassWord()
	{
		return passWord;
	}

	public void setPassWord(String passWord)
	{
		this.passWord = passWord;
	}

	public String getDesignation()
	{
		return designation;
	}

	public void setDesignation(String designation)
	{
		this.designation = designation;
	}

	@Override
	public String toString()
	{
		return "User [userName=" + userName + ", passWord=" + passWord + ", designation=" + designation + "]";
	}

}


interface IFolder
{
	public void performReadOrWriteOperations();
}



class Folder implements IFolder
{

	@Override
	public void performReadOrWriteOperations()
	{
		System.out.println(this.getClass()+" : Performing read or write operation on the folder");          
	}
}


class FolderProxy implements IFolder
{
	private Folder folder;
	private User   user;

	public FolderProxy( User user )
	{
		this.user = user;
	}

	@Override
	public void performReadOrWriteOperations()
	{

		if( user.getDesignation().equalsIgnoreCase("CEO") || user.getDesignation().equalsIgnoreCase("Manager") )
		{
			folder = new Folder();
			System.out.println(this.getClass()+" : Folder Proxy makes call to the RealFolder 'performReadOrWriteOperations method'");
			folder.performReadOrWriteOperations();
		}
		else
		{
			System.out.println(this.getClass()+": Folder proxy says 'You don't have access to this folder'");
		}

	}

}

public class Client
{
	public static void main( String[] args )
	{
		new Client().folderAccess();
	}

	private void folderAccess()
	{
		System.out.println(this.getClass()+" : Client passing user with designation 'CEO' to folderproxy");
		User john = new User("John", "John123","CEO");
		FolderProxy folderProxy = new FolderProxy(john);
		folderProxy.performReadOrWriteOperations();
		System.out.println("\n************************************************************           ***********************\n");
		System.out.println(this.getClass()+" : Client passing user with designation 'Developer' to folderproxy");
		User raj = new User("Raj", "Raj123","Developer");
		FolderProxy folderProxyWrong = new FolderProxy(raj);
		folderProxyWrong.performReadOrWriteOperations();

	}

}
