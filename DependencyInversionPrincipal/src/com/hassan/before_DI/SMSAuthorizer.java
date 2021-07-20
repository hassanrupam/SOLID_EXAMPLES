package com.hassan.before_DI;

public class SMSAuthorizer {

    private Boolean authorizationFlag = false;

    public void authorizeCode(String _securityCode){
        System.out.println("Verifying Code - " + _securityCode);
        this.authorizationFlag =  true;
    }

    public Boolean isAuthorized(){
        return this.authorizationFlag;
    }

}
