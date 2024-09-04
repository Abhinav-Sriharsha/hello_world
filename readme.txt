Prerequisites:
-Java Development Kit (JDK 17 or above)
-Maven
-Docker
-Kubernetes

Step-1 : Setup Development Environment
- Install Homebrew
    /bin/bash -c "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/HEAD/install.sh)"
- Install JDK
    brew install openjdk@11
- Install Maven
    brew install maven
- Install Docker via Homebrew or Docker webpage
    brew install --cask docker
- Install minikube
    brew install minikube
- Start Minikube
    minikube start

Step-2 : Create Microservices
- Create Hello service so that endpoint '/hello' gives output Hello
- Create World service so that endpoint '/world' gives output World
- Create Combined service that combines both hello and world service so that endpoint '/combined' gives output Hello World

Step-3 : Containerize the services using Docker
- Create Dockerfile for each service
- Build Docker Images for each service
-hello service
    docker build -t hello-service:latest ./hello-service
-running hello service container
    docker run -d -p 8081:8081 hello-service:latest
-world service
    docker build -t world-service:latest ./world-service
-running world service container
    docker run -d -p 8082:8082 world-service:latest
-combined service
    docker build -t combined-service:latest ./combined-service
-running combined service container
    docker run -d -p 8083:8083 combined-service:latest

Step-4 : Uploading Docker images to Docker Hub
-Login to Docker hub
    login docker
-Tag the images to docker hub
    docker tag hello-service:latest abhinav932002/hello-service:latest
    docker tag world-service:latest abhinav932002/world-service:latest
    docker tag combined-service:latest abhinav932002/combined-service:latest
-push the images to Docker Hub
    docker push abhinav932002/hello-service:latest
    docker push abhinav932002/world-service:latest
    docker push abhinav932002/combined-service:latest

Step-5 : Deploying on Kubernetes
-Create deployment yaml files for each service
-Apply kubernetes manifests
    kubectl apply -f hello-service-deployment.yaml
    kubectl apply -f world-service-deployment.yaml
    kubectl apply -f combined-service-deployment.yaml

-check the status of the pods and services
-make sure minikube is running
    kubectl get pods
    kubectl get services

Step-6 Running and Testing
-Make sure minikube is running
    minikube start
-open new terminal
-running hello service
    minikube service hello-service
-command opens the ip address running hello service
    type '/hello' to see the output
-running world service(in new terminal)
    minikube service world-service
-command opens the ip address running world service
    type '/world' to see the output
-running combined service(in new terminal)
    minikube service combined-service
-command opens the ip address running combined service
    type '/combined' to see the output


Docker Hub Links
Hello-service - https://hub.docker.com/repository/docker/abhinav932002/hello-service/general
World-service - https://hub.docker.com/repository/docker/abhinav932002/world-service/general
Combined-service - https://hub.docker.com/repository/docker/abhinav932002/combined-service/general


