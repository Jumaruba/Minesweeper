

# LPOO_110 - Minesweeper 

This project consists of a classic Minesweeper game, despite the original being played using the mouse, this new version requires you to play with the keyboard. Each cell has a value with the number of adjacent bombs, but if a bomb is revealed you lose.

This project was developed by __Alexandre Abreu__ (up201800168@fe.up.pt) and __Juliane Marubayashi__ (up201800175@g.uporto.pt) _for LPOO 2019/20_. 

## Implemented features 
**Move** - To move the cursor the player can use the arrow keys. When moving out of bound the cursor goes to the beginning of the line or column that ended.

**Flag** - The cursor cell can be marked with a flag when the space bar key is pressed.

**Reveal** - The cursor cell can be revealed when the enter key is pressed. All cells that can be reached without passing by cells with adjacent bombs are also revealed.

**Undo** - The last command can be reversed (not including movements) using the 'z' key. When a move is reversed the cursor goes back to the position that it was when the command was executed.

**Quit** - The key 'q' can be used at any time to close the game.

**Clock** - There's a clock at the top of the screen that counts how much time has passed since the beginning of the game.

### Images
![](https://i.imgur.com/3aNDZfS.png)  
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



## Design
### The movements should be reversible
#### Problem in context
Without the pattern we would have to do a switch statement that undoes the last command, but at each command added the switch should be updated and that breaks the __Open/Closed Principle__. Other solution would be to save the status of the game at each command, but that would require a lot of memory space that could be reduced.
#### The Pattern 
We have applied the __Command__ pattern. This pattern allows you to save the commands in a data structure. This helped us, because we could stack the commands and undo them very easily, as each command saves the state of the cursor when executed and knows how to reverse itself.
#### Implementation
The Command class is implemented [here](/src/main/java/lpoo/control/command/Command.java)

![](https://i.imgur.com/Bzu9wg5.png)
#### Consequences 
The __Command__ pattern allows the following consequences:
- It's easier to add new commands
- The commands can be stored in a data structure
- The controller doesn't need to know how to execute the command

## Generating the table
#### Problem in context
Thinking about the code logistic the factory pattern was used. Imagining the project without the factory pattern, most of the table code would be coupled at the table class and in this situation we would start with a smell (large class).  
In addition to that, following the __Single Principle Resposability__, generating the table at the __Table__ would go against this principle, since the this class would have two reasons to be changed.  
More over, case we wanted to generate two different tables (for different levels, for example) we would have to change the __Table__ class, which would go against another principle: the __Open/Closed Principle__. 
#### The Pattern 
We have applied the __Factory pattern__. This simple pattern helped us to create a consitent code in the context of code clarity, future prevention and the maintenance of the SOLID principles, which improves the code comprehension and allows easy development and maintenance. 
#### Implementation
The Factory Generator class is implemented [here](/src/main/java/lpoo/model/game/TableGenerator.java)

![](https://i.imgur.com/yplw12X.png)
#### Consequences 
Using this pattern has generated the following consequences: 
- The code has become easier to understant upon the use of the pattern, so we can write less comments 
- The SOLID principles are obeyed. 
- It has become easier to make changes now and in the future. 

## Create views  // factory view 
#### Problem in context 
Some classes in view package needed to create an instance of a object with the same parameters. For example, suppose that we have the following class: 
```
classExample(parameter1, parameter2); 
```
And we want to mention the same class in other classes with the same parameters.  
Writing the same piece of code in multiple classes would __let the code be ugly__ and __available to future errors of key typing__. So, we needed a solution to solve these two problems.  
Althought these are not compromising problems, making changes on the code and on the arguments of the objects mentioned before, would imply in a smell called __shotgun surgeon__, where in order to change the parameters parsed to the `classExample` it's necessary to do small changes in many places. 
#### The Pattern
The factory pattern is a solution for those problems. With a single instance of the factory class, it become possible to create the objects we desire with predifined parameters without needing to type it repeatdly. Also, if we didn't want to change the code (obeying the __open-closed solid principle__) we could just create another method for the class applying this design without needing to change the code.  

#### Implementation 
The Factory class is implemented [here](/src/main/java/lpoo/view/FactoryView.java)

![](https://i.imgur.com/9IvNSsT.png)   


#### Consequences 
In this scenerio, the problems explained in the __problem context__ were solved. And on this way, even testing the program becomses easier, since there is no need to parse many arguments to the class. 

## MVC
#### Problem in context 
Separate the data, interface and control of the game to have a more __code reusability__ and to make the code more organized and __easy to implement__.
Without this pattern, the __Single Principle Resposability__ could be broken, as a part of any of the MVC parts coulb be implemented on another.

#### The Pattern 
The MVC pattern is a way to separate all the code in three elements, Model, View and Control. The Model does not have dependences, the View depends on the Model, and the Controller depends on both the Viewer and Model.

#### Implementation 
The main source directory of the project has three directories that represent one of the MVC elements, they are:
[Model](/src/main/java/lpoo/model/)
[View](/src/main/java/lpoo/view/)
[Controller](/src/main/java/lpoo/control/)
![](https://i.imgur.com/7k56rmg.png)

#### Consequences 
Front-end and back-end can be done simultaneously, and relacted actions are grouped making the code more organized.
The program is easy to modify and to test because the three elements are isolated from each other.



## Known code smells and refactoring suggestions 
Some of the smells will not be changed, since we didn't find a good solution to it. The classes that contains these smells are marked with bold letters.  

### Object Orientation abusers 
#### Switch statments 
- To get the type of the command and state, we have used a great switch statment.  
Some other methods like __CellView__ uses switch statments at the _draw method_.  
During the developing of the code we have developed a solution to this smell, however this solution had another smell: __shotgun surgeon__ and it was really difficulty to modify. Between switch statments and a difficult code to change, we decided to mantain our work with the switchs. 

#### Refused bequest 
- The __Bomb__ class extends the __Cell__ abstract class and since does not use the method increase value, since its value will always be -1.  
- The __BackField__ class extends the __Fields__ abstract class and does not use the methods to increment and decrement its value since it does not have one.


### Dispensables 
#### Comments 
- Along the code some comments to justify why things are done like that. Besides being a smell, it's necessary.  
__Viewer__, for example, is one of the classes that contains this smell.  

#### Lazy class 
In order to have an organized code, this smell is very present in our code.  
- __GameCommand__ 
- __GameOver__ 
- __GameUndo__ 
- __BackField__ 
- __InstModel__

#### Data class
- __Cursor__: This class just contains set and get methods for the cursor row and col.  
- __Position__: This class contains the position of the cell 
- __RankingItem__: It's used to store the name and score of a player 
- __Cofiguration__: Stores the actual configuration of the game 

## Testing 
### Coverage
![](https://i.imgur.com/6aZ41UC.png)

### Tests for Control 
![](https://i.imgur.com/okXytVZ.png)  
 
![](https://i.imgur.com/yoNaymG.png)  

![](https://i.imgur.com/qJCuRbR.png)  

### Tests for Model 

![](https://i.imgur.com/7UZhtxu.png)  

![](https://i.imgur.om/MXkraFH.png)  

![](https://i.imgur.com/TSgDXDs.png)  

![](https://i.imgur.com/gHhJoVi.png)  

![](https://i.imgur.com/bxQg1Ia.png)  

![](https://i.imgur.com/FfhMEit.png)  

![](https://i.imgur.com/Veti1lH.png)  


### Tests for View 
![](https://i.imgur.com/b6DGSN1.png)  

![](https://i.imgur.com/KWrSgJO.png)  

![](https://i.imgur.com/eAYv30n.png)  

![](https://i.imgur.com/z74yvOw.png)  

### Mutation test
Check the [link](https://github.com/FEUP-LPOO/lpoo-2020-g10/tree/master/Tests/pit) of the mutation test!  

__Some conclusions:__ 
- Large classes like the Viewer and GameModel might have some changes in the tests for the second part since the results weren't satisfactory. 
- The model tests did great in general. 

## Application demo
![](/docs/app-demo.gif)  

## Self-evaluation 

Both of the components had a great participation of the biggest part of the classes created.
Some parts were initiated by one of us, but at the end both of us had an influence on the most part of the classes.

### Alexandre Abreu - 55% 

### Juliane Marubayashi - 55% 
