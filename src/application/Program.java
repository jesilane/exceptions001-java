package application;



import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
		try{
			System.out.print("Room number:");
			int number=sc.nextInt();
			System.out.print("Check-in date(dd/MM/yyyy): ");
			Date checKin=sdf.parse(sc.next());
			System.out.print("check-out date(dd/MM/yyyy): ");
			Date checKOut=sdf.parse(sc.next());
			
			
			
			Reservation reservation=new Reservation(number,checKin,checKOut);
			System.out.println("Reservation :" + reservation);
			
			System.out.println();
			System.out.println("Enter data to update the reservation");
			System.out.println("Check-in date(dd/MM/yyyy): ");
			checKin=sdf.parse(sc.next());
			System.out.println("check-out date(dd/MM/yyyy): ");
			checKOut=sdf.parse(sc.next());
				
			reservation.updateDates(checKin, checKOut);
			
			System.out.println("Reservation :" + reservation);
			
		}
			
		
		catch(ParseException e) {
			System.out.println("Invalide date formate");
		}
		catch(DomainException e) {
			System.out.println("Erro in reservation: "+ e.getMessage());
		}
		
		catch(RuntimeException e) {
			System.out.println("Unexpected error");
		}
		
		sc.close();

	}

}
