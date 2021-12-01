REM create a network to connect mysql and the rest-app
docker network create bd2021

REM get and run mysql in docker
docker run ^
    --name bd2021-mysql ^
    --restart unless-stopped ^
    --network bd2021 ^
    -e MYSQL_ROOT_PASSWORD=root ^
    -e MYSQL_DATABASE=hrm ^
    -d ^
    -p 3307:3306 ^
    mysql:latest

REM create image for this project (rest)
docker build -t rest-docker .

REM ... and run it in docker
docker run --name rest-docker --network bd2021 -dp 9090:9080 rest-docker

REM NOTE: you can also run the Dockerfile with IDEA run config (where you map ports and choose network)
