package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.footballPlayer;;

@WebServlet("/addPlayersServlet")
public class addPlayersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public addPlayersServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
     
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		footballPlayerHelper dao = new footballPlayerHelper();
		String team = request.getParameter("team");
		String name = request.getParameter("name");
		String owner = request.getParameter("owner");
		//Integer tempId = Integer.parseInt(request.getParameter("id"));
		footballPlayer playerToUpdate = new footballPlayer();
		playerToUpdate.setTeam(team);
		playerToUpdate.setName(name);
		playerToUpdate.setOwner(owner);
		dao.insertPlayer(playerToUpdate);
		getServletContext().getRequestDispatcher("/viewAllPlayersServlet").forward(request, response);
	}
}