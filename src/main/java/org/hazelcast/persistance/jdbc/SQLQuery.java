package org.hazelcast.persistance.jdbc;

/**
 * Created by Pubudu Dissanayake on 10/23/14.
 * pubudud@wso2.com
 */
public interface SQLQuery {

	String INSERT_QUERY = "INSERT INTO tbl_hazelmap(map_key,map_value) values(%s,%s)";
	String UPDATE_QUERY = "UPDATE tbl_hazelmap SET map_value=%s WHERE map_key=%s";
	String SELECT_QUERY = "SELECT map_value FROM tbl_hazelmap WHERE map_key=%s";
	String ALL_KEYS = "SELECT map_key FROM  tbl_hazelmap";
	String DELETE_KEY = "DELETE FROM tbl_hazelmap WHERE map_key=%s";


}
