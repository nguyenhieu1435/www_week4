package vn.edu.iuh.fit.backend.models;

import lombok.*;
import vn.edu.iuh.fit.backend.enums.SkillType;

import java.util.UUID;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Skill {
    private UUID id;
    private String description;
    private String name;
    private SkillType type;

    public Skill(UUID id) {
        this.id = id;
    }
}
