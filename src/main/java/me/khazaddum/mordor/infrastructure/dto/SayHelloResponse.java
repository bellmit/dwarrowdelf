package me.khazaddum.mordor.infrastructure.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import me.khazaddum.mordor.domain.model.Greeting;

@Setter
@Getter
@AllArgsConstructor
public class SayHelloResponse extends ResponseDto {

    Greeting greeting;

}
