package vn.edu.iuh.fit.repositories.interfaces;


import vn.edu.iuh.fit.models.Skill;

import java.util.List;
import java.util.UUID;

public interface ISkillRepository {
    public boolean save(Skill skill);

    public boolean update(Skill skill);
    public boolean detele(UUID uuid);

    public Skill getByID(UUID uuid);

    public List<Skill> getAll();
}
