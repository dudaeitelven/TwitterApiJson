package principal;

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
		String keyToSearch, ValueToSearch;
		
		Scanner entrada = new Scanner(System.in);

		switch (Escolha) {
			case 1: 
				System.out.println("Informe o id_usuario:");
				ValueToSearch = entrada.nextLine();
				
				GeraIndiceSeqIndexIdUser SeqInd1 = new GeraIndiceSeqIndexIdUser();
				SeqInd1.GerarIndiceSeqIndex(ValueToSearch);
				break;
			case 2: 
				System.out.println("Informe o id_tweet:");
				ValueToSearch = entrada.nextLine();
				
				GeraIndiceSeqIndexIdTweet SeqInd2 = new GeraIndiceSeqIndexIdTweet();
				SeqInd2.GerarIndiceSeqIndex(ValueToSearch);
				break;
			case 3: 
				System.out.println("Informe uma data no seguinte formato: 2019-10-24");
				keyToSearch = entrada.nextLine();
				
				System.out.println("Informe o id_tweet");
				ValueToSearch = entrada.nextLine();
				
				GerarIndiceTabelaHash hashTest = new GerarIndiceTabelaHash();
				hashTest.GerarIndiceHash(keyToSearch,ValueToSearch);
				break;
			case 4: 
				
				break;
		}
		
		entrada.close();
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
