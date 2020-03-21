Dans un soucis d'automatisation et de rapidité, nous avons crée notre propre image Jenkins qui sera construit dans un Docker-Compose qui est aussi produit par nos soins.

### Construction de l'image Jenkins
Vous retrouverez dans le répertoire front, dans le dossier "CI", un fichier **Dockerfile**, c'est ce fichier qui permet de construire l'image Jenkins. 

- Pour constuire l'image, placez vous dans le répertoire "CI" du projet Front et tapez la commande suivante

- `docker build -t custom/jenkins .`

- Une image sous le nom "custom/jenkins" sera créée

- L'image est maintenant créée, il faut crée un container avec cette image Jenkins, pour celà, vous avez à votre disposition un fichier "**Docker-compose.yml**" qui permet d'automatiser la création du container Jenkins. 

- Pour éxécuter le Docker-compose, il faudra rentrer la commande suivante : 

- `docker-compose up -d`

- (L'éxécution du docker compose créera aussi un container SonarQube mais nous y reviendrons plus tard)

- Vous pouvez maintenant vous rendre à l'adresse suivante "http://localhost:8181". Il vous faudra attendre quelques minutes que Jenkins se lance. 

- Vous pouvez vous connecter avec les identifiants suivants : 

- **Nom d'utilisateur** : `admin` 

- **Mots de passe** : `admin`

- Jenkins est automatiquement configuré avec les plugins nécessaire au front (nodeJS + SonarQube). 

Maintenant, il faut créer un build Jenkins qui analyse le code. 

- Dans le menu principal de Jenkins, cliquez sur "**New Item**" dans le bandeau de gauche

Entrez le nom du build : "**maintenance-back**"

- Cliquez sur "**Multibranch Pipeline**"

- Cliquez sur "**Ok**"

- Dans la configuration du build, allez dans la section "**Branches Sources**"

- Rentrez l'url du dépot git "**https://github.com/datskill/maintenance-front**" dans "**Repository HTTPS URL**"

- Dans la section "**Scan Repository Triggers**"  cochez la case "**Periodically if not otherwise run**"

- Cliquez sur Save puis Apply

Le build Jenkins éxécutera les étapes suivantes : 

- Installation des dépendances du projet
- Analyse du code sur SonarQube (le build s'arrêtera si une erreur apparait sur Sonar)
- Build de l'application
- Exécution des tests

Le jenkins analysera toutes les branches "actives" du projet mais aussi les Pull Request de Github

**/!\ Nous utilions l'API Github, de ce fait il peut y avoir une file d'attente pour build.**

Il reste cependant une manipulation à effectuer pour configurer Maven

- Rendez-vous dans "**Manage Jenkins**"

- Puis dans "**Global Tools Configuration**"

- Cherchez la section "**Maven", cliquez sur "Add Maven Installation**"

- Dans "**Name**", rentrez : "**apache-maven-3.6.3**"

- Cliquez sur "**Apply**" puis "**Save**" pour enregistrer


Nous allons maintenant préparer la configuration de SonarQube sur Jenkins

- Rendez-vous dans la page d'accueil de Jenkins

- Cliquez sur "**Manage Jenkins**" dans le bandeau de gauche

- Cliquez sur "**Configure System**"

- Recherchez la section "**SonarQube servers**"

- Cochez la case "**Enable injection of SonarQube server configuration as build environment variables**"

- Dans "**Name**", rentrez "**sonar-scanne**r"

- Dans "**Server URL"**, rentrez "http://sonarqube:9000/"

- Cliquez sur "**Save**" puis "**Apply**"

- Retournez sur la page d'accueil "**Manage Jenkins**"

- Cliquez sur "**Global Tool Configuration**"

- Ajoutez un "**Sonar-Scanner**"

- Dans l'input "**Name**", entrez "sonar-scanner" puis appliquez et enregistrez

Jenkins est maintenant configuré. 

Vous pouvez passer à l'installation de **SonarQube**

[Instalation et configuration de SonarQube](./conf-sonar.md)
