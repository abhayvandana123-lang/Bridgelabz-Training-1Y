public class RouteLinkedList<T extends Checkpoint> {

    private class Node {
        T data;
        Node next;

        Node(T data) {
            this.data = data;
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

    public boolean checkConsistency() {
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
        int count = 1;

        while (temp != null) {
            T cp = temp.data;
            System.out.println(count + ". " + cp.getType() + " - " + cp.getLocationName() + " - " +
                    (cp.isDelayed() ? "Delayed" : "On Time") + " - Penalty: " + cp.calculatePenalty());
            temp = temp.next;
            count++;
        }
    }
}