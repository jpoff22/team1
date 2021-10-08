#!/bin/bash

#
# Compile and run a JUnit test - run from this dir
# 	example: runtest.sh tests/TestMapMove.java

test_path=$1
test_name=$(grep -oP '(?<=/).*?(?=\.)' <<< $test_path)

echo "running test $test_name"
javac -cp tests/junit-4.10.jar src/*.java $test_path
java -cp tests/junit-4.10.jar:tests/:src/ org.junit.runner.JUnitCore ${test_name%.*}
