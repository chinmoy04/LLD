package com.src.behavioral.command;

class WordDocument
{
	public void open()
	{
		System.out.println("Document Opened");
	}

	public void save()
	{
		System.out.println("Document Saved");
	}

	public void close()
	{
		System.out.println("Document Closed");
	}

}



interface Command
{
	public void execute();
}



class OpenCommand implements Command
{
	private WordDocument wordDocument;

	public OpenCommand( WordDocument wordDocument )
	{
		this.wordDocument = wordDocument;
	}

	@Override
	public void execute()
	{
		wordDocument.open();
	}
}



class SaveCommand implements Command
{

	private WordDocument wordDocument;

	public SaveCommand( WordDocument wordDocument )
	{
		this.wordDocument = wordDocument;
	}

	@Override
	public void execute()
	{
		wordDocument.save();
	}
}




class CloseCommand implements Command
{
	private WordDocument wordDocument;

	public CloseCommand( WordDocument wordDocument )
	{
		this.wordDocument = wordDocument;
	}

	@Override
	public void execute()
	{
		wordDocument.close();
	}
}




/*
 *  Invoker
 */

class MenuOptions
{
	private Command openCommand;
	private Command saveCommand;
	private Command closeCommand;

	public MenuOptions( Command open, Command save, Command close )
	{
		this.openCommand = open;
		this.saveCommand = save;
		this.closeCommand = close;
	}

	public void clickOpen()
	{
		openCommand.execute();
	}

	public void clickSave()
	{
		saveCommand.execute();
	}

	public void clickClose()
	{
		closeCommand.execute();
	}
}



public class Client
{
	public static void main( String[] args )
	{
		WordDocument wordDocument = new WordDocument();
		Command openCommand = new OpenCommand(wordDocument);
		Command saveCommand = new SaveCommand(wordDocument);
		Command closeCommand = new CloseCommand(wordDocument);
		MenuOptions menu = new MenuOptions(openCommand, saveCommand, closeCommand);
		menu.clickOpen();
		menu.clickSave();
		menu.clickClose();
	}

}

