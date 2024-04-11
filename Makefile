b: build
clean:
	if [ -d build ]; then rm -r build; fi
list:
	./gradlew -q projects
wrap:
	gradle wrapper
build: clean
	gradle build
