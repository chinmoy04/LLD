package com.src.structural.bridge;

import java.util.Scanner;

interface MessageSender
{
public void sendMessage(String message);
}

class SmsMessageSender implements MessageSender
{
public void sendMessage(String message)
{
System.out.println("'"+message+ "'   : This Message has been sent using SMS");
}
}

class EmailMessageSender implements MessageSender
{
public void sendMessage(String message)
{
System.out.println("'"+message+ "'   : This Message has been sent using Email");
}
}



abstract class Message
{
protected MessageSender messageSender;

abstract public void sendMessage(String message);

}

class ShortMessage extends Message
{
public ShortMessage(MessageSender messageSender)
{
super.messageSender = messageSender;
}

@Override
public void sendMessage(String message)
{
if(message.length()<=5)
{
messageSender.sendMessage(message);
}
else
{
System.out.println("Sorry cannot send the message.....");
}
}

}


class LongMessage extends Message
{

public LongMessage(MessageSender messageSender)
{
super.messageSender = messageSender;
}

@Override
public void sendMessage(String message)
{
messageSender.sendMessage(message);
}

}


public class Client
{

public static void main(String[] args)
{

System.out.println("Do you want to send 'longmessage' or 'shortmessage' ?");
Scanner scanner = new Scanner(System.in);
String messageType = scanner.next();

System.out.println("Please enter the message you want to send");
Scanner scanner1 = new Scanner(System.in);
String message = scanner1.nextLine();

if (messageType.equalsIgnoreCase("longmessage"))
{
Message longMessage = new LongMessage(new EmailMessageSender());
longMessage.sendMessage(message);
}
else
{
Message shortMessage = new ShortMessage(new SmsMessageSender());
shortMessage.sendMessage(message);
}

}
}
