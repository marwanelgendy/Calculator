package eg.edu.alexu.csd.oop.test.calculator.cs63;

import java.util.List;

import eg.edu.alexu.csd.oop.calculator.cs63.Calculator;
import org.junit.Assert;




public class IntegrationTest {
    
    private final Class<?> interfaceToTest = Calculator.class ;
    
    
    @org.junit.Test
    public void testCreation() {	
    	List<Class<?>> candidateClasses = ReflectionHelper.findClassesImpmenenting(interfaceToTest, interfaceToTest.getPackage());
  
    	Assert.assertNotNull("Failed to create instance using interfcae '" + interfaceToTest.getName() + "' !", candidateClasses);
    	Assert.assertEquals("You have more than one public implementation of the interface",1,candidateClasses.size());
    	
    
    }

}