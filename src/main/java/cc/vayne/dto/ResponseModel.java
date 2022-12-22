package cc.vayne.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResponseModel<T> {
    private Integer code;
    private String message;
    private T data;

    public static <T> ResponseModel<T> success(T data){
        return new ResponseModel<>(200,"success",data);
    }

    public static <T> ResponseModel<T> fail(T data){
        return new ResponseModel<>(0,"fail",data);
    }

}
