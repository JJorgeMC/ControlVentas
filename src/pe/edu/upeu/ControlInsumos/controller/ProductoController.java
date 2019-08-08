package pe.edu.upeu.ControlInsumos.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import pe.edu.upeu.ControlInsumos.dao.ProductoDao;
import pe.edu.upeu.ControlInsumos.daoimp.ProductoDaoImp;
import pe.edu.upeu.ControlInsumos.entity.Producto;

/**
 * Servlet implementation class ProductoController
 */
@WebServlet("/pc")
public class ProductoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductoDao pro = new ProductoDaoImp();
	private Gson g = new Gson();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductoController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		int op = Integer.parseInt(request.getParameter("opc"));
		int x = 0;
		switch (op) {
		case 1:
			int w = Integer.parseInt(request.getParameter("id"));
			if(w == 0) {
				x = pro.create(new Producto(0, Integer.parseInt(request.getParameter("id_cat")),request.getParameter("name"),Double.parseDouble(request.getParameter("precio")),Integer.parseInt(request.getParameter("cant"))));
				out.println("Requistro guardado correctamente");
			}else {
				x = pro.update(new Producto(w, Integer.parseInt(request.getParameter("id_cat")),request.getParameter("name"),Double.parseDouble(request.getParameter("precio")),Integer.parseInt(request.getParameter("cant"))));
				out.println("Registro guardado satisfactoriamente...");
			}
			break;
		case 2:
			out.println(g.toJson(pro.readall()));
			break;
		case 3:
			out.println(g.toJson(pro.delete(Integer.parseInt(request.getParameter("id")))));
			break;
		case 4:
			out.println(g.toJson(pro.read(Integer.parseInt(request.getParameter("id")))));
			break;
		case 5:
			out.println(g.toJson(pro.updateStock(Integer.parseInt(request.getParameter("id")), Integer.parseInt(request.getParameter("cant")))));
		default:
			break;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
