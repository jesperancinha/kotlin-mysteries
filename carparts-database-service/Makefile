b: build
build:
	docker build . --tag "carparts-database-service"
push:
	docker push "carparts-database-service"
restart:
	docker-compose down
	docker-compose build --with-dependencies
dcup:
	docker-compose up -d

dcdown:
	docker-compose down
start-compose: restart dcup
