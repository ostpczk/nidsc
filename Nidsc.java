public class Nidsc {
	
	static int repLength = 3; 
	static int packetLength = 10;
	
  public static void main(String args[]) {
	  Nidsc nidsc = new Nidsc();
    System.out.println("NIDSC2 - PROJEKT");
    System.out.println("Jakub Ostapczuk, Adam Krizar, Paweł Norberciak");
    
    System.out.println("TEST RUN: REPETITION:"); ////////////////////////////////
    
    Data inputdata = new Data(10);
    System.out.println("\nINPUT DATA:");
    
    for(int bit : inputdata.bits) {
    	System.out.print(bit);
    }
    
    System.out.println("\nTRANSFER DATA:");
    int[] transferdata = Encoder.repetition(inputdata.bits, repLength);
    for(int bit : transferdata) {
    	System.out.print(bit);
    }
    
    transferdata = Noisemaker.randomErrors(transferdata);

    System.out.println("\nCORRUPTED DATA:");
    for(int bit : transferdata) {
    	System.out.print(bit);
    }
    
    System.out.println("\nOUTPUT DATA:");
    
    int[] outputdata = Decoder.repetition(transferdata,repLength);
    
    for(int bit : outputdata) {
    	System.out.print(bit);
    }
    
    System.out.println("TEST RUN: CRC:"); //////////////////////////////////////////////////////
    System.out.println("\nINPUT DATA:");
    
    for(int bit : inputdata.bits) {
    	System.out.print(bit);
    }
    
    System.out.println("\nTRANSFER DATA:");
    transferdata = Encoder.CRC(inputdata.bits, repLength);
    for(int bit : transferdata) {
    	System.out.print(bit);
    }
    
    transferdata = Noisemaker.randomErrors(transferdata);

    System.out.println("\nCORRUPTED DATA:");
    for(int bit : transferdata) {
    	System.out.print(bit);
    }
    
    System.out.println("\nOUTPUT DATA:");
    
    outputdata = Decoder.CRC(transferdata,repLength);
    
    for(int bit : outputdata) {
    	System.out.print(bit);
    }    
    
    
  }
}