package com.akajira.graph.model;

import java.util.List;

public record Team(
        Long id,
        String name,
        TeamLead leader,
        List<Performer> members
) {

}
