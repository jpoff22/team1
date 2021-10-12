#!/bin/bash

echo "===>> compiling"
javac -cp tests/junit-4.10.jar src/*.java 
if [ $? -eq 0 ]; then
	echo "===>> running StartMenu"
	java -cp src/ StartMenu
fi
