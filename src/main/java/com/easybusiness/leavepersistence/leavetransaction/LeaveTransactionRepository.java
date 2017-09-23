package com.easybusiness.leavepersistence.leavetransaction;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import com.easybusiness.leavepersistence.entity.LeaveMaster;
import com.easybusiness.leavepersistence.entity.LeaveTransaction;
import com.easybusiness.leavepersistence.entity.Status;
import com.easybusiness.leavepersistence.entity.User;

public interface LeaveTransactionRepository extends CrudRepository<LeaveTransaction, Long>,
	LeaveTransactionCustomRepository, JpaSpecificationExecutor<LeaveTransaction> {

    List<LeaveTransaction> findAll();

    List<LeaveTransaction> findById(Long id);

    List<LeaveTransaction> findByUser(User user);

    List<LeaveTransaction> findByLeaveMaster(LeaveMaster leavemaster);

    List<LeaveTransaction> findByUserAndLeaveMaster(User user, LeaveMaster leavemaster);
    
    List<LeaveTransaction> findByStatus(Status status);

    @SuppressWarnings("unchecked")
    LeaveTransaction save(LeaveTransaction leaveTransaction);

}
