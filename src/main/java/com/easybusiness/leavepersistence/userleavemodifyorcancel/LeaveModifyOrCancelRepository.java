package com.easybusiness.leavepersistence.userleavemodifyorcancel;

import java.sql.Date;

public interface LeaveModifyOrCancelRepository {
    
    public void leaveModifyOrCancelForUser(String operationType,String userId,String leaveTypeId,String leaveTransactionId,Date leaveStartDate,Date leaveEnddate,String locationId,String unitId,String dayType);

}
