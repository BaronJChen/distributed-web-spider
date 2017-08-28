#!/bin/bash
mvn clean
# maven is installed '/var/jenkins_home'
export PATH=$PATH:/var/jenkins_home/maven/bin
# -pl is used to skip bootstrap module here
# -amd is to install the dependency automically
mvn -pl '!bootstrap' install -amd
