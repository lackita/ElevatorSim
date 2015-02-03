/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elevatorsim;

/* This is the rider/person for the elevator sim. They will effectively populate 
 * the simulator with riders
 *
 * @author Chris Berns
 */
public class Rider {

    private int startFloor;
    private int destFloor;
    private final int id;
    private static int idGen = 0;
    private static int ridersInQueue;

    public Rider() {

        this.id = ++idGen;

    }

    public void setStartFlr(int a) {
        this.startFloor = a;
    }

    public int getStartFlr() {
        return this.startFloor;
    }

    public void setDestFlr(int a) {
        this.destFloor = a;
    }

    public int getDestFloor() {
        return this.destFloor;
    }

    //I wanted to add ability to track total waiting in que
    public void callElevator() {
        ridersInQueue++;
    }

    public void arrive() {
        ridersInQueue--;
    }

    public boolean isGoingUp() {
        boolean retVal = true;
        if (this.destFloor < this.startFloor) {
            retVal = false;
        } else if (this.startFloor == this.destFloor) {
            //to-do same floor handler
        }

        return retVal;
    }

    public static int getRiderInQue() {
        return ridersInQueue;
    }

    public static void main(String[] args) {
        // TODO code application logic here

        Rider a1 = new Rider();
        Rider a2 = new Rider();
        a1.callElevator();
        a2.callElevator();
        if (Rider.getRiderInQue() != 2) {
            System.out.print("Riders added to Que - FAIL\n");
        }
        a1.setStartFlr(0);
        a1.setDestFlr(2);
        if (!a1.isGoingUp()) {
            System.out.print("isGoingUp(true) - FAIL");
        }
        a1.setStartFlr(2);
        a1.setDestFlr(1);
        if (a1.isGoingUp()) {
            System.out.print("isGoingUp(false) - FAIL");
        }
        a1.arrive();
        a2.arrive();
        if (Rider.getRiderInQue() != 0) {
            System.out.print("Riders remove from Que - FAIL\n");
        }
        

    }
}
