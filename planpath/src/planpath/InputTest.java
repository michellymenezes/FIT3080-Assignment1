package planpath;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class InputTest {
	
	Input myInput;
	ArrayList<String[]> lista = new ArrayList<String[]>();
	
	@Before
	public void first(){
		try{
			myInput = new Input();
			}
		catch(Exception e){
			
		}
		lista.add(new String[4]);
		lista.add(new String[4]);
		lista.add(new String[4]);
		lista.add(new String[4]);
/*		lista.get(0)[0] = "S";
		lista.get(0)[1] = "A";
		lista.get(0)[2] = "A";
		lista.get(0)[3] = "X";
		lista.get(1)[0] = "G";
		lista.get(1)[1] = "X";
		lista.get(1)[2] = "X";
		lista.get(1)[3] = "X";
		lista.get(2)[0] = "X";
		lista.get(2)[1] = "X";
		lista.get(2)[2] = "X";
		lista.get(2)[3] = "X";
		lista.get(3)[0] = "X";
		lista.get(3)[1] = "X";
		lista.get(3)[2] = "X";
		lista.get(3)[3] = "X"; */

	}
	@Test
	public void test() {
		assertEquals("4", myInput.getAlg());
		assertEquals(4, myInput.getInt());
		assertEquals(4, myInput.getSize());
/*		assertArrayEquals(lista.get(0), myInput.getMap().get(0));
		assertArrayEquals(lista.get(1), myInput.getMap().get(1));
		assertArrayEquals(lista.get(2), myInput.getMap().get(2));
		assertArrayEquals(lista.get(3), myInput.getMap().get(3)); */
	}
}
