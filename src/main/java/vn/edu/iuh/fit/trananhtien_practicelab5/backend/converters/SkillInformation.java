package vn.edu.iuh.fit.trananhtien_practicelab5.backend.converters;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import vn.edu.iuh.fit.trananhtien_practicelab5.backend.enums.SkillLevel;
import vn.edu.iuh.fit.trananhtien_practicelab5.backend.models.Skill;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SkillInformation {
    Skill skill;
    SkillLevel skillLevel;
    private String moreInfos;
}
