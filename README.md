

# Minesweeper 

This project consists of a classic Minesweeper game, despite the original being played using the mouse, this new version requires you to play with the keyboard. Each cell has a value with the number of adjacent bombs, but if a bomb is revealed you lose.

## Features 
**Move** - To move the cursor the player can use the arrow keys. When moving out of bound the cursor goes to the beginning of the line or column that ended.

**Flag** - The cursor cell can be marked with a flag when the space bar key is pressed.

**Reveal** - The cursor cell can be revealed when the enter key is pressed. All cells that can be reached without passing by cells with adjacent bombs are also revealed.

**Undo** - The last command can be reversed (not including movements) using the 'z' key. When a move is reversed the cursor goes back to the position that it was when the command was executed.

**Quit** - The key 'q' can be used at any time to close the game.

**Clock** - There's a clock at the top of the screen that counts how much time has passed since the beginning of the game.

### Images
![](https://i.imgur.com/C3BfR4r.gifv)
A cell marked with a flag.

![](https://i.imgur.com/rGWsHoo.png)  
The cursor cell was revealed and a lot of other cells are revealed together.

![](https://i.imgur.com/NtOUsaM.png)  
The clock indicates that 57 seconds had passed.


## Features 
**Instructions** - A page that show instructions and maybe a tutorial.

**Preferences** - The user can change its preferences of board size and difficulty.

**Menus** - An inital menu and a final menu where the user can change its preferences, see instructions, start a game and load game. When the game ends the player can undo the last move, start a new game, return to main menu or quit the game.

**Rankings** - When a user finishes a game the ranking will be updated with their time with that specific dimension of board and difficulty.

### Images
![](https://i.imgur.com/h4gr9DB.png)  

![](https://i.imgur.com/ASxpy6o.png)  

![](https://i.imgur.com/MiAkLnQ.png)  

![](https://i.imgur.com/BYSC4HA.png)  

## Application demo
![](/docs/app-demo.gif)  

## Credits
This project was developed by 
[__Alexandre Abreu__ ](https://github.com/a3brx) and [__Juliane Marubayashi__ ](https://github.com/jumaruba) for the _Object Oriented Programming Laboratory_ class of MIEIC. 

University of Porto, 2020
