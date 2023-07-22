package com.zk.common.exception;


import lombok.Data;

@Data
public class CustomException extends RuntimeException {

   private Integer code;

    public CustomException() {
       super();
    }

    public CustomException(Integer code,String messsage){
        super(messsage);
        this.code=code;
    }
}
