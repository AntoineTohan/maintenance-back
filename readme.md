# OpenData Paris API

Partie back du projet OpenData Paris API

L'intégration continue est sensiblement similaire à celle du front


## Configuration de l'environnement
[Installation et configuration d'un environnement de développement](docs/conf-env.md)


## Jenkins
[Installation et configuration de Jenkins](docs/conf-jenkins.md)

## SonarQube
[Installation et configuration de SonarQube](docs/conf-sonar.md)



Si vous avez un terminal linux lancer ces commandes  :

  Intégrer mySQL dans le dockerfile etc...
```cd maintenance-back
docker pull mysql:5.7
docker run -p 3306:3306 --name opendata-db -e MYSQL_ROOT_PASSWORD=password -e MYSQL_DATABASE=opendata -d mysql:5.7
