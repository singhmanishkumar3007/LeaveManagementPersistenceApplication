package com.easybusiness.leavepersistence.leavemaster;

import com.easybusiness.leavepersistence.entity.LeaveMaster;

public interface LeaveMasterCustomRepository {

    public void add(LeaveMaster leaveMaster);

    public void deleteLeaveMaster(Long id);

    LeaveMaster getById(Long id);


}
