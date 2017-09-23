package com.easybusiness.leavepersistence.locationmaster;

import com.easybusiness.leavepersistence.entity.LocationMaster;

public interface LocationMasterCustomRepository {

    LocationMaster getById(Long id);

}
