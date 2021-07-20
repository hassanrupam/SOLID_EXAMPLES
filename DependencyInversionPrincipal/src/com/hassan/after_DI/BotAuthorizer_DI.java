package com.hassan.after_DI;

import java.security.SecureRandom;
import java.util.Scanner;

public class BotAuthorizer_DI extends Authorizer{
    private Boolean authorizationFlag= false;

    Scanner scanner = new Scanner(System.in);

    public void isABot(){
        System.out.println("Are you a robot?  - > " );
        SecureRandom random = new SecureRandom();
        int num = random.nextInt(100000);
        String formatted = String.format("%05d", num);
        System.out.println("Insert the following text to Verify -> " + formatted);
        String humanInput = scanner.nextLine();
        if(humanInput.equals(formatted)){
            this.authorizationFlag =  true;
        }
    }

    @Override
    public Boolean isAuthorized() {
        return this.authorizationFlag;
    }
}
