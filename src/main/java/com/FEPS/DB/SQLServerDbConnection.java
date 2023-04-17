package com.FEPS.DB;
/**
 * @author JeevanKumar K V

 * Email id : jeevankumar.kv@conduent.com
 *         
 */


import com.FEPS.settings.ObjectRepo;
import com.FEPS.utility.LoggerHelper;

import io.cucumber.java.Scenario;

import org.apache.log4j.Logger;

import java.sql.*;

public class SQLServerDbConnection {

	public  static Connection sqldb_Con =null;
	public static Connection bww_sqldb_Con=null;
	public  static Connection Retrieval_sqldb_Con =null;
	public static Connection Released_sqldb_Con =null;
	public  Statement stmt = null;
	public  ResultSet rs =null;
	public static String paymentUrl;
	public static String idempotentId;
	public static Float chargeAmount;
	public static String bww_sessionKey;
	public Connection bww_conn_url = null;
	SQLServerDbConnection dbConObj;
	String otherAdjustment;
	String certificateAdjustment;
	public static String posId_from_DB;

	public Scenario scenario = ObjectRepo.scenario;
	Logger log = LoggerHelper.getLogger(SQLServerDbConnection.class);

	//Printing logs
	public void Logger(String s){
//		//System.out.println(s);
		log.info(s);
		scenario.log(s);
//		Allure.step(s);
	}

	public Connection sqlServerDB_Connection()
	{
		String env = ObjectRepo.reader.get_Env();
		//System.out.println(" Env  : " +env);
		String conn_url = null;

		if(sqldb_Con==null)
		{
			if(env.equalsIgnoreCase("UAT"))
			{
//				conn_url = "jdbc:sqlserver://sql-ib-ue1-arb-uat01-dp-evwg.database.windows.net:1433;"
				conn_url = "jdbc:sqlserver://sql-ib-ue1-arb-uat01-dp-evwg.privatelink.database.windows.net:1433;"
						+ "database=Order;"
						+ "user=ibdbdevuser;"
						+ "password=xGB1&^W4E:!E:XbkC;";
			}

			if(env.equalsIgnoreCase("QA"))
			{

				conn_url = "jdbc:sqlserver://sql-ib-ue1-arb-qa01-dp-kkjv.database.windows.net:1433;"
						+ "database=Order;"
						+ "user=ibdbdevuser;"
						+ "password=xGB1&^W4E:!E:XbkC;";

			}
			if(env.equalsIgnoreCase("STAGE"))
			{

				conn_url = "jdbc:sqlserver://sql-ib-ue1-stg01-dp-wknu.database.windows.net:1433;"
						+ "database=Order;"
						+ "user=ibdbdevuser;"
						+ "password=xGB1&^W4E:!E:XbkC;";

			}

			try {


				sqldb_Con = DriverManager.getConnection(conn_url);

			} catch (SQLException ex) {
				ex.printStackTrace();
			}

		}

		return sqldb_Con;
	}

	public Connection sqlServerDB_Connection_Retrieval_Database()
	{
		String env = ObjectRepo.reader.get_Env();
		//System.out.println(" Env  : " +env);
		String retrieval_conn_url = null;

		if(Retrieval_sqldb_Con==null)
		{
			if(env.equalsIgnoreCase("UAT"))
			{
				retrieval_conn_url = "jdbc:sqlserver://sql-ib-ue1-arb-uat01-dp-evwg.database.windows.net:1433;"
						+ "database=RetrievalOrder;"
						+ "user=ibdbdevuser;"
						+ "password=xGB1&^W4E:!E:XbkC;";
			}

			if(env.equalsIgnoreCase("QA"))
			{

				retrieval_conn_url = "jdbc:sqlserver://sql-ib-ue1-arb-qa01-dp-kkjv.database.windows.net:1433;"
						+ "database=RetrievalOrder;"
						+ "user=ibdbdevuser;"
						+ "password=xGB1&^W4E:!E:XbkC;";

			}

			if(env.equalsIgnoreCase("STAGE"))
			{

				retrieval_conn_url = "jdbc:sqlserver://sql-ib-ue1-stg01-dp-wknu.database.windows.net:1433;"
						+ "database=RetrievalOrder;"
						+ "user=ibdbdevuser;"
						+ "password=xGB1&^W4E:!E:XbkC;";

			}

			try {


				Retrieval_sqldb_Con = DriverManager.getConnection(retrieval_conn_url);

			} catch (SQLException ex) {
				ex.printStackTrace();
			}

		}

		return Retrieval_sqldb_Con;
	}


