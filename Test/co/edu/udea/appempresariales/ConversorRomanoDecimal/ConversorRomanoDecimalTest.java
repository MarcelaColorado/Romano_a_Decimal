package co.edu.udea.appempresariales.ConversorRomanoDecimal;

import static org.junit.Assert.*;

import java.util.Hashtable;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

public class ConversorRomanoDecimalTest 
{
	ConversorRomanoDecimal crd;
	int numeroDecimal;

	@Before
	public void setUp() throws Exception
	{
		crd = new ConversorRomanoDecimal();
		crd.llenarHashtable();
	}
	
	@Test
	public void prueba_llenarHashtable()
	{
		Hashtable ht;
		ht = crd.llenarHashtable();
		System.out.println(ht);
		Assert.assertEquals("{L=50, V=5, I=1, D=500, C=100, M=1000, X=10}", ht.toString());
	}

	@Test
	public void prueba_romanoUnaLetraMayuscula() 
	{
		numeroDecimal = crd.convertir("X");
		Assert.assertEquals(10, numeroDecimal);
	}
	
	@Test
	public void prueba_romanoUnaLetraMinuscula() 
	{
		numeroDecimal = crd.convertir("i");
		Assert.assertEquals(1, numeroDecimal);
	}
	
	@Test
	public void prueba_romanoDosLetras() 
	{
		numeroDecimal = crd.convertir("xL");
		Assert.assertEquals(40, numeroDecimal);
	}
	
	@Test
	public void prueba_romanoTresLetras() 
	{
		numeroDecimal = crd.convertir("XIV");
		Assert.assertEquals(14, numeroDecimal);
	}
	
	@Test
	public void prueba_romanoCuatroLetras() 
	{
		numeroDecimal = crd.convertir("XLIX");
		Assert.assertEquals(49, numeroDecimal);
	}
	
	@Test
	public void prueba_romanoCincoLetras()
	{
		numeroDecimal = crd.convertir("MMXIV");
		Assert.assertEquals(2014, numeroDecimal);
	}
	
	//@Test
	public void prueba_romanoNoPermitido() 
	{
		numeroDecimal = crd.convertir("IL");
		Assert.assertEquals(0, numeroDecimal);
	}
	
	@Test
	public void prueba_noEsRomano() 
	{
		numeroDecimal = crd.convertir("Xa");
		Assert.assertEquals(0, numeroDecimal);
	}
	
	@Test
	public void prueba_noEsRomano_Numeros() 
	{
		numeroDecimal = crd.convertir("12");
		Assert.assertEquals(0, numeroDecimal);
	}
	
	@Test
	public void prueba_noEsRomano_CaracteresEspeciales() 
	{
		numeroDecimal = crd.convertir("#$%");
		Assert.assertEquals(0, numeroDecimal);
	}
	
	@Test
	public void prueba_noEsRomano_Vacio() 
	{
		numeroDecimal = crd.convertir("");
		Assert.assertEquals(0, numeroDecimal);
	}
	
	@Test
	public void prueba_noEsRomano_Espacios() 
	{
		numeroDecimal = crd.convertir(" ");
		Assert.assertEquals(0, numeroDecimal);
	}
	
	@Test
	public void prueba_noEsRomano_EspaciosLetras() 
	{
		numeroDecimal = crd.convertir(" XI ");
		Assert.assertEquals(11, numeroDecimal);
	}
	
	@Test
	public void prueba_noEsRomano_LetrasConEspacios() 
	{
		numeroDecimal = crd.convertir("C D");
		Assert.assertEquals(400, numeroDecimal);
	}
}
