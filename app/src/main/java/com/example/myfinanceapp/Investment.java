package com.example.myfinanceapp;

public class Investment {
    private int age;
    private long amountInvested;
    private int returnPercentage;
    private int inflationPercentage;
    private long amountAfterReturns;
    private long totalCorpus;
    private long currentDayValueOfCorpus;


    public Investment(int age, long amountInvested, int returnPercentage, int inflationPercentage, long amountAfterReturns, long totalCorpus, long currentDayValueOfCorpus) {
        this.age = age;
        this.amountInvested = amountInvested;
        this.returnPercentage = returnPercentage;
        this.inflationPercentage = inflationPercentage;
        this.amountAfterReturns = amountAfterReturns;
        this.totalCorpus = totalCorpus;
        this.currentDayValueOfCorpus = currentDayValueOfCorpus;
    }

    public Investment(int age, long amountInvested, long lastcorpus) {
        this.age = age;
        this.amountInvested = amountInvested;
        this.returnPercentage = 12; // Default return percentage
        this.inflationPercentage = 6; // Default inflation percentage
        setInflationPercentage(6);
        setReturnPercentage(12);
        calculateAmountAfterReturns(amountInvested);
        calculateTotalCorpus(lastcorpus);
        calculateCurrentDayValueOfCorpus();
    }

    public void setReturnPercentage(int returnPercentage) {
        this.returnPercentage = returnPercentage;
    }

    public void setAge(int age) {
        this.age = age;
//        calculateTotalCorpus();
//        calculateCurrentDayValueOfCorpus();
    }

    public int getAge() {
        return age;
    }

    public void setAmountInvested(long amountInvested) {
        this.amountInvested = amountInvested;
    }

    public double getAmountInvested() {
        return amountInvested;
    }

    public double getReturnPercentage() {
        return returnPercentage;
    }

    public double getInflationPercentage() {
        return inflationPercentage;
    }

    public double getAmountAfterReturns() {
        return amountAfterReturns;
    }

    public double getTotalCorpus() {
        return totalCorpus;
    }

    public double getCurrentDayValueOfCorpus() {
        return currentDayValueOfCorpus;
    }

    private void calculateAmountAfterReturns(long amountInvested) {
        amountAfterReturns = (long) (amountInvested * (1 + (getReturnPercentage() / 100)));
        setAmountAfterReturns(amountAfterReturns);
    }

    private void calculateTotalCorpus(long lastCorpus) {
//        totalCorpus = (long) (getAmountAfterReturns() + lastCorpus);
        totalCorpus = (long) ((long) (lastCorpus + getAmountInvested())*(1+(getReturnPercentage()/100)));
        setTotalCorpus(totalCorpus);
//        change the retirment value
//        int retirementAge = 60;
//        for (int i = age + 1; i <= retirementAge; i++) {
//            totalCorpus = (totalCorpus + amountInvested) * (1 + (returnPercentage / 100));
//        }
    }

    private void calculateCurrentDayValueOfCorpus() {
        int currentAge =24;
        currentDayValueOfCorpus = (long) (getTotalCorpus() / Math.pow((1 + (getInflationPercentage() / 100)), (getAge() - currentAge+ 1)));
        setCurrentDayValueOfCorpus(currentDayValueOfCorpus);
    }

    public void setTotalCorpus(long totalCorpus) {
        this.totalCorpus = totalCorpus;
    }

    public void setAmountAfterReturns(long amountAfterReturns) {
        this.amountAfterReturns = amountAfterReturns;
    }

    public void setCurrentDayValueOfCorpus(long currentDayValueOfCorpus) {
        this.currentDayValueOfCorpus = currentDayValueOfCorpus;
    }

    public void setInflationPercentage(int inflationPercentage) {
        this.inflationPercentage = inflationPercentage;
    }
}
