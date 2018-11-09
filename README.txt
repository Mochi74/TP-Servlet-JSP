URL
http://localhost:8080/Exemple1/random?min=0&max=100

CREATE TABLE `textes` (
  `id` varchar(50) NOT NULL,
  `texte` text NOT NULL
)
CREATE TABLE `frequence` (
  `textId` varchar(50) NOT NULL,
  `mot` varchar(50) NOT NULL,
  `frequence` int(11) NOT NULL
)