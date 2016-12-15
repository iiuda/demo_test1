package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import z.CatalogueMetierImpl;
import z.ICatalogueMetier;
import z.Produit;

public class ControleurServlet extends HttpServlet{
	private ICatalogueMetier metier;
	@Override
	public void init() throws ServletException {
		metier=new CatalogueMetierImpl();
	}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("VueProduits.jsp").forward(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProduitModel model=new ProduitModel();
		model.setMotCle(request.getParameter("motCle"));
		List<Produit> produits=metier.produitsParMC(model.getMotCle());
		model.setProduits(produits);
		request.setAttribute("model", model);
		request.getRequestDispatcher("VueProduits.jsp").forward(request, response);
	}
}
