public class Enigma{

    private String rotorInit[] = {"#GNUAHOVBIPWCJQXDKRYELSZFMT",
        "#EJOTYCHMRWAFKPUZDINSXBGLQV",
        "#BDFHJLNPRTVXZACEGIKMOQSUWY",
        "#NWDKHGXZVRIFJBLMAOPSCYUTQE",
        "#TGOWHLIFMCSZYRVXQABUPEJKND"};


    private Rotor rotors[];
        
    public Enigma(int id1, int id2, int id3, String start){

        rotors = new Rotor[3];
        rotors[0] = new Rotor(rotorInit[id1-1], start.charAt(0));
        rotors[1] = new Rotor(rotorInit[id2-1], start.charAt(1));
        rotors[2] = new Rotor(rotorInit[id3-1], start.charAt(2));
        
    }


    public String decrypt(String message){   
        //TODO
        String toDecrypt = ""; //create empty string
        char character; //initialize character
        int index; //initalize index
        for (int i = 0; i < message.length(); i++){ //go through message to decrypt
            character = message.charAt(i); //obtain character at wanted index of message
            for (int j = 0; j < 28; j++){ //loop through outer rotor
                if (this.rotors[2].charAt(j) == character){ //when character is found in rotor
                    index = j; //save index
                    character = this.rotors[1].charAt(index); //obtain character in middle rotor at that index
                    for (int k = 0; k < 28; k++){ //loop through outer rotor
                        if (this.rotors[2].charAt(k) == character){ //find the previously found character in the outer rotor
                            index = k; //save index at found character
                            character = this.rotors[0].charAt(index); //set the character to be at that index in the inner rotor
                            toDecrypt += character; //add character to string
                            rotate(); //rotate
                            break; //break out of loop
                        }
                    }
                    break; //another break to move to next letter in message
                }
            }
        }
        return toDecrypt; //return decrypted message
    }


    
    public String encrypt(String message){
        //TODO
        String toEncrypt = ""; //create empty string
        char character; //initialize character
        int index; //initalize index
        for (int i = 0; i < message.length(); i++){ //go through the message to encrypt 
            character = message.charAt(i); //set character to be first letter in message
            for (int j = 0; j < 28; j++){ //loo[ through inner rotor
                if (this.rotors[0].charAt(j) == character){ //find the character in the inner rotor
                    index = j; //set index to be at the found character
                    character = this.rotors[2].charAt(index); //save the character in the outer rotor at the specified index
                    for (int k = 0; k < 28; k++){ //loop through middle rotor
                        if (this.rotors[1].charAt(k) == character){ //find the saved character in the middle rotor
                            index = k; //save the index of the found character
                            character = this.rotors[2].charAt(index); //find the character at that index in the outer rotor
                            toEncrypt += character; //add character to string
                            rotate(); //rotate
                            break; //break
                        }
                    }
                    break; //break to move to next character in message
                }
            }

        }
        return toEncrypt; //return encrypted message
    }
    
    private void rotate(){
        if(rotors[0].rotate()){
            if(rotors[1].rotate()){
                rotors[2].rotate();
            }
        }
    }
    
}
