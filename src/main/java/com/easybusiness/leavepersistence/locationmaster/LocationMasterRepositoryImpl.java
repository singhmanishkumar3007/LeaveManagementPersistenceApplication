package com.easybusiness.leavepersistence.locationmaster;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.easybusiness.leavepersistence.entity.LocationMaster;

@Repository
public class LocationMasterRepositoryImpl implements LocationMasterCustomRepository {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public LocationMaster getById(Long id) {
	return entityManager.find(LocationMaster.class, id);
    }

}
