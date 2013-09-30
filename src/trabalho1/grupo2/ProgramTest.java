package trabalho1.grupo2;

import static org.junit.Assert.*;

import org.junit.Test;

import trabalho1.grupo1.Date;

public class ProgramTest {

	@Test
	public final void testProgram() {
		SimpleProduct vLisboa = new SimpleProduct("Lisboa",
				new Date(2012, 3, 23), new Date(2012, 3, 30), 600);
		SimpleProduct vAcores = new SimpleProduct("Açores",
				new Date(2012, 3, 1), new Date(2012, 3, 14), 700);
		SimpleProduct vMadeira = new SimpleProduct("Madeira", new Date(2012, 3,
				15), 7, 75);
		
		Program pDAM = new Program("Descubra os Açores e a Madeira",2,vAcores);
		pDAM.addProduct(vMadeira);
		Program pPI = new Program("Portugal e ilhas",2,pDAM);
		pPI.addProduct(vLisboa);
		
		System.out.println(pPI);
	}

}

