 package pe.edu.upeu.ControlInsumos.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import pe.edu.upeu.ControlInsumos.dao.ClienteDao;
import pe.edu.upeu.ControlInsumos.daoimp.ClienteDaoImp;
import pe.edu.upeu.ControlInsumos.entity.Cliente;

/**
 * Servlet implementation class ClienteController
 */
@WebServlet("/clc")
public class ClienteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ClienteDao cli = new ClienteDaoImp();
	private Gson g = new Gson();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClienteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {			
		PrintWriter out = response.getWriter();
		int x = 0;
		int op = Integer.parseInt(request.getParameter("opc"));
		switch (op) {
		case 1:
			//Create
			x = cli.create(new Cliente(0, request.getParameter("name"), request.getParameter("dni")));
			out.println("Cliente registrado correctamente...");
			break;
		case 2:
			//Read
			out.println(g.toJson(cli.read(request.getParameter("dni"))));
			break;
		case 3:
			//update
			break;
		case 4:
			//Delete
			break;
		case 5:
			//readall
			break;
		case 6:
			//existe
			out.println(cli.existe(request.getParameter("dni")));
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
