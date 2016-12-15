package z;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class CatalogueMetierImpl implements ICatalogueMetier {

	@Override
	public void addProduit(Produit p) {
		Connection conn=SingletonConnection.getConnection();
		try {
			PreparedStatement ps=conn.prepareStatement("insert into produits(REF_PROD,DESIGNATION,PRIX,QUANTITE) values (?,?,?,?)");
			ps.setString(1, p.getReference());
			ps.setString(2, p.getDesignation());
			ps.setDouble(3, p.getPrix());
			ps.setInt(4, p.getQuantite());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Produit> listProduits() {
		List<Produit> prods=new ArrayList<Produit>();
		Connection conn=SingletonConnection.getConnection();
		try {
			PreparedStatement ps=conn.prepareStatement("select * from produits");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Produit p=new Produit();
				p.setReference(rs.getString("REF_PROD"));
				p.setDesignation(rs.getString("DESIGNATION"));
				p.setPrix(rs.getDouble("PRIX"));
				p.setQuantite(rs.getInt("QUANTITE"));
				prods.add(p);
			}
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return prods;
	}

	@Override
	public List<Produit> produitsParMC(String mc) {
		List<Produit> prods=new ArrayList<Produit>();
		Connection conn=SingletonConnection.getConnection();
		try {
			PreparedStatement ps=conn.prepareStatement("SELECT * FROM cat_prod.produits WHERE DESIGNATION LIKE ?");
			ps.setString(1, ("%"+mc+"%"));
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Produit p=new Produit();
				p.setReference(rs.getString("REF_PROD"));
				p.setDesignation(rs.getString("DESIGNATION"));
				p.setPrix(rs.getDouble("PRIX"));
				p.setQuantite(rs.getInt("QUANTITE"));
				prods.add(p);
			}
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return prods;
	}

	@Override
	public Produit getProduit(String ref) {
		Produit p=null;
		Connection conn=SingletonConnection.getConnection();
		try {
			PreparedStatement ps=conn.prepareStatement("select * from produits where REF_PROD=?");
			ps.setString(1, ref);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				p=new Produit();
				p.setReference(rs.getString("REF_PROD"));
				p.setDesignation(rs.getString("DESIGNATION"));
				p.setPrix(rs.getDouble("PRIX"));
				p.setQuantite(rs.getInt("QUANTITE"));
			}
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(p==null) throw new RuntimeException("Produit "+ref+" does not exist");
		return p;
	}

	@Override
	public void updateProduit(Produit p) {
		Connection conn=SingletonConnection.getConnection();
		try {
			PreparedStatement ps=conn.prepareStatement("update produits set DESIGNATION=?, PRIX=?, QUANTITE=? where REF_PROD=?");
			ps.setString(1, p.getDesignation());
			ps.setDouble(2, p.getPrix());
			ps.setInt(3, p.getQuantite());
			ps.setString(4, p.getReference());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteProduit(String ref) {
		Connection conn=SingletonConnection.getConnection();
		try {
			PreparedStatement ps=conn.prepareStatement("delete from produits where REF_PROD=?");
			ps.setString(1, ref);
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
