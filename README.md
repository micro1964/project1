Project 1
https://www.selenium.dev/selenium/web/web-form.html
A subset of the elements on the page were exercised to demonstrate approach taken to develop a test framework that is flexible and can easily be reused.

Two approached were adopted: -
•	Vanilla Selenium + TestNg Tests were created using Page Object Model & Page Factory patterns
•	Selenium Cucumber used in business-driven development(BDD) fashion

The BDD artefacts can be identified in the following packages: -

com.reggy.bdd.featureFiles
com.reggy.bdd.stepdefinitions
com.reggy.bdd.runners

The vanilla selenium approach mainly found in the remaining packages. 
There was a fair amount of reusage by both approaches in some of the artefacts like
com.reggy.pages and com.reggy.utils

The main objective was to allow for a fair amount of flexibility that can be afforded with the application of object-orientation techniques. 

This proof of concept is delivered as a minimum viable product that can be built upon.

The framework is written to be executed on various browsers, of which the choice can be made via the config.properties file that exists in the resources folder.

The reporting exists in the reports folder and there are at least two types of reports available there in addition to the basic junit & testNg reports.

To Dos: - 
•	Tests to exercise the remaining elements on the page
•	Negative tests to exercise the boundaries of the input fields with input like symbols, large number of characters and minimum entry parameters

Please watch the video the demonstrates a brief walk through of the provided artefacts. And shows how to execute the tests.

https://drive.google.com/file/d/1-ktj4HrLLbv2qmPMmQ9giU3N1gw42ymr/view?usp=sharing

Thanks – https://www.reggywilliams.com
