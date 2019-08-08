package pe.edu.upeu.ControlInsumos.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import pe.edu.upeu.ControlInsumos.dao.CategoriaDao;
import pe.edu.upeu.ControlInsumos.daoimp.CategoriaDaoImp;
import pe.edu.upeu.ControlInsumos.entity.Categoria;

/**
 * Servlet implementation class CategoriaController
 */
@WebServlet("/cc")
public class CategoriaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CategoriaDao cat = new CategoriaDaoImp();
	private Gson g = new Gson();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CategoriaController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		
		int op = Integer.parseInt(request.getParameter("opc"));
		int x = 0;
		switch (op) {
		case 1:
			int w = Integer.parseInt(request.getParameter("id"));
			if(w==0) {
				x = cat.create(new Categoria(0,request.getParameter("name")));
				out.println("Registro guardado correctamente...");
			}else {
				x = cat.update(new Categoria(w, request.getParameter("name")));
				out.println("Registro modificado correctamente...");
			}
			break;
		case 2:
			out.println(g.toJson(cat.readall()));
			break;
		case 3:
			out.println(g.toJson(cat.delete(Integer.parseInt(request.getParameter("id")))));
			break;
		case 4:
			out.println(g.toJson(cat.read(Integer.parseInt(request.getParameter("id")))));
			break;

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
