package com.KartikeySingh.project.UberApp.Uber_Cl.advices;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Builder
@Data
@AllArgsConstructor
public class ApiResponse<T>{

    // @JsonFormat(pattern ="hh:mm:ss dd-MM-yyyy")
    private LocalDateTime timestamp;
    private T data;
    private ApiError error;

    public ApiResponse()
    {
        this.timestamp= LocalDateTime.now();
    }

    public ApiResponse(T data)
    {
        this();
        this.data=data;
    }

    public ApiResponse(ApiError error)
    {
        this();
        this.error=error;

    }

}
