# Makefile for Kotlin Spring application with MongoDB

# Define the name of your Kotlin application JAR file
JAR_FILE := demo/build/libs/demo-0.0.1-SNAPSHOT.jar

# Define the MongoDB Docker Compose file
DOCKER_COMPOSE_FILE := ./docker-compose.yml

# Gradle Wrapper script path within the demo directory
GRADLEW := ./gradlew

# Targets

# Default target: build the Kotlin application, start MongoDB, and run the service
all: start-mongodb build run

# Build the Kotlin application using Gradle from the demo directory
build:
	cd demo && $(GRADLEW) build

# Start the MongoDB container using Docker Compose
start-mongodb:
	docker-compose -f $(DOCKER_COMPOSE_FILE) up -d

# Stop and remove the MongoDB container
stop-mongodb:
	docker-compose -f $(DOCKER_COMPOSE_FILE) down

# Run the Kotlin application
run:
	java -jar $(JAR_FILE)

# Clean and restart
re: clean-all all

# Clean the build directory from the demo directory
clean:
	cd demo && $(GRADLEW) clean

# Clean the build directory and stop MongoDB
clean-all: stop-mongodb clean

.PHONY: all build start-mongodb stop-mongodb run clean clean-all re


