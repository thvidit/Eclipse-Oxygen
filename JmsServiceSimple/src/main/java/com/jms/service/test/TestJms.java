package com.jms.service.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.jms.service.apachemq.ConsumeMessage;
import com.jms.service.apachemq.ProduceMessage;

public class TestJms {
	
	@Test
	public void checkFunction() throws Exception {
		
		ProduceMessage pm = new ProduceMessage();
		ConsumeMessage cm = new ConsumeMessage();
		
		assertEquals(pm.getMessage(), cm.getMessage());
	}

}
