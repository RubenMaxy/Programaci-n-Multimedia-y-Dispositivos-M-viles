package com.example.trivial.data

data class QuestionData(
    val question: String,
    val answers: List<String>,
    val correctAnswerIndex: Int
)

val videoGameQuestions = listOf(
    QuestionData(
        "¿Cuál es el nombre del protagonista de la serie de juegos Legend of Zelda?",
        listOf("Link", "Zelda", "Ganon", "Epona"),
        0
    ),
    QuestionData(
        "¿En qué año se lanzó el primer juego de la serie Mario Kart?",
        listOf("1995", "1992", "1989", "1996"),
        1
    ),
    QuestionData(
        "¿Cuál es el nombre del villano principal en la serie de juegos Sonic the Hedgehog?",
        listOf("Dr. Eggman", "Bowser", "Wario", "Dr. Neo Cortex"),
        0
    ),
    QuestionData(
        "¿Qué videojuego popular presenta una batalla entre plantas y zombis?",
        listOf("Zombies Ate My Neighbors",  "Left 4 Dead", "Plants vs. Zombies", "Dead Rising"),
        2
    ),
    QuestionData(
        "¿Cuál es el nombre del planeta natal de los Zerg en la serie de juegos StarCraft?",
        listOf("Aiur", "Korhal", "Shakuras","Char"),
        3
    ),
    QuestionData(
        "¿Qué personaje es conocido como el 'Jefe Maestro' en la serie de juegos Halo?",
        listOf("Arbiter", "Cortana", "Jefe Maestro", "Sargento Johnson"),
        2
    ),
    QuestionData(
        "¿Cuál es el nombre del perro que acompaña al jugador en el juego Fallout 4?",
        listOf("Dogmeat", "Rex", "Max", "Dogmeat Jr."),
        0
    ),
    QuestionData(
        "¿En qué año fue lanzado el juego The Witcher 3: Wild Hunt?",
        listOf("2013", "2014", "2015", "2016"),
        2
    ),
    QuestionData(
        "¿Cuál es el juego de disparos en primera persona desarrollado por id Software en 1993?",
        listOf("Quake", "Doom", "Wolfenstein 3D", "Hexen"),
        1
    ),
    QuestionData(
        "¿Qué juego de lucha presenta a personajes como Ryu y Ken?",
        listOf("Mortal Kombat", "Tekken", "Street Fighter", "King of Fighters"),
        2
    ),
    QuestionData(
        "¿En qué año se lanzó el primer juego de la serie Final Fantasy?",
        listOf("1987", "1990", "1985", "1992"),
        0
    ),
    QuestionData(
        "¿Quién es el creador del juego de construcción y supervivencia Minecraft?",
        listOf("Markus Persson", "Shigeru Miyamoto", "Hideo Kojima", "Sid Meier"),
        0
    ),
    QuestionData(
        "¿Cuál es el nombre del reino donde se desarrolla la mayoría de los juegos de Mario?",
        listOf("Hyrule", "Mushroom Kingdom", "Dream Land", "Kanto"),
        1
    ),
    QuestionData(
        "¿En qué videojuego puedes encontrar el arma icónica llamada 'BFG 9000'?",
        listOf("Quake", "Half-Life", "Doom", "Halo"),
        2
    ),
    QuestionData(
        "¿Cuál es el nombre del protagonista de la serie de juegos Metroid?",
        listOf("Samus Aran", "Lara Croft", "Master Chief", "Solid Snake"),
        0
    ),
    QuestionData(
        "¿En qué año fue lanzado el primer juego de la serie Pokémon?",
        listOf("1996", "1998", "1995", "2000"),
        0
    ),
    QuestionData(
        "¿Qué empresa desarrolló el videojuego Fortnite?",
        listOf("Activision", "Epic Games", "Ubisoft", "Valve"),
        1
    ),
    QuestionData(
        "¿Quién es el creador de la serie de juegos Metal Gear?",
        listOf("Hideo Kojima", "Hideki Kamiya", "Tetsuya Nomura", "Shinji Mikami"),
        0
    ),
    QuestionData(
        "¿En qué juego puedes encontrar al personaje llamado 'Geralt de Rivia'?",
        listOf("Dragon Age", "The Witcher", "Dark Souls", "Elder Scrolls"),
        1
    ),
    QuestionData(
        "¿Cuál es el nombre del mundo donde se desarrolla el juego World of Warcraft?",
        listOf("Tamriel", "Azeroth", "Runeterra", "Norrath"),
        1
    ),
    QuestionData(
        "¿Qué juego popular incluye la línea 'The cake is a lie'?",
        listOf("Half-Life", "Portal", "BioShock", "Deus Ex"),
        1
    ),
    QuestionData(
        "¿En qué videojuego aparece el personaje 'Gordon Freeman'?",
        listOf("Half-Life", "BioShock", "System Shock", "Dishonored"),
        0
    ),
    QuestionData(
        "¿Cuál es el nombre del hermano menor de Mario en la serie de juegos de Mario?",
        listOf("Wario", "Luigi", "Toad", "Yoshi"),
        1
    ),
    QuestionData(
        "¿Qué videojuego es conocido por la frase 'Would you kindly'?",
        listOf("BioShock", "Dishonored", "Prey", "System Shock"),
        0
    ),
    QuestionData(
        "¿Cuál es el nombre del juego en el que los jugadores construyen y destruyen bloques en un mundo tridimensional?",
        listOf("Terraria", "Minecraft", "Roblox", "Fortnite"),
        1
    ),
    QuestionData(
        "¿Qué juego de supervivencia incluye criaturas llamadas 'Creepers'?",
        listOf("Don't Starve", "Rust", "Minecraft", "Ark: Survival Evolved"),
        2
    ),
    QuestionData(
        "¿Cuál es el nombre del personaje principal en la serie de juegos de plataformas Donkey Kong Country?",
        listOf("Donkey Kong", "Mario", "Diddy Kong", "King K. Rool"),
        0
    ),
    QuestionData(
        "¿En qué juego puedes encontrar la ciudad de 'Rapture'?",
        listOf("Half-Life", "BioShock", "Fallout", "Deus Ex"),
        1
    ),
    QuestionData(
        "¿Cuál es el nombre del protagonista de la serie de juegos de acción-aventura Uncharted?",
        listOf("Nathan Drake", "Lara Croft", "Ezio Auditore", "Geralt de Rivia"),
        0
    ),
    QuestionData(
        "¿En qué videojuego puedes encontrar a los personajes 'Big Daddy' y 'Little Sister'?",
        listOf("BioShock", "Half-Life", "System Shock", "Fallout"),
        0
    ),
    QuestionData(
        "¿Cuál es el nombre del juego de carreras de autos desarrollado por Polyphony Digital?",
        listOf("Need for Speed", "Gran Turismo", "Forza Horizon", "Burnout"),
        1
    ),
    QuestionData(
        "¿En qué juego puedes encontrar a los personajes 'Master Chief' y 'Cortana'?",
        listOf("Destiny", "Halo", "Gears of War", "Mass Effect"),
        1
    ),
    QuestionData(
        "¿Qué juego de estrategia en tiempo real fue desarrollado por Blizzard Entertainment en 1998?",
        listOf("StarCraft", "Warcraft III", "Age of Empires II", "Command & Conquer"),
        0
    ),
    QuestionData(
        "¿Cuál es el nombre del protagonista de la serie de juegos de rol The Elder Scrolls?",
        listOf("Dovahkiin", "Geralt", "Link", "Master Chief"),
        0
    ),
    QuestionData(
        "¿En qué juego puedes encontrar el personaje 'Solid Snake'?",
        listOf("Splinter Cell", "Metal Gear Solid", "Deus Ex", "Hitman"),
        1
    ),
    QuestionData(
        "¿Qué juego de simulación social permite a los jugadores controlar la vida de personas virtuales?",
        listOf("Second Life", "The Sims", "Animal Crossing", "Stardew Valley"),
        1
    ),
    QuestionData(
        "¿Cuál es el nombre del protagonista de la serie de juegos de acción-aventura Tomb Raider?",
        listOf("Samus Aran", "Nathan Drake", "Lara Croft", "Aloy"),
        2
    ),
    QuestionData(
        "¿En qué videojuego aparece el personaje 'Kratos'?",
        listOf("God of War", "Darksiders", "Dark Souls", "Devil May Cry"),
        0
    ),
    QuestionData(
        "¿Qué empresa desarrolló el juego de disparos en primera persona Half-Life?",
        listOf("id Software", "Valve", "Gearbox", "Epic Games"),
        1
    ),
    QuestionData(
        "¿Cuál es el nombre del juego de rol en el que los jugadores deben recolectar 'materia' para mejorar sus habilidades?",
        listOf("Chrono Trigger", "Xenogears", "Dragon Quest", "Final Fantasy VII"),
        3
    )
)