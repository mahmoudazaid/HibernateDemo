package org.example.hibernate.queries;

import org.example.hibernate.HibernateConnection;
import org.example.hibernate.entities.EmployeeEntity;
import org.hibernate.query.Query;

import java.util.Date;


public class EmployeeQueries extends HibernateConnection {
    public EmployeeQueries(Class entityName) {
        super(EmployeeEntity.class, EmployeeQueries.class.getName());
    }

    private EmployeeEntity findEmployee() {
        String sql = "select e from " + EmployeeEntity.class.getName() + " where e.columnID=:columnID";
        Query<EmployeeEntity> query = session.createQuery(sql);
        return query.setParameter("columnID", 1).getSingleResult();
    }

    public Date getColumnDate() {
        return findEmployee().getColumnDate();
    }
}