package heranca.exerc;

import java.text.SimpleDateFormat;

import java.util.Date;

public class UsedProduct extends Product {
	
	private Date dataFabricacao;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public UsedProduct(String nome, double preco, Date dataFabricacao) {
		super(nome, preco);
		this.dataFabricacao = dataFabricacao;
	}

	public Date getDataFabricação() {
		return dataFabricacao;
	}

	public void setDataFabricação(Date dataFabricacao) {
		this.dataFabricacao = dataFabricacao;
	}
	
	@Override
	public String etiquetaPreco() {
		String preco = Double.toString(getPreco());
		return nome + " (usado) $ " + preco + " (Data de fabricação: " + sdf.format(dataFabricacao) + ")";
	}
}
