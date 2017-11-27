package tool;

import java.sql.ResultSet;

import pers.hck.common.connect.DBConnecter;

public class BeanCodeGenerater {
	public static void main(String[] args) {
		String host = "10.37.122.201";
		String port = "1521";
		String sid = "srmdev";
		String user = "OPS$SRM";
		String password = "abc123";
		
		DBConnecter db = new DBConnecter(host, port, user, password, sid);

		String query = "SELECT * from srm_global;";
		System.out.println(query);
		
		try{
			ResultSet rs = db.executeQuery(query);
			while (rs.next()){
				System.out.println(rs.getString("glb_cd")+"||"+rs.getString("glb_values"));
			}
		}catch (Exception e){
			e.printStackTrace();
		}

		db.closeDB();
	}
}
