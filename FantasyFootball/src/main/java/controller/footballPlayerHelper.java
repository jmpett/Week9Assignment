package controller;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import model.footballPlayer;

public class footballPlayerHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("football");

	public void cleanUp() {
		emfactory.close();
	}
	
	public void deletePlayer(footballPlayer toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<footballPlayer> typedQuery = em.createQuery("select fb from footballPlayer fb where fb.name = :selectedName and fb.team = :selectedTeam",footballPlayer.class);
		typedQuery.setParameter("selectedName", toDelete.getName());
		typedQuery.setParameter("selectedTeam", toDelete.getTeam());
		typedQuery.setMaxResults(1);
		footballPlayer result = typedQuery.getSingleResult();
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}

	public void insertPlayer(footballPlayer toInsert) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(toInsert);
		em.getTransaction().commit();
		em.close();
	}

	public void updatePlayer(footballPlayer toEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}

	public List<footballPlayer> showAllPlayers() {
		EntityManager em = emfactory.createEntityManager();
		TypedQuery<footballPlayer> typedQuery = em.createQuery("select fb from footballPlayer fb", footballPlayer.class);
		List<footballPlayer> foundTeams = typedQuery.getResultList();
		em.close();
		return foundTeams;
	}
	
	public footballPlayer searchForPlayerById(int id) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		footballPlayer found = em.find(footballPlayer.class, id);
		em.close();
		return found;
	}
		
	public List<footballPlayer> searchForPlayerByTeam(String teamName) {  
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<footballPlayer> typedQuery = em.createQuery("select fb from footballPlayer fb where fb.team = :selectedTeam", footballPlayer.class);
		typedQuery.setParameter("selectedTeam", teamName);
		List<footballPlayer> foundName = typedQuery.getResultList();
		em.close();
		return foundName;
	}

	public List<footballPlayer> searchForPlayerByName(String name) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<footballPlayer> typedQuery = em.createQuery("select fb from footballPlayer fb where fb.name = :selectedName", footballPlayer.class);
		typedQuery.setParameter("selectedName", name);
		List<footballPlayer> foundTeams = typedQuery.getResultList();
		em.close();
		return foundTeams;
	}

	public List<footballPlayer> searchForPlayerByOwner(String owner) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<footballPlayer> typedQuery = em.createQuery("select fb from footballPlayer fb where fb.owner = :selectedOwner", footballPlayer.class);
		typedQuery.setParameter("selectedOwner", owner);
		List<footballPlayer> foundOwner = typedQuery.getResultList();
		em.close();
		return foundOwner;
	}
}