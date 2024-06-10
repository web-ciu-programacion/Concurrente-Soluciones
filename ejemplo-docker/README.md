sudo docker build -t ejemplo-docker:latest .
  (. = Dockerfile en directorio local)
sudo docker run -d -p 8080:8080 ejemplo-docker:latest
  (-d in background)