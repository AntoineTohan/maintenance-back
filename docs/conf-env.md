## Installation et configuration d'un environnement de développement


### Docker

Pour installer Docker sur Windows, il faut obligatoirement Windows 10 professionnel, sinon il faudra télécharger Docker ToolBox.

Pour l’installation de Docker ou Docker ToolBox il est nécessaire d’avoir accès à un terminal de ligne de commande type “shell bash Linux”.
Si vous êtes sur Windows, nous vous recommandons d'installer **Git Bash**.  https://git-scm.com/download/win.

### Windows 10 PRO :

* Ce rendre sur le site de Docker : https://www.docker.com/get-started

- Cliquer sur le bouton “Download Desktop and Take a Tutorial”

- Créer un compte Docker

- Télécharger l'exécutable pour Windows

- Double-cliquez sur "Docker Desktop Installateur.exe" pour lancer l'installateur

- Suivez l'assistant d'installation : acceptez la licence, autorisez l'installateur et procédez à l'installation

- Cliquez sur "Close" pour terminer l'installation

- Dans un nouveau terminal lancer `docker -v` , si le terminal vous donne la version actuelle de docker alors l’installation est réussi


Vous pouvez maintenant lancer Docker Desktop en le recherchant dans la barre de recherche de Windows et en cliquant dessus
Exécuter le tutoriel Docker Hello-World pour apprendre les commandes de bases de docker et vérifier l'installation docker run hello-world .

### Pour Windows 10 (Standard, Famille..) ou < 10 :

- Rendez-vous sur le GitHub Docker ToolBox : https://github.com/docker/toolbox/releases

- Télécharger le dernier éxécutable stable disponible (`DockerToolbox-XX.XX.X.exe`)

- Suivre les instructions d’installation du launcher

- Une fois fini vous devriez avoir un nouveau programme “**Docker QuickStart**”

- Exécuter “**Docker QuickStart**”

- Un terminal s’ouvre, s’il demande un “**User Account Control**”, répondre par “Yes”

- Quand l’initialisation est terminée, le terminal affichera un “$”

- Dans un nouveau terminal lancer `docker -v` si le terminal vous donne la version actuelle de docker alors l’installation est réussi

  Docker est maintenant installé.

### Pour MacOS:

- Ce rendre sur le Docker : https://docs.docker.com/docker-for-mac/install/ et cliquer sur “**Download from Docker Hub**”

- Créer un compte Docker

- Exécuter le fichier “**docker.dmg**”

- Suivre l’installateur comme pour toute application Mac, déplacer l'éxécutable dans le dossier **“Application”**

- Exécuter "**Docker Desktop**"

- Vous devriez voir apparaître l'icone de Docker dans la TopBar Mac

- Cliquer sur l’icone docker de la TopBar 

- Une fenêtre vous affichera le statut d'installation de votre docker et aussi un formulaire pour vous connecter avec votre compte Docker.


- Dans un nouveau terminal lancer 'docker -v' si le terminal vous donne la version actuelle de Docker alors l'installation est une réussite.

- Exécuter le tutoriel Docker Hello-World pour apprendre les commandes de base de Docker et vérifier l'installation ```docker run hello-world```.

Docker est maintenant installé.


### Pour Ubuntu Disco 19.04 / Cosmic 18.10 / Bionic 18.04 (LTS) / Xenial 16.04 (LTS) :

#### METTRE EN PLACE LE DÉPÔT

- Ouvrez un terminal natif et updater les packages : ```sudo apt-get update```

- Installer des paquets pour permettre à apt d'utiliser un référentiel sur HTTPS : ```sudo apt-get install apt-transport-https ca-certificates curl gnupg-agent software-properties-common```

- Ajoutez la clé GPG officiel de Docker : ```curl -fsSL https://download.docker.com/linux/ubuntu/gpg | sudo apt-key add -```

- Vérifiez que vous avez maintenant la clé avec l'empreinte digitale **9DC8 5822 9FC7 DD38 854A E2D8 8D81 803C 0EBF CD88**,  en recherchant les 8 derniers caractères de l'empreinte digitale. ```sudo apt-key fingerprint 0EBFCD88```

- Utilisez la commande suivante pour mettre en place le dépôt stable : ```sudo add-apt-repository "deb [arch=amd64] https://download.docker.com/linux/ubuntu $(lsb_release -cs) stable"

### INSTALLER DOCKER ENGINE - COMMUNITY

- Une fois le dépôt bien ajouté, lancer la commande suivante : `sudo apt-get update`

- Installer la dernière version de Docker Engine - Community : `sudo apt-get install docker-ce docker-ce-cli containerd.io`

- Dans un nouveau terminal lancer `docker -v` si le terminal vous donne la version actuelle de docker alors l’installation est réussi 

- Exécuter le tutoriel Docker Hello-World pour apprendre les commandes de bases de docker et vérifier l'installation 

**INSTALLER DOCKER COMPOSE**

- Cette commande permet de télécharger la version stable actuelle de Docker Compose : ```sudo curl -L "https://github.com/docker/compose/releases/download/1.25.3/docker-compose-$(uname -s)-$(uname -m)" -o /usr/local/bin/docker-compose```

- Appliquer les permissions d'exécution au binaire : `sudo chmod +x /usr/local/bin/docker-compose`


- Tester l'installation: `docker-compose --version`

 Docker est maintenant installé.

### Jenkins
Vous pouvez passez à l'étape de l'installation et de la confguration de Jenkins

[**Instalation et configuration de Jenkins**](./conf-jenkins.md)