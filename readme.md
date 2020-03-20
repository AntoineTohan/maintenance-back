# OpenData Paris API

Partie back du projet OpenData Paris API

## Sommaire

- [Comment bien démarrer sur le projet](#pour-bien-démarrer-sur-le-projet)
- [Les procédures GIT](#procédure-GIT)
- [Recommendations sur les Merges](#Merge-Request)
- [Configuration de l'environnement de développement](#intégration-continue)
- [Configurer Jenkins](#jenkins)
- [Configurer SonarQube](#sonarqube)
- [Effectuer une maintenance](#maintenance)

## Pour bien démarrer sur le projet


### Démarrer le projet

- Cloner le projet avec git `git clone https://github.com/AntoineTohan/maintenance-back.git`
- Positionnez vous dans le répertoire du projet `cd maintenance-back`
- Cliquer sur "Run" dans IntelliJ pour démarrer le projet. (Assurez-vous d'avoir installer les prérequis dans "Configurer un environnement de développement)
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
 -	Modifier la <version> du Pom.XML, ex: `version ="1.1.0"`devient `version ="1.1.1"`
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

## Merge Request

La branche Master étant "Protected", vous ne pouvez pas push directement sur celle-ci. 

Il faut effectuer une "Merge request" depuis votre branche de développement vers la branche master. 

Pour tout le processus de commit, vous pouvez suivre la documentation "Procédure GIT"

Aprés avoir push votre branche develop, vous devez créer une "Pull Request" sur Github. 

* Vous devez choisir la personne qui fera une review de votre code

* La personne en question se chargera avec vous, d'analyser les changements et de vérifier que les bonnes pratiques ont bien été respectées. 

* Si c'est le cas, la personne effectuera le merge de la Pull Request en cliquant sur le bouton "Merge Pull Request"

* S'il y a des erreurs ou des incohérence, il faut noter des commentaires dans les "changes" de Github avec une explication du pourquoi ça ne convient pas. Alors, la personne qui a créer la Pull Request doit reprendre sa branche, faire les modifications en conséquence et re-push. 

**/!\ Nous avons une intégration continue avec Jenkins, de ce fait ne mergez pas une branche qui n'a pas finis d'être buildé sur le Jenkins !**

**/!\ De plus, quand vous avez mergez votre branche develop, vérifiez que le build de la branche "Master" sur Jenkins fonctionne toujours**



## Intégration continue

Notre intégration continue se compose des outils suivants : 

- Docker
- Jenkins
- SonarQube

Afin de pouvoir travailler dans de bonnes conditions, veillez à suivre les différentes documentations disponible afin d'avoir un environnement de développement optimal. 


## Configuration de l'environnement de développement
[Installation et configuration d'un environnement de développement](docs/conf-env.md)


## Jenkins
[Installation et configuration de Jenkins](docs/conf-jenkins.md)

## SonarQube
[Installation et configuration de SonarQube](docs/conf-sonar.md)

## Maintenance

[Effectuer une maintenance de l'application](docs/maintenance.md)


