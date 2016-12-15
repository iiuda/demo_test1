package z;
import java.util.List;

public class TestMetier {

	public static void main(String[] args) {
		ICatalogueMetier metier=new CatalogueMetierImpl();
		//ICatalogueMetier metier=new CatalogueMetierImpl();
/*		metier.addProduit(new Produit("REF05", "AA", 870, 3));
		metier.addProduit(new Produit("REF06", "BB", 345, 12));
		metier.addProduit(new Produit("REF07", "CC", 65, 2));*/
		
		System.out.println("--------------------------------");
		List<Produit> prods=metier.listProduits();
		for(Produit p:prods){
			System.out.println(p.getDesignation());
		}
		System.out.println("--------------------------------");
		List<Produit> prods2=metier.produitsParMC("HP");
		for(Produit p:prods2){
			System.out.println(p.getDesignation());
		}
		System.out.println("--------------------------------");
		try{
			Produit p=metier.getProduit("PR02");
			System.out.println(p.getDesignation());
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		System.out.println("--------------------------------");
		try{
			Produit p=metier.getProduit("PR02");
			p.setPrix(9000);
			metier.updateProduit(p);
			Produit p2=metier.getProduit("PR02");
			System.out.println(p2.getPrix());
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		System.out.println("--------------------------------");
		//metier.deleteProduit("PR05");
	}

}
