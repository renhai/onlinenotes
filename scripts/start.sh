#!/bin/bash
cd ../
git pull origin master
./gradlew clean build
nohup java -Xms512m -Xmx512m -jar build/libs/app.jar >./logs/nohup.log 2>&1 &