package com.easybusiness.leavepersistence.statusmaster;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.easybusiness.leavepersistence.entity.Status;

@Repository
public class StatusRepositoryImpl implements StatusCustomRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void add(Status statusMaster) {

	entityManager.merge(statusMaster);
    }

    @Override
    public void deleteStatus(String id) {
	entityManager.remove(getByStatusId(id));

    }

    @Override
    public Status getByStatusId(String id) {
	return entityManager.find(Status.class, id);
    }

}
