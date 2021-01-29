package menu;

import java.util.Random;
import java.util.Scanner;
import Classes.Produtos;


public class Menu {

	public static void main(String[] args) {
		
		Produtos[] produto = new Produtos[100];
		
		Random aleatorio = new Random();
		int numeros = aleatorio.nextInt(100);
		
		System.out.println(numeros);
		
		
		int quantidade;
		double preco;
		String nome;
		
		int decisao = 0;
		int opcao=0;
		
		
		while(opcao != 5){
			
			
			System.out.println("-----------------------------");
			System.out.println(" Controle de venda de estoque");
			System.out.println("-----------------------------");
			System.out.println("");
			System.out.println("[1] Cadastrar produtos");
			System.out.println("[2] Consultar produtos cadastrados");
			System.out.println("[3] Listas todos os produtos");
			System.out.println("[4] Editar produto");
			System.out.println("[5] Sair");
			
			Scanner sc = new Scanner(System.in);
			opcao = sc.nextInt();
			
			
			if(opcao == 1){
				
				System.out.println("-----------------------------");
				System.out.println(" Cadastro de produtos");
				System.out.println("-----------------------------");
				
				System.out.println("");
				
				System.out.println("Digite o nome do produto");
				nome = sc.next();
				
				
				System.out.println("Digite o preço do produto");
				preco = sc.nextDouble();
				
				
				System.out.println("Digite a quantidade de produtos");
				quantidade = sc.nextInt();
				
				System.out.println("Deseja salvar o cadastro ? [1=sim] [0=nao]");
				decisao = sc.nextInt();
				
				
				if(decisao == 1) {
					System.out.println("entrou no if");
					
					produto[0].setNome(nome);
					produto[0].setPreco(preco);
					produto[0].setQuantidade(quantidade);
					produto[0].setId(numeros);
					System.out.println("Cadastro finalizado!");
				}else {
					System.out.println("Cadastro perdido");
				}
				
				
			}
			sc.close();
		
		
		}
		
		
		
		
		
		


	}

}
