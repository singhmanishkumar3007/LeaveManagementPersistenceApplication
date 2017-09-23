package com.easybusiness.leavepersistence.leavebalance;

import com.easybusiness.leavepersistence.entity.LeaveBalance;

public interface LeaveBalanceCustomRepository {

    public void add(LeaveBalance leaveBalance);

    public void deleteLeaveBalance(Long id);

    LeaveBalance getById(Long id);

}
