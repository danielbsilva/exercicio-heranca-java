package heranca.exerc;

import java.text.ParseException;

import java.text.SimpleDateFormat;

import java.util.ArrayList;

import java.util.Date;

import java.util.List;

import java.util.Scanner;

public class Application {

	public static void main(String[] args) {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		Scanner scan = new Scanner(System.in);

		System.out.print("Entre com o número de produtos: ");
		int n = scan.nextInt();

		List<Product> list = new ArrayList<Product>();

		for (int i = 1; i <= n; i++) {

			System.out.println("Produto #" + i + " dados: ");
			System.out.print("Comum, usado ou importado (c/u/i)? ");
			char tipo = scan.next().charAt(0);
			System.out.print("Nome: ");
			scan.nextLine();
			String nome = scan.nextLine();
			System.out.print("Preço: ");
			double preco = scan.nextDouble();

			if (tipo == 'c' || tipo == 'C') {
				list.add(new Product(nome, preco));
			} else if (tipo == 'i' || tipo == 'I') {
				System.out.print("Taxa de alfândega: ");
				double taxaAlfandega = scan.nextDouble();
				list.add(new ImportedProduct(nome, preco, taxaAlfandega));
			} else if (tipo == 'u' || tipo == 'U') {
				System.out.print("Data de fabricação (DD/MM/YYYY): ");
				try {
					Date dataFabricacao = sdf.parse(scan.next());
					list.add(new UsedProduct(nome, preco, dataFabricacao));
				} catch (ParseException e) {
					System.out.println("Data inválida");
				}
			}
		}
		System.out.println();
		System.out.println("ETIQUETA DE PREÇOS: ");
		for (Product p : list) {
			System.out.println(p.etiquetaPreco());
		}
		scan.close();
	}
}
