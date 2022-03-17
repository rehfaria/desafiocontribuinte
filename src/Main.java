//desafio contribuintes

import java.util.Locale;
import java.util.Scanner;

public class Main {

	// variavel rendaAnualSalario é o valor que o contribuinte recebe por ano

	static double impostoSobreSalario(double rendaAnualSalario) {

		double impostoDevido = rendaAnualSalario * 0.20;

		if (rendaAnualSalario <= 36000.00) {
			impostoDevido = 0.00;
		} else if (rendaAnualSalario < 60000.00) {
			impostoDevido = rendaAnualSalario * 0.10;
		}

		return impostoDevido;

	}

	// a variavel impostoSobreServico é o valor

	static double impostoSobreServico(double impostoSobreServico) {
		return impostoSobreServico * 0.15;
	}

	// a variavel impostoSobreGanhosCapital é a renda sobre ganhos de capital

	static double impostoSobreGanhosCapital(double impostoSobreGanhosCapital) {
		return impostoSobreGanhosCapital * 0.20;
	}

	// a variavel impostoSalario é o imposto sobre salario
	// a variavel impostoSobreServico é o imposto sobre serviço
	// a variavel impostoGanhoCapital é o imposto sobre ganhos de capital

	static double impostoBrutoTotal(double impostoSalario, double impostoSobreServico, double impostoGanhoCapital) {
		return impostoSalario + impostoSobreServico + impostoGanhoCapital;

	}

	// a variavel impostoBruto é o imposto bruto
	// a variavel gastoMedico é o gasto medico
	// a variavel gastoEducacional é o gasto educacional

	static double abatimento(double impostoBruto, double gastoMedico, double gastoEducacional) {

		return gastoMedico + gastoEducacional > impostoBruto * 0.30 ? impostoBruto * 0.30
				: gastoMedico + gastoEducacional;
	}

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		// definindo o tamanho do meu vetor

		int contribuinte;

		System.out.print("Quantos contribuintes você vai digitar?");
		contribuinte = sc.nextInt();
		System.out.println();

		while (contribuinte <= 0) {
			System.out.print("Quantos contribuintes você vai digitar? ");
			contribuinte = sc.nextInt();

		}

		double[] rendaSalario = new double[contribuinte];
		double[] rendaServico = new double[contribuinte];
		double[] ganhoCapital = new double[contribuinte];
		double[] gastoMedico = new double[contribuinte];
		double[] gastoEducacional = new double[contribuinte];
		double[] impostoBruto = new double[contribuinte];
		double[] abatimento = new double[contribuinte];
		double[] impostoDevido = new double[contribuinte];

		for (int i = 0; i < contribuinte; i++) {

			System.out.printf("Digite os dados do %d%s\n", i + 1, "° contribuinte: ");

			System.out.print("Renda anual com salário: ");
			rendaSalario[i] = sc.nextDouble();

			System.out.print("Renda anual com prestação de serviço: ");
			rendaServico[i] = sc.nextDouble();

			System.out.print("Renda anual com ganho de capital: ");
			ganhoCapital[i] = sc.nextDouble();

			System.out.print("Gastos médicos: ");
			gastoMedico[i] = sc.nextDouble();

			System.out.print("Gastos educacionais: ");
			gastoEducacional[i] = sc.nextDouble();
			System.out.println();

		}

		// usando as funçoes

		for (int i = 0; i < contribuinte; i++) {

			impostoBruto[i] = impostoBrutoTotal(impostoSobreSalario(rendaSalario[i]),
					impostoSobreServico(rendaServico[i]), impostoSobreGanhosCapital(ganhoCapital[i]));

			abatimento[i] = abatimento(impostoBruto[i], gastoMedico[i], gastoEducacional[i]);
			impostoDevido[i] = impostoBruto[i] - abatimento[i];

		}

		// final

		for (int i = 0; i < contribuinte; i++) {

			System.out.printf("Resumo do %d%s\n", i + 1, "° contribuinte: ");
			System.out.printf("Imposto bruto total: %.2f%n ", impostoBruto[i]);
			System.out.printf("Abatimento: %.2f%n ", abatimento[i]);
			System.out.printf("Imposto devido: %.2f%n ", impostoDevido[i]);
			System.out.println();

		}

		sc.close();

	}

}
