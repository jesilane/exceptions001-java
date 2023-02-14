package application;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
		System.out.println("Room number");
		int number=sc.nextInt();
		System.out.println("Check-in date(dd/MM/yyyy): ");
		Date checKIn=sdf.parse(sc.next());
		System.out.println("check-out date(dd/MM/yyyy): ");
		Date checKOut=sdf.parse(sc.next());
		
		if(!checKOut.after(checKIn)) {
			System.out.println("Errro in reservation: ");
		}
		else {
			Reservation reservation=new Reservation(number,checKIn,checKOut);
			System.out.println("Reservation :" + reservation);
			
			System.out.println();
			System.out.println("Enter data to update the reservation");
			System.out.println("Check-in date(dd/MM/yyyy): ");
			checKIn=sdf.parse(sc.next());
			System.out.println("check-out date(dd/MM/yyyy): ");
			checKOut=sdf.parse(sc.next());
			
			Date now =new Date();
			if(checKIn.before(now)||checKOut.before(now)) {
				System.out.println(" Error in reservation: Tem que ser datas futuras.");
			}
			else if(!checKOut.after(checKIn)){
				System.out.println("Errro in reservation: a data de checKOut tem que ser depois da data de check-in");
				
			}else {
				reservation.updateDates(checKIn, checKOut);
				System.out.println("Reservation :" + reservation);
			}
			
			
		}
		
		
		
		
		sc.close();

	}

}
