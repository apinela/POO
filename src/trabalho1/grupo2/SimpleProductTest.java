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
package trabalho1.grupo2;

import org.junit.Test;

import trabalho1.grupo1.Date;

public class SimpleProductTest {

	@Test
	public final void testSimpleProduct() {
		SimpleProduct vAcores = new SimpleProduct("Açores",
				new Date(2012, 3, 1), new Date(2012, 3, 14), 700);
		SimpleProduct vMadeira = new SimpleProduct("Madeira", new Date(2012, 3,
				15), 7, 75);
		System.out.println(vAcores);
		System.out.println(vMadeira);
	}

}
