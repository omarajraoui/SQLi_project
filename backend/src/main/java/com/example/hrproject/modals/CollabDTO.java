package com.example.hrproject.modals;

import com.example.hrproject.Entities.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class CollabDTO {
    private Collaborateur collab;
    private List<Competence> competences;
    private List<Diplome> diplomes;
}
