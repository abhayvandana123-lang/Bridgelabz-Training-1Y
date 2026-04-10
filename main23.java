package com.gla;

public class Main23 {
    public static void main(String[] args) {

        Driver driver = new Driver("D1204", "Kavita Nair");

        driver.getRouteHistory().addCheckpoint(
                new DeliveryCheckpoint("C1", "Warehouse A", 40, 60, 70));

        driver.getRouteHistory().addCheckpoint(
                new FuelCheckpoint("C2", "Pump 12", 20, 30, 30));

        driver.getRouteHistory().addCheckpoint(
                new RestCheckpoint("C3", "Motel X", 10, 20, 35));

        driver.getRouteHistory().addCheckpoint(
                new DeliveryCheckpoint("C4", "Client Hub", 50, 50, 65));

        driver.printSummary();
    }
}

class Driver {
    private String driverId;
    private String name;
    private RouteLinkedList<Checkpoint> routeHistory;

    public Driver(String driverId, String name) {
        this.driverId = driverId;
        this.name = name;
        this.routeHistory = new RouteLinkedList<>();
    }

    public RouteLinkedList<Checkpoint> getRouteHistory() {
        return routeHistory;
    }

    public void printSummary() {
        System.out.println("Driver: " + driverId + " – " + name);
        System.out.println("Route Summary:");

        routeHistory.printRoute();

        double totalDistance = routeHistory.computeTotalDistance();
        double totalPenalty = routeHistory.computeTotalPenalty();
        double routeScore = totalDistance - totalPenalty;

        System.out.println("Total Distance: " + totalDistance + " km");
        System.out.println("Total Penalty: " + totalPenalty);
        System.out.println("Route Score: " + routeScore);

        boolean consistent = routeHistory.checkCriticalConsistency();
        System.out.println("Critical Route Check: " +
                (consistent ? "All required checkpoints present."
                        : "Missing critical checkpoints!"));
    }
}

abstract class Checkpoint {
    protected String checkpointId;
    protected String locationName;
    protected double distanceFromLast;
    protected double expectedDuration;
    protected double actualDuration;

    public Checkpoint(String checkpointId, String locationName,
                      double distanceFromLast, double expectedDuration, double actualDuration) {
        this.checkpointId = checkpointId;
        this.locationName = locationName;
        this.distanceFromLast = distanceFromLast;
        this.expectedDuration = expectedDuration;
        this.actualDuration = actualDuration;
    }

    public String getCheckpointId() {
        return checkpointId;
    }

    public double getDistanceFromLast() {
        return distanceFromLast;
    }

    public boolean isDelayed() {
        return actualDuration > expectedDuration;
    }

    public abstract boolean isCritical();
    public abstract String getType();
    public abstract double calculatePenalty();
}

class DeliveryCheckpoint extends Checkpoint {
    public DeliveryCheckpoint(String id, String loc, double dist, double exp, double act) {
        super(id, loc, dist, exp, act);
    }

    public boolean isCritical() {
        return true;
    }

    public String getType() {
        return "DeliveryCheckpoint";
    }

    public double calculatePenalty() {
        if (isDelayed()) {
            return (actualDuration - expectedDuration) * 2;
        }
        return 0;
    }
}

class FuelCheckpoint extends Checkpoint {
    public FuelCheckpoint(String id, String loc, double dist, double exp, double act) {
        super(id, loc, dist, exp, act);
    }

    public boolean isCritical() {
        return true;
    }

    public String getType() {
        return "FuelCheckpoint";
    }

    public double calculatePenalty() {
        if (isDelayed()) {
            return 10;
        }
        return 0;
    }
}

class RestCheckpoint extends Checkpoint {
    public RestCheckpoint(String id, String loc, double dist, double exp, double act) {
        super(id, loc, dist, exp, act);
    }

    public boolean isCritical() {
        return false;
    }

    public String getType() {
        return "RestCheckpoint";
    }

    public double calculatePenalty() {
        if (isDelayed() && (actualDuration - expectedDuration) > 30) {
            return (actualDuration - expectedDuration) * 0.5;
        }
        return 0;
    }
}

class RouteLinkedList<T extends Checkpoint> {

    private class Node {
        T data;
        Node next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;

    public void addCheckpoint(T checkpoint) {
        Node newNode = new Node(checkpoint);
        if (head == null) {
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    public boolean removeCheckpoint(String checkpointId) {
        if (head == null) return false;

        if (head.data.getCheckpointId().equals(checkpointId)) {
            head = head.next;
            return true;
        }

        Node temp = head;
        while (temp.next != null) {
            if (temp.next.data.getCheckpointId().equals(checkpointId)) {
                temp.next = temp.next.next;
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    public T findCheckpoint(String checkpointId) {
        Node temp = head;
        while (temp != null) {
            if (temp.data.getCheckpointId().equals(checkpointId)) {
                return temp.data;
            }
            temp = temp.next;
        }
        return null;
    }

    public double computeTotalDistance() {
        double total = 0;
        Node temp = head;
        while (temp != null) {
            total += temp.data.getDistanceFromLast();
            temp = temp.next;
        }
        return total;
    }

    public double computeTotalPenalty() {
        double total = 0;
        Node temp = head;
        while (temp != null) {
            total += temp.data.calculatePenalty();
            temp = temp.next;
        }
        return total;
    }

    public boolean checkCriticalConsistency() {
        boolean hasDelivery = false;
        boolean hasFuel = false;

        Node temp = head;
        while (temp != null) {
            if (temp.data instanceof DeliveryCheckpoint) hasDelivery = true;
            if (temp.data instanceof FuelCheckpoint) hasFuel = true;
            temp = temp.next;
        }

        return hasDelivery && hasFuel;
    }

    public void printRoute() {
        Node temp = head;
        int i = 1;

        while (temp != null) {
            Checkpoint c = temp.data;
            System.out.println(i + ". " + c.getType() + " – " + c.locationName +
                    " – " + (c.isDelayed() ? "Delayed" : "On Time") +
                    " – Penalty: " + c.calculatePenalty());
            temp = temp.next;
            i++;
        }
    }
}