package z;

import java.io.Serializable;

public class Produit implements Serializable{
	private String reference;
	private String designation;
	private double prix;
	private int quantite;
	public String getReference() {
		return reference;
	}
	public void setReference(String refernce) {
		this.reference = refernce;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	public Produit() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Produit(String refernce, String designation, double prix, int quantite) {
		super();
		this.reference = refernce;
		this.designation = designation;
		this.prix = prix;
		this.quantite = quantite;
	}
	
}
