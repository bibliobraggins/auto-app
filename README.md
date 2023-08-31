# AutoApp
##### A quick dropwizard guicey demo application
 
### Requirements
- [JDK 17](https://adoptium.net/temurin/releases/)
  - I Prefer of OpenJDK Temurin Distribution Over The Oracle Distribution of OpenJDK
- A recent version of [maven](https://maven.apache.org/)

### How to run the App Locally

- Edit the [config.yml](./app/src/main/resources/config.yml) and set a preferred sqlite db file location.
- Build the app and executable
```
./mvnw clean install
```
- Initialize the Database File
```shell
./app/target/app db init ./app/target/classes/config.yml
```
- Run the migrations (must be done any time new migration scripts are created)
```shell
./app/target/app db migrate ./app/target/classes/config.yml
```
- If you'd like, view the current database status
```shell
./app/target/app db info ./app/target/classes/config.yml
```
- Run the web server
```shell
./app/target/app server ./app/target/classes/config.yml
```
- Test the app apis
```shell
curl localhost:8080/auto-app/ping
```
- Test the admin servlet apis
```shell
curl localhost:8080/admin/healthcheck
```
