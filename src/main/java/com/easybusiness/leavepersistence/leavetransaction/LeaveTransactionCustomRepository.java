package com.easybusiness.leavepersistence.leavetransaction;

import com.easybusiness.leavepersistence.entity.LeaveTransaction;

public interface LeaveTransactionCustomRepository {

    public void add(LeaveTransaction leaveTransaction);

    public void deleteLeaveTransaction(Long id);

    LeaveTransaction getById(Long id);

}
