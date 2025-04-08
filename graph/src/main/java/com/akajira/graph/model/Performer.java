package com.akajira.graph.model;

import java.util.List;

public record Performer(
        Long id,
        String name,
        List<Team> teams,
        List<Competence> skills,
        List<Task> tasks
) {
}
