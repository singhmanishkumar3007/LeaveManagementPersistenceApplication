package com.easybusiness.leavepersistence.statusmaster;

import com.easybusiness.leavepersistence.entity.Status;

public interface StatusCustomRepository {

    public void add(Status statusMaster);

    public void deleteStatus(String id);

    Status getByStatusId(String statusId);

}
