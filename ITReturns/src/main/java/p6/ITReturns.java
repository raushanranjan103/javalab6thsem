package p6;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class ITReturns
 */
public class ITReturns extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ITReturns() {
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
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		String name = request.getParameter("name");
		String salary = request.getParameter("salary");
		String tax = request.getParameter("tax");
		
		PrintWriter out = response.getWriter();
		out.println("" + name + salary + tax);
//File file = new File("/home/eclipse-new/test/src/main/webapp/info.jsp");
		File nfile = new File("C:\\Users\\RAUSHAN RANJAN\\Desktop\\file.txt");
		nfile.createNewFile();
		System.out.println(name); 
		FileOutputStream fout = new FileOutputStream(nfile);
		
		fout.write(("hello" + name  + salary + tax).getBytes());
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
