package model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
    
    private Integer roomNumber;
    private Date checkIn;
    private Date checkOut;

    public Reservation(Integer roomNumber, Date checkIn, Date checkOut){
        this.roomNumber = roomNumber;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    //Este dado esta como estatic porque não quero que seja instanciado um novo  formato de data que a aplicação tiver
    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public Integer getRoomNumber(){
        return roomNumber;
    }
    public void setRoomNumber(){
        this.roomNumber = roomNumber;
    }

    public Date getCheckIn(){
        return checkIn;
    }

    public Date getCheckOut(){
        return checkOut;
    }

    public long duration(){

        //aqui consigo a diferença das datas em milisegundos
        long diff = checkOut.getTime() - checkIn.getTime();
        //Converte o valor de milissegundos para dia
        return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
    }

    public String UpdateDates(Date checkIn, Date checkOut){

        Date now = new Date();
        if(checkIn.before(now) || checkOut.before(now)){
            return "Reservation dates for update must be futues dates";
        } else if(!checkOut.after(checkIn)) {
            return "Checkout date must be after check-in date";
        }

        this.checkIn = checkIn;
        this.checkOut = checkOut;
        return null;
    }

    @Override
    public String toString(){
        return "Room "
            + roomNumber
            + ", checkin: "
            + sdf.format(checkIn)
            + ", checkout: "
            + sdf.format(checkOut)
            + ", "
            + duration()
            + " nights";
    }
}
