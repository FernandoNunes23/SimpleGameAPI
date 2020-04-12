FROM java:8
COPY . /app
WORKDIR /app
RUN chmod +x entrypoint
ENTRYPOINT ["./entrypoint"]