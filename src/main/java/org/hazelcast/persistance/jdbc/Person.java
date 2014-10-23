package org.hazelcast.persistance.jdbc;

import java.io.Serializable;

/**
 * Created by Pubudu Dissanayake on 10/23/14.
 * pubudud@wso2.com
 */
public class Person implements Serializable {
	public String name;

	public Person(String name) {
		this.name = name;
	}

	public String toString() {
		return "Person{name'" + name + "'}";
	}
}
