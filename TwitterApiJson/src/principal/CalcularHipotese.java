package principal;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CalcularHipotese {
	
	public void ProcuraNoArquivo() {
		String linha = null;
		String tweet = null;
		int countFlamengo = 0;
		int countPalmeiras = 0;
		int countSantos = 0;
		int countCorinthians = 0;
		int countSaoPaulo = 0;
		int countSCInternacional = 0;
		int countGremio = 0;
		int countECBahia = 0;
		int countAthleticoPR = 0;
		int countGoiasoficial = 0;
		int countVascodaGama = 0;
		int countAtletico = 0;
		int countFortalezaEC = 0;
		int countBotafogo = 0;
		int countFluminenseFC = 0;
		int countCruzeiro = 0;
		int countCearaSC = 0;
		int countCSAoficial = 0;
		int countAvai = 0;
		int countChapecoenseReal = 0;

		/* Le o Arquivo e faz a inclusão nos objetos */
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(
				new FileReader("C:\\Users\\Duda\\git\\TwitterApiJson\\TwitterApiJson\\src\\files\\twitter.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		try {
			while ((linha = reader.readLine()) != null) {
				tweet = linha.substring(104, 385).trim();
				
				if (tweet.contains("Flamengo")) {
					countFlamengo++;
				}
				else if (tweet.contains("Palmeiras")) {
		        	countPalmeiras++;
		         }
		        else if (tweet.contains("Santos")) {
		        	countSantos++;
		         }
		        else if (tweet.contains("Corinthians")) {
		        	countCorinthians++;
		         }
		        else if (tweet.contains("SãoPaulo")) {
		        	countSaoPaulo++;
		         }
		        else if (tweet.contains("SCInternacional")) {
		        	countSCInternacional++;
		         }
		         else if (tweet.contains("Gremio")) {
		        	 countGremio++;
		         }
		         else if (tweet.contains("ECBahia")) {
		        	 countECBahia++;
		         }
		         else if (tweet.contains("AthleticoPR")) {
		        	 countAthleticoPR++;
		         }
		         else if (tweet.contains("goiasoficial")) {
		        	 countGoiasoficial++;
		         }
		         else if (tweet.contains("VascodaGama")) {
		        	 countVascodaGama++;
		         }
		         else if (tweet.contains("Atletico")) {
		        	 countAtletico++;
		         }
		         else if (tweet.contains("FortalezaEC")) {
		        	 countFortalezaEC++;
		         }
		         else if (tweet.contains("botafogo")) {
		        	 countBotafogo++;
		         }
		         else if (tweet.contains("FluminenseFC")) {
		        	 countFluminenseFC++;
		         }
		         else if (tweet.contains("Cruzeiro")) {
		        	 countCruzeiro++;
		         }
		         else if (tweet.contains("CearaSC")) {
		        	 countCearaSC++;
		         }
		         else if (tweet.contains("CSAoficial")) {
		        	 countCSAoficial++;
		         }
		         else if (tweet.contains("Avai")) {
		        	 countAvai++;
		         }
		         else if (tweet.contains("ChapecoenseReal")) {
		        	 countChapecoenseReal++;
		         }
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
