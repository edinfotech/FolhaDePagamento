package folhapagamento;

/* Esta é a classe o qual o usuario digita pelo prompt;
 *  
 * Folha de pagamento no qual o cliente digita o nome,cargo,dias trabalhados e o salario base.
 * O sistema retorna pro usuario os dados digitados e o salario bruto,o salario liquido 
 * o valor da hora trabalhada e o desconto do INSS ja calculando 
 * a porcentagem de desconto referente ao valor do salario.
 * 
 * 
 * 
 * 
 */
import java.util.Scanner;

public class FolhaPagEmOO {

	public static void main(String[] args) {
		
		FolhaPg folha = new FolhaPg();
		Scanner s = new Scanner(System.in);
		

		System.out.println("Funcionario : ");
		folha.setNome(s.nextLine());
		System.out.println("Cargo: ");
		folha.setCargo(s.nextLine());
		System.out.println("Dias Trabalhados :");
		folha.setDiaTrab(Integer.parseInt(s.nextLine()));
		System.out.println("Salario base do funcionario :");
		folha.setSaBase (Double.parseDouble(s.nextLine()));
		
		
		folha.SalarioBase();
		folha.CalcHorasTrabalhadas();
		folha.CalcValorHora();
		folha.CalcINSS();
		folha.SalarioLiquido();
		folha.Relatorio();
		folha.ExportaRelatorio();
		
		s.close();
		
		

	}

}
