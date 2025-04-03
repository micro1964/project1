package com.reggy.bdd.runners;


import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/java/com/reggy/bdd/featureFiles", glue="com.reggy.bdd.stepdefinitions", tags="@RegressionTest")
public class TestRunner {

}