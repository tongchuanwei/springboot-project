docker run --name springboot -p 8200:8200 -v /data/config/ai/springboot/:/root/config -v /data/logs/ai/springboot/:/root/logs -v /data/file/excel:/root/file  -d springboot:latest
