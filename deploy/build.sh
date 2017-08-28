#!/bin/bash
mvn clean
export PATH=$PATH:/var/jenkins_home/maven/bin
# -pl is used to skip bootstrap module here
# -amd is to install the dependency automically
mvn -pl '!bootstrap' install -amd
