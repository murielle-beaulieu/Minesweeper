## Minesweeper, step by step

        // set an array for the grid
        // set an array for the mines coordinates
        // generate random coordinates for the mines?

        // request in the scanner a key value pair of coordinates
        // compare the coordinates entered to the mine coordinates

        // if it's a match, game over
        // if it's not, continue

        // tiles should display the numbers of mines around ????

        // the game should continue until a mine is selected
        //    or the player successfully avoids all the mine
        // the grid regenerates every turn

//  __  __
// |  \/  (_)
// | \  / |_ _ __   ___  _____      _____  ___ _ __   ___ _ __
// | |\/| | | '_ \ / _ \/ __\ \ /\ / / _ \/ _ \ '_ \ / _ \ '__|
// | |  | | | | | |  __/\__ \\ V  V /  __/  __/ |_) |  __/ |
// |_|  |_|_|_| |_|\___||___/ \_/\_/ \___|\___| .__/ \___|_|
//                                            | |
//                                            |_|



### **MVP**

Recreate a simplified version of the game Minesweeper to be played in the java console

- The game should be able to randomly generate 10 mines in a 10x10 grid
- The user will be able to enter a command that represents a coordinate to check a location for a mine
- The application will display a number from 0-8 depending on how many mines surround that location
- If the user selects a mine, the game will respond "boom!" and the game will be lost
- If every non-mine square has been revealed, the game is won
- Render the grid to the console after every user command
