
public class Cliente extends Pessoa {
	public Cliente(String nome, String cpf, Endereco endereco, String celular) {
		super(nome, cpf, endereco, celular);
	}
	
	@Override
	public String toString(){
		return "Nome de cliente: "+getNome()+"\nCPF: "+getCpf()+"\nCelular: "+getCelular()+"\n";
	}
}
