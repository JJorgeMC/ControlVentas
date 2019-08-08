package pe.edu.upeu.ControlInsumos.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import pe.edu.upeu.ControlInsumos.dao.DetalleVentaDao;
import pe.edu.upeu.ControlInsumos.daoimp.DetalleVentaDaoImp;
import pe.edu.upeu.ControlInsumos.entity.DetalleVenta;

/**
 * Servlet implementation class DetalleVentaController
 */
@WebServlet("/dvc")
public class DetalleVentaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DetalleVentaDao det = new DetalleVentaDaoImp();
	private Gson g = new Gson();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DetalleVentaController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		int op = Integer.parseInt(request.getParameter("opc"));
		int x;
		switch (op) {
		case 1:
			x = det.create(new DetalleVenta(0, Integer.parseInt(request.getParameter("val1")),Integer.parseInt(request.getParameter("val2")),Double.parseDouble(request.getParameter("val3")),Integer.parseInt(request.getParameter("val4"))));
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
