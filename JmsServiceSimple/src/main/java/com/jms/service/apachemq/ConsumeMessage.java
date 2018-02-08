package com.jms.service.apachemq;

import java.io.BufferedReader;
import java.util.Properties;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.log4j.BasicConfigurator;

public class ConsumeMessage {
	
	String recievedText;
	
	private static String subject = "viditqueue";
	
	public ConsumeMessage()  throws JMSException, NamingException {
		 Properties props = new Properties();
			props.setProperty(Context.INITIAL_CONTEXT_FACTORY,"org.apache.activemq.jndi.ActiveMQInitialContextFactory");
			props.setProperty(Context.PROVIDER_URL,ActiveMQConnection.DEFAULT_BROKER_URL);
			
			InitialContext jndi = new InitialContext(props);
		  
		  ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(ActiveMQConnection.DEFAULT_BROKER_URL);
		  Connection connection = connectionFactory.createConnection();
		  connection.start();
		  
		  Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		 
		  Destination destination = session.createQueue(subject);
		
		  MessageConsumer consumer = session.createConsumer(destination);
		  
		  
		  Message message = consumer.receive();
		  if (message instanceof TextMessage) {
			   TextMessage textMessage = (TextMessage) message;
			   try {
				System.out.println("Your friend sent this message'" + textMessage.getText() + "'");
				recievedText = textMessage.getText();
			   }catch(Exception e) {
				   e.printStackTrace();
			   }finally {
				connection.close();
			}
		}
	}
	
	 public static void main(String[] args) throws JMSException, NamingException {
		 try 
			{
				 BasicConfigurator.configure();
				 new ConsumeMessage();
				
			}catch(Exception e){
				e.printStackTrace();
			}
	  
	 
	 }
	 
	 
	
	 public String getMessage() {
			return recievedText;
}
	}