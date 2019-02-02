package heranca.exerc;

public class ImportedProduct extends Product {
	
	private double taxaAlfandega;

	public ImportedProduct(String nome, double preco, double taxaAlfandega) {
		super(nome, preco);
		this.taxaAlfandega = taxaAlfandega;
	}

	public double getTaxaAlfandega() {
		return taxaAlfandega;
	}

	public void setTaxaAlfandega(double taxaAlfandega) {
		this.taxaAlfandega = taxaAlfandega;
	}
	
	public double precoTotal() {
		
		return getPreco() + taxaAlfandega;
		
	}
	
	@Override
	public String etiquetaPreco() {
		String taxaAlfandega = Double.toString(getTaxaAlfandega());
		return nome + " $ " + precoTotal() + " (Taxa de alfândega: $ " + taxaAlfandega + ")";
		
	}

}