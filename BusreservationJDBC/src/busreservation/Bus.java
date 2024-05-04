package busreservation;
 
public class Bus {
private int busno;
private int capacity;
private boolean ac;
   void setBusno(int b) {
	   busno=b;
   }
   void setcapacity(int c) {
	   capacity=c;
   }
   void setac(boolean a) {
	   ac=a;
   }
   int getBusno() {
	   return busno;
   }
   int getcapacity() {
	   return capacity;
   }
   boolean isac() {
	   return ac;
   }
  
}
