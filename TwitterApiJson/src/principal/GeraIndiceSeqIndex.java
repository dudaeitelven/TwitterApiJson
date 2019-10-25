package principal;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.util.ArrayList;


public class GeraIndiceSeqIndex {

	public static ArrayList<DadosTweet> aDadosTweet = new ArrayList<DadosTweet>();
	long resultadoPesquisa = 0;
	// Arquivo de dados para leitura
	//public static String arquivodeDados = "C:\\Users\\Alex\\Desktop\\Organização de Arquivos\\teste2.txt";
	//public static String arquivodeDados = "C:\\Users\\Duda\\git\\TwitterApiJson\\TwitterApiJson\\src\\files\\twitter2.txt";
	public static String arquivodeDados = "D:\\twitterSimples.txt";

	public GeraIndiceSeqIndex() {

		GeraArquivodeDadosOrdenado(aDadosTweet);
		OrdenaArquivoIdUser(aDadosTweet);
		GeraArquivoDeDados(aDadosTweet);
		
		aDadosTweet = new ArrayList<DadosTweet>();
		PopulaArrayDados(aDadosTweet);
		OrdenaArquivoIdUser(aDadosTweet);

		//ImprimeADadosTweet(aDadosTweet);
		GeraArquivoDeIndice(aDadosTweet);

		try {
			resultadoPesquisa = pesquisaBin("331047699");
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		System.out.println("Resultado da pesquisa:" + resultadoPesquisa);
		System.out.println("--");

		try {
			ProcuraNoArquivo(resultadoPesquisa,"331047699");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void PopulaArrayDados(ArrayList<DadosTweet> aDadosTweet) {
		String id_user = null;
		String name = null;
		String followers_count = null;
		String friends_count = null;
		String id_tweet = null;
		String text = null;
		String elo = null;
		String data = null;
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
;
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
		String data = null;
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
			reader = new BufferedReader(new FileReader(arquivodeDados));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		String linha = null;

		try {
			while ((linha = reader.readLine()) != null) {
				// LER DADOS

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
		for (DadosTweet dados : aDadosTweet) {
			System.out.println("--Dados Tweet--");
			System.out.println("id_user:" + dados.getId_user());
			System.out.println("name:" + dados.getName());
			System.out.println("followers_count:" + dados.getFollowers_count());
			System.out.println("friends_count:" + dados.getFriends_count());
			System.out.println("idTweet:" + dados.getIdTweet());
			System.out.println("data:" + dados.getData());
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
			//arq = new FileWriter("D:\\WSEclipse\\ARQUIVOS TRABALHO OA\\INDICE.txt");
			//arq = new FileWriter("C:\\Users\\Duda\\git\\TwitterApiJson\\TwitterApiJson\\src\\files\\INDICE.txt");
			arq = new FileWriter("D:\\INDICE.txt");
			
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
				gravarArq.printf(sId_Usuario + sInicioBloco + "\n");
				contLinha = 0;
			}
			
		}

		try {
			arq.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void GeraArquivoDeDados(ArrayList<DadosTweet> aDadosTweet) {

		int i;
		FileWriter arq = null;
		try {

			//arq = new FileWriter("D:\\WSEclipse\\ARQUIVOS TRABALHO OA\\ArquivoDeDados.txt");
			//arq = new FileWriter("C:\\Users\\Duda\\git\\TwitterApiJson\\TwitterApiJson\\src\\files\\ArquivoDeDados.txt");
			arq = new FileWriter("D:\\ArquivoDeDados.txt");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		PrintWriter gravarArq = new PrintWriter(arq);

		/* Tipo 10 */
		for (i = 1; i < aDadosTweet.size(); i++) {
			gravarArq.printf(aDadosTweet.get(i).getId_user() + aDadosTweet.get(i).getName()
					+ aDadosTweet.get(i).getIdTweet()  + aDadosTweet.get(i).getData() + aDadosTweet.get(i).getText() +  "\n");
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
		String tempData = null;
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
					tempData = null;
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
					tempData = aDadosTweet.get(j).getData();
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
					aDadosTweet.get(j).setData(aDadosTweet.get(j + 1).getData());
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
					aDadosTweet.get(j + 1).setData(tempData);
					aDadosTweet.get(j + 1).setElo(tempElo);
					aDadosTweet.get(j + 1).setIdUser(tempIdUser);
					aDadosTweet.get(j + 1).setIdTweet(tempIdTweet);
				}
			}
		}

	}

	public long pesquisaBin(String ValorProcurado) throws IOException {	
		long indice = 0;
		int inicio = 0;
		int fim = 0;
		int meio = 0;
		long valorIndiceAnterior;
		long valorIndice;
		long procura = 0;
		
		String linhaAnt = null;
		String linha = null;
		
		byte[] bVetor = new byte[28];
		byte[] bVetorAnt = new byte[28];
		
	
		try {
//			RandomAccessFile dadosArquivo = new RandomAccessFile(
//					"D:\\WSEclipse\\ARQUIVOS TRABALHO OA\\ArquivoDeDados.txt", "r");
//			RandomAccessFile arquivoIndice = new RandomAccessFile(
//					"C:\\Users\\Duda\\git\\TwitterApiJson\\TwitterApiJson\\src\\files\\INDICE.txt", "rw");
			RandomAccessFile arquivoIndice = new RandomAccessFile("D:\\INDICE.txt","rw");
			
			fim = (int) (arquivoIndice.length() / 26);
			procura = Long.parseLong(ValorProcurado);

			while (inicio <= fim) {
				meio = (inicio + fim) / 2;
							
				
				if (meio <= 1) {
					arquivoIndice.close();
					return 1;
				}
				
				arquivoIndice.seek((meio-2) * 27);
				arquivoIndice.read(bVetorAnt, 0, 26);
				//System.out.println(new String(bVetorAnt));	
				linhaAnt = new String(bVetorAnt);
				valorIndiceAnterior = Long.parseLong(linhaAnt.substring(0,20)); 
				
				arquivoIndice.seek((meio-1) * 27);
				arquivoIndice.read(bVetor, 0, 26);
				//System.out.println(new String(bVetor));	
				linha = new String(bVetor);
				valorIndice =  Long.parseLong(linha.substring(0,20));
				indice =  Integer.parseInt(linha.substring(20,26)); 
				

				if (procura > valorIndiceAnterior && procura <= valorIndice) {
					arquivoIndice.close();
					return indice;
				} else {
					if (procura < indice)
						fim = meio - 1;
					else if (procura > indice)
						inicio = meio + 1;
				}
			}
			
			arquivoIndice.close();
		} catch (FileNotFoundException e) {
			System.err.printf("Arquivo não encontrado: %s.\n", e.getMessage());
		}
		
		return 0;
	}

	public void ProcuraNoArquivo(long indiceArquivo, String valorProcurado) throws IOException {

		long i = 0;
		long indice = 0;
		String linha;

		try {
//			RandomAccessFile dadosArquivo = new RandomAccessFile(
//					"D:\\WSEclipse\\ARQUIVOS TRABALHO OA\\ArquivoDeDados.txt", "r");
//			RandomAccessFile dadosArquivo = new RandomAccessFile(
//					"C:\\Users\\Duda\\git\\TwitterApiJson\\TwitterApiJson\\src\\files\\ArquivoDeDados.txt", "r");
			
			RandomAccessFile dadosArquivo = new RandomAccessFile("D:\\ArquivoDeDados.txt", "r");

			System.out.printf("-------------------------------------------------------\n");
			
			indice = (indiceArquivo-1) * 392;
			
			if (indiceArquivo == 0) indice = 1;
			
			for (i = indice; i <= (indice + 1176); i=i+392) {
				dadosArquivo.seek(i);
					linha = (String) dadosArquivo.readLine();
					if(linha.contains(valorProcurado))
						System.out.println(linha);
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
