package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CustomerDao;
import model.Customer;


/**
 * Servlet implementation class CustomerController
 */
@WebServlet("/CustomerController")
public class CustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerController() {
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
		if(action.equalsIgnoreCase("register")) {
			Customer c = new Customer();
			c.setName(request.getParameter("name"));
			c.setContact(Long.parseLong(request.getParameter("contact")));
			c.setAddress(request.getParameter("address"));
			c.setEmail(request.getParameter("email"));
			c.setPassword(request.getParameter("password"));
			CustomerDao.insertCustomer(c);
			request.setAttribute("msg", "data inserted");
			request.getRequestDispatcher("customer-login.jsp").forward(request, response);
		}
		else if(action.equalsIgnoreCase("login")) {
			Customer c = new Customer();
			c.setEmail(request.getParameter("email"));
			c.setPassword(request.getParameter("password"));
 			Customer c1 = CustomerDao.loginCustoemr(c);
			if(c1 == null) {
				request.setAttribute("msg1", "email or password is incorrect");
				request.getRequestDispatcher("customer-login.jsp").forward(request, response);
			}
			else {
				HttpSession session = request.getSession();
				session.setAttribute("data", c1);
				request.getRequestDispatcher("customer-index.jsp").forward(request, response);
			}
		}
		else if(action.equalsIgnoreCase("update")) {
			Customer c = new Customer();
			c.setId(Integer.parseInt(request.getParameter("id")));
			c.setName(request.getParameter("name"));
			c.setContact(Long.parseLong(request.getParameter("contact")));
			c.setAddress(request.getParameter("address"));
			c.setEmail(request.getParameter("email"));
			CustomerDao.updatecustomer(c);
			HttpSession session = request.getSession();
	 		session.setAttribute("data", c);
	 		request.getRequestDispatcher("customer-profile.jsp").forward(request, response);
		}
	}

}
