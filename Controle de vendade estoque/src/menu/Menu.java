package menu;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.Random;

import java.util.Scanner;
import Classes.Produtos;

public class Menu {

	public static void main(String[] args) {

		Produtos[] produto = new Produtos[100];

		for (int i = 0; i < produto.length; i++) {
			produto[i] = new Produtos();
		}

		Random aleatorio = new Random();
		int numeros = aleatorio.nextInt(100);
		
		Scanner sc = null;
		
		//Manipula arquivo txt
		FileInputStream  consultaArquivo = null;
		InputStreamReader lendoArquivo = null;
		BufferedReader  convertendoArquivo = null;
		
		
		//Atributos dos Produtos
		int id;
		int quantidade;
		double preco;
		String nome;
		
		//variaveis para a construçao do programa
		String consultaProduto;
		int decisao = 0;
		int opcao = 0;
		int numVetor= 0;
		int verificaId = 1 ;
		
		

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
				  
				  System.out.println("Deseja salvar o cadastro ? [1=sim] [0=nao]");
				  decisao = sc.nextInt();
				  
				  FileOutputStream documento = null;
				  
				  for(numVetor = 0; numVetor <= produto.length; numVetor++) {
					  if(produto[numVetor].getNome() == null) {
						  
						  break;
						 
					  }
					  
				  }
				  
				 if ((decisao == 1 )&&(produto[numVetor].getNome() == null ) ) {			
					 	 
						
						 try {

								//*************compara****************
								try {									
									
									consultaArquivo = new FileInputStream("cadastro_Produtos.txt");
									lendoArquivo = new InputStreamReader(consultaArquivo);
									convertendoArquivo = new BufferedReader(lendoArquivo);

									
									
										id = 24;
										
										String passagem = convertendoArquivo.readLine();
										String[] informacao = passagem.split(";");
										

										while(verificaId == 1) {
											
											while(convertendoArquivo.ready()) {
												
												//verifica se o id ja foi cadastrado;
																	
												if(informacao[0].equals( String.valueOf(id) )) {
													System.out.println("id ja existe");
													id = numeros;
													verificaId = 1;
													
												}else {
													System.out.println("Id disponivel");
													verificaId = 0;
												}
												
												
												
												//verifica se o nome ja foi cadastrado
												if((informacao[1].equals(nome))) {
													
													System.out.println("Produto já cadastrado");
													System.out.println("Digite o nome do produto"); 
													nome = sc.next();
													
											
													
												}else {
													
													 System.out.println("entro no try catch");
													 produto[numVetor].setNome(nome);
													 produto[numVetor].setPreco(preco);
													 produto[numVetor].setQuantidade(quantidade);
													 
												}
											}
										}
									
									
								}catch(Exception e) {
									System.out.println("Erro inesperado");
								}
							 
							 produto[numVetor].setId(id); 
							 
							 String juncaoProdutos = id + ";" + nome +";" + preco +";" + quantidade +  "\r\n"  ;
							 System.out.println(juncaoProdutos);
							 
							 documento= new FileOutputStream("cadastro_Produtos.txt", true);
							 						 
						  
							 byte[] produtoByte = juncaoProdutos.getBytes();
						  
							 documento.write(produtoByte);
						  
						  }catch(Exception e) { 
							  System.out.println("erro inesperado! "); 
						  }
						 
					  
						 System.out.println("Cadastro Realizado"); 
				 }else {
					 System.out.println("Cadastro pedido");
				 }					
				
			}// fim do if opcao 1
			
			
			
	
			
			
			//consultando produto no arquivo txt
			
			if (opcao == 2) {
				System.out.println("-----------------------------");
				System.out.println("  Consulta de Produto    ");
				System.out.println("-----------------------------");

				System.out.println("Digite o nome do produto ou ID");
				consultaProduto = sc.next();
				

				
				//*************busca o Produto****************
				try {									
					
					consultaArquivo = new FileInputStream("cadastro_Produtos.txt");
					lendoArquivo = new InputStreamReader(consultaArquivo);
					convertendoArquivo = new BufferedReader(lendoArquivo);

					
					while(convertendoArquivo.ready()) {
						
						
						String passagem = convertendoArquivo.readLine();
						String[] informacao = passagem.split(";");
						
						if((informacao[0].equals(consultaProduto)) || (informacao[1].equals(consultaProduto)))  {
							
							System.out.println("\r\n");
							System.out.println("ID: "+informacao[0]);
							System.out.println("Nome: "+informacao[1]);
							System.out.println("Preco: "+informacao[2]);
							System.out.println("Quantidade: "+informacao[3]);
							System.out.println("\r\n");
							
						}
				
					}
					
				}catch(Exception e) {
					System.out.println("Erro inesperado");
				}
				


			} // fim if opcao 2

		} // fim do while

	}// fim do metodo main

}
