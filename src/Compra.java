import java.util.ArrayList;
import java.util.Collections;

public class Compra {
	private Funcionario funcionario; 
	private Cliente cliente; 
	private ArrayList <Produto> compra=new ArrayList<>();
	
	public Compra(Funcionario funcionario, Cliente cliente) {
		this.funcionario=funcionario;
		this.cliente=cliente;
	}
	
	void adicionarProduto(Produto prod) {
		this.compra.add(prod);
	}
	
	public void listarCompra() {
		Collections.sort(compra);
		System.out.println(compra);
		System.out.println("Funcionario: "+funcionario.getNome()+"\nCliente: "+cliente.getNome());
		float total=0;
		
		for(Produto produto : compra) {
			total+=produto.getValor();
		}
		System.out.printf("Valor total: %.2f\n", total);
		System.out.print("\n");
	}

}
