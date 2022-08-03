# Gilded Rose Inventory System

## Description
Welcome to the Gilded Rose Inventory System, this system currently keeps track of our various items sell by date and quality.

## Prerequisites
- Java version 18.0.1.1
  - To check your local Java version enter `java --version` in the command line.
    - **If not installed** Follow the instruction details in this link -> [Java](https://java.com/en/download/)
- Gradle version 7.4.2
  - To check if you have gradle running locally enter `gradle -v` in the command line
    - **If not installed** Follow the instruction details in this link -> [Gradle](https://gradle.org/install/)
- Regarding installation: we used [Homebrew](https://docs.brew.sh/Installation)
  - You can also install gradle and java locally using homebrew once installed by running
  - `brew install java` `brew install gradle`
## To install the app locally
1. `git clone git@github.com:jramnani/GildedRoseJavaLLC.git`
2. `cd GildedRoseJavaLLC`
3. `git submodule init`
4. `git submodule update`

## To run the app
1. `gradle run`
2. To exit the running app enter `ctrl-c` on your command line

## To run tests locally
1. `gradle test`
