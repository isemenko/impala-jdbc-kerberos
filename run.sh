#!/bin/bash

java  -cp $HADOOP_CLASSPATH:target/hiveserver2-jdbc-1.0-jar-with-dependencies.jar  com.test.ImpalaJDBC $1 $2
