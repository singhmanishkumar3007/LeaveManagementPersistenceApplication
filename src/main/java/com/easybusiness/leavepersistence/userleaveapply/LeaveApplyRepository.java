package com.easybusiness.leavepersistence.userleaveapply;

import java.sql.Date;

public interface LeaveApplyRepository {
    
    public void leaveApplyForUser(String userId,String leaveTypeId,Date leaveStartDate,Date leaveEnddate,String locationId,String unitId,String dayType);

}