	public Connection sqlServerDB_Connection_Released_Database()
	{
		String env = ObjectRepo.reader.get_Env();
		//System.out.println(" Env  : " +env);
		String released_conn_url = null;

		if(Released_sqldb_Con==null)
		{
			if(env.equalsIgnoreCase("UAT"))
			{
				released_conn_url = "jdbc:sqlserver://sql-ib-ue1-arb-uat01-dp-evwg.database.windows.net:1433;"
						+ "database=ReleaseOrder;"
						+ "user=ibdbdevuser;"
						+ "password=xGB1&^W4E:!E:XbkC;";
			}

			if(env.equalsIgnoreCase("QA"))
			{

				released_conn_url = "jdbc:sqlserver://sql-ib-ue1-arb-qa01-dp-kkjv.database.windows.net:1433;"
						+ "database=ReleaseOrder;"
						+ "user=ibdbdevuser;"
						+ "password=xGB1&^W4E:!E:XbkC;";

			}

			if(env.equalsIgnoreCase("STAGE"))
			{

				released_conn_url = "jdbc:sqlserver://sql-ib-ue1-arb-stg01-dp-kkjv.database.windows.net:1433;"
						+ "database=ReleaseOrder;"
						+ "user=ibdbdevuser;"
						+ "password=xGB1&^W4E:!E:XbkC;";

			}

			try {

				Released_sqldb_Con = DriverManager.getConnection(released_conn_url);

			} catch (SQLException ex) {
				ex.printStackTrace();
			}

		}

		return Released_sqldb_Con;
	}


	public ResultSet  getData_sqlDBServer(Connection conObj, Integer order_id) throws SQLException
	{

		String sql_query = "SELECT ordr.brand_id , ordr.customer_id , ordr.name, ordr.status, ordr.created , ordr.last_modified, ordr.pos_id , ordr.pos_display_id , ordr.pos_message , ordr.pos_submit_code, fd.order_id , "
				+ " fd.fulfillment_id ,fd.fulfillment_time , fd.fulfillment_type,fd.contact_person , fd.contact_email , fd.contact_phone ,"
				+ " fd.location_id ,fd.location_name ,  fd.country_code , fd.state_code,   fd.city , fd.address1 ,fd.address2 , fd.postal_code , fd.vehicle_description,im.id , im.price , im.modifier_group_id, im.parent_id, im.description ,mg.id , mg.pos_id , mg.order_item_id , "
				+ " mg.description ,oi.id ,oi.pos_id , oi.price , oi.quantity , oi.order_id , oi.parent_id , oi.description , oi.note FROM [Order].dbo.orders ordr"
				+ " Left join [Order].dbo.fulfillment_details fd ON ordr.id = fd.order_id Left join [Order].dbo.item_modifiers im ON im.id = ordr.id  Left join [Order].dbo.modifier_groups mg ON mg.id = ordr.id "
				+ " Left join [Order].dbo.order_items oi ON oi.id = ordr.id where ordr.id =" +order_id;

		//System.out.println(" SQL Query : "+sql_query);

		if(conObj!=null)
		{
			Logger(" SQL Database server connection is Active");
			stmt = conObj.createStatement();
			stmt.executeQuery(sql_query);
			rs=stmt.getResultSet();
		}
		else
		{
			Logger(" SQL Database server connection is not Active ");
		}

		return rs;
	}

