
package com.calc.exceptions;

import java.util.Collection;
import org.springframework.util.StringUtils;

public class mathException extends RuntimeException{

    private Collection<String> messages;

    public mathException(String msg){
        super(msg);
    }


    public mathException(String msg, Exception cause){
        super(msg, cause);
    }


    public mathException(Collection<String> messages){
        super();
        this.messages= messages;
    }


    public mathException (Collection<String> messages, Exception cause){
        super(cause);
        this.messages= messages;
    }

    @Override
    public String getMessage(){
        String msg;

        if(this.messages!=null && !this.messages.isEmpty()){
            msg="[";

            for(String message : this.messages){
                msg+=message+",";
            }

           // msg= StringUtils.removeEnd(msg, ",")+"]";

        }else msg= super.getMessage();

        return msg;
    }
}

