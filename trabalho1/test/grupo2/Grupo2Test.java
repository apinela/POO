/*******************************************************************************
 * Copyright (c) 2013 André Pinela - ISEL Student 38603.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/gpl.html
 * 
 * Contributors:
 *     André Pinela - ISEL Student 38603 - initial API and implementation
 ******************************************************************************/
package grupo2;

import static org.junit.Assert.fail;
import grupo1.Date;

import org.junit.Test;

public class Grupo2Test {
	
	@Test
	public final void testSimpleProduct() {
		SimpleProduct vAcores = new SimpleProduct("Açores",
				new Date(2012, 3, 1), new Date(2012, 3, 14), 700);
		SimpleProduct vMadeira = new SimpleProduct("Madeira", new Date(2012, 3,
				15), 7, 75);
		System.out.println(vAcores);
		System.out.println(vMadeira);
	}

	@Test
	public final void testProgram() {
		try {
			SimpleProduct vLisboa = new SimpleProduct("Lisboa", new Date(2012,
					3, 23), new Date(2012, 3, 30), 600);
			SimpleProduct vAcores = new SimpleProduct("Açores", new Date(2012,
					3, 1), new Date(2012, 3, 14), 700);
			SimpleProduct vMadeira = new SimpleProduct("Madeira", new Date(
					2012, 3, 15), 7, 75);

			Program pDAM = new Program("Descubra os Açores e a Madeira", 2,
					vAcores);
			pDAM.addProduct(vMadeira);
			Program pPI = new Program("Portugal e ilhas", 2, pDAM);
			pPI.addProduct(vLisboa);

			System.out.println(pPI);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

}
