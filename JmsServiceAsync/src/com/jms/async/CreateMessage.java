package com.jms.async;

import java.util.Properties;
import java.util.Scanner;

import javax.jms.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.log4j.BasicConfigurator;

public class CreateMessage {
	
	public CreateMessage() throws NamingException, JMSException {
		Properties props = new Properties();
		props.setProperty(Context.INITIAL_CONTEXT_FACTORY, "org.apache.activemq.jndi.ActiveMQInitialContextFactory");
		props.setProperty(Context.PROVIDER_URL, ActiveMQConnection.DEFAULT_BROKER_URL);
		
		InitialContext in = new InitialContext(props);
		
		ConnectionFactory cf = new ActiveMQConnectionFactory(ActiveMQConnection.DEFAULT_BROKER_URL);
		Connection conn = cf.createConnection();
		Scanner input = new Scanner(System.in);
		System.out.print("Enter your Message: ");
		String message = input.nextLine();
		Session session=null;
		try {
			conn.start();
			session = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);
			Destination destination = session.createQueue("messageQueue");
			MessageProducer producer = session.createProducer(destination);
			TextMessage text = session.createTextMessage(message);
			producer.send(text);
			System.out.println("Sent Message: " + message);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	public static void main(String[] args) throws NamingException, JMSException {
		BasicConfigurator.configure();
		try {
			new CreateMessage();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
