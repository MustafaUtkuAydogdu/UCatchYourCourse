# How to use Git, Github and Android Studio in this project
This, work on progress, file contains simple instructions for collaborators to examine and edit project files.
We assume that you are using GitHub Desktop app for version controlling, and Android Studio as an IDE. 
Moreover you're not allowed to falsify our assumption, if our assumption doesn't seem correct render it correct without changing it!

## Downloading current files 
### First time ever
+ Open GitHub Desktop app. (Sign in if you haven't!)
+ Click File/Clone Repository (or press Ctrl + Shift + O (letter) altogether), a pop-up will pop up.
+ Choose this repository from the github tab of
+ Write a proper (path) location for downloading, desktop is not a proper location btw. 
If you want you can always add a shortcut to desktop. 
+ Then (obviously) click to ***Clone*** .
### Other times
+ Open GitHub Desktop app.
+ Click ***Fetch Origin*** and/or ***pull***.

## Open Repository
+ Open android studio ( If there is some opened projects, close them. You don't have to, but it is better practice.)
+ Click ***Open an existing Android Studio project***
+ Choose the "proper (path) location" where you downloaded the repository.  
Important warning: Do not choose ***cs102g1J*** file, You should choose ***CatchYourCourse*** file because this file is assigned for the android project and if you choose cs102g1J it will (supposingly) give error related to gradle sync.

## Edit and Upload files
+ You better to know the way to edit in Android Studio. If you don't, learn it.
+ Each time you make some appropriate progress, press Git: commit button (green tick) on the right top of window
( You can also choose through VCS/commit or Ctrl + K in windows)  
Note: if you updated your project either through "pull"ing from github or another IDE first update the project.   
To update press Git: update button (blue arrow) on the right top of window
( You can also choose through VCS/update or Ctrl + T in windows)
+ and of course Open Github Desktop, choose repository. There will be list of the changes made.  
Write appropriate commit comments and press commit, then push it.  
Thus your changes will be synchronized with the repository in the github servers :) 

## Questions & Answers
+ I would like to try new things to better understand the android/files ecosystem without messing up all project, since it is totaly different from drjava projects. Are there any way to make this changes without the risk of messing up the project?
> Impressed, you have just rediscovered the _branch_ system ( forking may also work in this case). You can create new branche(s) and sustain your work on this branch till you  completed or made some resonable progress then connect (merge ?) it to the master branch. Further explanation will be given soon.
