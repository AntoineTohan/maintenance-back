# OpenData Paris API

Java Spring + Maven project. 


## Configuration de l'environnement
[Instalation et configuration d'un environnement de développement](docs/conf-env.md)


## Jenkins
[Instalation et configuration de Jenkins](docs/conf-jenkins.md)

## SonarQube
[Instalation et configuration de SonarQube](docs/conf-sonar.md)


## Procédure installation

- Avoir un Mac/Linux OU Windows 10 PRO pour le temrinal shell / bash

- Installation JDK Java 8 Stable (Maven intégré dans IntelliJ : non.) : https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html

- Installation Intellij Idea https://www.jetbrains.com/idea/download/

- Installation de Maven (ATTENTION : peu déjà être inclu dans votre IDE) :https://maven.apache.org/download.cgi

- Configuration Intellij Idea (ORM => HIBERNATE(via maven), Log(log4j via maven),JUnit via maven Extensions, Linter, etc…)🐳

- Installation Docker: https://www.docker.com/ ( pour installation d’un mysql en local pour le dev ) 🙏

- Installation Git : https://gitforfedora.org/

Pour un nouveau développeur : 

 - Configuration compte git (pour avoir les droit sur le repo)
 - Git clone le projet (git clone https://github.com/AntoineTohan/maintenance-back.git)
 - Git add remote upstream (les repos remotes)
 - Git pull sur le projet
 - Apprendre par 💖 GitFlow
 
 

Si vous avez un terminal linux lancer ces commandes  :

```cd maintenance-back
docker pull mysql:5.7
docker run -p 3306:3306 --name opendata-db -e MYSQL_ROOT_PASSWORD=password -e MYSQL_DATABASE=opendata -d mysql:5.7
```


Ensuite lancer le projet Java dans votre IDE.


## Commandes utile :

Lister tous les containers Docker : ```docker ps -a```

Démarrer le service mysql : ```docker start <IdContainer>```


Mettre en pause les containers avec : ```docker stop <IdContainer>```


Supprimer le service mysql : **Attention la suppression vous fera perdre toute votre configuration ```docker rm <IdContainer>```**
