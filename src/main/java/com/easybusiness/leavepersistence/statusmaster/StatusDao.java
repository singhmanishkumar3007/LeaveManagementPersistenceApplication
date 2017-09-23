package com.easybusiness.leavepersistence.statusmaster;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.easybusiness.leavepersistence.entity.Status;

@Component
public class StatusDao {

    @Autowired
    StatusRepository statusRepository;

    public Status findByStatusId(String statusId) {
	return statusRepository.findByStatusId(statusId).stream().findFirst().orElse(new Status());
    }

    public Status findByStatusName(String statusName) {
	return statusRepository.findByStatusName(statusName).stream().findFirst().orElse(new Status());
    }

    public List<Status> findAll() {
	return statusRepository.findAll();
    }

    public Status addorModifyStatusMaster(Status statusMaster)

    {
	return statusRepository.save(statusMaster);
    }

    public void deleteStatusMaster(String stausId)

    {
	statusRepository.deleteStatus(stausId);
    }

}
