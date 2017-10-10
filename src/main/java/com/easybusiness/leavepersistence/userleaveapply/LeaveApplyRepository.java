package com.easybusiness.leavepersistence.userleaveapply;

import java.sql.Date;
import java.sql.SQLException;

public interface LeaveApplyRepository {
    
    public void leaveApplyForUser(String userId,String leaveTypeId,Date leaveStartDate,Date leaveEnddate,String locationId,String unitId,String dayType) throws SQLException;

}
