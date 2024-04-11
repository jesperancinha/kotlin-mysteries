b: build
list:
	./gradlew -q projects
wrap:
	gradle wrapper
build:
	build gradle
