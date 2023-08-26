/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package onlinereservationsystem;

/**
 *
 * @author kali-i
 */
public class OnlineReservationSystem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
     
       DatabaseClass.CreateDatabase();
       DatabaseClass.createReservationTable();

       Login a =new Login();
       a.show();
     
    }
    
}
