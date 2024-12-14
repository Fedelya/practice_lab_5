package vn.edu.iuh.fit.trananhtien_practicelab5.backend.enums

import lombok.Getter

@Getter
enum class SkillLevel(val level: Int) {
    BEGINNER(1),
    INTERMEDIATE(2),
    ADVANCED(3),
    PROFESSIONAL(4),
    MASTER(5);
}
