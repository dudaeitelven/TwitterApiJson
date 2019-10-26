package principal;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CarregarArquivoDados {
	private static ArrayList<DadosTweet> aDadosTweet = new ArrayList<DadosTweet>();
	private static String arquivodeDados = "D:\\twitterSimples.txt";
	
	public ArrayList<DadosTweet> RetornarArquivoDados() {
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
		long linha = 0;
		String linhaDados = null;
		
		BufferedReader reader = null;		
		try {
			reader = new BufferedReader(new FileReader(arquivodeDados));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		try {
			while ((linhaDados = reader.readLine()) != null) {
				id_user = linhaDados.substring(0, 21);
				name = linhaDados.substring(21, 62);
				followers_count = linhaDados.substring(62, 73);
				friends_count = linhaDados.substring(73, 83);
				id_tweet = linhaDados.substring(83, 104);
				data = linhaDados.substring(105,136);
				text = linhaDados.substring(156, 430);
				elo = " ";
				
				linha++;
				
				idUser = Long.parseLong(linhaDados.substring(0, 21).trim());
				idTweet = Long.parseLong(linhaDados.substring(83, 104).trim());
				DadosTweet dadosLinha = new DadosTweet(id_user, name, followers_count, friends_count, id_tweet, data,
						text, elo, idUser, idTweet, linha);
				
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
		
		return aDadosTweet;
	}

}
