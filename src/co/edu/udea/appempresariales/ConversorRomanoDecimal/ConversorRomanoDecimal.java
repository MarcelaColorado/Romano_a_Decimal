package co.edu.udea.appempresariales.ConversorRomanoDecimal;

import java.util.Hashtable;

public class ConversorRomanoDecimal 
{
	Hashtable <String, Integer> numerosRomanos = new Hashtable <String, Integer>();
	int tamRomano = 0;	//Longitud de la cadena ingresada como número romano para la conversión a decimal
	
	/*
	 * Método para llenar el hashtable con los números romanos básicos
	 * 
	 * @return numerosRomanos: hashtable que contiene los números romanos básicos asociados a su valor en decimal
	 */
	public Hashtable llenarHashtable()
	{
		numerosRomanos.put("I", 1);
		numerosRomanos.put("V", 5);
		numerosRomanos.put("X", 10);
		numerosRomanos.put("L", 50);
		numerosRomanos.put("C", 100);
		numerosRomanos.put("D", 500);
		numerosRomanos.put("M", 1000);
		
		return numerosRomanos;	//Hashtable lleno
	}
	
	/*
	 * Método para llevar a cabo la conversión de números romano a decimal
	 * 
	 * @param entrada: cadena que contiene el número romano que se quiere convertir a decimal
	 * 
	 * @return decimal: corresponde al numero equivalente en decimal del número romano ingresado como parámetro
	 */
	public int convertir(String entrada)
	{
		String romano = entrada.trim();	//elimina los espacios en blanco al inicio y al final de la cadena
		tamRomano = romano.length();	//tamaño de la cadena ingresada como parámetro
		
		int decimal = 0;	//variable de retorno
		String resultado;	//String con el mensaje que se le mostrará al usuario
		int valor = 0;	//equivalente en decimal a una letra determinada del número romano pasado como parámetro
		char letra;	//uno de los caracteres que componen la cadena ingresada como parámetro
		boolean esta;	//almacena el resultado de búsqueda de 'letra' en el hashtable de números romanos
		int anterior = 0;	//almacena el valor anterior al evaluado en el ciclo
				
		
		for(int i = 0; i< tamRomano; i++)	//Se recorre la cadena ingresada como parámetro
		{
			letra = romano.charAt(i);	//toma el caracter en la posición i de la cadena
			
			if(Character.isWhitespace(letra))	//verifica si el caracter es un espacio en blanco
			{
				continue;				
			}
			
			//se busca la letra en el hashtable de números romanos
			esta = numerosRomanos.containsKey(Character.toString(letra).toUpperCase());
			
			if(esta)	//si la letra corresponde a un número romano básico
			{
				//se obtiene el equivalente de la letra en decimal
				valor = numerosRomanos.get(Character.toString(letra).toUpperCase());
				decimal = decimal + valor;
				
				//se calcula el valor en decimal para el número romano pasado como parámetro
				if(anterior < valor)
				{
					decimal = decimal - anterior*2;
					anterior = valor;
				}
				else
				{
					anterior = valor;
				}					
			}
			
			else decimal = 0;
		}
		
		if(decimal != 0)
		{
			resultado = "El número " + romano + " en decimal es: "+ decimal;
			System.out.println(resultado);
			return (decimal);
		}
		
		else
		{
			resultado = "La secuencia '" + entrada + "' no corresponde a un número romano";
			System.out.println(resultado);
			return decimal;
		}
	}
}

