import java.util.InputMismatchException;
import java.util.Scanner;

public class Fornecedor implements Verificavel{
	private String razaoSocial; 
	private String nomeFantasia; 
	private String cnpj; 
	private Endereco endereco; 
	private String celular;
	
	public Fornecedor(String razaoSocial, String nomeFantasia, String cnpj, Endereco endereco, String celular) {
		this.razaoSocial=razaoSocial;
		this.nomeFantasia=nomeFantasia;
		this.cnpj=cnpj;
		this.endereco=endereco;
		this.celular=celular;
		
		if(validar(cnpj)==true) {
			this.cnpj=cnpj;
		}
		else {
			solicitarNovo();
		}
	}
	
	@Override
	public String toString() {
		return "Razao Social: " + razaoSocial + ", Nome Fantasia: " + nomeFantasia + ", CNPJ: " + cnpj+","+"\n"
				+ "" + endereco + ", Celular: " + celular + "\n";
	}

	@Override
	public boolean validar(String CNPJ) {
		if (CNPJ.equals("00000000000000") || CNPJ.equals("11111111111111") || CNPJ.equals("22222222222222")
				|| CNPJ.equals("33333333333333") || CNPJ.equals("44444444444444") || CNPJ.equals("55555555555555")
				|| CNPJ.equals("66666666666666") || CNPJ.equals("77777777777777") || CNPJ.equals("88888888888888")
				|| CNPJ.equals("99999999999999") || (CNPJ.length() != 14))
			return (false);

		char dig13, dig14;
		int sm, i, r, num, peso;

		try {
			sm = 0;
			peso = 2;
			for (i = 11; i >= 0; i--) {
				num = (int) (CNPJ.charAt(i) - 48);
				sm = sm + (num * peso);
				peso = peso + 1;
				if (peso == 10)
					peso = 2;
			}

			r = sm % 11;
			if ((r == 0) || (r == 1))
				dig13 = '0';
			else
				dig13 = (char) ((11 - r) + 48);

			sm = 0;
			peso = 2;
			for (i = 12; i >= 0; i--) {
				num = (int) (CNPJ.charAt(i) - 48);
				sm = sm + (num * peso);
				peso = peso + 1;
				if (peso == 10)
					peso = 2;
			}

			r = sm % 11;
			if ((r == 0) || (r == 1))
				dig14 = '0';
			else
				dig14 = (char) ((11 - r) + 48);

			if ((dig13 == CNPJ.charAt(12)) && (dig14 == CNPJ.charAt(13)))
				return (true);
			else
				return (false);
		} catch (InputMismatchException erro) {
			return (false);
		}
	}
	
	@Override
	public void solicitarNovo() {
		Scanner sc = new Scanner(System.in);

		boolean cnpjIncorreto = true;

		while (cnpjIncorreto) {
			System.out.print("CNPJ incorreto. Tente digitar novamente sem pontuação: ");
			String novoCnpj = sc.next();
			if (validar(novoCnpj)) {
				this.cnpj = novoCnpj;
				cnpjIncorreto = false;
			} else {
				cnpjIncorreto = true;
			}
		}
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}
}
