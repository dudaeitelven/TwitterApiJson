package principal;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class BusarSeek {
	
	public static void ProcurarNoArquivoSeek(long indice) throws IOException {
		String linha;
		byte[] byteVetor = new byte[430];

		try {
			RandomAccessFile dadosArquivo = new RandomAccessFile("D:\\twitterSimples.txt", "rw");

			System.out.printf("-------------------------------------------------------\n");
			
			dadosArquivo.seek((indice-1) * 457);
			dadosArquivo.read(byteVetor, 0, 430);
			linha = new String(byteVetor);
			
			System.out.println(linha);
			
			System.out.printf("-------------------------------------------------------\n");
			
			dadosArquivo.close();
			
		} catch (FileNotFoundException e) {
			System.err.printf("Arquivo não encontrado: %s.\n", e.getMessage());
		}
	}


}
