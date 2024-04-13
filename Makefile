b: build
clean:
	if [ -d build ]; then rm -r build; fi
list:
	./gradlew -q projects
wrap:
	gradle wrapper
build: clean
	gradle build
dcup:
	docker-compose up -d
dcup-action:
	docker-compose -f docker-compose.yaml up -d
dcd:
	docker-compose down
