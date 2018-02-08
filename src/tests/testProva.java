package tests;
import java.util.*;
import junit.framework.*;

public class testProva extends TestCase{
	public testProva(String nome){
		super(nome);
	}
	
	public void testVoidCollection(){
		Collection collection=new ArrayList();
		assertTrue(collection.isEmpty());
	}
	
	public void testACaso(){
		
	}
	
	public static Test suite(){
		return new TestSuite(testProva.class);
	}
	
	public static void main(String[] args) {
		junit.textui.TestRunner.run(suite());
	}
}