	public ResultSet  getData_sqlDBServer_for_Brink_POS(Connection conObj, Integer order_id) throws SQLException
	{
		String sql_query = "SELECT ordr.id ,ordr.brand_id , ordr.name, ordr.created , ordr.expected_pickup_time,fd.contact_phone,fd.location_id, ordr.price,ordr.tax, "
				+"  oi.pos_id,oi.product_id, oi.line_item_id,oi.quantity, oi.description,oi.product_kind, "
				+"  py.amount,py.status "
				+"  FROM [Order].dbo.orders ordr "
				+"  Left join [Order].dbo.fulfillment_details fd ON ordr.id = fd.order_id  Left join [Order].dbo.order_items oi ON oi.order_id = ordr.id "
				+"  Left join [Order].dbo.payments py ON py.order_id = ordr.id where ordr.id =" +order_id;

		//System.out.println(" SQL Query : "+sql_query);

		if(conObj!=null)
		{
			//System.out.println();
			Logger(" SQL Database server connection is Active");
			stmt = conObj.createStatement();
			stmt.executeQuery(sql_query);
			rs=stmt.getResultSet();
		}
		else
		{
			Logger(" SQL Database server connection is not Active ");
		}

		return rs;
	}

	public ResultSet get_Order_Status_query(Connection conObj, String order_id) throws SQLException {
		String sql_q = "SELECT id, status, last_modified FROM [Order].dbo.orders where id = " + order_id;
		//System.out.println(" SQL Query : "+sql_q);
		if(conObj!=null)
		{
			Logger(" SQL Database server connection is Active");
			stmt = conObj.createStatement();
			stmt.executeQuery(sql_q);
			rs=stmt.getResultSet();
		}
		else
		{
			Logger(" SQL Database server connection is not Active ");
		}

		return rs;

	}

	public ResultSet get_requestID_for_freedom_pay_portal(Connection conObj, Integer order_id) throws SQLException{
		String sql_q = "SELECT request_id FROM [Order].dbo.payments where order_id = " +order_id;
		//System.out.println("SQL query : " +sql_q);

		if(conObj!=null)
		{
			Logger("SQL Database server connection is active");
			stmt = conObj.createStatement();
			stmt.executeQuery(sql_q);
			rs=stmt.getResultSet();
		}
		else
		{
			Logger(" SQL Database server connection is not active ");
		}
		return rs;
	}

	public ResultSet get_status_for_orders_from_OrderDB(Connection conObj, Integer order_id) throws SQLException{
		String sql_q = "SELECT status FROM [Order].dbo.orders where id = " +order_id;
		//System.out.println("SQL query : " +sql_q);

		if(conObj!=null)
		{
			Logger("SQL Database server connection is active");
			stmt = conObj.createStatement();
			stmt.executeQuery(sql_q);
			rs=stmt.getResultSet();
		}
		else
		{
			Logger(" SQL Database server connection is not active ");
		}
		return rs;
	}


	public ResultSet get_fulfilment_instructions_for_orders_from_OrderDB(Connection conObj, Integer order_id) throws SQLException{
		String sql_q = "SELECT instruction FROM [Order].dbo.fulfillment_instructions fi where fulfillment_order_id = " +order_id;
		//System.out.println("SQL query : " +sql_q);

		if(conObj!=null)
		{
			Logger("SQL Database server connection is active");
			stmt = conObj.createStatement();
			stmt.executeQuery(sql_q);
			rs=stmt.getResultSet();
		}
		else
		{
			Logger(" SQL Database server connection is not active ");
		}
		return rs;
	}

	public ResultSet get_tenderType_for_orders_from_OrderDB(Connection conObj, Integer order_id) throws SQLException{
		String sql_q = "SELECT card_issuer FROM [Order].dbo.payments pay where order_id = " +order_id;
		//System.out.println("SQL query : " +sql_q);

		if(conObj!=null)
		{
			Logger("SQL Database server connection is active");
			stmt = conObj.createStatement();
			stmt.executeQuery(sql_q);
			rs=stmt.getResultSet();
		}
		else
		{
			Logger(" SQL Database server connection is not active ");
		}
		return rs;
	}


	public ResultSet get_fulfilment_instructions_count_for_orders_from_OrderDB(Connection conObj, Integer order_id) throws SQLException{
		String sql_q = "SELECT COUNT(*) instruction FROM [Order].dbo.fulfillment_instructions fi where fulfillment_order_id = " +order_id;
		//System.out.println("SQL query : " +sql_q);

		if(conObj!=null)
		{
			Logger("SQL Database server connection is active");
			stmt = conObj.createStatement();
			stmt.executeQuery(sql_q);
			rs=stmt.getResultSet();
		}
		else
		{
			Logger(" SQL Database server connection is not active ");
		}
		return rs;
	}


