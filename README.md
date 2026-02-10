# ⚔️ War Vehicle Card Battle Simulation

This project is a strategic card battle simulation developed using **Java**, based on Object-Oriented Programming (OOP) principles. In this system where the player and the computer try to destroy each other's vehicles with reciprocal moves, **Inheritance**, **Polymorphism**, and **Abstraction** structures are effectively utilized.

## 📖 About the Project

The game simulates the combat of military vehicles divided into 3 main classes: Land, Air, and Sea. Starting with basic vehicles (Aircraft, Howitzer, Frigate), the game deepens as advanced vehicles (UCAV, USV, KFS) are unlocked when the parties exceed a certain score (20 Points).

Simulation results are both displayed on the console screen and logged to the `sim.txt` file.

### 🚀 Key Features

* **Advanced OOP Architecture:** Subclasses derived from the `SavasAraclari` (WarVehicles) abstract class and concrete vehicles derived from them.
* **Dynamic Advantage System:** Similar to the Rock-Paper-Scissors logic; Land vehicles have a strike advantage against Sea, Air vehicles against Land, and Sea vehicles against Air.
* **Level System:** New and stronger vehicles (UCAV, KFS, USV) are added to the card pool based on the players' scores.
* **Durability Mechanism:** The durability of cards that take damage decreases; a card reaching 0 is eliminated and earns points for the opponent.
* **Logging:** Recording the entire game flow (moves, damages, scores) to the `sim.txt` file.

## 🛠️ Class Hierarchy and Architecture

The project has a layered class structure:

1.  **Abstract Base:** `SavasAraclari` (Common properties of all vehicles: Strike, Durability, Level Score).
2.  **Abstract Categories:**
    * `HavaAraclari` (AirVehicles) (Adds Land strike advantage property)
    * `KaraAraclari` (LandVehicles) (Adds Sea strike advantage property)
    * `DenizAraclari` (SeaVehicles) (Adds Air strike advantage property)
3.  **Concrete Classes:**
    * ✈️ **Air:** `Ucak` (Aircraft), `Siha` (UCAV)
    * 🚜 **Land:** `Obus` (Howitzer), `KFS` (Land Missile System)
    * 🚢 **Sea:** `Firkateyn` (Frigate), `Sida` (Armed Unmanned Surface Vehicle)

## 🎮 Game Rules

1.  **Start:** 6 random cards are dealt to both parties (Player and Computer).
2.  **Selection:** The player selects 3 cards from their hand, the computer selects randomly.
3.  **Battle:** Selected cards are compared in order.
    * *Example:* If an `Ucak` (Air) attacks an `Obus` (Land), "Land Strike Advantage" points are added to the base strike power, increasing the damage.
4.  **Elimination:** A card with depleted durability is removed from the game. The opponent earns score equal to the eliminated card's level score.
5.  **End:** The side running out of cards loses, or scores are compared at the end of the determined number of turns.

## ⚙️ Installation and Execution

To run the project on your local machine:

### 1. Compilation
Open Terminal or Command Prompt and navigate to the project directory:
*(Note: The path may vary depending on whether the files are inside the `src` folder or the root directory)*

```bash
javac *.java
```
### 2. Execution
Run the main class Oyun:

```bash
java Oyun
```

## 📂 File Structure (Recommended)

```bash
.
├── src/
│   ├── SavasAraclari.java   # Abstract Base Class
│   ├── KaraAraclari.java    # Abstract Class
│   ├── HavaAraclari.java    # Abstract Class
│   ├── DenizAraclari.java   # Abstract Class
│   ├── Ucak.java            # Concrete Class
│   ├── Siha.java            # Concrete Class
│   ├── Obus.java            # Concrete Class
│   ├── KFS.java             # Concrete Class
│   ├── Firkateyn.java       # Concrete Class
│   ├── Sida.java            # Concrete Class
│   ├── Oyuncu.java          # Player Operations
│   └── Oyun.java            # Main Method and Game Loop
├── sim.txt                  # Game Log File (Automatically created)
└── README.md
```
