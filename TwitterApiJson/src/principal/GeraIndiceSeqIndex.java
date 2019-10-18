package principal;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;



public class GeraIndiceSeqIndex {

	public static ArrayList<DadosTweet> aDadosTweet = new ArrayList<DadosTweet>();

	public GeraIndiceSeqIndex() {

		leArquivo(aDadosTweet);
		OrdenaArquivo(aDadosTweet);
		GeraArquivoDeIndice(aDadosTweet);
	}

	public static void leArquivo(ArrayList<DadosTweet> aDadosTweet) {

		String id_user = null;
		String name = null;
		String screen_name = null;
		String followers_count = null;
		String friends_count = null;
		String id_tweet = null;
		String text = null;
		String hashtag = null;
		String user_mentions = null;
		String elo = null;
		long idUser = 0;
		long idTweet = 0;

		/* Escolhe o Arquivo para editar */
		JFileChooser abrir = new JFileChooser();
		int res = abrir.showOpenDialog(abrir);
		if (res == JFileChooser.APPROVE_OPTION) {
			JOptionPane.showMessageDialog(null, "Voce selecionou o arquivo :" + abrir.getSelectedFile().getName());
			// nomeArquivo = abrir.getSelectedFile().getName();

		}

		/* Le o Arquivo e faz a inclusão nos objetos */
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new InputStreamReader(new FileInputStream(abrir.getSelectedFile().toString())));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String linha = null;

