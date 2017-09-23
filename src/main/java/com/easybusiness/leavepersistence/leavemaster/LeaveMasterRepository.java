package com.easybusiness.leavepersistence.leavemaster;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.easybusiness.leavepersistence.entity.LeaveMaster;

public interface LeaveMasterRepository extends CrudRepository<LeaveMaster, Long>,LeaveMasterCustomRepository {
    
    List<LeaveMaster> findAll();
    List<LeaveMaster> findById(Long id);
    List<LeaveMaster> findByLeaveType(String leaveType);
    @SuppressWarnings("unchecked")
    LeaveMaster save(LeaveMaster leaveMaster);
    

}
