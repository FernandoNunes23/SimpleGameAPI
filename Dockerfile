FROM java:8
RUN useradd -u 1000 -ms /bin/bash app \
&& usermod -g 1000 app
USER app
WORKDIR /home/app
COPY ./ ./
ENTRYPOINT ["./entrypoint"]