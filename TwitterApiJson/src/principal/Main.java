package principal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main  {
	
	public static void menu() {
		System.out.println("     	     --- M E N U ---           	");
		System.out.println(" 1 - Sequencial indexada por id_usuario ");
		System.out.println(" 2 - Sequencial indexada por id_tweet   ");
		System.out.println(" 3 - Tabela hash por data e id_tweet    ");
		System.out.println(" 4 - Arvore de pesq. binaria            ");
		System.out.println(" 0 - SAIR                               ");
	}
	
	public static void carregaMenu(int Escolha) {
		String keyToSearch = null, ValueToSearch = null;
		
		//Scanner entrada = new Scanner(System.in);
		BufferedReader entrada = new BufferedReader(
				new InputStreamReader(System.in));

		switch (Escolha) {
			case 1: 
				System.out.println("Informe o id_usuario:");
				//ValueToSearch = entrada.nextLine();
			try {
				ValueToSearch =entrada.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
				GeraIndiceSeqIndexIdUser SeqInd1 = new GeraIndiceSeqIndexIdUser();
				SeqInd1.GerarIndiceSeqIndex(ValueToSearch);
				break;
			case 2: 
				System.out.println("Informe o id_tweet:");
			try {
				ValueToSearch = entrada.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
				GeraIndiceSeqIndexIdTweet SeqInd2 = new GeraIndiceSeqIndexIdTweet();
				SeqInd2.GerarIndiceSeqIndex(ValueToSearch);
				break;
			case 3: 
				System.out.println("Informe uma data no seguinte formato: 2019-10-24");
				//keyToSearch = entrada.nextLine();
			try {
				keyToSearch =entrada.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				System.out.println("Informe o id_tweet");
			try {
				ValueToSearch = entrada.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
				GerarIndiceTabelaHash hashTest = new GerarIndiceTabelaHash();
				hashTest.GerarIndiceHash(keyToSearch,ValueToSearch);
				break;
			case 4: 
				GeraIndiceArvoreBinaria arvBinaria = new GeraIndiceArvoreBinaria();
				arvBinaria.main();
				break;
		}
		
		//entrada.close();
	}
	
	public void chamaMenu() {
		
		
	}

	public static void main(String[] args) {
		int Escolha = 0;
		
		Scanner entrada = new Scanner(System.in);
		do {
			do {
				menu();
				Escolha = entrada.nextInt();

				if ((Escolha < 0) || (Escolha > 5)) {
					System.out.println("Opcao incorreta, tente novamente ! \n");
				}
				carregaMenu(Escolha);
			} while ((Escolha < 0) || (Escolha > 12));
		} while (Escolha != 0);
		
		entrada.close();
	}
	
}
