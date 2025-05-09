package coisas;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tamanho = 0;
		boolean cond = true;
		int id = 0;

		List<Produto> produtos = new ArrayList<>();
		Produto p = new Produto();

		System.out.println("=====================================================================");
		System.out.println("         BEM VINDO AO SISTEMA DE GESTÃO DE PRODUTOS!!");
		System.out.println("=====================================================================");
		System.out.println("     Vamos adicionar os produtos");
		boolean Valido = false;
		while (!Valido) {
			try {
				System.out.print("Quantos produtos diferentes serão adicionados: ");
				tamanho = sc.nextInt();
				if (tamanho <= 0) {
					System.err.println("Deve ser um número maior que 0");
				} else {
					Valido = true;
				}
			} catch (Exception e) {
				sc.nextLine();
				System.err.println("Deve ser um número inteiro");
			}
		}

		for (int i = 0; i < tamanho; i++) {
			Produto produto = new Produto();
			System.out.println("\n " + (i + 1) + "° Produto:");
			produto.setId(id++);
			produto.Preenchimento();
			produtos.add(produto);
		}
		System.out.println("Seu(s) produto(s):");
		p.MostrarProdutos(produtos);

		while (cond == true) {
			System.out.println("\n=================================");
			System.out.println("              MENU");
			System.out.println("=================================\n");
			System.out.println("[1]- Adicionar produto");
			System.out.println("[2]- Editar produto");
			System.out.println("[3]- Remover produto");
			System.out.println("[4]- Visualizar produtos");
			System.out.println("[5]- Ordernar produtos");
			System.out.println("[6]- Sair");
			System.out.print(" Opção >> ");
			int opcao = sc.nextInt();

			switch (opcao) {
			case 1:
				Valido = false;
				while (!Valido) {
					try {
						System.out.print("\nQuantos produtos diferentes serão adicionados: ");
						tamanho = sc.nextInt();
						Valido = true;
					} catch (Exception e) {
						sc.nextLine();
						System.err.println("Deve ser um número inteiro");
					}
				}
				for (int i = 0; i < tamanho; i++) {
					System.out.println("\nProduto " + (i + 1) + "/" + tamanho);
					Produto produto = new Produto();
					produto.setId(id++);
					produto.Preenchimento();
					produtos.add(produto);

				}

				break;
			case 2:
				System.out.println("\nQue produto você deseja editar?(Id)");
				for (Produto produto : produtos) {
					System.out.println("Id: " + produto.getId() + ", Nome: " + produto.getNome());
				}
				boolean encontrado = false;
				try {
					System.out.print(">> ");
					int ide = sc.nextInt();
					for (Produto produt : produtos) {
						if (ide == produt.getId()) {
							System.out.println("\nO que você gostaria de editar?");
							System.out.print("[1]-Nome\r[2]-Quantidade\r[3]-Preço\r[4]-validade\r[5]-Tudo\r Opção >> ");
							int resp = sc.nextInt();
							produt.Editar(resp);
							encontrado = true;
						}
					}
					if (!encontrado) {
						System.err.println("Produto não encontrado");
					}

				} catch (Exception e) {
					System.err.println("Deve ser um Número inteiro");
				}

				break;

			case 3:
				System.out.println("\nQue produto você deseja remover?(Id)");
				for (Produto produto : produtos) {
					System.out.println("Id: " + produto.getId() + ", Nome: " + produto.getNome());
				}

				try {
					System.out.print(">> ");
					int ids = sc.nextInt();
					encontrado = false;
					for (Produto produto : produtos) {
						if (ids == produto.getId()) {
							System.out.println("Tem certeza que deseja remover " + produto.getNome() + "?[sim/não]");
							encontrado = true;
							String resp = sc.next().toLowerCase();
							if (resp.equals("sim")) {
								produtos.remove(produto.getId());
								System.out.println("Produto removido!");
							}
						}
						if (!encontrado) {
							System.err.println("Produto não encontrado");
						}
					}
				} catch (Exception e) {
					System.err.println("Deve ser um número inteiro");
				}

				break;
			case 4:
				for (Produto Produtos : produtos) {
					System.out.println(Produtos.toString());
				}

				break;
			case 5:
				System.out.println("\nOrdenar por:\r[1]-Id\r[2]-Nome\r[3]-Estoque\r[4]-Preço\r[5]-Validade");
				try {
					System.out.print(" Opção >> ");
					int r = sc.nextInt();
					p.Ordenar(r, produtos);
				} catch (Exception e) {
					System.err.println("Deve ser um número inteiro");
				}

				break;
			case 6:
				cond = false;
				System.out.println("Muito Obrigado!!");
				break;

			default:
				break;
			}
		}
	}
}
