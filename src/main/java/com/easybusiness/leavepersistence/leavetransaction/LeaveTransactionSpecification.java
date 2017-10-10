package com.easybusiness.leavepersistence.leavetransaction;

import static com.easybusiness.leavepersistence.LeaveManagementConstant.CANCELED_LEAVE_STATUS;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.easybusiness.leavepersistence.entity.LeaveMaster;
import com.easybusiness.leavepersistence.entity.LeaveMaster_;
import com.easybusiness.leavepersistence.entity.LeaveTransaction;
import com.easybusiness.leavepersistence.entity.LeaveTransaction_;
import com.easybusiness.leavepersistence.entity.User;
import com.easybusiness.leavepersistence.entity.User_;

public final class LeaveTransactionSpecification {

    private LeaveTransactionSpecification() {

    }

    public static Specification<LeaveTransaction> getLeaveTransactionsByUserAndLeaveDates(User user,
	    LeaveMaster leaveMaster, Date leaveStartDate, Date leaveEndDate) {
	return new Specification<LeaveTransaction>() {

	    @Override
	    public Predicate toPredicate(Root<LeaveTransaction> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
		final Collection<Predicate> predicates = new ArrayList<>();
		final Predicate userPredicate = root.join(LeaveTransaction_.user).get(User_.id).in(user.getId());
		predicates.add(userPredicate);

		final Predicate leaveTypePredicate = root.join(LeaveTransaction_.leaveMaster).get(LeaveMaster_.id)
			.in(leaveMaster.getId());
		predicates.add(leaveTypePredicate);

		final Predicate datePredicate = cb.between(root.get(LeaveTransaction_.leaveStartDate), leaveStartDate,
			leaveEndDate);
		predicates.add(datePredicate);
		return cb.and(predicates.toArray(new Predicate[predicates.size()]));
	    }
	};

    }
    // Cancelled

    public static Specification<LeaveTransaction> getLeaveTransactionsByUserAndLeaveDatesForNonCancelledLeaves(
	    User user, LeaveMaster leaveMaster, Date leaveStartDate, Date leaveEndDate) {
	return new Specification<LeaveTransaction>() {

	    @Override
	    public Predicate toPredicate(Root<LeaveTransaction> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
		final Collection<Predicate> predicates = new ArrayList<>();
		final Predicate userPredicate = root.join(LeaveTransaction_.user).get(User_.id).in(user.getId());
		predicates.add(userPredicate);

		final Predicate leaveTypePredicate = root.join(LeaveTransaction_.leaveMaster).get(LeaveMaster_.id)
			.in(leaveMaster.getId());
		predicates.add(leaveTypePredicate);

		final Predicate datePredicate = cb.between(root.get(LeaveTransaction_.leaveStartDate), leaveStartDate,
			leaveEndDate);
		predicates.add(datePredicate);

		/*final Predicate statusPredicate = cb.notEqual(root.get(LeaveTransaction_.status),
			CANCELED_LEAVE_STATUS);
		predicates.add(statusPredicate);*/

		return cb.and(predicates.toArray(new Predicate[predicates.size()]));
	    }
	};

    }

    public static Specification<LeaveTransaction> getLeaveTransactionsByUserAndLeaveDatesForAllKindOfLeaves(User user,
	    Date leaveStartDate, Date leaveEndDate) {
	return new Specification<LeaveTransaction>() {

	    @Override
	    public Predicate toPredicate(Root<LeaveTransaction> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
		final Collection<Predicate> predicates = new ArrayList<>();
		final Predicate userPredicate = root.join(LeaveTransaction_.user).get(User_.id).in(user.getId());
		predicates.add(userPredicate);

		final Predicate datePredicate = cb.between(root.get(LeaveTransaction_.leaveStartDate), leaveStartDate,
			leaveEndDate);
		predicates.add(datePredicate);

		/*final Predicate statusPredicate = cb.notEqual(root.get(LeaveTransaction_.status),
			CANCELED_LEAVE_STATUS);
		predicates.add(statusPredicate);*/

		return cb.and(predicates.toArray(new Predicate[predicates.size()]));
	    }
	};

    }

}
