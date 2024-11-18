

public class Rotor {

    
    private String rotorValues;
    private char startChar;
        
    public Rotor(String v, char c){
        this.rotorValues = new String(v);
        this.startChar = c;
        
        while(!this.rotate());
            
    }
    
    public boolean rotate(){
        //TODO
        int size = this.rotorValues.length(); //obtain size of the string 
        //create new string by placing last element of old string to be the first element in the new string and then adding the rest of
        //the old string shifting the elements over one
        String newRotorValues = rotorValues.charAt(size - 1) + rotorValues.substring(0, size - 1); 
        this.rotorValues = newRotorValues; //update rotorValues to be the new string

        if (rotorValues.charAt(0) == startChar){ //if the first char is the starting character
            return true; 
        }
        return false; //if first char is not starting char
               
    }
    

    public int indexOf(char c){
        //TODO
        for (int i = 0; i < rotorValues.length(); i++){ //loop through rotor string
            if (rotorValues.charAt(i) == c){ //if characters match 
                return i; //return index
            }
        }
        return 292943; //else return a random number that wont match an index
    }

    public char charAt(int idx){
        //TODO
        char target;
        target = rotorValues.charAt(idx);
        return target;
    }
}
    
