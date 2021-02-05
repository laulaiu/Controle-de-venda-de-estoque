package Classes;

import java.io.FileOutputStream;

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
	
	
//	public void gravarInfo(String juncaoProdutos) {
//		FileOutputStream documento = null;
//		
//		juncaoProdutos = this.id + ";" + this.nome +";" + this.preco +";" + this.quantidade  ;
//		 try {
//			 documento= new FileOutputStream("cadastro_Produtos.txt", true);
//			  
//			 byte[] produtoByte = juncaoProdutos.getBytes();
//			  
//			 documento.write(produtoByte);
//
//		 }catch(Exception e) {
//			 System.out.println("erro inesperado! ");
//		 }
//		  
//		 System.out.println("Cadastro Realizado");
//		
//	}
	
	
		
	
	

}
