# Docker Compose Spring Boot and Postgres demo
## Technologies
- Spring Boot
- Postgresql
- Docker
- Docker Compose

## Run the System
Run the following command:
```bash
docker-compose up
```

## Stop the System
To stop all running containers, use this command:
```bash
docker-compose down
```

## Remove image
To remove local image to reload some change of application 
```bash
docker rmi image_id
```

## Connect and interact with container bash
```bash
docker exec -it container_id or container_name /bin/sh

## Connect to Db
1- To connect from host according to environment variable in docker-compose.yml 
```bash
psql -p $LOCAL_PORT -h 127.0.0.1 -d $YOUR_DB_NAME -U $YOUR_USERNAME -W
psql -p 5433 -h 127.0.0.1 -d demo -U pw -W

2 - To connect from container by using environment variable in docker-compose.yml 
  - connect first to container (docker exec -it container_id or container_name /bin/bash)
  - connect to db from host
  psql -p $DOCKER_PORT -h 127.0.0.1 -d $YOUR_DB_NAME -U $YOUR_USERNAME -W
  psql -p 5432 -h 127.0.0.1 -d demo -U pw -W
```