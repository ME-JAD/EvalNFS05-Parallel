# Evaluation Programmation et Parallélisme

## Contexte
- Un object StrongBox représentant un coffre fort muni de 1M clés est isntancié.
- Chaque clé correspond à un mot de la langue française issu d'un dictionnaire fourni (336531 mots).
- Chaque clé peut être testée de manière individuelle en lui envoyant une chaine de caractère.
- Chaque clé peut être ouverte de manière individuelle en lui envoyant une chaine de caractère.
- Si une ouverture de clé est faite avec une mauvais clé, la clé se bloque définitivement.
- Si une ouverture est faite sur une clé déjà ouverte, la clé se bloque définitivement, même s'il s'agit de la bonne chaine de caractère.
- Un affichage de l'at du coffre fort est placé dans la console toutes les 5 secondes.

## Diagramme de classe de la solution de départ

## Travail demandé
- Réaliser un programme en utilisant les threads permettant de craquer le coffre fort
