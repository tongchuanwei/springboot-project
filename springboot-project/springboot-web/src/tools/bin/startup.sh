#!/bin/bash
echo starting
nohup java -jar springboot-web.jar --server.port=6789 >/dev/null 2>&1  &