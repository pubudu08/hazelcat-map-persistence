Map Persistence: Hazelcast fail-over feature test using mysql 
=============================================================

* Create database in mysql 

* CREATE DATABASE  IF NOT EXISTS 'hazel_db';
* CREATE TABLE tbl_hazelmap( map_key int(11) NOT NULL, map_value varchar(45) DEFAULT NULL,  PRIMARY KEY (map_key)  )ENGINE=InnoDB  DEFAULT CHARSET='utf8';

* Use following sequence to run the sample 
* Run WriteMember.java then after ReadMember.java
