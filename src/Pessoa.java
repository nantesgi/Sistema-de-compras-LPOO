import java.util.InputMismatchException;
import java.util.Scanner;

public abstract class Pessoa implements Verificavel {
	private String nome; 
	private String cpf; 
	private Endereco endereco; 
	private String celular;
	
	public Pessoa(String nome, String cpf, Endereco endereco, String celular) {
		this.nome=nome;
		this.endereco=endereco;
		this.celular=celular;
		
		if(validar(cpf)==true) {
			this.cpf=cpf;
		}
		else {
			solicitarNovo();
		}
	}
	
	@Override
	public boolean validar(String CPF) {
		 if (CPF.equals("00000000000") || CPF.equals("11111111111") || CPF.equals("22222222222")
				|| CPF.equals("33333333333") || CPF.equals("44444444444") || CPF.equals("55555555555")
				|| CPF.equals("66666666666") || CPF.equals("77777777777") || CPF.equals("88888888888")
				|| CPF.equals("99999999999") || (CPF.length() != 11))
			return (false);

		char dig10, dig11;
		int sm, i, r, num, peso;

		try {
			sm = 0;
			peso = 10;
			for (i = 0; i < 9; i++) {
				num = (int) (CPF.charAt(i) - 48);
				sm = sm + (num * peso);
				peso = peso - 1;
			}

			r = 11 - (sm % 11);
			if ((r == 10) || (r == 11))
				dig10 = '0';
			else
				dig10 = (char) (r + 48); 

			sm = 0;
			peso = 11;
			for (i = 0; i < 10; i++) {
				num = (int) (CPF.charAt(i) - 48);
				sm = sm + (num * peso);
				peso = peso - 1;
			}

			r = 11 - (sm % 11);
			if ((r == 10) || (r == 11))
				dig11 = '0';
			else
				dig11 = (char) (r + 48);

			if ((dig10 == CPF.charAt(9)) && (dig11 == CPF.charAt(10)))
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

		boolean cpfIncorreto = true;

		while (cpfIncorreto) {
			System.out.print("CPF incorreto. Tente digitar novamente sem pontuação: ");
			String novoCpf = sc.next();
			if (validar(novoCpf)) {
				this.cpf = novoCpf;
				cpfIncorreto = false;
			} else {
				cpfIncorreto = true;
			}
		}
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
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
