package com.br.safira.sistema.sistemasafira.controller.request;

import com.br.safira.sistema.sistemasafira.model.enums.Level;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CandidateRequest {

    @NotNull @Pattern(regexp = "^[A-Za-záàâãéèêíïóôõöúçñÁÀÂÃÉÈÍÏÓÔÕÖÚÇÑ'\\s]+$")
    private String fullName;
    @NotNull @Pattern(regexp = "^[áàâãéèêíïóôõöúçñÁÀÂÃÉÈÍÏÓÔÕÖÚÇÑ'\\s\\w\\W]+$")
    private String description;

    @NotNull
    private Level level;

    @Min(value = 1)
    private int proficiency;

    private String socialLinks;

}
