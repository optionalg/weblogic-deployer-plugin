/**
 * 
 */
package org.jenkinsci.plugins.deploy.weblogic.util;

import java.io.File;
import java.io.FileInputStream;

import jenkins.model.Jenkins;
import junit.framework.Assert;

import org.jenkinsci.plugins.deploy.weblogic.configuration.WeblogicDeploymentConfiguration;
import org.jenkinsci.plugins.deploy.weblogic.data.WeblogicEnvironment;
import org.junit.Test;


/**
 * @author rchaumie
 *
 */
public class XStreamTestCase {

	
	
	
	  /**
	   * 
	   */
	  @Test public void testObjectConvert() {
		  	WeblogicDeploymentConfiguration a = new WeblogicDeploymentConfiguration(new WeblogicEnvironment("sdg","sdg","sdg","sdg","sg"), new WeblogicEnvironment("sdg2","sdg2","sdg2","sdg2","sg2"));
			String xml = Jenkins.XSTREAM2.toXML(a);
	    	System.out.println(xml + "\n"); // for debugging
	    	WeblogicDeploymentConfiguration actual = (WeblogicDeploymentConfiguration) Jenkins.XSTREAM2.fromXML(xml);
	    	Assert.assertEquals(2, actual.getWeblogicEnvironments().length);
	  }
	  
	  /**
	   * 
	   * @throws Exception
	   */
	  @Test public void testFileConfigurationMarsahlling() throws Exception {
		  	WeblogicDeploymentConfiguration actual = (WeblogicDeploymentConfiguration) Jenkins.XSTREAM2.fromXML(new FileInputStream(new File(System.getProperty("user.dir")+"/src/test/resources/default.xml")));
		  	Assert.assertEquals(6, actual.getWeblogicEnvironments().length);
	  }
}
