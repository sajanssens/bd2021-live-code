package nl.belastingdienst.jpa.dao;

import nl.belastingdienst.jpa.domain.Department;
import nl.belastingdienst.jpa.domain.Office;

import javax.persistence.TypedQuery;
import java.util.HashSet;
import java.util.Set;

import static java.util.stream.Collectors.toSet;

public class OfficeDao extends Dao<Office, Integer> {

    public Set<Department> getDepartments(Office o) {
        // performs 1 query:
        Office office = find(o.getId()); // managed

        // now i can fetch each deparment when I access a department's field
        // performs office.getDepartments().size() queries
        for (Department department : office.getDepartments()) {
            Integer id = department.getId();
        }
        return office.getDepartments();

        // in total a lot of queries!
    }

    public Set<Department> getDepartments2(Office o) {
        TypedQuery<Department> query = em.createQuery(
                "SELECT o.departments " +
                        "FROM Office o " +
                        "JOIN FETCH Department " +
                        "WHERE o.id = :id",
                Department.class);
        // JOIN: is still lazy
        // JOIN FETCH: is eager!
        query.setParameter("id", o.getId());
        return new HashSet<>(query.getResultList());
        // performs only ONE query! Much better than getDepartments(..) above.
    }

    public Office findDetached(Integer id) {
        Office office = super.find(id);
        em.clear();
        return office;
    }
}
