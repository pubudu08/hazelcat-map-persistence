/*
 * Copyright (c) 2014, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 *   WSO2 Inc. licenses this file to you under the Apache License,
 *   Version 2.0 (the "License"); you may not use this file except
 *   in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 */

package org.wso2.carbon.persistence.jdbc;

import com.hazelcast.core.EntryEvent;
import com.hazelcast.core.EntryListener;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Created by Pubudu Dissanayake on 11/3/14.
 * pubudud@wso2.com
 */
public class MapEntryListener implements EntryListener<Long,Person> {
	private static Log LOGGER = LogFactory.getLog(MapEntryListener.class);
	@Override
	public void entryAdded(EntryEvent<Long, Person> longPersonEntryEvent) {
		LOGGER.info("*Added Entry " + longPersonEntryEvent);
	}

	@Override
	public void entryRemoved(EntryEvent<Long, Person> longPersonEntryEvent) {
		LOGGER.info("*Removed Entry " + longPersonEntryEvent);
	}

	@Override
	public void entryUpdated(EntryEvent<Long, Person> longPersonEntryEvent) {
		LOGGER.info("*Updated Entry " + longPersonEntryEvent);
	}

	@Override
	public void entryEvicted(EntryEvent<Long, Person> longPersonEntryEvent) {
		LOGGER.info("*Evicted Entry " + longPersonEntryEvent);
	}
}
