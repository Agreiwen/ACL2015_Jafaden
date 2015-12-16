Utilisation des JARs :

Pour voir les diff�rentes versions de notre application, il vous suffit de parcourir les 4 dossiers : sprint1, sprint2, sprint3 et sprint4.
A l'int�rieur de ces dossiers, vous trouvez un jar, et pour les sprints 3 et 4, un dossier laby. A l'interieur de ce dossier vous trouvez un fichier
vous permettant de configurer le labyrinthe de la mani�re suivante :

Sprint3 :
	- 1 pour un mur, 0 pour une case libre, 2 pour la case tr�sor
	- 20x20

Sprint4 :
	- 1 pour un mur, 0 pour une case libre, 2 pour la case tr�sor
	- pour placer une trappe, on ajoute exactement 2x une lettre, (ex : 1a10001101a101010001)
	- on peut placer autant de trappes qu'il existe de lettres dans l'alphabet
	- 20x20

Chaque ex�cution des jars vous propose un affichage dans le terminal.

Pour ex�cuter un jar, on utilise la commande : java -jar pacman.jar
--------------------------------------------------------------------------------------------------

Nous avons du proceder de cette mani�re car nous ne sommes pas parvenus � r�aliser un script capable de compiler le code � diff�rentes versions sans
que cela cr�e des erreurs.