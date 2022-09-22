package customercontroller;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



import dao.customerdao;
import model.customermodel;


/**
 * Servlet implementation class customercontroller
 */
@WebServlet("/customercontroller")
public class customercontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public customercontroller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if(action.equalsIgnoreCase("Submit"))
		{
			customermodel c =  new customermodel();
			c.setYourname(request.getParameter("yourname"));
		    c.setPhone(Long.parseLong(request.getParameter("phone")));
			c.setEmail(request.getParameter("email"));
			c.setPasswords(request.getParameter("Passwords"));
		
		customerdao.insertcustomer(c);
		request.setAttribute("regmsg","data registered succesfully");
		request.getRequestDispatcher("customerlog.jsp").forward(request, response);
		
		}
	
		else if (action.equalsIgnoreCase("login")) {
			customermodel c = new customermodel ();
			c.setEmail(request.getParameter("email"));
			c.setPasswords(request.getParameter("Passwords"));
			customermodel c1 = customerdao.logincustomer(c);
			System.out.println(c1);
			if(c1==null) {
				request.setAttribute("validate", "email or password incorrect");
				request.getRequestDispatcher("customerlog.jsp").forward(request, response);
			}
			else {
				HttpSession session = request.getSession();
				session.setAttribute("data", c1);
				request.getRequestDispatcher("customerindex.jsp").forward(request, response);
			}
			
	  }
		else if(action.equalsIgnoreCase("update")) {
			customermodel c = new customermodel();
			c.setID(Integer.parseInt("ID"));
			c.setYourname(request.getParameter("yourname"));
			c.setPhone(Long.parseLong(request.getParameter("phone")));
			c.setEmail(request.getParameter("email"));
			
			customerdao.updatecustomer(c); 
			HttpSession session = request.getSession();
	 		session.setAttribute("data", c);
	 		request.getRequestDispatcher("customerprofile.jsp").forward(request, response);
		}
		
		else if(action.equalsIgnoreCase("updatepassword")) {
			String email = request.getParameter("email");
			String op = request.getParameter("op");
			String np = request.getParameter("np");
			String cnp = request.getParameter("cnp");
			System.out.println(op);
			System.out.println(np);
			System.out.println(cnp);
			
			boolean flag = customerdao.checkPassword(email, np);
			if(flag == true) {
				if(np.equals(cnp)) {
				
					customerdao.updatepassword(email, cnp);
					response.sendRedirect("customerindex.jsp");
				}
				else {
					request.setAttribute("msgpass", "new password and current new password didnt match");
					request.getRequestDispatcher("changepassword.jsp").forward(request, response);
				}
			}
			
			else {
				request.setAttribute("msg", "old password didnt match");
				request.getRequestDispatcher("changepassword.jsp").forward(request, response);
			}
			
		}

	}

}
