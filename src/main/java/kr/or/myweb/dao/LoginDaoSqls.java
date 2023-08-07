package kr.or.myweb.dao;

public class LoginDaoSqls {
	public final static String SELECT_ONE_USER="select id, user_id, password, email, tel_no, reg_date, update_date from user where user_id= :userId and password= :password";

}
