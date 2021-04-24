package com.example.demo.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.time.LocalDate;

@Embeddable
@Data
public class Birthday {
    private int yearOfbBirthDay;

    @Min(1)
    @Max(12)
    private int monthOfBirthDay;

    @Min(1)
    @Max(31)
    private int dayOfBirthDay;

    public Birthday(LocalDate birthday){
        this.yearOfbBirthDay = birthday.getYear();
        this.monthOfBirthDay = birthday.getMonthValue();
        this.dayOfBirthDay = birthday.getDayOfMonth();
    }

}
