SHELL := /bin/bash
GRADLE_VERSION ?= 8.14

b: build
clean:
	if [ -d build ]; then rm -r build; fi
list:
	./gradlew -q projects
wrap:
	gradle wrapper
build: clean
	gradle build -i
dcup:
	docker-compose up -d
dcup-action:
	docker-compose -f docker-compose.yaml up -d
dcd:
	docker-compose down
upgrade-gradle: upgrade-system upgrade-sdk-man upgrade
upgrade-system:
	sudo apt upgrade
	sudo apt update
upgrade-sdk-man:
	export SDKMAN_DIR="$(HOME)/.sdkman"; \
	[[ -s "$(HOME)/.sdkman/bin/sdkman-init.sh" ]]; \
	source "$(HOME)/.sdkman/bin/sdkman-init.sh"; \
	sdk update; \
	gradleOnlineVersion=$(shell curl -s https://services.gradle.org/versions/current | jq .version | xargs -I {} echo {}); \
	if [[ -z "$$gradleOnlineVersion" ]]; then \
		sdk install gradle $(GRADLE_VERSION); \
		sdk use gradle $(GRADLE_VERSION); \
	else \
		sdk install gradle $$gradleOnlineVersion; \
		sdk use gradle $$gradleOnlineVersion; \
		export GRADLE_VERSION=$$gradleOnlineVersion; \
	fi;
upgrade:
	export CURRENT=$(shell pwd); \
	gradle wrapper --gradle-version $(GRADLE_VERSION);
deps-plugins-update:
	curl -sL https://raw.githubusercontent.com/jesperancinha/project-signer/master/pluginUpdatesOne.sh | bash -s -- $(PARAMS)
deps-java-update:
	curl -sL https://raw.githubusercontent.com/jesperancinha/project-signer/master/javaUpdatesOne.sh | bash
deps-gradle-update:
	curl -sL https://raw.githubusercontent.com/jesperancinha/project-signer/master/gradleUpdatesOne.sh | bash
deps-quick-update: deps-plugins-update deps-java-update deps-gradle-update

