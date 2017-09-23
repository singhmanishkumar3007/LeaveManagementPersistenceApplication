package com.easybusiness.leavepersistence.leavemaster;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.easybusiness.leavepersistence.entity.LeaveMaster;

@Component
public class LeaveMasterDao {

    @Autowired
    LeaveMasterRepository leaveMasterRepository;

    public LeaveMaster findByLeaveTypeId(Long leaveTypeId) {
	return leaveMasterRepository.getById(leaveTypeId);
    }

    public LeaveMaster findByLeaveType(String leaveType) {
	return leaveMasterRepository.findByLeaveType(leaveType).get(0);
    }

    public List<LeaveMaster> findAll() {
	return leaveMasterRepository.findAll();
    }

    public LeaveMaster addLeaveMaster(LeaveMaster leaveMaster)

    {
	return leaveMasterRepository.save(leaveMaster);
    }

    public void deleteLeaveMaster(Long leaveTypeId)

    {
	leaveMasterRepository.deleteLeaveMaster(leaveTypeId);
    }

}
