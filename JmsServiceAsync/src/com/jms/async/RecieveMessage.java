package com.jms.async;

import java.util.Properties;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.log4j.BasicConfigurator;

public class RecieveMessage{

	public RecieveMessage() throws NamingException, JMSException{
		
		Properties props = new Properties();
		props.setProperty(Context.INITIAL_CONTEXT_FACTORY, "org.apache.activemq.jndi.ActiveMQInitialContextFactory");
		props.setProperty(Context.PROVIDER_URL, ActiveMQConnection.DEFAULT_BROKER_URL);
		
		InitialContext context = new InitialContext(props);
		ConnectionFactory cf = new ActiveMQConnectionFactory(ActiveMQConnection.DEFAULT_BROKER_URL);
		Connection connection = cf.createConnection();
		
		try {
			
			Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			Destination destination = session.createQueue("messageQueue");
			MessageConsumer consumer = session.createConsumer(destination);
			MyListener listener = new MyListener();
			consumer.setMessageListener(listener);
			connection.start();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		BasicConfigurator.configure();
		try {
			new RecieveMessage();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
