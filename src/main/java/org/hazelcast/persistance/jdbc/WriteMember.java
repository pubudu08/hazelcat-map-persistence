package org.hazelcast.persistance.jdbc;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;

/**
 * Hz instance will put values to the HZ map although behind the code it will insert values to the
 * configured DB. And it will get terminated
 * Created by Pubudu Dissanayake on 10/23/14.
 * pubudud@wso2.com
 */
public class WriteMember {
	public static void main(String[] args) throws InterruptedException {
		HazelcastInstance hz = Hazelcast.newHazelcastInstance();
		IMap<Long, Person> personMap = hz.getMap("personMap");
		personMap.put(1L, new Person("Pubudu"));
		personMap.put(2L, new Person("lasal"));
		System.exit(0);       // Terminating HZ instant
	}
}
