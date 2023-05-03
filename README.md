# UCE Génie Logiciel Avancé : Techniques de tests

## Badges (TP4)

![namebadge](https://img.shields.io/static/v1?label=Nom&message=Milan%20VERY-GRIETTE&color=blue)
![groupbadge](https://img.shields.io/static/v1?label=Groupe&message=ILSEN-ALT-Gr1&color=lightgrey)
[![CircleCI](https://dl.circleci.com/status-badge/img/gh/Milan-VERY-GRIETTE/ceri-m1-techniques-de-test/tree/master.svg?style=svg)](https://dl.circleci.com/status-badge/redirect/gh/Milan-VERY-GRIETTE/ceri-m1-techniques-de-test/tree/master)
[![codecov](https://codecov.io/gh/Milan-VERY-GRIETTE/ceri-m1-techniques-de-test/branch/master/graph/badge.svg?token=BD869Z8DSU)](https://codecov.io/gh/Milan-VERY-GRIETTE/ceri-m1-techniques-de-test)
![Checkstyle](docs/badges/checkstyle-result.svg)

## Documentation (TP5)

[Accès à la documentation (Github Pages)](https://milan-very-griette.github.io/ceri-m1-techniques-de-test/fr/univavignon/pokedex/api/package-summary.html)

## Rapport - Revue de code de la Team Rocket (TP6)

### Étape 1 : Test de l'implémentation RocketPokemonFactory

L'implémentation a été soumise aux mêmes tests que la PokemonFactory.
Des trois tests existants, les trois ont échoué, pour les raisons suivantes :

- `shouldGetPokemon` échoue, car le nom de pokémon attendu (Bulbizarre) ne correspond avec le nom renvoyé (MISSINGNO).<br>
    **Explication:** La Team Rocket et moi-même nous basons sur un référentiel différent quant à l'index d'un Pokémon donné. En effet, ceux-ci semblent se baser sur l'index officiel des Pokémons (avec Bulbizarre en 1 et MISSINGNO en 0), tandis que je me base sur l'index fourni par la consigne, qui est établi par rapport à la place des Pokémons dans un tableau, dont l'id du premier élément est 0 (donc, nous avons Bulbizarre en id 0 et, hypothétiquement, MISSINGNO en -1). Le vérification du Pokémon 0 amène donc à une différence de valeurs.

- `shouldThrowPokedexExceptionWhenIndexTooLow` échoue, car aucune exception n'est levée lorsque l'index de Pokémon demandé en dehors des valeurs autorisées pour le Pokédex (en dessous de 0).<br>
  **Explication:** L'implémentation de la Team Rocket ne lève pas de `PokedexException` en cas de valeur hors de portée du Pokédex.

- `shouldThrowPokedexExceptionWhenIndexTooHigh` échoue, car aucune exception n'est levée lorsque l'index de Pokémon demandé en dehors des valeurs autorisées pour le Pokédex (au dessus de la taille actuelle du Pokédex).<br>
  **Explication:** L'implémentation de la Team Rocket ne lève pas de `PokedexException` en cas de valeur hors de portée du Pokédex.

### Étape 2 : Étude du code de l'implémentation RocketPokemonFactory

Une étude rapide du code proposé par la Team Rocket permet d'identifier un autre problème non reconnu par les tests (ceux-ci échouent plus tôt dans leur exécution, avant de vérifier ce point en particulier).
Le problème concerne la génération des statistiques des Pokémons (Attaque, Défense, Stamina et IV).
En effet, la génération de l'Attaque, de la Défense et de la Stamina est aléatoire, ce qui ne correspond pas aux valeurs réelles des Pokémons. De plus, la valeur de l'IV est de soit 0, soit de 1, ce qui ne correspond pas non plsu aux critères réels.

### Étape 3 : Refonte des tests

Les tests de l'implémentation RocketPokemonFactory ont été remaniés pour correspondre aux spécificités du code de ce dernier.

## Introduction

Vous allez à travers ces projet mettre en application une partie des aspects évoqués en cours vis à vis des techniques de tests.  
Pour cela nous allons réaliser un projet logiciel de petite taille, en suivant la roadmap suivante : 
- Setup du projet
- Mise en place des outils d’intégration continue
- Écriture des tests unitaires
- Écriture des mocks, et validation des tests
- Développement dirigé par les tests
- Documentation et conventions de style
- Test d'une implémentation donnée

Le projet consiste à mettre en place un outil d’analyse statistique pour le jeu Pokémon GO.  
Durant cette série de TPs, le gestionnaire de version Git sera utilisé à foison, à travers la plateforme GitHub. Si vous n’êtes pas à l’aise avec cet outil[^1], [voici](http://rogerdudler.github.io/git-guide/) un petit guide à garder sous la main.

## Sujets

L'ensemble des sujets de TPs peut être trouvé dans le dossier `TPs`.

Le dossier `src` contient la définition de l'ensemble des interfaces qui seront l'objet de vos travaux.

## Rendus

Le rendu des TPs se fait au rythme suivant :

- TP1 : 1ère séance
- TP2 : 2ème séance
- TP3 : 3ème séance
- TP4 : 5ème séance
- TP5 : dernière séance
- TP6 : dernière séance

Pour chaque rendu, le projet dans son intégralité doit être déposé sur la plateforme.

[^1]: Si vous n’êtes vraiment pas à l’aise avec cet outil nous vous conseillons quand même vivement de vous y mettre.
