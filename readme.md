# OpenData Paris API

Partie back du projet OpenData Paris API

L'intégration continue est sensiblement similaire à celle du front

## Pour bien démarrer sur le projet

### Outils de développement React - TS


Pour un nouveau développeur, il est conseillé de suivre la procédure suivante : 

### Prérequis logiciel

- Installer NodeJS (https://nodejs.org)
- S'assurer de l'installation de NodeJS en tapant `node -version` dans un terminal
- Installer React (https://fr.reactjs.org/)
- S'assurer de l'installation de React en tapant `npx --version` dans un terminal
- Installer Git (https://git-scm.com)
- S'assurer de l'installation de Git en tapant `git -version` dans un terminal
- Si vous n'avez pas d'IDE à disposition, nous vous recommandons Visual Studio Code (https://code.visualstudio.com)

Vous avez désormais tous les outils nécessaires

### Démarrer le projet

- Cloner le projet avec git `git clone https://github.com/datskill/maintenance-front.git`
- Positionnez vous dans le répertoire du projet `cd maintenance-front`
- Dans le terminal, tapez `npm install` pour installer les dépendances du projet
- Dans le terminal, tapez `npm run start`

Le projet va démarrer et s'ouvrir dans une fenêtre de votre navigateur par défaut

## Procédure GIT

### Pour développer une nouvelle feature

 -	Se positionner sur la branche Master
 -	Exécutez un `git pull` pour être à jour avec le dépôt distant
  -	Exécutez un  `git checkout -b nouvelle_feature` pour créer une nouvelle branche où nouvelle_feature est le nom de la feature en question.
 -	Faire les développements nécessaires
 -	Exécutez `git add . ` pour ajouter toutes les modifications
 -	Exécutez  `git commit -m « message_commit` (voir annexe pour le nommage des commits)
 -	Retournez sur la branche Master avec `git checkout master`
 -	Executez un `git pull` pour se remettre à jour avec la branche Master
 -	Retournez sur la branche feature avec `git checkout nouvelle_feature`
 -	Exécutez un `git rebase master` pour mettre la branche nouvelle_feature à jour avec la branche Master
 -	Exécutez un  `ng build –prod` pour builder l’application avec un environnement de production
 -	Exécutez un `npm run test` pour lancer les tests
 -	Exécuter un `git push -u origin nouvelle_feature` pour push les modifications sur le dépôt distant
 -	Si des modifications surviennent sur la branche avant d’avoir merger sur Master, `git push` suffit pour push les nouvelles modifications

### Pour créer un hotfix

-	Se positionner sur la branche Master
 -	Exécuter un `git pull`  pour être à jour avec le dépôt distant
 -	Exécuter un `git checkout -b hotfix/1.1.X` (où X est le Nième hotfix sur la version actuelle, ici 1.1) ex : `git checkout -b hotfix/1.1.1`
 -	Pour l’application FRONT-END, modifier la version du package.json, ex: `version ="1.1.0"`devient `version ="1.1.1"`
 -	Push les modifications (suivre la procédure pour développer une nouvelle feature)
 -	A partir de maintenant, pour chaque correction de bug, se placer sur la branche hotfix avec `git checkout hotfix/1.1.X` et tirer une nouvelle branche depuis celle-ci (`git checkout -b correction_bug`)
 -	Pour push, suivre la procédure pour « développer une nouvelle feature ». Cependant le pull/rebase se fera avec la branche hotfix/1.1.X

### Nommage des commits

Essayez d’être le plus explicite possible dans le nommage des commit comme en précisant le nom de la feature développé, du bug résolu… EX :


**Pour une nouvelle feature : [ADD] Création de la page X**

**Pour la correction d’un bug SonarQube : [SONAR] Correction bug XXX (XXX : id de l’anomalie SonarQube)**

**Pour une correction de bug : [FIX] Alignement des boutons**

**Pour une modification d’une feature existante : [REFACT] Modification de la page X**

**Pour la suppression d’un élément : [DEL] Suppression du bouton de droite**

**Pour des commentaires de code : [COM] Commentaire méthode X**

**Pour la création d’une nouvelle version : [VRS] 1.1.5 to 1.2.0**

**Pour la création d’un hotfix : [HOT] 1.1.1 to 1.1.2**


## Intégration continue

Notre intégration continue se compose des outils suivants : 

- Docker
- Jenkins
- SonarQube

Afin de pouvoir travailler dans de bonnes conditions, veillez à suivre les différentes documentations disponible afin d'avoir un environnement de développement optimal. 


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
