package com.jms.service.apachemq;

import java.util.Properties;
import java.util.Scanner;

import javax.jms.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.activemq.ActiveMQConnection;
import org.apache.log4j.BasicConfigurator;

public class ProduceMessage {
	
	String textMessage;
	
	public ProduceMessage() throws JMSException, NamingException, RuntimeException{
		Properties props = new Properties();
		props.setProperty(Context.INITIAL_CONTEXT_FACTORY,"org.apache.activemq.jndi.ActiveMQInitialContextFactory");
		props.setProperty(Context.PROVIDER_URL,ActiveMQConnection.DEFAULT_BROKER_URL);
		
		InitialContext jndi = new InitialContext(props);
		Connection connection; 
		ConnectionFactory connFactory = (ConnectionFactory) jndi.lookup("ConnectionFactory");
		connection = connFactory.createConnection();
		Scanner in = new Scanner(System.in);
		System.out.print("Please enter your message: ");
		String message = in.nextLine();
		if(message.length()==0) {
			throw new RuntimeException("Length cannot be null!");
		}
		
		try {
			connection.start();
			
			Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			Destination destination = session.createQueue("viditqueue");
			
			MessageProducer producer = session.createProducer(destination);
			
				TextMessage text = session.createTextMessage(message);
				
				producer.send(text);
				System.out.println("Sent message: " + text.getText());
				textMessage = text.getText();
			
		}finally {
			connection.close();
		}
	}
	
	public String getMessage() {
		return textMessage;
	}
	
	public static void main(String[] args) throws JMSException, NamingException{
		try 
		{
			 BasicConfigurator.configure();
			 new ProduceMessage();
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
