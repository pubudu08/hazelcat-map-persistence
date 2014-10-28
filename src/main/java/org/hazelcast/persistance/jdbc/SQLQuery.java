/*
*  Copyright (c) 2005-2014, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
*
*  WSO2 Inc. licenses this file to you under the Apache License,
*  Version 2.0 (the "License"); you may not use this file except
*  in compliance with the License.
*  You may obtain a copy of the License at
*
*    http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing,
* software distributed under the License is distributed on an
* "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
* KIND, either express or implied.  See the License for the
* specific language governing permissions and limitations
* under the License.
*/
package org.hazelcast.persistance.jdbc;

/**
 * Created by Pubudu Dissanayake on 10/23/14.
 * pubudud@wso2.com
 */
public interface SQLQuery {

	String INSERT_QUERY = "INSERT into tbl_hazelmap values(%s,'%s')";
	String UPDATE_QUERY = "UPDATE tbl_hazelmap SET map_value=%s WHERE map_key=%s";
	String SELECT_QUERY = "SELECT map_value from tbl_hazelmap where map_key =%s";
	String ALL_KEYS = "SELECT map_key FROM  tbl_hazelmap";
	String DELETE_KEY = "DELETE from tbl_hazelmap WHERE map_key = %s";


}
