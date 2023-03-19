# AutoApp

### Initialize The App

- Edit the [config.yml](./app/src/main/resources/config.yml) and set a preferred sqlite db file location.
- Build the app and executable
```
./mvnw clean install
```
- Initialize the Database File
```
./app/target/app db initialize ./app/target/classes/config.yml #initialze the db
```
- Run the migrations (must be done any time new migration scripts are created)
```
./app/target/app db migrate ./app/target/classes/config.yml
```
- If you'd like, view the current database status
```
./app/target/app db info ./app/target/classes/config.yml
```
- Run the web server
```
./app/target/app server ./app/target/classes/config.yml
```
- Test the app apis
```
curl localhost:8080/auto-app/ping
curl localhost:8080/admin/healthcheck
```
