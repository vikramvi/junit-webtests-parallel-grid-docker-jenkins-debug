## Automated web tests using Serenity, Maven and Docker

A simple example of some BDD-style automated acceptance criteria, running against http://etsy.com.

Run the tests like this:

1. Single Machine + Parallel Run on Mulitple Browser Instances

```
mvn clean verify -Dskip.parallel=false -DskipITs 

```
2. Single Machine + Single Browser

```
mvn clean verify -Dskip.parallel=true

```

The reports will be generated in `target/site/serenity`.



# Docker setup
docker stop `docker ps -a -q`

docker rm `docker ps -a -q`

docker run -d -p 4444:4444 --name selenium-hub -e GRID_BROWSER_TIMEOUT=15000 selenium/hub:2.52.0

docker run -d --link selenium-hub:hub -v /dev/shm:/dev/shm selenium/node-chrome:2.52.0

docker run -d --link selenium-hub:hub -v /dev/shm:/dev/shm selenium/node-chrome:2.52.0

and more based on the machine capacity

docker ps

docker stats $(docker ps -aq)

docker port backstabbing_yalow 5900

docker port stupefied_goldstine 5900


# Commands to execute on Docker Grid

mvn clean verify -Dskip.parallel=false -DskipITs -Dwebdriver.remote.url=http://xxx.xxx.xx.xxx:4444/wd/hub -Dwebdriver.remote.driver=chrome -Dwebdriver.remote.os=LINUX


