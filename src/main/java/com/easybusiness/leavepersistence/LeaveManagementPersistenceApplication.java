package com.easybusiness.leavepersistence;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class LeaveManagementPersistenceApplication implements CommandLineRunner {

    /*
     * @Autowired LeaveUpdateUserCreationRepositoryImpl
     * leaveUpdateUserCreationRepositoryImpl;
     * 
     * @Autowired LeaveApplyRepositoryImpl leaveApplyRepositoryImpl;
     * 
     * @Autowired CompOffApplyRepositoryImpl compOffApplyRepositoryImpl;
     * 
     * @Autowired LeaveModifyOrCancelRepositoryImpl
     * LeaveModifyOrCancelRepositoryImpl;
     * 
     * @Autowired CompOffRaiseRepositoryImpl compOffRaiseRepositoryImpl;
     * 
     * @Autowired CompOffCancelRepositoryImpl compOffCancelRepositoryImpl;
     * 
     * @Autowired CompOffModifyRepositoryImpl compOffModifyRepositoryImpl;
     */

    private static final Logger LOGGER = LoggerFactory.getLogger(LeaveManagementPersistenceApplication.class);

    public static void main(String[] args) {
	SpringApplication springApplication = new SpringApplicationBuilder()
		.sources(LeaveManagementPersistenceApplication.class).web(false).build();

	springApplication.run(args);
	//SpringApplication.run(LeaveManagementPersistenceApplication.class, args);
    }

    @Override
    public void run(String... arg0) throws Exception {
	LOGGER.info("inside run of LeaveManagementPersistenceApplication");

	/*
	 * // leaveUpdateUserCreationRepositoryImpl.leaveUpdateForUserCreation(
	 * "4240"); //01-OCT-17
	 * 
	 * SimpleDateFormat format1 = new SimpleDateFormat("dd-MM-yyyy");
	 * SimpleDateFormat format2 = new SimpleDateFormat("dd-MMM-yy");
	 * java.util.Date date = format1.parse("02-10-2017"); String
	 * newFromDate=format2.format(date); java.util.Date
	 * date1=format2.parse(newFromDate); Date startDate = new
	 * java.sql.Date((date1).getTime()); Date endDate = new
	 * java.sql.Date((date1).getTime()); Date startDate = new
	 * java.sql.Date((new
	 * SimpleDateFormat("dd-MM-yyyy").parse("10-09-2017")).getTime()); Date
	 * endDate = new java.sql.Date((new
	 * SimpleDateFormat("dd-MM-yyyy").parse("11-09-2017")).getTime()); try {
	 * leaveApplyRepositoryImpl.leaveApplyForUser("7010", "2",startDate,
	 * endDate, "1", "1", "FULL"); } catch (Exception e) {
	 * System.out.println("exception is " + e.getMessage()); }
	 * 
	 * try { compOffApplyRepositoryImpl.compOffApplyForUser("7010", "3",
	 * startDate, endDate, "1", "1", "FULL"); } catch (Exception e) {
	 * System.out.println("exception is " + e.getMessage()); }
	 * 
	 * try { LeaveModifyOrCancelRepositoryImpl.leaveModifyOrCancelForUser(
	 * "MODIFY", "7010", "3", null, startDate, endDate, "1", "1", "HALF"); }
	 * catch (Exception e) { System.out.println("exception is " +
	 * e.getMessage()); }
	 * 
	 * try { compOffRaiseRepositoryImpl.compOffRaise("7010", startDate, "1",
	 * "1"); } catch (Exception e) { System.out.println("exception is " +
	 * e.getMessage()); }
	 * 
	 * try{ compOffCancelRepositoryImpl.compOffCancelForUser("7010",
	 * startDate, endDate, "1", "1"); } catch(Exception e ) {
	 * System.out.println("exception is " + e.getMessage()); }
	 * 
	 * try{ compOffModifyRepositoryImpl.compOffModifyForUser("7010",
	 * startDate, endDate, "1", "1","FULL"); } catch(Exception e ) {
	 * System.out.println("exception is " + e.getMessage()); }
	 */
    }

}
