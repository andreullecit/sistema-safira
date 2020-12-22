package com.br.safira.sistema.sistemasafira.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Candidate {
    @Id
    private String id;

    private String fullName;

    private String description;

    private int proficiency;

    private Level level;

    private String socialLinks;

    private LocalDateTime createdAt;
}
