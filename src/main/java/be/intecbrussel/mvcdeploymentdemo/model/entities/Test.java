package be.intecbrussel.mvcdeploymentdemo.model.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Test {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long testId;
    private String testName;
    private double scorePercentage;
    
    public Test(String testName, double scorePercentage) {
        this.testName = testName;
        this.scorePercentage = scorePercentage;
    }
    
    protected Test(){};

    public double getScorePercentage() {
        return scorePercentage;
    }

    public String getTestName() {
        return testName;
    }
}