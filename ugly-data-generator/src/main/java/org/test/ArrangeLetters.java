/**
 * 
 */
package org.test;

import java.util.StringTokenizer;

/**
 * @author chemicalangel
 * 
 */
public class ArrangeLetters
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}

	public String arrange(String sentence)
	{
		StringBuilder returnString = new StringBuilder();

		StringTokenizer strTokens = new StringTokenizer(sentence);
		while (strTokens.hasMoreTokens())
		{
			String word = strTokens.nextToken();
			StringBuffer strBuff = new StringBuffer(word.length());

		}

		return returnString.toString();
	}

}
