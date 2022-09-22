package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.sellerdao;
import model.Seller;

/**
 * Servlet implementation class Sellercontroller
 */
@WebServlet("/Sellercontroller")
public class Sellercontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Sellercontroller() {
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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   String action = request.getParameter("action");
	   if(action.equalsIgnoreCase("register"))
	   {
		  Seller s = new Seller();
		  s.setName(request.getParameter("yourname"));
		  s.setPasswords(request.getParameter("Passwords"));
		  s.setemail(request.getParameter("email"));
		  s.setphone(Long.parseLong(request.getParameter("phone")));
		  
		  sellerdao.insertseller(s);
		  request.setAttribute("msg", "data register successfully");
		  request.getRequestDispatcher("sellerlog.jsp").forward(request, response);
		  
	   }
	   else if(action.equalsIgnoreCase("login"))
	   {
		   Seller c = new Seller ();
			c.setemail(request.getParameter("email"));
			c.setPasswords(request.getParameter("Passwords"));
		    Seller s1 = sellerdao.loginseller(c);
			System.out.println(s1);
			if(s1==null) {
				request.setAttribute("validate", "email or password incorrect");
				request.getRequestDispatcher("sellerlog.jsp").forward(request, response);
			}
			else {
				HttpSession session = request.getSession();
				session.setAttribute("data", s1);
				request.getRequestDispatcher("sellerindex.jsp").forward(request, response);
			}
	   }
	   else if(action.equalsIgnoreCase("update"))
	   {
		   Seller S = new Seller();
		   S.setName(request.getParameter("yourname"));
		   S.setphone(Long.parseLong(request.getParameter("phone")));
		   S.setemail(request.getParameter("email"));
		   S.setID(Integer.parseInt("ID"));
		   
		   sellerdao.updateseller(S);
		   HttpSession session = request.getSession();
	 		session.setAttribute("data", S);
	 		request.getRequestDispatcher("sellerprofile.jsp").forward(request, response);
			
	 }
	   else if(action.equalsIgnoreCase("updatepassword"))
	   {
			String email = request.getParameter("email");
			String op = request.getParameter("op");
			String np = request.getParameter("np");
			String cnp = request.getParameter("cnp");
			
			boolean flag = sellerdao.checkPassword(email, cnp);
			if(flag == true) {
				if(np.equals(cnp))
				{
					sellerdao.updatepassword(email, cnp);
					response.sendRedirect("sellerindex.jsp");
					
				}
				else {
					request.setAttribute("msgpass", "new password and current new password didnt match");
					request.getRequestDispatcher("sellerchangepassword.jsp").forward(request, response);

				}
				
			}
			else {
				request.setAttribute("msg", "old password didnt match");
				request.getRequestDispatcher("sellerchangepassword.jsp").forward(request, response);
			}
			
	   }
	
	}

}
