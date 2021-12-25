#
#  PythonMain.py
#
#  Created by Brandon Petersen on 8/10/21.
#

#Importing neccessary modules
import re
import string
import os.path
from os import path

#Creating a function that will open, read, and cound all the terms in the txt file
def CountAll():
#Opens the file in read mode
    text = open("CS210_Project_Three_Input_File.txt", "r")

    dictionary = dict()

#Loop that will read each line of the txt file
    for line in text:
#Removes any unneccessary characters
        line = line.strip()

#Makes every word lowercase for easier reading and managing
        word = line.lower()

#Checks to see if the word has been counted
        if word in dictionary:
            dictionary[word] = dictionary[word] + 1
        else:
            dictionary[word] = 1

#Prints all contents in dictionary
    for key in list (dictionary.keys()):
        print(key.capitalize(), ":", dictionary[key])

#Closes the txt file
    text.close()

#Any user input is made lowercase for easier reading and managing
    searchWord = searchWord.lower()

#Opens txt file in read mode
    text = open("CS210_Project_Three_Input_File.txt", "r")

#wordCound to keep track of how many times the searchWord has been conuted
    wordCount = 0

#Loop that will read each line of the txt file
    for line in text:
#Removes any unneccessary characters
        line = line.strip()

#Makes all words in txt file lowercase for better reading and managing
        word = line.lower()

#If the searchWord matches a word in txt file it adds to wordCount
        if word == searchWord:
            wordCount + wordCount + 1

#Returns the count for searchWord
    return wordCount

#Closes teh txt file
    text.close()

#Creates function that will write data to frequency.dat
def CollectData():
#Opens txt file in read mode
    text = open("CS210_Project_Three_Input_File.txt", "r")

#Opens .dat file in write mode
    frequency = open("frequency.dat", "w")

    dictionary = dict()

#Loop that will read each line in the txt file
    for line in text:

#Removes any unneccessary characters
        line = line.strip()

#Makes all words lowercase for easier reading and managing
        word = line.lower()

#Adds word to the dictionary or if already in dictionary adds +1 to frequency
        if word in dictionary:
            dictionary[word] = dictionary[word] + 1
        else:
            dictionary[word] = 1

#Writes word and frequency in frequency.dat file
    for key in list(dictionary.keys()):
        frequency.write(str(key.capitalize()) + " " + str(dictionary[key]) + "\n")

#Closes the txt and .dat file
    text.close()
    frequency.close()
