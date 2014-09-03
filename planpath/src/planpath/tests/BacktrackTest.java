package planpath.tests;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import planpath.Backtrack;
import planpath.Input;

public class BacktrackTest {

	Backtrack A, B,C, D, E, F, G;
	ArrayList<String> a, b, c, d, e, f, g;
	Input one, two, three, four, five, six, seven;
	
	@Before
	public void preparation1(){
		
		a = new ArrayList<String>();
		a.add("S");
		a.add("R");
		a.add("R");
		a.add("R");
		a.add("G");
		try {
			one = new Input("tests/teste1.txt");
			A = new Backtrack(one.getSize(), one.getMapB());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void test1() {
		Assert.assertEquals(a, A.backtrack());
	} 
	
	@Before
	public void preparation2(){
		
		b = new ArrayList<String>();
		b.add("S");
		b.add("R");
		b.add("R");
		b.add("D");
		b.add("G");
		try {
			two = new Input("tests/teste2.txt");
			B = new Backtrack(two.getSize(), two.getMapB());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void test2() {
		Assert.assertEquals(b, B.backtrack());
	}  
	
	@Before
	public void preparation3(){
		
		c = new ArrayList<String>();
		c.add("S");
		c.add("R");
		c.add("G");
		try {
			three = new Input("tests/teste3.txt");
			C = new Backtrack(three.getSize(), three.getMapB());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void test3() {
		Assert.assertEquals(c, C.backtrack());
	} 
	
	@Before
	public void preparation4(){
		
		d = new ArrayList<String>();
		d.add("S");
		d.add("R");
		d.add("R");
		d.add("D");
		d.add("R");
		d.add("G");
		try {
			four = new Input("tests/teste4.txt");
			D = new Backtrack(four.getSize(), four.getMapB());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void test4() {
		Assert.assertEquals(d, D.backtrack());
	} 
	
	@Before
	public void preparation5(){
		
		e = new ArrayList<String>();
		e.add("S");
		e.add("D");
		e.add("D");
		e.add("D");
		e.add("G");
		try {
			five = new Input("tests/teste5.txt");
			E = new Backtrack(five.getSize(), five.getMapB());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void test5() {
		Assert.assertEquals(e, E.backtrack());
	}
	
	@Before
	public void preparation6(){
		
		f = new ArrayList<String>();
		f.add("S");
		f.add("D");
		f.add("D");
		f.add("R");
		f.add("D");
		f.add("L");
		f.add("G");
		try {
			six = new Input("tests/teste6.txt");
			F = new Backtrack(six.getSize(), six.getMapB());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void test6() {
		Assert.assertEquals(f, F.backtrack());
	}
	
	@Before
	public void preparation7(){
		try{
			seven = new Input("tests/teste7.txt");
			G = new Backtrack(seven.getSize(), seven.getMapB());
		} catch(Exception e){
			// TODO Auto-generated catch block
			e.printStackTrace();	
		}
	}
	@Test
	public void test7(){
		Assert.assertNull(G.backtrack());
	}
}
