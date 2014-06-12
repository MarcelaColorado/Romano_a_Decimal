package co.edu.udea.appempresariales.ConversorRomanoDecimal;

import java.util.Hashtable;

public class ConversorRomanoDecimal 
{
	Hashtable <String, Integer> numerosRomanos = new Hashtable <String, Integer>();
	int tamRomano = 0;	//Longitud de la cadena ingresada como n�mero romano para la conversi�n a decimal
	
	/*
	 * M�todo para llenar el hashtable con los n�meros romanos b�sicos
	 * 
	 * @return numerosRomanos: hashtable que contiene los n�meros romanos b�sicos asociados a su valor en decimal
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
	 * M�todo para llevar a cabo la conversi�n de n�meros romano a decimal
	 * 
	 * @param entrada: cadena que contiene el n�mero romano que se quiere convertir a decimal
	 * 
	 * @return decimal: corresponde al numero equivalente en decimal del n�mero romano ingresado como par�metro
	 */
	public int convertir(String entrada)
	{
		String romano = entrada.trim();	//elimina los espacios en blanco al inicio y al final de la cadena
		tamRomano = romano.length();	//tama�o de la cadena ingresada como par�metro
		
		int decimal = 0;	//variable de retorno
		String resultado;	//String con el mensaje que se le mostrar� al usuario
		int valor = 0;	//equivalente en decimal a una letra determinada del n�mero romano pasado como par�metro
		char letra;	//uno de los caracteres que componen la cadena ingresada como par�metro
		boolean esta;	//almacena el resultado de b�squeda de 'letra' en el hashtable de n�meros romanos
		int anterior = 0;	//almacena el valor anterior al evaluado en el ciclo
				
		
		for(int i = 0; i< tamRomano; i++)	//Se recorre la cadena ingresada como par�metro
		{
			letra = romano.charAt(i);	//toma el caracter en la posici�n i de la cadena
			
			if(Character.isWhitespace(letra))	//verifica si el caracter es un espacio en blanco
			{
				continue;				
			}
			
			//se busca la letra en el hashtable de n�meros romanos
			esta = numerosRomanos.containsKey(Character.toString(letra).toUpperCase());
			
			if(esta)	//si la letra corresponde a un n�mero romano b�sico
			{
				//se obtiene el equivalente de la letra en decimal
				valor = numerosRomanos.get(Character.toString(letra).toUpperCase());
				decimal = decimal + valor;
				
				//se calcula el valor en decimal para el n�mero romano pasado como par�metro
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
			resultado = "El n�mero " + romano + " en decimal es: "+ decimal;
			System.out.println(resultado);
			return (decimal);
		}
		
		else
		{
			resultado = "La secuencia '" + entrada + "' no corresponde a un n�mero romano";
			System.out.println(resultado);
			return decimal;
		}
	}
}

