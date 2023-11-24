package vn.edu.iuh.fit.backend.repositories.interfaces;


import vn.edu.iuh.fit.backend.models.Skill;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ISkillRepository {
    public boolean save(Skill skill);

    public boolean update(Skill skill);
    public boolean detele(UUID uuid);

    public Optional<Skill> getByID(UUID uuid);

    public List<Skill> getAll();
}
