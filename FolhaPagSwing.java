package folhapagamento;

/* Esta é a classe a qual o usuario entra com dados via janela(JOptionPane);
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
import javax.swing.*;
public class FolhaPagSwing {

	public static void main(String[] args) {
		
		FolhaPg folha2 = new FolhaPg();
		
		folha2.setNome(JOptionPane.showInputDialog("Funcionario :"));
		folha2.setCargo(JOptionPane.showInputDialog("Cargo :"));
		folha2.setDiaTrab(Integer.parseInt(JOptionPane.showInputDialog("Dias trabalhados :")));
		folha2.setSaBase(Double.parseDouble(JOptionPane.showInputDialog("Salario base do funcionario :")));
		
		folha2.SalarioBase();
		folha2.CalcHorasTrabalhadas();
		folha2.CalcValorHora();
		folha2.CalcINSS();
		folha2.SalarioLiquido();
		folha2.Relatorio();
		folha2.ExportaRelatorio();
		
		
	}

}
