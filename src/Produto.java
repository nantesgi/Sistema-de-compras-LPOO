import java.util.InputMismatchException;

public class Produto implements Comparable<Object> {
	private String nomeProduto; 
	private float valor; 
	private Fornecedor empresa;
	
	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public Fornecedor getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Fornecedor empresa) {
		this.empresa = empresa;
	}

	public Produto(String nomeProduto, float valor, Fornecedor empresa) {
		this.nomeProduto=nomeProduto;
		this.empresa=empresa;
		try {
			this.valor=valor;
		} 
		catch(InputMismatchException e){
			System.out.println("Erro");
		}
	}
	
	@Override
    public int compareTo(Object obj) {
        return (int) (this.getValor() - (((Produto) obj).getValor()));
    }
	
	@Override
	public String toString() {
		return nomeProduto+" R$: "+valor;
	}
}