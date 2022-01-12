-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : ven. 15 oct. 2021 à 14:51
-- Version du serveur : 10.4.21-MariaDB
-- Version de PHP : 8.0.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `pika-jobs`
--

-- --------------------------------------------------------

--
-- Structure de la table `companies`
--

CREATE TABLE `companies` (
  `id` tinyint(4) NOT NULL,
  `nom` varchar(40) NOT NULL,
  `responsableRH` varchar(40) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `companies`
--

INSERT INTO `companies` (`id`, `nom`, `responsableRH`) VALUES
(1, 'pokedex', 'lipoutou bis');

-- --------------------------------------------------------

--
-- Structure de la table `offre`
--

CREATE TABLE `offre` (
  `id` int(11) NOT NULL,
  `titre` varchar(50) NOT NULL,
  `mini_description` text NOT NULL,
  `lieu` text NOT NULL,
  `missions` text NOT NULL,
  `salaire` int(11) NOT NULL,
  `horaire` text DEFAULT NULL,
  `avantage` text DEFAULT NULL,
  `experience` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `offre`
--

INSERT INTO `offre` (`id`, `titre`, `mini_description`, `lieu`, `missions`, `salaire`, `horaire`, `avantage`, `experience`) VALUES
(2, 'Soigneur Pokemon', 'Devenez soigneur pokemon comme la célèbre infirmière Joelle.', 'Centre Pokemon de Mauville, dans la région Johto', '- Soins et bien-être des pokémons.\r\n- Gérer la zone de repos des dresseurs.', 2400, NULL, NULL, 'Expérience de 3 ans minimum  demandée'),
(3, 'Maître d\'Arène Pokémon', 'Devenez un grand maître pokémon de type eau.', 'Arène d\'Azuria, dans la région de Kanto', '\r\n    - Combattre les challengers en combat Pokémon et remettre le badge cascade à ceux qui parviennent à triompher.\r\n    - Etre spécialisé en Pokémon de type eau.\r\n', 3000, NULL, 'Logement de fonction', NULL),
(4, 'Professeur Pokemon', 'Passionné(e) de pokemon, transmettez votre passion.', 'Bourg Palette, dans la région de Kanto', '    - Accompagnement des jeunes dresseurs pokemon.    - Proposition des pokémons starter aux jeunes dresseurs.    - Etudier les pokémons pour la mise à jour du pokedex.    - Mener une étude sur évoli et toutes ses évolutions.    - Etre disponible à toute heure de la nuit et du jour pour renseigner les jeunes dresseurs.', 4500, 'null', 'Logement de fonction, Véhicule de fonction.', 'null'),
(6, 'Responsable Poke-Store', 'Devenez responsable Poke-Store dans votre région.', 'Doublonville, région Johto', 'management équipes', 1800, 'Horaires Flexibles \n Période de travail de 8h', NULL, NULL),
(8, 'Développeur Jeux', 'Game Freak recrute un développeur Jeux. ', 'Doublonville ', 'Type de contrat : CDILe siège installé à Doublonville offre de nombreuses possibilités d’évolutions de carrières. Intégré(e) dans l\'équipe de production des jeux de Pokémon, vous participerez à la conception ainsi qu\'aux développements des jeux.Rattaché(e) au responsable technique du projet vous serez amené à produire la documentation technique et les tests associés.Vous participerez également à la correction d\'anomalies détectées durant le cycle de qualification.', 2500, 'Emploi en CDI sur la base de 35h/semaine ', 'Avantages sociaux intéressant, mutuelle avantageuse', 'null'),
(9, 'Gameplay Programmer - Confirmé ', 'Game Freak recrute un développeur Jeux.', 'Rosalia', 'majoritairement en télétravail mais le télétravail complet n\'est pas envisageable sur le long terme, nous espérons pouvoir nous retrouver au siège dès que cela sera possible.  Vos responsabilités principales seront : Développer des nouvelles fonctionnalités de jeu, du prototypage au debug, dans un cadre online ; Interagir avec l\'équipe Design et créatives autour des fonctionnalités prévues, afin de comprendre les objectifs, et pouvoir challenger les missions.', 5000, 'Emploi en CDI sur la base de 35h/semaine ', 'Avantages sociaux intéressant, mutuelle avantageuse', ''),
(10, 'Vendeur(se) de vélos Confirmé(e)', 'Pour le développement de notre nouveau magasin, nous recrutons sur notre site de Carmin sur Mer: Un(e) Vendeur(se) de vélos confirmé(e)', 'Azuria', 'Intégré(e) à l\'équipe de vente, vous êtes en charge du conseil et de la vente de vélocycles. Votre bonne connaissance de la vente et des matériaux de construction ainsi que vos capacités professionnelles sont reconnues.  Vous êtes passionné(e) par le cyclisme et disposez d\'une forte connaissance du secteur et de ses tendances.  Vous êtes par ailleurs dynamique, impliqué(e), vous avez le goût pour le travail d\'équipe et aimez conseiller et fidéliser une clientèle.  Votre sens relationnel, votre polyvalence, votre rigueur et le goût du travail en équipe seront des atouts pour occuper ce poste.  Nous vous offrons : L\'opportunité de rejoindre une structure à taille humaine et un véritable challenge à relever dans le cadre du développement de notre site. CDI à temps complet à pourvoir dès que possible.', 2000, ' ', 'mutuelle, prévoyance, prime de vacances, intéressement, plan d\'épargne entreprise.', ''),
(12, 'Croupier Débutant H/F', 'Devenez croupier au Casino de Céladopole.', 'Céladopole, région Kanto', 'Ce que le casino de Céladopole souhaite vous offrir, c\'est : - Une majoration de vos heures de nuit ,Un régime de mutuelle et prévoyance avantageux , Un secteur d\'activité où le divertissement, la fête et les émotions règnent en maitre - Un environnement de travail convivial basé sur l\'entraide et l\'esprit d\'équipe - Un management de proximité accessible qui vous permet de progresser - L\'intégration dans un groupe qui offre des perspectives d\'évolution interne . Ce que nous attendons d\'un(e) croupier(e) débutant(e) c\'est : - Préparer sa table et son matériel de jeu avec soin  - Accueillir nos clients à la table avec sourire en enthousiasme  - Démocratiser l\'accès aux jeux de table, en expliquant si besoin les règles aux clients  - Animer les parties avec convivialité et dextérité  - Garantir les bonnes relations entre les joueurs  - Savoir prévenir les situations d\'abus de jeux.', 2500, 'Temps plein', 'salaire négociable selon expérience', 'Ce qui vous caractérise : - Vous avez un casier judiciaire vierge et êtes de nationalité française ou européenne, conditions indispensables pour obtenir un agrément ministériel (obligatoire pour travailler en casino). - Vous êtes curieux(se) de découvrir le secteur des jeux et êtes prêt(e) à vous former à un nouveau métier (formation dispensée par le casino). - Vous avez une certaine résistance au stress. - Vous avez de réelles capacités en calcul mental et de concentration. - Vous souhaitez travailler exclusivement de nuit. - Diplomate et cordial(e), vous bénéficiez d\'un très bon relationnel et savez faire preuve de discrétion. - Vous avez une âme d\'animateur(rice) que vous souhaitez exploiter dans votre futur job.'),
(13, 'Déménageur H/F', 'Devenez déménageur au sein d\'une entreprise dynamique.', ' Vergazon', 'Vos missions : - Ranger et emballer les objets dans des cartons en les protégeant pour éviter la casse. - Charger le camion de déménagement de manière optimisée. - Être capable de soulever des objets très lourds. - Savoir manier avec précaution les objets précieux ou volumineux. - Acheminer les objets vers le nouveau logement sans encombre. - Procéder au déchargement. - Déballer les cartons. - Ranger les objets. - Démonter et remonter les meubles. - S\'occuper des formalités administratives.  Vous travaillez en doublon avec un machopeur de l’équipe.   Vous être plutôt bricoleur(se) pour réaliser des travaux de montage et démontage de meubles, êtes une personne rigoureuse, organisée et soignée et aimé travailler en collaboration avec des Pokemon. ', 3500, '', '', 'Expériences similaires acceptées - Déménageur H/F . - Chauffeur Déménageur H/F .'),
(14, 'Electricien H/F', 'Devenez electricien dans la centrale électrique de vore ville.', 'Floraville', 'Doté de solides connaissances dans le secteur de l\'électricité, vous disposez au moins d’un Voltobre ou Pokémon électrique équivalent.   Habile manuellement, vous êtes à l\'aise lors de l\'utilisation d\'outils spécifiques.  Minutieux, méthodique et organisé vous respectez les règles de sécurité, les procédures de contrôle ainsi que les consignes et les délais définis.  Cette offre vous intéresse ? Postulez dès à présent !', 2900, '', '', 'Issu d\'une formation dans ce domaine, vous justifiez d\'une expérience réussie et significative de minimum 1 an sur ces fonctions et disposez de vos habilitations électriques (BR, BV, BV1) à jour et en cours de validité.'),
(15, 'Paysagiste H/F', 'Nous recherchons pour notre client situé sur la région de Kanto, un Paysagiste H/F en CDI pour intégrer l’équipe en charge du Parc Safari. ', 'Eternara', 'Nous recherchons pour notre client situé sur la région de Kanto, un Paysagiste H/F en CDI pour intégrer l’équipe en charge du Parc Safari.  - Réaliser des chantiers de création selon le planning : Terrassement manuel et par moyen mécanique, réalisation de dalles béton, réalisation de terrasse bois, de dallage, de muret. Réalisation de tout type de clôture. Plantations, gazon et élagage. - Appliquer les règles d\'hygiènes, de sécurité et de réglementations. - Assurer l\'entretien courant du matériel dédié à la création et à l\'équipe. - Assurer des prestations de qualité.', 1800, '', '', 'Vous êtes, titulaire d\'un Bac Pro aménagements paysagers ou équivalent et justifiez d\'une expérience professionnelle réussie d\'au moins 3 ans en paysage. Titulaire du permis C, BE.   Rigoureux(se), méthodique, vous savez travailler avec goût et sensibilité et faites preuve d\'implication. '),
(17, 'Assistant(e) administratif(ve) & Direction (H/F)', 'Nous recrutons un Assistant administratif et Direction (H/F) pour l’un de nos sites industriels situé dans la région de Johto  ', 'Volucité', 'Type de contrat : CDD Temps plein Vous assurez, en support de la Direction et du service Comptabilité & Finances la gestion administrative des contrats et des fournisseurs. la gestion des notes de frais L’organisation des déplacements (train, avion, hôtel, location de voiture etc.) La réalisation de reportings groupe L’organisation & la coordination d’évènements divers et le relais de la communication groupe Le rôle de référent auprès du service informatique. Les missions sont variées et évolutives.', 2000, '', '', 'De formation BAC +2 minimum, vous avez une expérience réussie d’au moins 5 ans dans un poste similaire. Vous maîtrisez les outils informatiques.  Anglais courant indispensable et bonnes capacités rédactionnelles.'),
(18, 'Juriste Droit Public (F / H) ', 'Bonjour, moi c\'est Josselin. Je fais partie de l\'équipe RH du groupe The Pokemon Company. Aujourd\'hui, je recrute un.e Juriste Droit Public (F / H) ', 'Parsemille', 'A propos : The Pokemon Company est un groupe une entreprise essentielle au fonctionnement de Pokémon en lien avec Game Freak et Nintendo.  Le groupe réalise désormais 80 millions de CA, en France et au Canada, grâce à ses 600 collaborateurs et 7 000 structures clientes. A propos du poste : Vos responsabilités : Après un parcours d\'intégration et de formation à nos outils et méthodes : Vous prenez en charge les questions et demandes émanant de nos clients sur les thématiques suivantes : urbanisme / commande publique / fonction publique et fonctionnement des collectivités ; Vous prenez en compte les attentes, étudiez les demandes et apportez une information structurée et vérifiée ;Vous mutualisez les connaissances et développez nos bases d\'informations, et contribuez à enrichir nos services et outils numériques. Vous pouvez participer à la rédaction de mémos, articles ou dossiers à thème, et à des réunions ou conférences en ligne sur des sujets d\'actualité. Pour réussir dans votre mission, vous êtes accompagné.e par votre management et pouvez compter sur une équipe dynamique et enthousiaste qui participera à votre intégration et au développement de vos compétences. Profil recherché : Votre profil : Formation : Bac +5 en droit public, idéalement droit des collectivités territoriales ;Compétences informatiques : Aisance avec les outils digitaux ; Compétences comportementales : Sens de la relation client, du travail en équipe, une bonne communication orale et une bonne capacité rédactionnelle, de grandes qualités d\'écoute. Poste ouvert aux personnes en situation de handicap. Les bonnes raisons de nous rejoindre : Des missions variées et des challenges à relever ; De réelles possibilités de développement de compétences ; Un management à l\'écoute / bienveillant ; Un environnement convivial et un esprit collectif.', 2300, 'Horaire de travail effectif : 9h - 18hPoste en CDI', 'statut Cadre, 13ème mois / TR / Mutuelle avantageuse.', '');

-- --------------------------------------------------------

--
-- Structure de la table `offre_postuler`
--

CREATE TABLE `offre_postuler` (
  `nom` varchar(40) NOT NULL,
  `prenom` varchar(40) NOT NULL,
  `email` varchar(40) NOT NULL,
  `phone` varchar(40) NOT NULL,
  `titreoffre` varchar(40) NOT NULL,
  `id` tinyint(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `offre_postuler`
--

INSERT INTO `offre_postuler` (`nom`, `prenom`, `email`, `phone`, `titreoffre`, `id`) VALUES
('TEISSEIRE', 'Alexandre', 'alexandre1.teisseire@epitech.eu', '0622979373', 'Soigneur Pokemon', 7),
('Mouse', 'Mickey', 'mickey.mouse@epitech.eu', '0622979325', 'Responsable Poke-Store', 9),
('TEISSEIRE', 'Alexandre', 'alexandre1.teisseire@epitech.eu', '0622979373', 'Soigneur Pokemon', 10),
('TEISSEIRE', 'Alexandre', 'alexandre1.teisseire@epitech.eu', '0622979373', 'Professeur Pokemon', 11),
('Mouse', 'Mickey', 'mickey.mouse@epitech.eu', '0622979325', 'Soigneur Pokemon', 13),
('Mouse', 'Mickey', 'mickey.mouse@epitech.eu', '0622979325', 'Professeur Pokemon', 15),
('Pokemon', 'Salameche', 'salameche@gmail.com', '02445456456', 'Déménageur H/F', 16);

-- --------------------------------------------------------

--
-- Structure de la table `people`
--

CREATE TABLE `people` (
  `id` tinyint(4) NOT NULL,
  `nom` varchar(40) NOT NULL,
  `prenom` varchar(40) NOT NULL,
  `email` varchar(40) NOT NULL,
  `phone` varchar(40) NOT NULL,
  `password` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `people`
--

INSERT INTO `people` (`id`, `nom`, `prenom`, `email`, `phone`, `password`) VALUES
(1, 'TEISSEIRE', 'Alexandre', 'alexandre1.teisseire@epitech.eu', '0622979373', 'test'),
(2, 'Mouse', 'Mickey', 'mickey.mouse@epitech.eu', '0622979325', 'minnie'),
(3, 'Administrateur', 'Administrateur', 'administrateur@gmail.com', '0236363636', 'boss'),
(5, 'Duck', 'Donald', 'donald.duck@epitech.eu', '02969696969', 'coincoin'),
(6, 'Pokemon', 'Salameche', 'salameche@gmail.com', '02445456456', 'feu');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `companies`
--
ALTER TABLE `companies`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `offre`
--
ALTER TABLE `offre`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `offre_postuler`
--
ALTER TABLE `offre_postuler`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `people`
--
ALTER TABLE `people`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `companies`
--
ALTER TABLE `companies`
  MODIFY `id` tinyint(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT pour la table `offre`
--
ALTER TABLE `offre`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- AUTO_INCREMENT pour la table `offre_postuler`
--
ALTER TABLE `offre_postuler`
  MODIFY `id` tinyint(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT pour la table `people`
--
ALTER TABLE `people`
  MODIFY `id` tinyint(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
