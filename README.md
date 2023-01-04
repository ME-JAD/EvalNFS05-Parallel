# Evaluation Programmation et Parallélisme

## Contexte
- Un object StrongBox représentant un coffre fort muni de 1M clés est instancié.
- Chaque clé correspond à un mot de la langue française issu d'un dictionnaire fourni (336531 mots).
- Chaque clé peut être testée de manière individuelle en lui envoyant une chaine de caractère.
- Chaque clé peut être ouverte de manière individuelle en lui envoyant une chaine de caractère.
- Si une ouverture de clé est faite avec une mauvaise clé, la clé se bloque définitivement.
- Si une ouverture est faite sur une clé déjà ouverte, la clé se bloque définitivement, même s'il s'agit de la bonne chaine de caractère.
- Un affichage de l'état du coffre-fort est placé dans la console toutes les 5 secondes.

## Diagramme de classe de la solution de départ
![Diagramme de classe](https://github.com/Jean-Aymeric/EvalNFS05-Parallel/blob/master/StrongBox.png)

## Programme d'exemple
Dans le main, il y a un programme d'exemple qui teste toutes les combinaisons à l'aide de deux boucles for imbriquées. Cet exemple ne fait absolument pas appel aux threads.

## Travail demandé
- Réaliser un programme en utilisant les threads permettant de craquer le coffre-fort
- Il y a plusieurs possibilités, cependant vous ne devez pas avoir plus de 1000 threads en même temps quelque soit votre manière de faire.
