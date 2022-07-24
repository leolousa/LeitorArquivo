package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import application.model.Product;

/**
 * Leitura de arquivo Texto
 * v4.0
 * @author Leonardo
 *
 */
public class Program {

	public static void main(String[] args) {

		String path = "C:\\temp\\in.txt";
		
		List<Product> produtos = new ArrayList<Product>();

		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			String line = br.readLine();
			line = br.readLine();
			
			while (line != null) {
				String[] vetor = line.split(",");
				
				String name = vetor[0];
				Double price = Double.parseDouble(vetor[1]);
				Integer qtd = Integer.parseInt(vetor[2]);
				
				Product prod = new Product(name, price, qtd);
				
				produtos.add(prod);
				
				line = br.readLine();
			}
		} 
		catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		} 
		
		System.out.println("PRODUCTS:");
		for(Product p : produtos) {
			System.out.println(p);
		}
	}

}
