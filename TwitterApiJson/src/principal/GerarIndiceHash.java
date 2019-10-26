package principal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class GerarIndiceHash {
	private static Map<String, List<DadosTweet>> hash = new HashMap<>();
	private static ArrayList<DadosTweet> aDadosTweet = new ArrayList<DadosTweet>();
	
	public void GeraIndiceHash() {
		String keyToSearch = null;
		String ValueToSearch = null;
		long indice = 0;
		
		AlimentarIndiceHash();
		
//	    for(Map.Entry<String, List<DadosTweet>> entry: hash.entrySet()) { 
//    	System.out.println(hash.keySet());
//    	
//        for(DadosTweet c: entry.getValue()) {
//            System.out.println(c.getId_tweet() + " - " + c.getData().trim() + " - " + c.getLinha());
//        }
//    }	
		      
		keyToSearch = "2019-10-24";
		ValueToSearch = "1187503296241643520";
		       
		indice = BuscarIndiceHash(keyToSearch,ValueToSearch);
		
		if (indice != 0) {
			 try {
				BusarSeek.ProcurarNoArquivoSeek(indice);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		else {
			System.out.println("Valor " + ValueToSearch + " nao encontrado no indice hash! \n");
		}
       
	}
	
	public static long BuscarIndiceHash (String keyToSearch, String ValueToSearch) {
		long linha = 0;
		String ValueHash = null;
		
        for (String key : hash.keySet()) {
            List<DadosTweet> value = hash.get(key);
            
            for (int i=0; i < value.size();i++) {
            	ValueHash = value.get(i).getId_tweet().trim();
            	if (ValueHash.equals(ValueToSearch)) {
            		return value.get(i).getLinha();
            	}
            }
        }
		
		return 0;
	}
	

	public static void AlimentarIndiceHash () {
		String keyToSearch = null;

		aDadosTweet = CarregarArquivoDados.CarregarArquivoDados();
		
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
	
}
