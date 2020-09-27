package com.bankless.core.infrastructure.dto;

import com.bankless.core.domain.model.Greeting;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class SayHelloResponse extends ResponseDto {

    Greeting greeting;

}
