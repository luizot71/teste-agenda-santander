package com.br.api.agenda.junit;

import org.junit.Assert;
import org.junit.Test;
 
public class TesteConfiguracaoJUnit {
 
	@Test
	public void testeConfiguracao(){
		Assert.assertEquals(2, (1+1), 0);
	}
}