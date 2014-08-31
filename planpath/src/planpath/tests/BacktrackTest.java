package planpath.tests;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import planpath.Backtrack;

public class BacktrackTest {

	Backtrack A, B,C, D, E, F;
	ArrayList<String> a, b, c, d, e, f;
	
	@Before
	public void preparation1(){
		
		a = new ArrayList<String>();
		a.add("S");
		a.add("R");
		a.add("R");
		a.add("R");
		a.add("G");
		try {
			A = new Backtrack("tests/teste1.txt");
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
			B = new Backtrack("tests/teste2.txt");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void test2() {
		System.out.println(b);
		Assert.assertEquals(b, B.backtrack());
	} 
	
	@Before
	public void preparation3(){
		
		c = new ArrayList<String>();
		c.add("S");
		c.add("R");
		c.add("G");
		try {
			C = new Backtrack("tests/teste3.txt");
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
			D = new Backtrack("tests/teste4.txt");
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
			E = new Backtrack("tests/teste5.txt");
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
			F = new Backtrack("tests/teste6.txt");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void test6() {
		Assert.assertEquals(f, F.backtrack());
	}

}
