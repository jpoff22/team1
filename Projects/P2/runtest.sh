#!/bin/bash

#
# Compile and run a JUnit test - run from this dir
# 	example: runtest.sh tests/TestMapMove.java

test_path=$1
test_name=$(grep -oP '(?<=/).*?(?=\.)' <<< $test_path)

echo "===>> compiling test $test_path"
javac -cp tests/junit-4.10.jar src/*.java $test_path
if [ $? -eq 0 ]; then
	echo "===>> running test $test_name"
	if [ "$(expr substr $(uname -s) 1 10)" == "MINGW32_NT" ] || [ "$(expr substr $(uname -s) 1 10)" == "MINGW64_NT" ]; then
		java -cp tests/junit-4.10.jar;tests/;src/ org.junit.runner.JUnitCore ${test_name%.*}
	else
		java -cp tests/junit-4.10.jar:tests/:src/ org.junit.runner.JUnitCore ${test_name%.*}
	fi
fi
