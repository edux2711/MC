import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MessageUtilTest {

	   String message = "Hello World!!";	
	   MessageUtil messageUtil = new MessageUtil(message);

	   @Test
	   public void testPrintMessage() {
	      assertEquals(message,messageUtil.printMessage());
	   }
}