	public ResultSet get_status_for_orders_from_RetrievalDB(Connection Retrieval_sqldb_Con, Integer order_id) throws SQLException{
		String sql_q = "SELECT status FROM [RetrievalOrder].dbo.orders where id = " +order_id;
		//System.out.println("SQL query : " +sql_q);

		if(Retrieval_sqldb_Con!=null)
		{
			Logger("SQL Database server connection is active");
			stmt = Retrieval_sqldb_Con.createStatement();
			stmt.executeQuery(sql_q);
			rs=stmt.getResultSet();
		}
		else
		{
			Logger(" SQL Database server connection is not active ");
		}
		return rs;
	}

	public ResultSet get_status_for_orders_from_ReleasedDB(Connection Released_sqldb_Con, Integer order_id) throws SQLException{
		String sql_q = "SELECT release_status FROM [ReleaseOrder].dbo.release_tasks where id = " +order_id;
		//System.out.println("SQL query : " +sql_q);

		if(Released_sqldb_Con!=null)
		{
			Logger("SQL Database server connection is active");
			stmt = Released_sqldb_Con.createStatement();
			stmt.executeQuery(sql_q);
			rs=stmt.getResultSet();
		}
		else
		{
			Logger(" SQL Database server connection is not active ");
		}
		return rs;
	}


	public ResultSet  getData_sqlDBServer_RetrievalDB(Connection retrieval_sqldb_Con, Integer order_id) throws SQLException
	{

		String sql_query = "SELECT ordr.brand_id , ordr.customer_id , ordr.name, ordr.status, ordr.created , ordr.last_modified, ordr.pos_id , ordr.pos_display_id , ordr.pos_message , ordr.pos_submit_code, fd.order_id , "
				+ " fd.fulfillment_id ,fd.fulfillment_time , fd.fulfillment_type,fd.contact_person , fd.contact_email , fd.contact_phone ,"
				+ " fd.location_id ,fd.location_name ,  fd.country_code , fd.state_code,   fd.city , fd.address1 ,fd.address2 , fd.postal_code , fd.vehicle_description,im.id , im.price , im.modifier_group_id, im.parent_id, im.description ,mg.id , mg.pos_id , mg.order_item_id , "
				+ " mg.description ,oi.id ,oi.pos_id , oi.price , oi.quantity , oi.order_id , oi.parent_id , oi.description , oi.note FROM [RetrievalOrder].dbo.orders ordr"
				+ " Left join [RetrievalOrder].dbo.fulfillment_details fd ON ordr.id = fd.order_id Left join [RetrievalOrder].dbo.item_modifiers im ON im.id = ordr.id  Left join [RetrievalOrder].dbo.modifier_groups mg ON mg.id = ordr.id "
				+ " Left join [RetrievalOrder].dbo.order_items oi ON oi.id = ordr.id where ordr.id =" +order_id;

		//System.out.println(" SQL Query : "+sql_query);

		if(retrieval_sqldb_Con!=null)
		{
			Logger(" SQL Database server connection is Active");
			stmt = retrieval_sqldb_Con.createStatement();
			stmt.executeQuery(sql_query);
			rs=stmt.getResultSet();
		}
		else
		{
			Logger(" SQL Database server connection is not Active ");
		}

		return rs;
	}



	public ResultSet get_pos_sync_id_for_orders_from_OrderDB(Connection sqldb_Con, Integer order_id) throws SQLException{
		String sql_q = "SELECT pos_sync_id FROM [Order].dbo.payments where order_id = " +order_id;
		//System.out.println("SQL query : " +sql_q);

		if(sqldb_Con!=null)
		{
			Logger("SQL Database server connection is active");
			stmt = sqldb_Con.createStatement();
			stmt.executeQuery(sql_q);
			rs=stmt.getResultSet();
		}
		else
		{
			Logger(" SQL Database server connection is not active ");
		}
		return rs;
	}


