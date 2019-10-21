package principal;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class GeraIndiceSeqIndex {

	public static ArrayList<DadosTweet> aDadosTweet = new ArrayList<DadosTweet>();
	long resultadoPesquisa = 0;
	// Arquivo de dados para leitura
	public static String arquivodeDados = "C:\\Users\\Alex\\Desktop\\Organização de Arquivos\\teste2.txt";

	public GeraIndiceSeqIndex() {

		GeraArquivodeDadosOrdenado(aDadosTweet);
		OrdenaArquivoIdUser(aDadosTweet);
		GeraArquivoDeDados(aDadosTweet);

		
		
		aDadosTweet = new ArrayList<DadosTweet>();
		PopulaArrayDados(aDadosTweet);
		OrdenaArquivoIdUser(aDadosTweet);

		ImprimeADadosTweet(aDadosTweet);
		GeraArquivoDeIndice(aDadosTweet);

		//resultadoPesquisa = pesquisaBin("00000000000507310033");
		System.out.println("Resultado da PEsquisa:" + resultadoPesquisa);
		System.out.println("--");
		//resultadoPesquisa = pesquisaBin("01134628853119406081");
		System.out.println("Resultado da PEsquisa:" + resultadoPesquisa);
		System.out.println("--");
		 
//			try {
//				ProcuraNoArquivo(10,"847164610818007022");
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}

	}

	public static void PopulaArrayDados(ArrayList<DadosTweet> aDadosTweet) {

		String id_user = null;
		String name = null;
		String followers_count = null;
		String friends_count = null;
		String id_tweet = null;
		String text = null;
		String elo = null;
		long idUser = 0;
		long idTweet = 0;

		/* Le o Arquivo e faz a inclusão nos objetos */
		BufferedReader reader = null;
		try {
			// reader = new BufferedReader(new InputStreamReader(new
			// FileInputStream(abrir.getSelectedFile().toString())));
			reader = new BufferedReader(new FileReader(arquivodeDados));

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String linha = null;

		try {
			while ((linha = reader.readLine()) != null) {
				// LER DADOS

				// id_user = linha.substring(0, 21).trim();

				id_user = linha.substring(0, 21).trim();
				name = linha.substring(21, 62).trim();
				followers_count = linha.substring(62, 73).trim();
				friends_count = linha.substring(73, 83).trim();
				id_tweet = linha.substring(83, 104).trim();
				text = linha.substring(104, 385).trim();
				elo = " ";
				idUser = Long.parseLong(linha.substring(0, 21).trim());
				idTweet = Long.parseLong(linha.substring(83, 104).trim());
				DadosTweet dadosLinha = new DadosTweet(id_user, name, followers_count, friends_count, id_tweet, text,
						elo, idUser, idTweet);
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

	public static void GeraArquivodeDadosOrdenado(ArrayList<DadosTweet> aDadosTweet) {

		String id_user = null;
		String name = null;
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
		/*
		 * JFileChooser abrir = new JFileChooser(); int res =
		 * abrir.showOpenDialog(abrir); if (res == JFileChooser.APPROVE_OPTION) {
		 * JOptionPane.showMessageDialog(null, "Voce selecionou o arquivo :" +
		 * abrir.getSelectedFile().getName()); // nomeArquivo =
		 * abrir.getSelectedFile().getName();
		 * 
		 * }
		 */

		/* Le o Arquivo e faz a inclusão nos objetos */
		BufferedReader reader = null;
		try {
			// reader = new BufferedReader(new InputStreamReader(new
			// FileInputStream(abrir.getSelectedFile().toString())));
			reader = new BufferedReader(new FileReader(arquivodeDados));

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String linha = null;

		try {
			while ((linha = reader.readLine()) != null) {
				// LER DADOS

				// id_user = linha.substring(0, 21).trim();

				id_user = linha.substring(0, 21);
				name = linha.substring(21, 62);
				followers_count = linha.substring(62, 73);
				friends_count = linha.substring(73, 83);
				id_tweet = linha.substring(83, 104);
				text = linha.substring(104, 385);
				elo = " ";
				idUser = Long.parseLong(linha.substring(0, 21).trim());
				idTweet = Long.parseLong(linha.substring(83, 104).trim());
				DadosTweet dadosLinha = new DadosTweet(id_user, name, followers_count, friends_count, id_tweet, text,
						elo, idUser, idTweet);
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

	public void ImprimeADadosTweet(ArrayList<DadosTweet> aDadosTweet) {

		/* Tipo 21 */
		for (DadosTweet dados : aDadosTweet) {
			System.out.println("--Dados Tweet--");
			System.out.println("id_user:" + dados.getId_user());
			System.out.println("name:" + dados.getName());
			System.out.println("followers_count:" + dados.getFollowers_count());
			System.out.println("friends_count:" + dados.getFriends_count());
			System.out.println("idTweet:" + dados.getIdTweet());
			System.out.println("text:" + dados.getText());
			System.out.println("iduser long:" + dados.getIdUser());
			System.out.println("idTweet:" + dados.getIdTweet());
		}

	}

	public static void GeraArquivoDeIndice(ArrayList<DadosTweet> aDadosTweet) {

		int contLinha = 0;
		int inicioBloco = 0;
		String sInicioBloco = null;
		int i;
		String sId_Usuario = null;
		FileWriter arq = null;
		try {

			arq = new FileWriter("D:\\WSEclipse\\ARQUIVOS TRABALHO OA\\INDICE.txt");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		PrintWriter gravarArq = new PrintWriter(arq);

		/* Tipo 10 */
		for (i = 1; i < aDadosTweet.size() - 1; i++) {
			
			contLinha++;
			if (contLinha == 1) {
				inicioBloco = i;
				sInicioBloco = String.format("%06d", inicioBloco); // 12345678901
				
			}
			if (contLinha == 3) {
				sId_Usuario = String.format("%020d", aDadosTweet.get(i).getIdUser()); // 12345678901
				gravarArq.printf(sId_Usuario + sInicioBloco + "%n");
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

	public static void GeraArquivoDeDados(ArrayList<DadosTweet> aDadosTweet) {

		int i;
		FileWriter arq = null;
		try {

			arq = new FileWriter("D:\\WSEclipse\\ARQUIVOS TRABALHO OA\\ArquivoDeDados.txt");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		PrintWriter gravarArq = new PrintWriter(arq);

		/* Tipo 10 */
		for (i = 1; i < aDadosTweet.size(); i++) {
			gravarArq.printf(aDadosTweet.get(i).getId_user() + aDadosTweet.get(i).getName()
					+ aDadosTweet.get(i).getFollowers_count() + aDadosTweet.get(i).getFriends_count()
					+ aDadosTweet.get(i).getIdTweet() + aDadosTweet.get(i).getText() + "%n");
		}

		try {
			arq.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void OrdenaArquivoIdUser(ArrayList<DadosTweet> aDadosTweet) {
		int i, j, menor;

		/* Variaveis Temporárias */

		String tempId_user = null;
		String tempName = null;
		String tempFollowers_count = null;
		String tempFriends_count = null;
		String tempId_tweet = null;
		String tempText = null;
		String tempElo = null;
		long tempIdUser = 0;
		long tempIdTweet = 0;

		for (i = 0; i < aDadosTweet.size() - 1; i++) {
			for (j = 0; j < aDadosTweet.size() - 1; j++) {
				if (aDadosTweet.get(j).getIdUser() > aDadosTweet.get(j + 1).getIdUser()) {

					tempId_user = null;
					tempName = null;
					tempFollowers_count = null;
					tempFriends_count = null;
					tempId_tweet = null;
					tempText = null;
					tempElo = null;
					tempIdUser = 0;
					tempIdTweet = 0;

					// temp.add(aDadosTweet.get(menor));
					tempId_user = aDadosTweet.get(j).getId_user();
					tempName = aDadosTweet.get(j).getName();
					tempFollowers_count = aDadosTweet.get(j).getFollowers_count();
					tempFriends_count = aDadosTweet.get(j).getFriends_count();
					tempId_tweet = aDadosTweet.get(j).getId_tweet();
					tempText = aDadosTweet.get(j).getText();
					tempElo = aDadosTweet.get(j).getElo();
					tempIdUser = aDadosTweet.get(j).getIdUser();
					tempIdTweet = aDadosTweet.get(j).getIdTweet();

					// Altera valor do menor
					// vet[menor] = vet[i];
					aDadosTweet.get(j).setId_user(aDadosTweet.get(j + 1).getId_user());
					aDadosTweet.get(j).setName(aDadosTweet.get(j + 1).getName());
					aDadosTweet.get(j).setFriends_count(aDadosTweet.get(i).getFriends_count());
					aDadosTweet.get(j).setId_tweet(aDadosTweet.get(j + 1).getId_tweet());
					aDadosTweet.get(j).setText(aDadosTweet.get(j + 1).getText());
					aDadosTweet.get(j).setElo(aDadosTweet.get(j + 1).getElo());
					aDadosTweet.get(j).setIdUser(aDadosTweet.get(j + 1).getIdUser());
					aDadosTweet.get(j).setIdTweet(aDadosTweet.get(j + 1).getIdTweet());

					// vet[i] = temp;
					aDadosTweet.get(j + 1).setId_user(tempId_user);
					aDadosTweet.get(j + 1).setName(tempName);
					aDadosTweet.get(j + 1).setFollowers_count(tempFollowers_count);
					aDadosTweet.get(j + 1).setFriends_count(tempFriends_count);
					aDadosTweet.get(j + 1).setId_tweet(tempId_tweet);
					aDadosTweet.get(j + 1).setText(tempText);
					aDadosTweet.get(j + 1).setElo(tempElo);
					aDadosTweet.get(j + 1).setIdUser(tempIdUser);
					aDadosTweet.get(j + 1).setIdTweet(tempIdTweet);
				}
			}
		}

	}

	public long pesquisaBin(String ValorProcurado) {
		String sValor = null;
		String sPosicao = null;
		long valor = 0;
		long posicao = 0;
		int inicio = 0;
		int fim = 0;
		int meio = 0;
		long valorIndiceAnterior;
		long valorIndice;
		long procura = 0;

		ArrayList<Indice> indice = new ArrayList<Indice>();

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

				sValor = linha.substring(0, 20);
				sPosicao = linha.substring(20, 26);
				valor = Long.parseLong(linha.substring(0, 20));
				posicao = Long.parseLong(linha.substring(20, 26));
				Indice dadosIndice = new Indice(sValor, sPosicao, valor, posicao);
				indice.add(dadosIndice);
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

		fim = indice.size() - 1;

		procura = Long.parseLong(ValorProcurado);

		while (inicio <= fim) {
			meio = (inicio + fim) / 2;
			valorIndiceAnterior = indice.get(meio - 1).getValor();
			valorIndice = indice.get(meio).getValor();

			if (procura > valorIndiceAnterior && procura <= valorIndice) {
				return indice.get(meio).getposicao();
			} else {
				if (procura < indice.get(meio).getValor())
					fim = meio - 1;
				else if (procura > indice.get(meio).getValor())
					inicio = meio + 1;
			}
		}

		return 0;
	}
	
	

	
	
	

	public void ProcuraNoArquivo(long indiceArquivo, String valorProcurado) throws IOException {

		long i = 0;
		long indice = 0;
		String linha;

		try {
			RandomAccessFile dadosArquivo = new RandomAccessFile(
					"D:\\WSEclipse\\ARQUIVOS TRABALHO OA\\ArquivoDeDados.txt", "r");

			System.out.printf("-------------------------------------------------------\n");
			long n = (dadosArquivo.length()/384); // calcula o número de registros do arquivo (sizefile)
			//long n = 22;

			indice = indiceArquivo * 385;
			
			
			for (i = indice; i <= (indice + 1152); i=i+385) {
				//115200
				//for (i = 0; i <= 114816‬; i=i+384) {
				//linha = lerString(dadosArquivo, 20);
				dadosArquivo.seek(i);
					if(dadosArquivo.readLine().contains(valorProcurado))
						System.out.println(dadosArquivo.readLine());

			}
			System.out.printf("-------------------------------------------------------\n");
			dadosArquivo.close();
		} catch (FileNotFoundException e) {
			System.err.printf("Arquivo não encontrado: %s.\n", e.getMessage());
		}
	}

	private static String lerString(RandomAccessFile arq, int tam) throws IOException {
		char result[] = new char[tam];
		for (int i = 0; i < tam; i++) {
			result[i] = arq.readChar();
		}
		return (new String(result).replace('\0', ' '));
	}

}
