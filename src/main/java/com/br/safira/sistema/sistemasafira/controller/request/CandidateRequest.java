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

    @NotNull @Pattern(regexp = "^([a-zA-ZáàâãéèêíïóôõöúçñÁÀÂÃÉÈÍÏÓÔÕÖÚÇÑ'])+([\\s])([\\s]|[a-zA-Z])*([a-zA-Z]+)$")
    private String fullName;
    @NotNull @Pattern(regexp = "^([A-Za-z0-9áàâãéèêíïóôõöúçñÁÀÂÃÉÈÍÏÓÔÕÖÚÇÑ'])+([\\s])([\\s]|[a-zA-Z0-9])*([a-zA-Z0-9]+)$")
    private String description;

    @NotNull
    private Level level;

    @Min(value = 1)
    private int proficiency;

    private String socialLinks;

}
