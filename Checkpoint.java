package com.gla;

abstract class Checkpoint {
    String checkpointId;
    String locationName;
    double distanceFromLast;
    int expectedDuration;
    int actualDuration;

    public Checkpoint(String id, String loc, double dist, int exp, int act) {
        this.checkpointId = id;
        this.locationName = loc;
        this.distanceFromLast = dist;
        this.expectedDuration = exp;
        this.actualDuration = act;
    }

    public boolean isDelayed() {
        return actualDuration > expectedDuration;
    }

    public abstract boolean isCritical();
    public abstract String getType();
    public abstract double calculatePenalty();
}