# PracticeProject: Test script for Shoper-based e-commerce
I wrote this simple automated test script for the purpose of verifying youtube videos availability in
products descriptions on NeoRobots eShop - based on Shoper SaaS.

NeoRobots eShop URL:
> neorobot.pl

### My motivation
shoperTestYT project is the result of a combination of three things: 
1. My need to consolidate the knowledge I gained from the Sii training 
"Become a Selenium automation tester",  for which I am grateful because it has given me a new perspective,
2. My need to build something of my own on a real-life and working web app, using the knowledge I gained,
3. The practical need for a tool that quickly checks the availability of videos of all products posted on the eShop
at my previous workplace.

## Technologies used for the build
This project was build using:
* Java version 17 
* Maven version 3.8.5 with Surefire plugin version 3.0.0-M7
* Selenium version 4.3.0
* TestNG version 7.6.1
* WebDriverManager version 5.2.2
* and Apache Commons Lang version 3.12.0


## Quick notice about soft assertions and reports:
Project's main test class CycleThroughProductsTest uses soft assertions - Test will not fail after first found 
unavailable YouTube video. 

This test will cycle through all Products Description Pages seen in each
Product Category Page from the Menu of NeoRobots eShop in search of iFrames with YT videos.
Test will fail if any of the videos found won't have clickable play button (as when video is unavailable or private).
After test failure, you will see error logs in Run terminal with numbers of the unplayable videos and URLs
to product description pages where the videos were found and didn't pass the soft assertion. 
It will look like in this example below:
```
[INFO] Results:
[INFO]
[ERROR] Failures:
[ERROR]   CycleThroughProductsTest.checkIfAllVideosAreDisplayedAndClickable:43 The following asserts failed:
Video number 1 not playable in product page url: https://neorobot.pl/pl/iRobot-Root-robot-do-nauki-programowania.html expected [true] but found [false]

```
You can also check surefire generated reports for the same error logs.

## How to run this project

### Prerequisites:
* Make sure you got Chrome, JDK 17 and Maven 3.8.5+ properly installed on your local machine
* Make sure you got java IDE that support Apache Maven (I used IntelliJ IDEA)
* Clone/download this repository

### Run:

1. Open project in chosen IDE
2. Using Maven lifecycle phases simply run `Test` phase or type:
`mvn clean test` in IDE's terminal (opened in projects repo) f.e.:
```
 D:\Repositories\shoperTestYT> mvn clean test
 ```
Test will run and you shall see chrome being automated to cycle through all products available on NeoRobots eShop site.