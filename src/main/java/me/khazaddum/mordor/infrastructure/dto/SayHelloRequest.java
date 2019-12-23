package me.khazaddum.mordor.infrastructure.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SayHelloRequest extends RequestDto {

    String name;

}
