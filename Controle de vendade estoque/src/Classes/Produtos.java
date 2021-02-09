package Classes;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;




public class Produtos {
	
	private int id;
	private int quantidade;	
	private String nome;
	private double preco;
	
	
	public int getId() {
		return id;
		
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	public void setAll(int id, String nome, double preco, int quantidade) {
		this.id = id;
		this.nome = nome;
		this.preco = preco;
		this.quantidade = quantidade;

		 
	}
	
	public boolean gravaArquivo(boolean testeboolean, boolean falso) {
		
		FileOutputStream arquivo = null;
		
		try{
			
			arquivo = new FileOutputStream("cadastro_Produto.txt", testeboolean);
			
			if((!nome.equals("") ) && (id != 0)) {
				
				String inf = (id+";"+nome+";"+preco+";"+quantidade+"\r\n");
				
				byte[] informacao = inf.getBytes();
				
				arquivo.write(informacao);
				
				falso = true;
			}
			

			
			
			
		}catch(IOException e){
			System.out.println("**falha ao gravar arquivo**");
			
		}
		return falso;
	}
	
	
	
	//verifica se o nome ja esta cadastrado
	public boolean lerArquivo( String nomeProd) {

		boolean retorno = false;
		
		FileInputStream arquivo = null;
		InputStreamReader lerArquivo = null;
		BufferedReader convertArquivo = null;
		
		try {
			
			arquivo = new FileInputStream("cadastro_Produto.txt");
			lerArquivo = new InputStreamReader(arquivo);
			convertArquivo = new BufferedReader(lerArquivo);
			
			while(convertArquivo.ready()) {
				
				String linha = convertArquivo.readLine();
				String[] infoproduto = linha.split(";");
				
				if(infoproduto[1].equals(nomeProd)) { 
					
					retorno = true;
					break;
				}
			}

		}catch(IOException e) {
			System.out.println("Não foi possível ler o arquivo!");
			System.out.println("criando arquivo novo...");
		}
	
		return retorno;
	}
	
	
	
	//verifica se o id ja esta cadastrado
	public boolean lerId( int idProd) {

		boolean retorno = false;
		
		FileInputStream arquivo = null;
		InputStreamReader lerArquivo = null;
		BufferedReader convertArquivo = null;
		
		try {
			
			arquivo = new FileInputStream("cadastro_Produto.txt");
			lerArquivo = new InputStreamReader(arquivo);
			convertArquivo = new BufferedReader(lerArquivo);
			
			while(convertArquivo.ready()) {
				
				String linha = convertArquivo.readLine();
				String[] infoproduto = linha.split(";");
				
				if( Integer.parseInt(infoproduto[0]) ==  idProd) { 
					
					retorno = true;
					break;
				}
			}

		}catch(Exception e) {
			System.out.println("Não foi possível ler o arquivo da ID! ");
			
		}

		return retorno;
	}
	
	
	//Busca pelo nome ou id
		public Boolean Buscaproduto( String nomeouid, boolean falso) {	
			
			FileInputStream arquivo = null;
			InputStreamReader lerArquivo = null;
			BufferedReader convertArquivo = null;
			
			try {
				
				arquivo = new FileInputStream("cadastro_Produto.txt");
				lerArquivo = new InputStreamReader(arquivo);
				convertArquivo = new BufferedReader(lerArquivo);
				
				while(convertArquivo.ready()) {
					
					String linha = convertArquivo.readLine();
					String[] infoproduto = linha.split(";");
					
					if(( infoproduto[0].equals(nomeouid))||(infoproduto[1].equals(nomeouid))) { 
						System.out.println("\r\n");
						System.out.println("Id: "+infoproduto[0]);
						System.out.println("Nome: "+infoproduto[1]);
						System.out.println("Preco: "+infoproduto[2]);
						System.out.println("Quantidade: "+infoproduto[3]);
						System.out.println("\r\n");
						falso = true;

					}
				}

			}catch(IOException e) {
				System.out.println("Não foi possível Buscar o produto! ");
			}
			return falso;
			
		}
		
		
		//Imprime Todos os produtos
		public void listaProdutos( ) {	
			
			FileInputStream arquivo = null;
			InputStreamReader lerArquivo = null;
			BufferedReader convertArquivo = null;
			
			try {
				
				arquivo = new FileInputStream("cadastro_Produto.txt");
				lerArquivo = new InputStreamReader(arquivo);
				convertArquivo = new BufferedReader(lerArquivo);
				
				while(convertArquivo.ready()) {
					
					String linha = convertArquivo.readLine();
					String[] infoproduto = linha.split(";");
					System.out.println("\r\n");
					System.out.println("Id: "+infoproduto[0]);
					System.out.println("Nome: "+infoproduto[1]);
					System.out.println("Preco: "+infoproduto[2]);
					System.out.println("Quantidade: "+infoproduto[3]);
					System.out.println("\r\n");
				}

			}catch(IOException e) {
				System.out.println("Não foi possível listar todos produto! ");
			}
			
		}
		
		
		//atualiza lista do arquivo.txt
		public void atualizaArquivo( ) {	
			
			
			FileInputStream arquivo = null;
			InputStreamReader lerArquivo = null;
			BufferedReader convertArquivo = null;
			
			try {
				
				arquivo = new FileInputStream("cadastro_Produto.txt");
				lerArquivo = new InputStreamReader(arquivo);
				convertArquivo = new BufferedReader(lerArquivo);
				
				while(convertArquivo.ready()) {
					
					String linha = convertArquivo.readLine();
					String[] infoproduto = linha.split(";");
					System.out.println("\r\n");
					System.out.println("Id: "+infoproduto[0]);
					System.out.println("Nome: "+infoproduto[1]);
					System.out.println("Preco: "+infoproduto[2]);
					System.out.println("Quantidade: "+infoproduto[3]);
					System.out.println("\r\n");
					

					
				}

			}catch(IOException e) {
				System.out.println("Não foi possível listar todos produto! ");
			}
			
		}
		
		//editar  produto
		public boolean editaproduto( String nomeouid) {
			
			boolean vdd = false;
			
			Scanner sc = new Scanner(System.in);
			FileInputStream arquivo = null;
			InputStreamReader lerArquivo = null;
			BufferedReader convertArquivo = null;
			
			try {
				
				arquivo = new FileInputStream("cadastro_Produto.txt");
				lerArquivo = new InputStreamReader(arquivo);
				convertArquivo = new BufferedReader(lerArquivo);
				
				while(convertArquivo.ready()) {
					
					String linha = convertArquivo.readLine();
					String[] infoproduto = linha.split(";");
					
					if(( infoproduto[0].equals(nomeouid))||(infoproduto[1].equals(nomeouid))) { 
						System.out.println("\r\n");
						System.out.println("Id: "+infoproduto[0]);
						System.out.println("Nome: "+infoproduto[1]);
						System.out.println("Preco: "+infoproduto[2]);
						System.out.println("Quantidade: "+infoproduto[3]);
						System.out.println("\r\n");
						
						System.out.println("deseja editar ? [1]sim [2]não");
						int decisao = sc.nextInt();
						
						
						if(decisao == 1) {
							
							vdd = true;
						}

					}else {
						if(vdd == false) {
							vdd = false;
						}
					}
				}

			}catch(IOException e) {
				System.out.println("Não foi possível Buscar o produto! ");
			}
			
			return vdd;
			
		}
		



		
		

		
		
		


	
	
		
	
	

}
