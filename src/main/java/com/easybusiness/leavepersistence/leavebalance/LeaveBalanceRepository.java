package com.easybusiness.leavepersistence.leavebalance;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.easybusiness.leavepersistence.entity.LeaveBalance;
import com.easybusiness.leavepersistence.entity.LeaveMaster;
import com.easybusiness.leavepersistence.entity.User;

public interface LeaveBalanceRepository extends CrudRepository<LeaveBalance, Long>, LeaveBalanceCustomRepository {

    List<LeaveBalance> findAll();

    List<LeaveBalance> findById(Long id);

    List<LeaveBalance> findByUser(User user);

    List<LeaveBalance> findByLeaveMaster(LeaveMaster leavemaster);

    List<LeaveBalance> findByUserAndLeaveMaster(User user, LeaveMaster leavemaster);

    @SuppressWarnings("unchecked")
    LeaveBalance save(LeaveBalance leaveBalance);

}
