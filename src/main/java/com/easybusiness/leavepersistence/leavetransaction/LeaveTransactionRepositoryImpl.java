package com.easybusiness.leavepersistence.leavetransaction;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.easybusiness.leavepersistence.entity.LeaveTransaction;

@Repository
public class LeaveTransactionRepositoryImpl implements LeaveTransactionCustomRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void add(LeaveTransaction leaveTransaction) {

	entityManager.merge(leaveTransaction);
    }

    @Override
    public void deleteLeaveTransaction(Long id) {
	entityManager.remove(getById(id));

    }

    @Override
    public LeaveTransaction getById(Long id) {
	return entityManager.find(LeaveTransaction.class, id);
    }

}
