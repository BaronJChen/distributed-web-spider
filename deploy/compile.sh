#!/bin/bash
mvn clean
# -pl is used to skip bootstrap module here
# -amd is to install the dependency automically
mvn -pl '!bootstrap' install -amd -X