		try {
			while ((linha = reader.readLine()) != null) {
				// LER DADOS

				id_user = linha.substring(0, 19);
				name = linha.substring(19, 39);
				screen_name = linha.substring(39, 59);
				followers_count = linha.substring(59, 69);
				friends_count = linha.substring(69, 79);
				id_tweet = linha.substring(79, 99);
				text = linha.substring(99, 379);
				elo = " ";
				idUser = Long.parseLong(linha.substring(0, 19));
				// idTweet= Long.parseLong(linha.substring(79, 99));
				DadosTweet dadosLinha = new DadosTweet(id_user, name, screen_name, followers_count, friends_count,
						id_tweet, text, elo, idUser, idTweet);
				aDadosTweet.add(dadosLinha);

			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			reader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void GeraArquivoDeIndice(ArrayList<DadosTweet> aDadosTweet) {

		int contLinha = 0;
		int inicioBloco = 0;
		String sInicioBloco = null;
		int i;
		FileWriter arq = null;
		try {

			arq = new FileWriter("D:\\WSEclipse\\ARQUIVOS TRABALHO OA\\INDICE.txt");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		PrintWriter gravarArq = new PrintWriter(arq);

		/* Tipo 10 */
		for (i = 1; i < aDadosTweet.size(); i++) {
			contLinha++;
			if (contLinha == 1) {
				inicioBloco = i;
				sInicioBloco = String.format("%06d", inicioBloco); // 12345678901

			}
			if (contLinha == 3) {
				gravarArq.printf(aDadosTweet.get(i).getId_user() + sInicioBloco + "%n");
				contLinha = 0;
			}

		}

		try {
			arq.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void OrdenaArquivo(ArrayList<DadosTweet> aDadosTweet) {
		int i, j, menor;

		/* Variaveis Temporárias */

		String tempId_user = null;
		String tempName = null;
		String tempScreen_name = null;
		String tempFollowers_count = null;
		String tempFriends_count = null;
		String tempId_tweet = null;
		String tempText = null;
		String tempElo = null;
		long tempIdUser = 0;
		long tempIdTweet = 0;

		for (i = 0; i < aDadosTweet.size() - 1; i++) {
			menor = i;
			for (j = i + 1; j < aDadosTweet.size() - 1; j++) {
				if (aDadosTweet.get(j).getIdUser() < aDadosTweet.get(menor).getIdUser()) {
					menor = j;

					tempId_user = null;
					tempName = null;
					tempScreen_name = null;
					tempFollowers_count = null;
					tempFriends_count = null;
					tempId_tweet = null;
					tempText = null;
					tempElo = null;
					tempIdUser = 0;
					tempIdTweet = 0;

					// temp.add(aDadosTweet.get(menor));
					tempId_user = aDadosTweet.get(menor).getId_user();
					tempName = aDadosTweet.get(menor).getName();
					tempScreen_name = aDadosTweet.get(menor).getScreen_name();
					tempFollowers_count = aDadosTweet.get(menor).getFollowers_count();
					tempFriends_count = aDadosTweet.get(menor).getFriends_count();
					tempId_tweet = aDadosTweet.get(menor).getId_tweet();
					tempText = aDadosTweet.get(menor).getText();

					tempElo = aDadosTweet.get(menor).getElo();
					tempIdUser = aDadosTweet.get(menor).getIdUser();
					tempIdTweet = aDadosTweet.get(menor).getIdTweet();

					// Altera valor do menor
					// vet[menor] = vet[i];
					aDadosTweet.get(menor).setId_user(aDadosTweet.get(i).getId_user());
					aDadosTweet.get(menor).setName(aDadosTweet.get(i).getName());
					aDadosTweet.get(menor).setScreen_name(aDadosTweet.get(i).getScreen_name());
					aDadosTweet.get(menor).setFollowers_count(aDadosTweet.get(i).getFollowers_count());
					aDadosTweet.get(menor).setFriends_count(aDadosTweet.get(i).getFriends_count());
					aDadosTweet.get(menor).setId_tweet(aDadosTweet.get(i).getId_tweet());
					aDadosTweet.get(menor).setText(aDadosTweet.get(i).getText());
					aDadosTweet.get(menor).setElo(aDadosTweet.get(i).getElo());
					aDadosTweet.get(menor).setIdUser(aDadosTweet.get(i).getIdUser());
					aDadosTweet.get(menor).setIdTweet(aDadosTweet.get(i).getIdTweet());

					// vet[i] = temp;
					aDadosTweet.get(i).setId_user(tempId_user);
					aDadosTweet.get(i).setName(tempName);
					aDadosTweet.get(i).setScreen_name(tempScreen_name);
					aDadosTweet.get(i).setFollowers_count(tempFollowers_count);
					aDadosTweet.get(i).setFriends_count(tempFriends_count);
					aDadosTweet.get(i).setId_tweet(tempId_tweet);
					aDadosTweet.get(i).setText(tempText);
					aDadosTweet.get(i).setElo(tempElo);
					aDadosTweet.get(i).setIdUser(tempIdUser);
					aDadosTweet.get(i).setIdTweet(tempIdTweet);

				}
			}

		}

	}

	/*
	 * public int pesquisaBin(int x){ int esq=0; int dir=arranjo.length - 1; int
	 * meio; do{ meio=esq + (dir - esq)/2; if(x<arranjo[meio]) dir=meio-1; else
	 * if(x>arranjo[meio]) esq=meio+1; else return meio; }while(esq<=dir); return
	 * -1;
	 * 
	 * }
	 * 
	 */

	public DadosTweet pesquisaBin(ArrayList<DadosTweet> aDadosTweet, int x) {
		int esq = 0;
		int dir = aDadosTweet.size() - 1;
		int meio;
		
		String sValor = null;
		String sPosicao = null;
		long valor = 0;
		long posicao = 0;
		
		

		/* Le o Arquivo e faz a inclusão nos objetos */
		BufferedReader reader = null;
		try {

			reader = new BufferedReader(new FileReader("D:\\WSEclipse\\ARQUIVOS TRABALHO OA\\INDICE.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String linha = null;

		try {
			while ((linha = reader.readLine()) != null) {
				
				sValor = linha.substring(0, 19);
				sPosicao = linha.substring(19, 26);
				valor = Long.parseLong(linha.substring(0, 19));
				posicao = Long.parseLong(linha.substring(19, 26));
				Indice dadosIndice = new Indice(sValor, sPosicao,valor,posicao);
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			reader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		do {
			meio = esq + (dir - esq) / 2;
			if (x < (aDadosTweet.get(meio).getIdTweet()))
				dir = meio - 1;
			else if (x > (aDadosTweet.get(meio).getIdTweet()))
				esq = meio + 1;
			else
				return aDadosTweet.get(meio);
		} while (esq <= dir);
		System.out.println("Não ENCONTRADO\n");

		return null;
	}

}
