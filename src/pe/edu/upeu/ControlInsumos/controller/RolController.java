package pe.edu.upeu.ControlInsumos.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import pe.edu.upeu.ControlInsumos.dao.RolDao;
import pe.edu.upeu.ControlInsumos.daoimp.RolDaoImp;

/**
 * Servlet implementation class RolController
 */
@WebServlet("/rc")
public class RolController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RolDao rol = new RolDaoImp();
	private Gson g = new Gson();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RolController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		int op = Integer.parseInt(request.getParameter("opc"));
		switch (op) {
		case 1:
			
			break;
		case 2:
			//read all
			out.println(g.toJson(rol.readall()));
			break;
		case 3:
			
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
