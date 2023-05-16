# hl-sonet-core 
#### Highloaded Social Network Core

## Запускаем проект через докер
- скачиваем исходники git checkout
- заходим в корень проекта
- запускаем docker-compose up
- докер скачивает образы Postgres, Maven, Java-11, билдит артефакт Springboot приложения и запускает его на http://localhost:8080

## Использование приложения
- регистрация: POST http://localhost:8080/user/update - достаточно email, firstname, password
- логин: POST http://localhost:8080/user/login - выдает JWT token
- изменение профайла POST http://localhost:8080/user/update - тут можно добавить/поменять свой профиль. Необходима авторизация Basic или по JWT токену, подключены оба типа авторизации.
- просмотр анкет зарегистрированных пользователей GET http://localhost:8080/user/get/{uuid}

#### Swagger UI приложения (пока что не поддерживает аутентификацию, АПИ эндпоинтов отдельно от схем)
Доступен по адресу<br/>
http://localhost:8080/swagger-ui/index.html

#### Swagger UI сгенерированный по Otus Highload specification
**For Windows** only absolute path is allowed for mounting volumes in command line.<br/>
docker run -p 5000:8080 --name swaggerui -v /gen/api:/open-apis -e SWAGGER_JSON=/open-apis/openapi.yaml swaggerapi/swagger-ui<br/>