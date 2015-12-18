Utilisation du ant

build.xml a 4 target:

build : qui compile le projet et les tests
run : qui exécute le projet
test : qui exécute les tests
run_all : qui compile le projet et exécute les tests et le projet

Utilisation des JARs (nous avons constaté des problèmes d'éxécution sur linux):

Pour voir les différentes versions de notre application, il vous suffit de parcourir les 4 dossiers : sprint1, sprint2, sprint3 et sprint4.
A l'intérieur de ces dossiers, vous trouvez un jar, et pour les sprints 3 et 4, un dossier laby. A l'interieur de ce dossier vous trouvez un fichier
vous permettant de configurer le labyrinthe de la manière suivante :

Sprint3 :
	- 1 pour un mur, 0 pour une case libre, 2 pour la case trésor
	- 20x20

Sprint4 :
	- 1 pour un mur, 0 pour une case libre, 2 pour la case trésor
	- pour placer une trappe, on ajoute exactement 2x une lettre, (ex : 1a10001101a101010001)
	- on peut placer autant de trappes qu'il existe de lettres dans l'alphabet
	- 20x20

Chaque exécution des jars vous propose un affichage dans le terminal.

Pour exécuter un jar, on utilise la commande : java -jar pacman.jar
--------------------------------------------------------------------------------------------------

Nous avons du proceder de cette manière car nous ne sommes pas parvenus à réaliser un script capable de compiler le code à différentes versions sans
que cela crée des erreurs.
