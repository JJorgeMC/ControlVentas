package pe.edu.upeu.ControlInsumos.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import pe.edu.upeu.ControlInsumos.dao.VentaDao;
import pe.edu.upeu.ControlInsumos.daoimp.VentaDaoImp;
import pe.edu.upeu.ControlInsumos.entity.Venta;

/**
 * Servlet implementation class VentaController
 */
@WebServlet("/vc")
public class VentaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private VentaDao ven = new VentaDaoImp();
	private Gson g = new Gson();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VentaController() {
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
			//create
			Timestamp t = new Timestamp(System.currentTimeMillis());
			x = ven.create(new Venta(0, Integer.parseInt(request.getParameter("id_usuario")),Integer.parseInt(request.getParameter("id_cliente")),request.getParameter("tipo_doc"), t,request.getParameter("num_doc")));
			break;
		case 6:
			out.println(g.toJson(ven.getVentasLength()));
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
