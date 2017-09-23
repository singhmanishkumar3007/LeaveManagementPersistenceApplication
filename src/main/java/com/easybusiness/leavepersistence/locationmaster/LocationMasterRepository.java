package com.easybusiness.leavepersistence.locationmaster;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.easybusiness.leavepersistence.entity.LocationMaster;

public interface LocationMasterRepository extends CrudRepository<LocationMaster, Long>, LocationMasterCustomRepository {

    List<LocationMaster> findAll();

    List<LocationMaster> findById(Long id);

}
