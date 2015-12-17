## Automated web tests using Serenity, JBehave and Maven

A simple example of some BDD-style automated acceptance criteria, running against http://etsy.com.

Run the tests like this:

```
mvn clean verify
```

The reports will be generated in `target/site/thucydides`.

# Docker setup
docker stop `docker ps -a -q`

docker rm `docker ps -a -q`

docker run -ti -m 150M --memory-swap 300M --cpu-shares=104 -d -p 4444:4444 --name selenium-hub -e GRID_BROWSER_TIMEOUT=15000 selenium/hub:2.48.2

docker run -ti -m 750M --memory-swap 900M --cpu-shares=460 -d -p --link selenium-hub:hub -v /dev/shm:/dev/shm selenium/node-chrome-debug:2.48.2 

docker run -ti -m 750M --memory-swap 900M --cpu-shares=460 -d -P --link selenium-hub:hub -v /dev/shm:/dev/shm selenium/node-chrome-debug:2.48.2

docker ps

docker port backstabbing_yalow 5900

docker port stupefied_goldstine 5900

# Commands to execute on Docker Grid

mvn verify -Dskip.parallel=false -Dwebdriver.remote.url=http://192.168.99.100:4444/wd/hub -Dwebdriver.remote.driver=chrome -Dwebdriver.remote.os=LINUX

mvn serenity:aggregate


