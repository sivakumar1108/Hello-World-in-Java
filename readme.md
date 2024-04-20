# Reference Documentation

## Docker
Dockerfile
```
FROM openjdk:17

WORKDIR /app

COPY HelloWorld-release.jar /app/HelloWorld-release.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app/HelloWorld-release.jar"]
```

### commands

```
docker build -t vatsan127/hello-world . 
``` 


## Kubernetes
Deployment file
```
kind: Namespace
apiVersion: v1
metadata:
  name: dev
  labels:
    name: dev

---
kind: ConfigMap
apiVersion: v1
metadata:
  name: configmapv1
  namespace: dev
data:
  APP_NAME: 'Hello-World Java !!!'

---
# service - NodePort
apiVersion: v1
kind: Service
metadata:
  name: hw-service
  namespace: dev
spec:
  selector:
    service: hw-service
  ports:
    - name: http
      port: 8080
      protocol: TCP
      nodePort: 30080
  type: NodePort

---
# implement LoadBalancer

---
apiVersion: apps/v1
kind: Deployment
metadata:
  name: hello-world
  namespace: dev
spec:
  replicas: 1
  selector:
    matchLabels:
      app: hello-world
  template: # pod details
    metadata:
      labels:
        app: hello-world
        service: hw-service
    spec:
      containers:
        - name: hello-world
          image: vatsan127/hello-world:latest
          ports:
            - containerPort: 8080
          envFrom:
            - configMapRef:
                name: configmapv1

```

### commands

Create deployment
```
kubectl create -f <deployment-file>
```

Delete deployment
```
kubectl delete -f <deployment-file>
```