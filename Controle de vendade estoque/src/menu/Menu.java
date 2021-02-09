package menu;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.Scanner;

import Classes.Produtos;

public class Menu {

	public static void main(String[] args) {
		
		
		//cria um vetor de Objetos da classe Produtos
		Produtos[] produto = new Produtos[10];

		for (int i = 0; i < produto.length; i++) {
			produto[i] = new Produtos();
			produto[i].setNome("");
			
		}
		
		

		Random aleatorio = new Random();
		int numeros = aleatorio.nextInt(100);
		
		Scanner sc = null;		
		
		
		//Atributos dos Produtos
		int id;
		int quantidade;
		double preco;
		String nome;
		
		//variaveis para a construçao do programa
		int numVetor;
		int opcao = 0;


		while (opcao != 5) {
			
			System.out.println("-----------------------------");
			System.out.println(" Controle de venda de estoque");
			System.out.println("-----------------------------");
			System.out.println("");
			System.out.println("[1] Cadastrar produtos");
			System.out.println("[2] Consultar produtos cadastrados");
			System.out.println("[3] Listas todos os produtos");
			System.out.println("[4] Editar produto");
			System.out.println("[5] Sair");

			sc = new Scanner(System.in);
			opcao = sc.nextInt();


			
			if (opcao == 1) {
				
				  System.out.println("-----------------------------"); 
				  System.out.println(" Cadastro de produtos"); 
				  System.out.println("-----------------------------");
				  
				  System.out.println("");
				  
				  System.out.println("Id do Produto: "+ (id = numeros));
				  
				  System.out.println("Digite o nome do produto"); 
				  nome = sc.next();
				  
				  System.out.println("Digite o preço do produto"); 
				  preco = sc.nextDouble();
				  
				  System.out.println("Digite a quantidade de produtos"); 
				  quantidade = sc.nextInt();
				  
				  
					
				  // Verifica se o nome do produto ja foi cadastrado				  
			  	  boolean  vdd = true ;
				  while(vdd == true) {
				  
				  vdd = produto[1].lerArquivo(nome);				  
					  if( vdd == true) {					  
						  System.out.println("Produto já cadastrado");					  
						  System.out.println("Digite o nome do produto");
						  nome = sc.next();
					  
					  } 
				  }
					  
				  
					id = 59;  
				  //verifica se o id do produto ja foi cadastrado 
				  vdd = true; 
				  while(vdd == true) {
				  
					vdd = produto[1].lerId(id);
				  	if(vdd == true) {
				  		id = numeros = aleatorio.nextInt(100);; 
				  	}
				  
				  }
					   
				  
				  
				  
			  for(numVetor = 0; numVetor<produto.length; numVetor++) {
					  
					  if((produto[numVetor].getNome() == "") && (produto[numVetor].getId() == 0)){					
						  
						  produto[numVetor].setAll(id, nome, preco, quantidade);
						  produto[numVetor].gravaArquivo(true,false);
						  System.out.println("Gravado com sucesso!");
						  break;
						  
					  }
					  
			  }
		  
			}// Fim do if 1
			
			
			
			
			if(opcao == 2) {
				
				  System.out.println("-----------------------------"); 
				  System.out.println(" Busca de produtos"); 
				  System.out.println("-----------------------------");
				  
				  System.out.println("");
				  
				  System.out.println("Digite o nome do produto ou a id"); 
				  String nomeOuId = sc.next();
				  
				  boolean falso = false;
				  
				  falso = produto[1].Buscaproduto(nomeOuId, falso);
				  
				  if(falso == false ) {
					  System.out.println("Produto não cadastrado!");
				  }
				  
				  
				  	
				
			}
			
			
			
			
			if(opcao == 3) {
				
				  System.out.println("-----------------------------"); 
				  System.out.println(" Lista todos os produtos     "); 
				  System.out.println("-----------------------------");
				  
				  System.out.println("");
				  
				  produto[1].listaProdutos();
				  
				
				
			}
			
			if(opcao == 4) {
				
				  System.out.println("-----------------------------"); 
				  System.out.println(" Editar Produtos    "); 
				  System.out.println("-----------------------------");
				  
				  System.out.println("");
				  
				  System.out.println("Digite o nome do produto ou a id"); 
				  String nomeid = sc.next();
				  
				  boolean verdadeiro = produto[0].editaproduto(nomeid);
				  
				  if(verdadeiro == true) {
					  					  
							FileInputStream arquivo = null;
							InputStreamReader lerArquivo = null;
							BufferedReader convertArquivo = null;
							
							try {
								
								arquivo = new FileInputStream("cadastro_Produto.txt");
								lerArquivo = new InputStreamReader(arquivo);
								convertArquivo = new BufferedReader(lerArquivo);
								
								int n1 = 0;
								
								while(convertArquivo.ready()) {
									
									String linha = convertArquivo.readLine();
									String[] infoproduto = linha.split(";");
									
									
									int idconvertido = Integer.parseInt(infoproduto[0]);
									String nomeconvertido = infoproduto[1];
									double precoconvertido = Double.parseDouble(infoproduto[2]);
									int quantidadeconvertido = Integer.parseInt(infoproduto[3]);
									
									produto[n1].setAll(idconvertido, nomeconvertido,
											precoconvertido,quantidadeconvertido );
									
									n1 = n1 + 1;
									

									
								}

							}catch(IOException e) {
								System.out.println("Não foi possível listar todos produto! ");
							}
						  
						  
					  
					  
				  }// fim do if vdd
				  
				  if(verdadeiro == true) {
					  
				  
				  
				  for( int Vetor = 0; Vetor < produto.length; Vetor++) {
					  if((produto[Vetor].getNome().equals(nomeid))||
							  (Integer.toString(produto[Vetor].getId()).equals(nomeid))) {
						  
						  System.out.println("nome do edit: "+produto[Vetor].getNome());
						  System.out.println("Digite um novo nome: ");
						  String nome2 = sc.next();
						  
						  System.out.println("Digite um preço: ");
						  double preco2 = sc.nextDouble();
						  
						  System.out.println("Digite a quantidade: ");
						  int quantidade2 = sc.nextInt();
						  
						  
						  produto[Vetor].setNome(nome2);
						  produto[Vetor].setPreco(preco2);
						  produto[Vetor].setQuantidade(quantidade2);
					  
						  
					  }
					  
				  }

				boolean gravaVdd= false;
				boolean falso = false;
				
				for(int Vetor = 0; Vetor <produto.length;Vetor++){
					
					if(Vetor == 1) {
						gravaVdd = true;						
					}
					
					falso = produto[Vetor].gravaArquivo(gravaVdd, falso);
					

					
					
				}
				
				if(falso == true) {
					System.out.println("Editado com sucesso");	
				}else {
					System.out.println("Falha ao editar;");
				}
				
				}else {
					System.out.println("Produto cancelado ou nao encontrado!");
				}
				
				
			}//fim do if 4
			
			

		} // fim do while
		
		sc.close();
		
		System.out.println("\r\n");
		System.out.println("*Fim do Programa*");

	}// fim do metodo main

}
