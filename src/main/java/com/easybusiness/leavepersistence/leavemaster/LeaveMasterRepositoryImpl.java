package com.easybusiness.leavepersistence.leavemaster;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.easybusiness.leavepersistence.entity.LeaveMaster;

@Repository
public class LeaveMasterRepositoryImpl implements LeaveMasterCustomRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void add(LeaveMaster leaveMaster) {
	
	entityManager.merge(leaveMaster);
    }

    @Override
    public void deleteLeaveMaster(Long id) {
	entityManager.remove(getById(id));
	
    }

    @Override
    public LeaveMaster getById(Long id) {
	return entityManager.find(LeaveMaster.class, id);
    }


}
