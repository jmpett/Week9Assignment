package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/searchOwnerServlet")
public class searchOwnerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public searchOwnerServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	footballPlayerHelper dao = new footballPlayerHelper();
	String enteredOwner = request.getParameter("owner");
	request.setAttribute("enteredOwner", dao.searchForPlayerByOwner(enteredOwner));
	if(dao.searchForPlayerByOwner(enteredOwner).isEmpty()){
		request.setAttribute("enteredOwner", " ");
	} else
	getServletContext().getRequestDispatcher("/owner-list.jsp").forward(request, response);
}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}


