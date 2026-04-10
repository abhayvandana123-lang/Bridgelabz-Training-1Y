package com.gla;

class RestCheckpoint extends Checkpoint {

    public RestCheckpoint(String id, String loc, double dist, int exp, int act) {
        super(id, loc, dist, exp, act);
    }

    public boolean isCritical() {
        return false;
    }

    public String getType() {
        return "RestCheckpoint";
    }

    public double calculatePenalty() {
        int delay = actualDuration - expectedDuration;
        if (delay > 30) {
            return delay * 0.5;
        }
        return 0;
    }
}