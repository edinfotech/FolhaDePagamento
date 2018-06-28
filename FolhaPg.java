package folhapagamento;

/* Esta é a classe principal 
 * Folha de pagamento no qual o cliente digita o nome,cargo,dias trabalhados e o salario base.
 * O sistema retorna pro usuario os dados digitados e o salario bruto,o salario liquido 
 * o valor da hora trabalhada e o desconto do INSS ja calculando 
 * a porcentagem de desconto referente ao valor do salario.
 * 
 * 
 * 
 * 
 */
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.NumberFormat;

public class FolhaPg {
	
	// Variaveis encapsuladas

	private String Nome, Cargo;
	private Double INSS1 = 8.0, INSS2 = 9.0, INSS3 = 11.0, INSS4 = 621.04;
	private Double SaBase, SaLiq, SaBtr, INSS;
	private Double HrTrab1 = 7.33, VlHora, HrTrab2;
	private int Hrmes = 220, DiaTrab;

	// Conversor para Real(Brasileiro)
	NumberFormat f = NumberFormat.getCurrencyInstance();

	// Pasta a qual vai o arquivo de texto
	Path path = Paths.get("c:/cursojava/textos/relatorio2.txt");
	Charset utf8 = StandardCharsets.UTF_8;

	// metodos getters e setters

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public String getCargo() {
		return Cargo;
	}

	public void setCargo(String cargo) {
		Cargo = cargo;
	}

	public Double getINSS1() {
		return INSS1;
	}

	public void setINSS1(Double iNSS1) {
		INSS1 = iNSS1;
	}

	public Double getINSS2() {
		return INSS2;
	}

	public void setINSS2(Double iNSS2) {
		INSS2 = iNSS2;
	}

	public Double getINSS3() {
		return INSS3;
	}

	public void setINSS3(Double iNSS3) {
		INSS3 = iNSS3;
	}

	public Double getINSS4() {
		return INSS4;
	}

	public void setINSS4(Double iNSS4) {
		INSS4 = iNSS4;
	}

	public Double getSaBase() {
		return SaBase;
	}

	public void setSaBase(Double saBase) {
		SaBase = saBase;
	}

	public Double getSaLiq() {
		return SaLiq;
	}

	public void setSaLiq(Double saLiq) {
		SaLiq = saLiq;
	}

	public Double getSaBtr() {
		return SaBtr;
	}

	public void setSaBtr(Double saBtr) {
		SaBtr = saBtr;
	}

	public Double getINSS() {
		return INSS;
	}

	public void setINSS(Double iNSS) {
		INSS = iNSS;
	}

	public Double getHrTrab1() {
		return HrTrab1;
	}

	public void setHrTrab1(Double hrTrab1) {
		HrTrab1 = hrTrab1;
	}

	public Double getVlHora() {
		return VlHora;
	}

	public void setVlHora(Double vlHora) {
		VlHora = vlHora;
	}

	public Double getHrTrab2() {
		return HrTrab2;
	}

	public void setHrTrab2(Double hrTrab2) {
		HrTrab2 = hrTrab2;
	}

	public int getHrmes() {
		return Hrmes;
	}

	public void setHrmes(int hrmes) {
		Hrmes = hrmes;
	}

	public int getDiaTrab() {
		return DiaTrab;
	}

	public void setDiaTrab(int diaTrab) {
		DiaTrab = diaTrab;
	}

	void CalcHorasTrabalhadas() {
		HrTrab2 = DiaTrab * HrTrab1;
	}

	void CalcValorHora() {
		VlHora = SaBase / Hrmes;
	}

	void CalcINSS() {
		if (SaBtr <= 1_693.72) {
			INSS = INSS1 * SaBtr / 100;
		} else if (SaBtr > 1_693.72 && SaBtr <= 2_822.90) {
			INSS = INSS2 * SaBtr / 100;
		} else if (SaBtr > 2_822.90 && SaBtr <= 5_645.80) {
			INSS = INSS3 * SaBtr / 100;
		} else {
			INSS = INSS4;
		}

	}

	void SalarioLiquido() {
		SaLiq = SaBtr - INSS;
	}

	void SalarioBase() {
		SaBtr = SaBase / 30 * DiaTrab;
	}
    
	//Mostra o relario no prompt
	void Relatorio() {
		System.out.println("Funcionario : " + Nome + "\n Cargo : " + Cargo + "\n Dias Trabalhados : " + DiaTrab);
		System.out.println("Salario Base:" + f.format(SaBase));
		System.out.println("Salario Bruto:" + f.format(SaBtr));
		System.out.println("Horas Trabalhadas :" + HrTrab2);
		System.out.println("Valor Horas Trabalhada :" + f.format(VlHora));
		System.out.println("*******************************");
		System.out.println("Salario Liquido:" + f.format(SaLiq));
		System.out.println("Desconto INSS:" + f.format(INSS));
	}
	//exporta o relatorio para um arquivo de texto
	void ExportaRelatorio() {
		try (BufferedWriter w = Files.newBufferedWriter(path, utf8);) {

			w.write("Funcionario : " + Nome + "\r\n Cargo :" + Cargo + "\r\n Dias Trabalhados : " + DiaTrab);
			w.write("\r\n Salario Base:" + f.format(SaBase));
			w.write("\r\n Salario Bruto:" + f.format(SaBtr));
			w.write("\r\n Horas Trabalhadas :" + HrTrab2);
			w.write("\r\n Valor Horas Trabalhada :" + f.format(VlHora));
			w.write("\r\n *******************************");
			w.write("\r\n Salario Liquido:" + f.format(SaLiq));
			w.write("\r\n Desconto INSS:" + f.format(INSS));

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
