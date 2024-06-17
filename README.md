# Minesweeper

## Brief description
Minesweeper is a single-player puzzle game where you try to clear a grid filled with hidden mines. Here's how it works:
1. Grid: You play on a grid, which can be different sizes, like 9x9 or 16x16.
2. Mines: Some squares have hidden mines, which are dangerous to click on.
3. Revealing Squares: Clicking on a square shows if it's safe or if there's a mine. If there's a mine, you lose.
4. Numbers: Safe squares will show a number that tells you how many of the adjacent squares have mines.
5. Flags: You can use flags to mark squares you think have mines, helping you avoid them.
6. Winning: The goal is to clear all the safe squares without clicking on a mine.

## Prerequisites
Before you begin, ensure you have met the following requirements:

- You have installed [Java JDK](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html) (version 8 or later recommended).
- You have a text editor or an IDE (like IntelliJ IDEA, Eclipse, or NetBeans) installed for writing and compiling your Java code.

## Cloning the Repository

1. Clone this repository to your local machine using Git. Open a terminal and run:
  git clone https://github.com/HaDo2003/Minesweeper.git
2. Navigate into the project directory:
   cd Minesweeper
## Compiling the Code

1. Open a terminal in the `Minesweeper` directory.

2. Compile the Java source code. Run the following command:
   javac -d bin src/*.java
This command compiles all Java files in the `src` directory and places the compiled bytecode in the `bin` directory.

## Running the Application

1. After compiling, run the Minesweeper application using the following command:
   java -cp bin Minesweeper
- `-cp bin` specifies the classpath where the compiled classes are located.
- `MineApp` is the main class to start the game.

2. If there are additional libraries or dependencies, include them in the classpath:
   java -cp "bin
  /*" Minesweeper
Adjust the path to your libraries as needed.

## Troubleshooting

- Verify that Java is installed correctly by running `java -version` and `javac -version` in your terminal.
- Ensure that the classpath is set correctly to avoid `ClassNotFoundException`.
- For further help, consult the Java documentation or seek assistance from online programming communities.

## Contributing

1. Fork the repository.
2. Create a new branch (git checkout -b feature-branch).
3. Make your changes.
4. Commit your changes (git commit -am 'Add new feature').
5. Push to the branch (git push origin feature-branch).
6. Open a pull request to propose your changes.

## License

Specify the license under which your project is distributed.
