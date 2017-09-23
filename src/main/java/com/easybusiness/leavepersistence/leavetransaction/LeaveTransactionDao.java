package com.easybusiness.leavepersistence.leavetransaction;

import static org.apache.commons.lang.time.DateUtils.ceiling;
import static org.apache.commons.lang.time.DateUtils.truncate;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.easybusiness.leavepersistence.entity.LeaveMaster;
import com.easybusiness.leavepersistence.entity.LeaveTransaction;
import com.easybusiness.leavepersistence.entity.User;
import com.easybusiness.leavepersistence.leavemaster.LeaveMasterDao;
import com.easybusiness.leavepersistence.statusmaster.StatusDao;
import com.easybusiness.leavepersistence.user.UserDao;

@Component
public class LeaveTransactionDao {

    @Autowired
    LeaveTransactionRepository leaveTransactionRepository;

    @Autowired
    UserDao userDao;

    @Autowired
    LeaveMasterDao leaveMasterDao;

    @Autowired
    StatusDao statusDao;

    public LeaveTransaction findByLeaveTransactionId(Long leaveTransactionId) {
	return leaveTransactionRepository.getById(leaveTransactionId);
    }

    public List<LeaveTransaction> findLeaveTransactionByUser(User user) {
	return leaveTransactionRepository.findByUser(user);
    }

    public List<LeaveTransaction> findLeaveTransactionByUserAndLeaveType(User user, LeaveMaster leaveMaster) {
	return leaveTransactionRepository.findByUserAndLeaveMaster(user, leaveMaster);
    }

    public List<LeaveTransaction> findLeaveTransactionByUserIdAndLeaveTypeId(Long userId, Long leaveTypeId) {

	return leaveTransactionRepository.findByUserAndLeaveMaster(userDao.findUserById(userId),
		leaveMasterDao.findByLeaveTypeId(leaveTypeId));
    }

    public List<LeaveTransaction> findLeaveTransactionByUserId(Long userId) {
	return leaveTransactionRepository.findByUser(userDao.findUserById(userId));
    }

    public List<LeaveTransaction> findLeaveTransactionByUserName(String userName) {
	return leaveTransactionRepository.findByUser(userDao.findByUserName(userName));
    }

    public List<LeaveTransaction> findLeaveTransactionByUserNameAndLeaveTypeId(String userName, Long leaveTypeId) {

	return leaveTransactionRepository.findByUserAndLeaveMaster(userDao.findByUserName(userName),
		leaveMasterDao.findByLeaveTypeId(leaveTypeId));
    }

    public List<LeaveTransaction> findLeaveTransactionByStatus(String leaveStatus) {

	List<LeaveTransaction> leaveTransactionList = new ArrayList<LeaveTransaction>();
	try {
	    leaveTransactionList = leaveTransactionRepository.findByStatus(statusDao.findByStatusId(leaveStatus));
	} catch (Exception e) {

	}
	return leaveTransactionList;
    }

    public List<LeaveTransaction> findLeaveTransactionByUserIdAndLeaveTypeIdAndLeaveDate(Long userId, Long leaveTypeId,
	    Date leaveStartDate, Date leaveEndDate) {

	java.util.Date fromDate = truncate(leaveStartDate, Calendar.DAY_OF_MONTH);
	Date toDate = new Date(ceiling(leaveEndDate, Calendar.DAY_OF_MONTH).getTime() - 1);
	java.sql.Date sqlFromDate = new java.sql.Date(fromDate.getTime());
	java.sql.Date sqlToDate = new java.sql.Date(toDate.getTime());
	return leaveTransactionRepository.findAll(LeaveTransactionSpecification.getLeaveTransactionsByUserAndLeaveDates(
		userDao.findUserById(userId), leaveMasterDao.findByLeaveTypeId(leaveTypeId), sqlFromDate, sqlToDate));
    }

    public int countOfLeavesApplied(Long userId, Long leaveTypeId, Date leaveStartDate, Date leaveEndDate) {

	java.util.Date fromDate = truncate(leaveStartDate, Calendar.DAY_OF_MONTH);
	Date toDate = new Date(ceiling(leaveEndDate, Calendar.DAY_OF_MONTH).getTime() - 1);
	java.sql.Date sqlFromDate = new java.sql.Date(fromDate.getTime());
	java.sql.Date sqlToDate = new java.sql.Date(toDate.getTime());
	return leaveTransactionRepository.findAll(LeaveTransactionSpecification
		.getLeaveTransactionsByUserAndLeaveDatesForNonCancelledLeaves(userDao.findUserById(userId),
			leaveMasterDao.findByLeaveTypeId(leaveTypeId), sqlFromDate, sqlToDate))
		.size();
    }

    public List<LeaveTransaction> findAll() {
	return leaveTransactionRepository.findAll();
    }

    public LeaveTransaction addOrModifyLeaveTransaction(LeaveTransaction leaveTransaction) {

	/*
	 * if(null!=leaveTransaction.getId() &&
	 * null!=findByLeaveTransactionId(leaveTransaction.getId())) {
	 */
	return leaveTransactionRepository.save(leaveTransaction);
    }

    public void deleteLeaveTransaction(Long leaveTypeId)

    {
	leaveTransactionRepository.deleteLeaveTransaction(leaveTypeId);
    }

}
