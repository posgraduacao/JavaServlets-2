package up.jservlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SearchJobServlet
 */
@WebServlet("/SearchJobServlet")
public class SearchJobServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SearchJobServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Método Post");

		String searchString = request.getParameter("searchstring");

		String[] states = request.getParameterValues("state");

		PrintWriter pw = response.getWriter();
		pw.println("<html>");
		pw.println("<head>");
		pw.println("Results");
		pw.println("</head>");
		pw.println("<hr>");
		pw.println("<body>");
		if (states != null) {
			for (int i = 0; i < states.length; ++i) {
				pw.println("Estado: " + states[i]);
				pw.println("<br>Cidades: ");
				pw.println(getCities(searchString, states[i]));
			}
		} else {
			pw.println("No state selected");
		}
		pw.println("</body>");
		pw.println("</html>");

	}

	private String getCities(String job, String state) {
		StringBuffer cities = new StringBuffer();

		if (job.equalsIgnoreCase("java")) {
			if (state.equalsIgnoreCase("rj")) {
				cities.append("<br>Rio de Janeiro");
				cities.append("<br>Niteroi");
			}
			if (state.equalsIgnoreCase("sp")) {
				cities.append("<br>São Paulo");
				cities.append("<br>Campinas");
			}
			if (state.equalsIgnoreCase("mg")) {
				cities.append("<br>Belo Horizonte\n");
				cities.append("<br>Betim");
			}
			if (state.equalsIgnoreCase("rs")) {
				cities.append("<br>Porto Alegre\n");
				cities.append("<br>Canoas");
			}
			if (state.equalsIgnoreCase("pr")) {
				cities.append("<br>Curitiba\n");
				cities.append("<br>Londrina");
			}
		} else {
			cities.append("No cities found for job " + job);
		}

		return cities.toString();
	}

}
