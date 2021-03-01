#Docker build icin kullanılacak komut

docker build -t spring-boot-api-doc .


#dokerda olusan image'i docker uzerinde 8082 de calistir, pc localhosta 8081 bagla
docker run -p 8081:8082 spring-boot-api-doc

#dokerda olusan image'i docker uzerinde 8082 de calistir, pc localhosta 8081 bagla, -d ise arkaplanda calistir demek
docker run  -d -p 8081:8082 spring-boot-api-doc