	public Connection BWW_sqlServerDB_Connection()
	{
		String env = ObjectRepo.reader.get_Env();
		//System.out.println(" Env  : " +env);
		String bww_conn_url = null;

		if(bww_sqldb_Con==null)
		{
			if(env.equalsIgnoreCase("UAT"))
			{
				bww_conn_url = "jdbc:sqlserver://sql-ib-ue1-bww-uat01-dp-gwnd.privatelink.database.windows.net;"
						+ "database=Order;"
						+ "user=ibdbdevuser;"
						+ "password=xGB1&^W4E:!E:XbkC;";
			}

			if(env.equalsIgnoreCase("QA"))
			{

				bww_conn_url = "jdbc:sqlserver://sql-ib-ue1-bww-qa01-dp-gwnd.privatelink.database.windows.net;"
						+ "database=Order;"
						+ "user=ibdbdevuser;"
						+ "password=xGB1&^W4E:!E:XbkC;";

			}
			if(env.equalsIgnoreCase("STAGE"))
			{

				bww_conn_url = "jdbc:sqlserver://sql-ib-ue1-bww-stg01-dp-gwnd.privatelink.database.windows.net;"
						+ "database=Order;"
						+ "user=ibdbdevuser;"
						+ "password=xGB1&^W4E:!E:XbkC;";

			}

			try {


				bww_sqldb_Con = DriverManager.getConnection(bww_conn_url);

			} catch (SQLException ex) {
				ex.printStackTrace();
			}

		}

		return bww_sqldb_Con;
	}

	public ResultSet bww_get_order_discount_query(Connection bww_conObj, String idempotentId) throws SQLException {
		String sql_q = "SELECT discount FROM [Order].dbo.orders where idempotent_id = " + idempotentId;
		//System.out.println(" SQL Query : "+sql_q);
		if(bww_conObj!=null)
		{
			Logger(" SQL Database server connection is Active");
			stmt = bww_conObj.createStatement();
			stmt.executeQuery(sql_q);
			rs=stmt.getResultSet();
		}
		else
		{
			Logger(" SQL Database server connection is not Active ");
		}

		return rs;

	}


	public ResultSet bww_get_order_certificateDiscount_query(Connection bww_conObj, String idempotentId) throws SQLException {
		String sql_q = "SELECT certificate_discount FROM [Order].dbo.orders where idempotent_id = " + idempotentId;
		//System.out.println(" SQL Query : "+sql_q);
		if(bww_conObj!=null)
		{
			Logger(" SQL Database server connection is Active");
			stmt = bww_conObj.createStatement();
			stmt.executeQuery(sql_q);
			rs=stmt.getResultSet();
		}
		else
		{
			Logger(" SQL Database server connection is not Active ");
		}

		return rs;

	}


	public ResultSet bww_get_order_posId_query(Connection bww_conObj, String idempotentId) throws SQLException {
		String sql_q = "SELECT pos_id FROM [Order].dbo.orders where idempotent_id = " + idempotentId;
		//System.out.println(" SQL Query : "+sql_q);
		if(bww_conObj!=null)
		{
			Logger(" SQL Database server connection is Active");
			stmt = bww_conObj.createStatement();
			stmt.executeQuery(sql_q);
			rs=stmt.getResultSet();
		}
		else
		{
			Logger(" SQL Database server connection is not Active ");
		}

		return rs;
	}

	public ResultSet bww_get_order_status(Connection bww_conObj, String idempotentId) throws SQLException {
		String sql_q = "SELECT status FROM [Order].dbo.orders where idempotent_id = " + idempotentId;
		//System.out.println(" SQL Query : "+sql_q);
		if(bww_conObj!=null)
		{
			Logger(" SQL Database server connection is Active");
			stmt = bww_conObj.createStatement();
			stmt.executeQuery(sql_q);
			rs=stmt.getResultSet();
		}
		else
		{
			Logger(" SQL Database server connection is not Active ");
		}

		return rs;
	}




	public ResultSet bww_get_payment_maskedCardNumber(Connection bww_conObj) throws SQLException {

		String sql_q = "SELECT masked_card_number FROM [Order].dbo.payments where pos_sync_id = " + posId_from_DB;
		//System.out.println(" SQL Query : "+sql_q);
		if(bww_conObj!=null)
		{
			Logger(" SQL Database server connection is Active");
			stmt = bww_conObj.createStatement();
			stmt.executeQuery(sql_q);
			rs=stmt.getResultSet();
		}
		else
		{
			Logger(" SQL Database server connection is not Active ");
		}

		return rs;
	}

}

