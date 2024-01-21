package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.Reservation;

public class Program {

    public static void main(String[] args) throws ParseException{
        
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Room number: ");
        int number = sc.nextInt();

        System.out.println("Check-in date dd/MM/yyyy: ");
        Date checkIn = sdf.parse(sc.next());

        System.out.println("Check-out date dd/MM/yyyy: ");
        Date checkOut = sdf.parse(sc.next());

        //Se não checkout for maior que checkIn vai aparecer tal erro: 
        if(!checkOut.after(checkIn)){
            System.out.println("Error in reservation: Checkout date must be after check-in date");
        }else {
            //instanciando a reserva
            Reservation reservation = new Reservation(number, checkIn, checkOut);
            //dados da reserva
            System.out.println("Reservation: " + reservation);
        
            System.out.println("");
            System.out.println("Enter data to update the reservation: ");
        
            System.out.println("Check-in date dd/MM/yyyy: ");
            checkIn = sdf.parse(sc.next());
            System.out.println("Check-out date dd/MM/yyyy: ");
            checkOut = sdf.parse(sc.next());

            Date now = new Date();
            if(checkIn.before(now) || checkOut.before(now)){
                System.out.println("Error in reservation: Reservation dates for update must be futues dates");
            } else if(!checkOut.after(checkIn)) {
                System.out.println("Error in reservation: Checkout date must be after check-in date");
            }else{
                reservation.UpdateDates(checkIn, checkOut);
                System.out.println("Reservation " + reservation);
            }

            reservation.UpdateDates(checkIn, checkOut);
            System.out.println("Reservation: " + reservation);
        }

        sc.close();
    }
    
}