package org.hazelcast.persistance.jdbc;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;

import java.util.Map;

/**
 * New Hazelcast instant will read values from the DB itself and will populate the map
 * Created by Pubudu Dissanayake on 10/23/14.
 * pubudud@wso2.com
 */
public class ReadMember {
	public static void main(String[] args) throws InterruptedException {
		HazelcastInstance hz = Hazelcast.newHazelcastInstance();
		IMap<Long, Person> personMap = hz.getMap("personMap");
		personMap.get(1L);
		personMap.remove(2L);
		for (Map.Entry<Long, Person> entry : personMap.entrySet()) {
			System.out.println(entry.getValue());
		}
	}
}
