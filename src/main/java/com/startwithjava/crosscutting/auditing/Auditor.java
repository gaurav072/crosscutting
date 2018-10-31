package com.startwithjava.crosscutting.auditing;

import org.hibernate.envers.AuditReader;
import org.hibernate.envers.AuditReaderFactory;
import org.hibernate.envers.query.AuditQuery;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
public class Auditor {
    @PersistenceContext
    private EntityManager entityManager;
    private AuditReader reader = AuditReaderFactory.get(entityManager);

    public <T> List<T> find(Class<T> clazz,int limit) {
        AuditQuery query = reader.createQuery()
                .forRevisionsOfEntity(clazz,true,true);
        return  query
                .setMaxResults(limit)
                .getResultList();
    }

}
