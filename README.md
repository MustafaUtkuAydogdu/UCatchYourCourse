# CS 102 Project for 2019-2020 Spring Semester in Bilkent
## Notes to be deleted afterward
* This project was initialy started as an organization project [here](https://github.com/CS102g1J/project01). It is copied here due to Mr. David Davenport's emphasis on ***private repositories***.
* Each project group member should write their ***own name and Bilkent ID*** under the "Group Members" title in the README.md file, and send this change ***as a commit using their OWN account***.

## Group Members
* [ID number and Write Your Name]
* [ID number and Write Your Name]
* [ID number and Write Your Name]
* 21803473 Mustafa Utku Aydoğdu
* 21901865 Melis Atun
* 21901779 Muhammed Can Küçükaslan 

## Catch Your Course
Look [here](https://cs102g1j.github.io/project01/)

## Project Proposal Guides
* [How to prepare a proposal](http://www.cs.bilkent.edu.tr/~bgedik/coursewiki/doku.php/cs102:projects)
* [How to lose points](http://www.cs.bilkent.edu.tr/~david/cs102/practicalwork/cs102projectorganisationandgrading.htm#AdditionalPoints).

## Resources
+ This topic will be moved another file soon (within next few decades).
### Default images
[App icon](https://pixabay.com/tr/vectors/konum-toprak-harita-d%C3%BCnya-4496459/)
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
