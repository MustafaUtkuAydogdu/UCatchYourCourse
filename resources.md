# Resources
## Project Proposal Guides
* [How to prepare a proposal](http://www.cs.bilkent.edu.tr/~bgedik/coursewiki/doku.php/cs102:projects)
* [How to lose points](http://www.cs.bilkent.edu.tr/~david/cs102/practicalwork/cs102projectorganisationandgrading.htm#AdditionalPoints).

## Application Specific Resources
### Images, Icons, Vectors and so on
[App icon proposal](https://pixabay.com/tr/vectors/konum-toprak-harita-d%C3%BCnya-4496459/)
[Create drawables from a large scale image automatically](https://medium.com/code-yoga/create-drawables-from-a-large-scale-image-automatically-2128dde61ad9)

### Android Application development
* [Android Studio User Guide](https://developer.android.com/studio/intro)
* [A great Udacity Course](https://www.udacity.com/course/new-android-fundamentals--ud851)
* [Build Your First Android App in Java by Google (codelabs)](https://codelabs.developers.google.com/codelabs/build-your-first-android-app/#0)
* [Request Location updates](https://developer.android.com/training/location/request-updates?hl=en)

### Mapping
* [About Open Street Map](https://www.openstreetmap.org/about)
* Open Street Map [export map](https://www.openstreetmap.org/export#map=14/39.8726/32.7637)
* Open Street Map [Develop-Wiki](https://wiki.openstreetmap.org/wiki/Develop)

## Design and Style Guidelines
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
  
### Order of parts of the classes
1. If you have inner classes ad/or interfaces you MUST place them to END OF THE CLASS!
Not the beginning, not the middle of the class's, NOT BETWEEN METHODS OR CONSTRUCTORS.
Do not mess with the code, humans will read your code not ROBOTs! Also do not mix the static and instance methods.

```
class TheClass
{
   // static constants/variables
   // properties/ instance variables
   
   //Constructors
   
   // Instance methods
   
   // Static methods
   
   // inner Interfaces
   
   // inner Classes
   
} //end of the TheClass
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
    public class Example
    {
       ...
    }
   ```
   
   * Before constructors
    ```
    /**
    * This generates a ClassName object and sets default or given (by parameters) values to the properties
    * @param paramName is blah blah blah
    */
   public ClassName( Object paramName) 
   {
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
   public ObjectType getName( Object paramName)
   {
      ...
   }
   ```
