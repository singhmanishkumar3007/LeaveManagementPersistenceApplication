package com.easybusiness.leavepersistence.usercompoffraise;

import java.sql.Date;

public interface CompOffRaiseRepository {
    
    public void compOffRaise(String userId,Date leaveRaiseDate,String locationId,String unitId);

}
