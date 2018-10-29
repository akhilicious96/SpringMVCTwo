package com.cg.springmvctwo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.cg.springmvctwo.dto.Mobile;
@Repository("mobiledao")
public class MobileDaoImpl implements IMobileDao {

	@PersistenceContext
	EntityManager em;
	
	
	@Override
	public void addMobile(Mobile mob) {
		// TODO Auto-generated method stub
		
		em.persist(mob);
		em.flush();
		
	}

	@Override
	public List<Mobile> showAll() {
		// TODO Auto-generated method stub
		Query query = em.createQuery("FROM Mobile");
		List<Mobile> myAll = query.getResultList();
		return myAll;
	}

	@Override
	public void deleteMobile(int mobId) {
		// TODO Auto-generated method stub
		Query query = em.createQuery("Delete FROM Mobile where mobId=:mobileId");
		query.setParameter("mobileId", mobId);
		query.executeUpdate();
		
		
	}

	@Override
	public Mobile searchMobile(int mobId) {
		// TODO Auto-generated method stub
		
		Query querySearch = em.createQuery("FROM Mobile where mobId=:mobdata");
		querySearch.setParameter("mobdata", mobId);
		Mobile mob = (Mobile) querySearch.getResultList().get(0);
		return mob;
	}

	@Override
	public void updateMobile(int mobId, double price) {
		// TODO Auto-generated method stub
		Query query = em.createQuery("Update Mobile set mobPrice=:price where mobId=:mobId");
		query.setParameter("price", price);
		query.setParameter("mobId", mobId);
		query.executeUpdate();
	}

}
