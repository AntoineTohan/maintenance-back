# Maintenance du projet

## Que fait la maintenance ?

Lancer une maintenance aura plusieurs effets : 

- Effectuer une sauvegarde de la base de données
- Bloquer l'upload de fichiers XML ou CSV
- Site web inaccessible (message d'erreur du site en maintenance)

## Comment effectuer la maintenance


* Positionnez vous à la racine du projet `cd maintenance-back`
* Déplacez vous dans le dossier "maintenance" `cd maintenance`
### Si vous êtes sur Linux/Mac ou sur Windows avec un bash

* Exécutez la commande pour donner les droits sur le fichier "maintenance.sh" `chmod +x ./maintenance.sh`
* Exécutez le fichier à l'aide de `./maintenance.sh`

### Si vous êtes sur Windows sans bash

* Ouvrez un terminal "DockerToolBox"
* Ouvrez le fichier "maintenance.sh"
* Exécuter les commandes une par une

## Possible Amélioration

Il serait possible d'automatiser la maintenance de la base de données en créant une tâche dans le "**Cron**" du serveur qui héberge la base de données afin de déclencher une maintenance tous les X jours. 
