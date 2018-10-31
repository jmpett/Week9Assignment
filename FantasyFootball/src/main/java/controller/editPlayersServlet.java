package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.footballPlayer;

@WebServlet("/editPlayersServlet")
public class editPlayersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public editPlayersServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		footballPlayerHelper dao = new footballPlayerHelper();
		String owner = request.getParameter("owner");
		String name = request.getParameter("name");
		String team = request.getParameter("team");
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		footballPlayer playerToUpdate = dao.searchForPlayerById(tempId);
		playerToUpdate.setOwner(owner);
		playerToUpdate.setName(name);
		playerToUpdate.setTeam(team);
		dao.updatePlayer(playerToUpdate);
		getServletContext().getRequestDispatcher("/viewAllPlayersServlet").forward(request, response);
	}
}




