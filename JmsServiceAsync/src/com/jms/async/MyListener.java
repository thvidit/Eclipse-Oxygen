package com.jms.async;

import javax.jms.*;

public class MyListener implements MessageListener{

	@Override
	 public void onMessage(Message message) {  
        try{  	
        	TextMessage msg = (TextMessage) message;  
        	System.out.println("Recieved Message: " + msg.getText());  
        }catch(JMSException e){
        	System.out.println(e);
        }  
    }  

}
