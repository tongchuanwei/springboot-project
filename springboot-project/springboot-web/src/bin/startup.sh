#!/bin/bash
echo starting
nohup java -jar aidrg-web.jar --server.port=6789 >/dev/null 2>&1  &