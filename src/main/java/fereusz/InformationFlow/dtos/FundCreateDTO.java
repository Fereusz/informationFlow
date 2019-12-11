package fereusz.InformationFlow.dtos;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class FundCreateDTO {

    @NotNull @Min(2)
    private Double assetsUnderManagement;
    @NotBlank
    private String name;
    @NotNull @Max(1)
    private Integer tier;


}
