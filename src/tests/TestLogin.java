package tests;

import junit.framework.*;

public class TestLogin extends TestCase{
	String username;
	String password;
	
	protected void setUp() throws Exception {
		username="AngelaVec94";
		password="AngelaVec94";
	}
	
	protected void tearDown() throws Exception {
		username="";
		password="";
	}
	
	public void testUsername(){
		assertTrue(username.length()>=3);
		assertTrue(username.length()<=20);
		assertTrue(username.matches("^(?=.{3,20}$)(?![_.])(?!.*[_.]{2})[a-zA-Z0-9._-]+(?<![_.])$"));
	}
	
	public void testPassword(){
		assertTrue(password.length()>=8);
		assertTrue(password.length()<=30);
		assertTrue(password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])[A-Za-z0-9$@$!%*?&]{8,30}"));
	}
	
	public static Test suite(){
		return new TestSuite(TestLogin.class);
	}
	
	public static void main(String[] args) {
		junit.textui.TestRunner.run(suite());
	}
}
