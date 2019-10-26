package principal;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.Key;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

public class GerarIndiceHash {
	private static Map<String, List<DadosTweet>> hash = new HashMap<>();
	private static ArrayList<DadosTweet> aDadosTweet = new ArrayList<DadosTweet>();
	private static String arquivodeDados = "D:\\twitterSimples.txt";
	
	public void GeraIndiceHash() {
		AlimentarIndiceHash();
		
        for(Map.Entry<String, List<DadosTweet>> entry: hash.entrySet()) { 
        	System.out.println(hash.keySet());
        	
            for(DadosTweet c: entry.getValue()) {
                System.out.println(c.getId_tweet() + " - " + c.getData().trim());
            }
        }
		
	}
	
	public static void AlimentarIndiceHash () {
		String keyToSearch = null;

		CarregarArquivoDados();
		
		for (DadosTweet aDados : aDadosTweet) {
			keyToSearch = aDados.getData().trim();
			
			if (hash.containsKey(keyToSearch)) {
				hash.get(aDados.getData().trim()).add(aDados);
			}
			else {
				hash.put(aDados.getData().trim(), new ArrayList<DadosTweet>());
				hash.get(aDados.getData().trim()).add(aDados);
			}
		}          
	}	
	
	public static void CarregarArquivoDados() {
		String id_user = null;
		String name = null;
		String followers_count = null;
		String friends_count = null;
		String id_tweet = null;
		String text = null;
		String data = null;
		String elo = null;
		long idUser = 0;
		long idTweet = 0;

		/* Le o Arquivo e faz a inclusão nos objetos */
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(arquivodeDados));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		String linha = null;

		try {
			while ((linha = reader.readLine()) != null) {
				id_user = linha.substring(0, 21);
				name = linha.substring(21, 62);
				followers_count = linha.substring(62, 73);
				friends_count = linha.substring(73, 83);
				id_tweet = linha.substring(83, 104);
				data = linha.substring(105,136);
				text = linha.substring(156, 438);
				elo = " ";
				
				idUser = Long.parseLong(linha.substring(0, 21).trim());
				idTweet = Long.parseLong(linha.substring(83, 104).trim());
				DadosTweet dadosLinha = new DadosTweet(id_user, name, followers_count, friends_count, id_tweet, data,
						text, elo, idUser, idTweet);
				aDadosTweet.add(dadosLinha);
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
