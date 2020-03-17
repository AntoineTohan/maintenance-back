# Prérequis ajouter les permissions au fichier: chmod +x ./maintenance.sh
#!/bin/bash
echo "----------- Lancement du plan de maintenance -----------"

sleep 3s

echo "----------- Set on maintenance -----------"
docker exec -it opendata mysql -uroot -ppassword opendata -e "UPDATE maintenance SET status=true WHERE id=1;"
sleep 1s

echo "----------- Création de l'architectures de fichier -----------"
mkdir $PWD/backups/$(date +"%d-%m-%Y")
sleep 1s
cd $PWD/backups/$(date +"%d-%m-%Y")

sleep 3s

echo "----------- Dump la databse sql -----------"

docker exec opendata /usr/bin/mysqldump -u root --password=password opendata >backup.sql

# for testing simulate a big db
sleep 60s

echo "----------- Set off maintenance -----------"
docker exec -it opendata mysql -uroot -ppassword opendata -e "UPDATE maintenance SET status=false WHERE id=1;"
sleep 1s

echo "----------- Fin du plan de maintenance-----------"
