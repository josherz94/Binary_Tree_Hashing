# Binary Tree Hashing
This program builds an index, or cross-reference listing, for text-based documents. 
It displays the number of times each word appears in the document, the line 
numbers in which each word appears and the position of each word in the line.

This program also allows the user to query the document for specific words and 
will display the number of times the word appears in the document, 
the line numbers in which the word appears, and the position of the word in the line.

A full javadoc is available for this program.

## Table of contents
* [General info](#general-info)
* [Screenshots](#screenshots)
* [Technologies](#technologies)
* [Features](#features)
* [Status](#status)
* [Inspiration](#inspiration)
* [Contact](#contact)

## General info

This program demonstrates the concept of indices since the index is the most fundamental idea behind any search engine.
In this specific program, The text document being read in is the Gettysburg Address. The document is parsed and each word
is stored in a node that is then put into a binary tree. A hash table is also created to store a list of ommited words. 
The user queries specific words that can be found in the document and these are cross referenced against the hash table.
This program uses a custom hash function I created using linear probing as collision resolution. 
This limits the hash function collisions to 6, and resolution collisions to 1. The total load factor is ~73%.
This project specifically does not use a known hash function, or perfect hash function purposefully to 
demonstrate collision resolution.

## Screenshots
TODO: add screenshots
![Example screenshot](./img/screenshot.png)

## Technologies
* Java 
* BlueJ

## Features
* Cross references word documents to specific words that are omitted
* Utilizes Binary trees and a hash table

## Status
Project is: _finished_

## Inspiration
This program is meant to demonstrate how search engines are matching and 
ranking queries based on keywords, but on text-based documents.

## Contact
Created by [@josherz94] - feel free to contact me!
