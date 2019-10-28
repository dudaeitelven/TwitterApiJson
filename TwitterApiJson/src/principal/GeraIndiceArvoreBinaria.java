package principal;

import java.io.*;
import java.util.*;



class No {
	public long item;
	public long linha;
	public No dir;
	public No esq;
}

////////////////////////////////////////////////
class Tree {
	private No root; // raiz
	private static ArrayList<DadosTweet> aDadosTweet = new ArrayList<DadosTweet>();

	public Tree() {
		root = null;
	} // inicializa arvore

	public void inserir(long v, long linha) {
		No novo = new No(); 
		novo.item = v; 
		novo.linha = linha; 
		novo.dir = null;
		novo.esq = null;

		if (root == null)
			root = novo;
		else { 
			No atual = root;
			No anterior;
			while (true) {
				anterior = atual;
				if (v <= atual.item) {
					atual = atual.esq;
					if (atual == null) {
						anterior.esq = novo;
						return;
					}
				} 
				else { 
					atual = atual.dir;
					if (atual == null) {
						anterior.dir = novo;
						return;
					}
				} 
			} 
		} 

	}

	public long buscar(long chave) {
		if (root == null)
			return 0; 
		No atual = root; 
		while (atual.item != chave) { 
			if (chave < atual.item)
				atual = atual.esq; 
			else
				atual = atual.dir; 
			if (atual == null)
				return 0; 
		} 
		return atual.linha; 
	}

	
	
	public void insereDados () {
		CarregarArquivoDados carregaDados = new CarregarArquivoDados();
		aDadosTweet = carregaDados.RetornarArquivoDados();
		int i;
		for (i=0;i<=aDadosTweet.size()-1;i++) {
			inserir(aDadosTweet.get(i).getIdTweet(),aDadosTweet.get(i).getLinha());
		}  

	}

	 public void caminhar() {
		    System.out.print("\n Exibindo em ordem: ");
		    inOrder(root);
		    System.out.print("\n Exibindo em pos-ordem: ");
		    posOrder(root);
		    System.out.print("\n Exibindo em pre-ordem: ");
		    preOrder(root);
		    //System.out.print("\n Altura da arvore: " + altura(root));
		   // System.out.print("\n Quantidade de folhas: " + folhas(root));
		    System.out.print("\n Quantidade de Nós: " + contarNos(root));
		    if (root != null ) {  // se arvore nao esta vazia
		       System.out.print("\n Valor minimo: " + min().item);
		       System.out.println("\n Valor maximo: " + max().item);
		    }
		  }

		  public void inOrder(No atual) {
		    if (atual != null) {
		      inOrder(atual.esq);
		      System.out.print(atual.item + " ");
		      inOrder(atual.dir);
		    }
		  }
		  
		  public void preOrder(No atual) {
		    if (atual != null) {
		      System.out.print(atual.item + " ");
		      preOrder(atual.esq);
		      preOrder(atual.dir);
		    }
		  }
		  
		  public void posOrder(No atual) {
		    if (atual != null) {
		      posOrder(atual.esq);
		      posOrder(atual.dir);
		      System.out.print(atual.item + " ");
		    }
		  }  
		  
		  public int altura(No atual) {
		     if(atual == null || (atual.esq == null && atual.dir == null))
		       return 0;
		     else {
		   	if (altura(atual.esq) > altura(atual.dir))
		   	   return ( 1 + altura(atual.esq) );
		   	else
			   return ( 1 + altura(atual.dir) );
		     }
		  }
		  
		  public int folhas(No atual) {
		    if(atual == null) return 0;
		    if(atual.esq == null && atual.dir == null) return 1;
		    return folhas(atual.esq) + folhas(atual.dir);
		  }
		  
		  public int contarNos(No atual) {
		   if(atual == null)  return 0;
		   else return ( 1 + contarNos(atual.esq) + contarNos(atual.dir));
		  }

		  public No min() {
		    No atual = root;
		    No anterior = null;
		    while (atual != null) {
		      anterior = atual;
		      atual = atual.esq;
		    }
		    return anterior;
		  }

		  public No max() {
		    No atual = root;
		    No anterior = null;
		    while (atual != null) {
		      anterior = atual;
		      atual = atual.dir;
		    }
		    return anterior;
		  }

		  
		  public void buscaNoArquivo(long linha) {
				long indice = 0;
				
				//indice = (linha-1) * 392;
				indice = linha;
				
				if (linha == 0) indice = 1;
				
				
				
				if (indice != 0) {
					 try {
						BusarSeek.ProcurarNoArquivoSeek(indice);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				else {
					System.out.println("Valor nao encontrado no Arquivo! \n");
				}
		       
			}
			
}






class GeraIndiceArvoreBinaria {
	public static void main() {
		Scanner le = new Scanner(System.in);
		Tree arv = new Tree();
		long busca, linha;
		
		arv.insereDados();
	
		System.out.print("\n Informe o Id do Tweet para buscar:  ");
		busca = le.nextLong();	
		linha = arv.buscar(busca);
		arv.buscaNoArquivo(linha);
		
	

	}
}
