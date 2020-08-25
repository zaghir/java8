la programmation fonctionnel apporte deux idées globale
  - ne pas partager les données qui sont mutables
  - possibilisé de passer des methodes à d'autres methode 



mvn sonar:sonar \
  -Dsonar.projectKey=test \
  -Dsonar.host.url=http://localhost:9000 \
  -Dsonar.login=4e5fc2a828fb9c5e2d707d28b0071b9051190ef1
  
mvn sonar:sonar -Dsonar.projectKey=test -Dsonar.host.url=http://localhost:9000 -Dsonar.login=4e5fc2a828fb9c5e2d707d28b0071b9051190ef1



# java8

description :
------------------------------------
Ce dépôt est utilisé pour savoir les nouvelles fonctions que java 8 propose que ce soit pour la version SE ou JEE

initialisation de depot :
------------------------------------
or create a new repository on the command line

echo "# java8" >> README.md
git init
git add README.md
git commit -m "first commit"
git remote add origin https://github.com/zaghir/java8.git
git push -u origin master


or push an existing repository from the command line

git remote add origin https://github.com/zaghir/java8.git
git push -u origin master