package com.hassan.after_DI;

public class SMSAuthorizer_DI extends Authorizer{
    private Boolean authorizationFlag = false;

    public void authorizeCode(String _securityCode){
        System.out.println("Verifying Code - " + _securityCode);
        this.authorizationFlag =  true;
    }

    @Override
    public Boolean isAuthorized() {
        return this.authorizationFlag;
    }
}
