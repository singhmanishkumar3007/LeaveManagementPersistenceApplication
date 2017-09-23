package com.easybusiness.leavepersistence.statusmaster;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.easybusiness.leavepersistence.entity.Status;

public interface StatusRepository extends CrudRepository<Status, Long>, StatusCustomRepository {

    List<Status> findAll();

    List<Status> findByStatusId(String statusId);

    List<Status> findByStatusName(String statusName);

    @SuppressWarnings("unchecked")
    Status save(Status statusMaster);

}
