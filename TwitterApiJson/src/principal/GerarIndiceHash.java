package principal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GerarIndiceHash {
	private static Map<String, List<DadosTweet>> hash = new HashMap<>();
	private static ArrayList<DadosTweet> aDadosTweet = new ArrayList<DadosTweet>();
	
	public void GeraIndiceHash() {
		AlimentarIndiceHash();
		
        for(Map.Entry<String, List<DadosTweet>> entry: hash.entrySet()) { 
        	System.out.println(hash.keySet());
        	
            for(DadosTweet c: entry.getValue()) {
                System.out.println(c.getId_tweet() + " - " + c.getData().trim() + " - " + c.getLinha());
            }
        }	
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
