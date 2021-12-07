import java.util.InputMismatchException;

public class Funcionario extends Pessoa{
	private float sal;
	private String funcao;
	
	public Funcionario(String nome, String cpf, Endereco endereco, String celular, float sal, String funcao) {
	super(nome, cpf, endereco, celular);	
	try {
		this.sal=sal;
	}catch(InputMismatchException e) {
		System.out.println("Valor invalido");
	}
	this.funcao=funcao;
	}
	
	@Override
	public String toString(){
		return "Nome do funcionario: "+getNome()+"\nCPF: "+getCpf()+"\nCelular: "+getCelular()+"\nFuncao: "+this.funcao+"\nSalario: "+this.sal+"\n";
	}

}
