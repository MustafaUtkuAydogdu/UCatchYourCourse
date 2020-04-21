# CS 102 Project for 2019-2020 Spring Semester in Bilkent
## Notes to be deleted afterward
* This project was initialy started as an organization project [here](https://github.com/CS102g1J/project01). It is copied here due to Mr. David Davenport's emphasis on ***private repositories***.

## Catch Your Course
Our project’s aim is to make the students eager to go to their courses all the time. Also, we want to make the school life of every student enjoyable… Simply, our project tries to motivate the students to attend their lectures on time by making them play a fun game. This game includes catching the professors of the students’ lesson and earning points while doing so. When the student catches an amount of items, which will be determined by the app, the student is rewarded and has a chance to be on the leaderboards of the app. Furthermore, our app will have another feature. This feature includes finding the classrooms inside a labyrinthine building, for example the G building. Especially freshmen students confuse the places of the classrooms and they can be late to their lectures. Using our app, a student can find the classroom of his lecture and have the intention to attend a lecture on time to play the game and catch the professor of that lesson, knowing he will be rewarded if he catches as many items as he can.
Look project's [webpage](https://muhammedcankucukaslan.github.io/cs102g1J/) for further informations.

## Group Members
* 21802530 Mustafa Yasir Altunhan
* 21803632 Deniz Hayri Özay
* 21902298 Giray Akyol
* 21803473 Mustafa Utku Aydoğdu
* 21901865 Melis Atun
* 21901779 Muhammed Can Küçükaslan 

## Member Contributions 
_Assuming the week starting April 20th as week 12 as indicated in the moodle page of CS102 course._
### 21802530 Mustafa Yasir Altunhan

### 21803632 Deniz Hayri Özay

### 21902298 Giray Akyol

### 21803473 Mustafa Utku Aydoğdu

### 21901865 Melis Atun

### 21901779 Muhammed Can Küçükaslan 
##### Week 12
   _There will be some cool explanations for ordinary works. For instance, "I am pleased to announce that with the efficiencies we have identified, and despite the additional two assignments given by the instructor, our users WILL NOT be seeing a further exploitation of their RAMs. God bless me."._

## Project Proposal Guides
* [How to prepare a proposal](http://www.cs.bilkent.edu.tr/~bgedik/coursewiki/doku.php/cs102:projects)
* [How to lose points](http://www.cs.bilkent.edu.tr/~david/cs102/practicalwork/cs102projectorganisationandgrading.htm#AdditionalPoints).

## Resources
+ This topic will be moved another file soon (within next few decades).
### Default images
[App icon proposal](https://pixabay.com/tr/vectors/konum-toprak-harita-d%C3%BCnya-4496459/)
### Android Application development
* [Build Your First Android App in Java by Google](https://codelabs.developers.google.com/codelabs/build-your-first-android-app/#0)
* [Request Location updates](https://developer.android.com/training/location/request-updates?hl=en)

### Mapping
* [About Open Street Map](https://www.openstreetmap.org/about)
* Open Street Map [export map](https://www.openstreetmap.org/export#map=14/39.8726/32.7637)
* Open Street Map [Develop-Wiki](https://wiki.openstreetmap.org/wiki/Develop)

### Design and Style Guidelines
+ In this project we strictly follow certain rules which are gathered together by David Davenport:
   - design and implementation rules which can be found  [here](https://web.archive.org/web/20170930094137/http://www.cs.bilkent.edu.tr/~david/cs101/practicalwork/2010/JavaLabs.htm),
   - and we have rules on OOP [here](https://web.archive.org/web/20170930110056/http://www.cs.bilkent.edu.tr/~david/cs101/practicalwork/2010/JavaOOPLabs.htm),
   - and of course a strict style guide lines [here](https://web.archive.org/web/20170930110102/http://www.cs.bilkent.edu.tr/~david/cs101/practicalwork/2010/styleguidelines.htm).


+ First line of every class, **except the ones contains main method**, starts with packaging,
  + [Further reading](https://www.geeksforgeeks.org/packages-in-java/) that you may or may not find useful 
+ continues with imports after a blank line
  ```
  package superPack.pack;
  
  import superPack.pack.src.Class;
  import java.util.Xxxx;
  ```
### About javadoc comments
***Usage of javadoc comments just before defining classes, constructors and methods is mandatory.***
1. Examples of styling
   * Before Classes
   ```
   /**
    * This class (or object) have blah blah blah and can do blah blah blah
    * @author Muhammed Can Küçükaslan
    * @version 2020.02.14 added blah blah methods and fixed blah blah bugs
    *          2020.01.14 Created with blah blah methods and properties 
    */
    public class Example {
    ...
    }
   ```
   
   * Before constructors
    ```
    /**
    * This generates a ClassName object and sets default or given (by parameters) values to the properties
    * @param paramName is blah blah blah
    */
   public ClassName( Object paramName) {
   ...
   }
    ```
   * Before Methods
    ```
    /**
    *  This method does blah blah blah
    * (if an instance method) changes blah blah properties in blah blah way
    * @param paramName is blah blah blah
    * @return a logical value which is ObjectType (or a primitive value)
    */
   public ObjectType getName( Object paramName) {
   ...
   }
   ```
