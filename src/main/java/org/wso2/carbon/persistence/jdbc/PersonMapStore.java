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
package org.wso2.carbon.persistence.jdbc;

import com.hazelcast.core.MapStore;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static java.lang.String.format;

/**
 * This is a sample application which will demonstrates how Hazelcast Map Persistence works
 * Created by Pubudu Dissanayake on 10/23/14.
 */
public class PersonMapStore implements MapStore<Long, Person> {
	private Log LOGGER = LogFactory.getLog(PersonMapStore.class);
	private Connection connection = null;

	public PersonMapStore() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			// we can define this in our data-source.xml and refer it here though
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hazel_db",
			  "root", "root");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} catch (ClassNotFoundException e) {
			LOGGER.error("*Where is my MySQL JDBC Driver?", e);
		}
	}

	@Override
	public void store(Long key, Person person) {
		try {
			connection.createStatement().executeUpdate(format(SQLQuery.INSERT_QUERY, key,
			  person.name));
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	@Override
	public void storeAll(Map<Long, Person> longPersonMap) {
		for (Map.Entry<Long, Person> entry : longPersonMap.entrySet()) {
			store(entry.getKey(), entry.getValue());
		}
	}

	@Override
	public void delete(Long key) {
		LOGGER.info("*Deleted entry Key:" + key);
		try {
			connection.createStatement().executeUpdate(format(SQLQuery.DELETE_KEY, key));
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void deleteAll(Collection<Long> longs) {
		for (Long key : longs) {
			delete(key);
		}
	}

	@Override
	public Person load(Long aLong) {
		try {
			ResultSet resultSet = connection.createStatement().executeQuery(format(SQLQuery
			  .SELECT_QUERY, aLong));
			try {
				if (!resultSet.next()) {
					return null;
				}
				String name = resultSet.getString(1);
				return new Person(name);
			} finally {
				resultSet.close();
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public Map<Long, Person> loadAll(Collection<Long> longs) {
		Map<Long, Person> result = new HashMap<Long, Person>();
		for (Long key : longs) {
			result.put(key, load(key));
		}
		return result;
	}

	@Override
	public Set<Long> loadAllKeys() {
		return null;
	}
}
