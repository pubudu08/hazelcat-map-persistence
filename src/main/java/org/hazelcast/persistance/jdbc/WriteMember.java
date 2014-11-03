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

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;
import com.hazelcast.core.TransactionalMap;
import com.hazelcast.transaction.TransactionContext;

/**
 * Hz instance will put values to the HZ map although behind the code it will insert values to the
 * configured DB. And it will get terminated
 * Created by Pubudu Dissanayake on 10/23/14.
 */
public class WriteMember {
	public static void main(String[] args) throws InterruptedException {
		HazelcastInstance hz = Hazelcast.newHazelcastInstance();
		IMap<Long, Person> personMap = hz.getMap("personMap");
		personMap.addEntryListener(new MapEntryListener(),true);
		personMap.put(1L, new Person("Pubudu"));
		personMap.put(2L, new Person("lasal"));

		/*TransactionContext transactionContext = hz.newTransactionContext();
		transactionContext.beginTransaction();
		TransactionalMap<Long, Person> tmap = transactionContext.getMap("personMap");
		tmap.put(3L, new Person("Dissanayake"));
		transactionContext.commitTransaction();*/

		System.exit(0);       // Terminating HZ instance
	}
}

