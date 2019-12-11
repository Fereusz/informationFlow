package fereusz.InformationFlow.dtos;

import fereusz.InformationFlow.domain.entities.Fund;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class FundManagerDTO {

    @NotBlank
    private String firstName;
    @NotBlank
    private String secondName;
    @NotBlank
    private String sector;
    private Fund fund;
}
