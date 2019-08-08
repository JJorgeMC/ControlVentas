package pe.edu.upeu.ControlInsumos.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.sun.org.apache.bcel.internal.generic.SWITCH;

import pe.edu.upeu.ControlInsumos.dao.UsuarioDao;
import pe.edu.upeu.ControlInsumos.daoimp.UsuarioDaoImp;
import pe.edu.upeu.ControlInsumos.entity.Usuario;

/**
 * Servlet implementation class UsuarioController
 */
@WebServlet("/uc")
public class UsuarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UsuarioDao usu = new UsuarioDaoImp();
	private Gson g = new Gson();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UsuarioController() {
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
			//log
			out.println(usu.log(request.getParameter("name"), request.getParameter("pass")));
			break;
		case 2:
			//read
			out.println(g.toJson(usu.read(request.getParameter("name"),request.getParameter("pass"))));
			break;
		case 3:
			//Create
			x = usu.create(new Usuario(0, Integer.parseInt(request.getParameter("rol")),request.getParameter("name"), request.getParameter("clave")));
			out.println("Usuario registrado correctamente...");
			break;
		case 4:
			
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
