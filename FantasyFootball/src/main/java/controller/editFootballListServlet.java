package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.footballPlayer;

@WebServlet("/editFootballListServlet")
public class editFootballListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public editFootballListServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		footballPlayerHelper dao = new footballPlayerHelper();
		String act = request.getParameter("doThisToPlayer");
		
		if (act == null) {
			getServletContext().getRequestDispatcher("/viewAllPlayersServlet").forward(request, response);
		} else if (act.equals("Delete Selected Player")) {
			Integer tempId = Integer.parseInt(request.getParameter("id"));
			footballPlayer playerToDelete = dao.searchForPlayerById(tempId);
			dao.deletePlayer(playerToDelete);
			getServletContext().getRequestDispatcher("/viewAllPlayersServlet").forward(request, response);
		} else if (act.equals("Edit Selected Player")) {
			Integer tempId = Integer.parseInt(request.getParameter("id"));
			footballPlayer playerToEdit = dao.searchForPlayerById(tempId);
			request.setAttribute("playerToEdit", playerToEdit);
			getServletContext().getRequestDispatcher("/edit-players.jsp").forward(request, response);
		} else if (act.equals("Add New Player")) {
			getServletContext().getRequestDispatcher("/addPlayer.html").forward(request, response);
		} 
	}
}