FROM docker.io/library/eclipse-temurin:17-jre-alpine

# Copy In the executable
COPY ./app/target/app /
# Copy in the processed config
COPY ./app/target/classes/config.yml /

CMD /app server /config.yml
