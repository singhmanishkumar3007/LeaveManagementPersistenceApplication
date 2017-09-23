package com.easybusiness.leavepersistence.locationmaster;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.easybusiness.leavepersistence.entity.LocationMaster;
import com.easybusiness.leavepersistence.user.UserDao;

@Component
public class LocationMasterDao {

    @Autowired
    LocationMasterRepository locationMasterRepository;

    @Autowired
    UserDao userDao;

    public LocationMaster findById(Long locationId) {
	return locationMasterRepository.getById(locationId);
    }

}
