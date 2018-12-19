package Soap;

import java.io.IOException;

import org.apache.xmlbeans.XmlException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.eviware.soapui.impl.wsdl.WsdlProject;
import com.eviware.soapui.impl.wsdl.WsdlTestSuite;
import com.eviware.soapui.impl.wsdl.testcase.WsdlTestCase;
import com.eviware.soapui.model.support.PropertiesMap;
import com.eviware.soapui.model.testsuite.TestRunner;
import com.eviware.soapui.model.testsuite.TestRunner.Status;
import com.eviware.soapui.support.SoapUIException;

public class testRunner2 {
  @Test
  public void SoapTest1() {
	  
	  //Grab the project
	  WsdlProject project = null;
	try {
		project = new WsdlProject("C:\\Soap Ui information\\libraryapiandemployee_xml\\Employee.xml");
	} catch (XmlException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SoapUIException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  //Grabbing the test suite in the project
	  WsdlTestSuite testsuite = project.getTestSuiteByName("Testing");
	  
	  //Grabbing the test cases present in the test suite
		  WsdlTestCase testCase = testsuite.getTestCaseByName("GetEmployee");
		  //Run the test case
		  TestRunner runner = testCase.run(new PropertiesMap(), false);
		  Assert.assertEquals(Status.FINISHED, runner.getStatus());

	  
  }
}
