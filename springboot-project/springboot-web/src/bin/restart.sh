#!/bin/bash

port=6789
#根据端口号查询对应的pid
pid=$(netstat -nlp | grep :$port | awk '{print $7}' | awk -F"/" '{ print $1 }');

#杀掉对应的进程，如果pid不存在，则不执行
if [  -n  "$pid"  ];  then
    kill  -9  $pid;
    echo kill $pid
fi

echo starting
nohup java -jar aidrg-web.jar --server.port=6789 >/dev/null 2>&1  &
