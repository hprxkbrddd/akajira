package com.akajira.graph.model;

import java.util.List;

public record TeamLead(
        Long id,
        String name,
        List<Team> teams,
        List<Performer> subordinates,
        List<Competence> skills,
        List<Task> tasks
) {
}
