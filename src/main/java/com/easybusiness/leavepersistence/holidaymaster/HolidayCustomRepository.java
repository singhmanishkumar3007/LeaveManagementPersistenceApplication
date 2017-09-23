package com.easybusiness.leavepersistence.holidaymaster;

import com.easybusiness.leavepersistence.entity.HolidayMaster;

public interface HolidayCustomRepository {

    public void add(HolidayMaster holidayMaster);

    public void deleteHoliday(Long id);

    HolidayMaster getById(Long id);

}
