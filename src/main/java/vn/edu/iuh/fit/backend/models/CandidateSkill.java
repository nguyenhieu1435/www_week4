package vn.edu.iuh.fit.backend.models;

import lombok.*;
import vn.edu.iuh.fit.backend.enums.SkillLevel;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CandidateSkill {
    private Candidate candidate;
    private Skill skill;
    private String moreInfos;
    private SkillLevel skillLevel;


}
