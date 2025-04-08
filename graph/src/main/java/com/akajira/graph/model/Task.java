package com.akajira.graph.model;

import java.util.List;

public record Task(
        Long id,
        String title,
        List<Competence> skillsRequired,
        TaskStatus status
) {
}
