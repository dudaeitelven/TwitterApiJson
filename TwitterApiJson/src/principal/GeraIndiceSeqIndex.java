package principal;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class GeraIndiceSeqIndex {

	public GeraIndiceSeqIndex() {

		leArquivo();
	}

	public static void leArquivo() {

		String id_user = null;
		String name = null;
		String screen_name = null;
		String followers_count = null;
		String friends_count = null;
		String id_tweet = null;
		String text = null;
		String hastag = null;
		String user_mentions = null;

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

				id_user = linha.substring(0, 10);
				name = linha.substring(10, 30);
				screen_name = linha.substring(30, 50);
				followers_count = linha.substring(50, 60);
				friends_count = linha.substring(60, 70);
				id_tweet = linha.substring(70, 90);
				text = linha.substring(90, 380);
				hastag = linha.substring(380, 410);
				user_mentions = linha.substring(410, 460);

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

//	public static void Ordena() {
//		
////https://www.guj.com.br/t/ordenar-um-arraylist/27792/4
//		Collections.sort(blah, new Comparator() {
//			public int compare(Object o1, Object o2) {
//				Categoria c1 = (Categoria) o1;
//				Categoria c2 = (Categoria) o2;
//				return c1.getNome().compareToIgnoreCase(c2.getNome());
//			}
//		});
//
//	}

}
