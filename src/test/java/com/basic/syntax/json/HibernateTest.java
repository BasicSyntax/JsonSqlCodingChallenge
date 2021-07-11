package com.basic.syntax.json;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.json.simple.JSONValue;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class HibernateTest {
    private SessionFactory sessionFactory;
    private Site site;
    private final List<Object> siteList = new ArrayList<>();
    private static final Logger log =
            LoggerFactory.getLogger(HibernateTest.class);

    @Before
    public void setUp() {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure()
                .build();
        log.info("registry created: " + registry.getClass());
        try {
            sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
            log.info("sessionFactory instantiated: " + sessionFactory.getClass());
        } catch (Exception e) {
            StandardServiceRegistryBuilder.destroy(registry);
            log.info("sessionFactory error: " + e.getMessage());
        }
    }

    @After
    public void tearDown() {
        if (sessionFactory != null) {
            sessionFactory.close();
        }
    }

    @Test
    @SuppressFBWarnings("DM_DEFAULT_ENCODING")
    @SuppressWarnings("unchecked")
    public void checkMappingToDatabaseAndCompareToJavaObjects() {
        // given
        final var checkList = new ArrayList<>();

        try {
            Object jsonDoc = JSONValue.parse(new FileReader("src/test/java/com/basic/syntax/json/jsonTestFile.json"));
            site = new Site(jsonDoc);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Session session;

        for (int idNumber = 1; idNumber <= 4; idNumber++) {
            session = sessionFactory.openSession();
            session.beginTransaction();
            site.setName("TestName" + idNumber);
            site.setUniqueID("34567tdd-" + idNumber);
            session.save(site);
            log.info("Saved site : " + site.getClass() + " : Event (" + site.getName() + ") : " + site.getUniqueID());
            session.getTransaction().commit();
            session.close();

            site.setId(idNumber);
            checkList.add(new Site(site));
        }

        // when
        session = sessionFactory.openSession();
        session.beginTransaction();
        var result = session.createQuery("from com.basic.syntax.json.Site").list();
        for (Site site : (List<Site>) result) {
            log.info("Pulling Sites from Database : " + result.getClass() + ", length = " + result.size());
            System.out.println("Event (" + site.getName() + ") , id : " + site.getId() + ", uniqueID : " + site.getUniqueID());
            siteList.add(site);
        }
        session.getTransaction().commit();
        session.close();

        // then
        assertThat(siteList.toString()).isEqualTo(checkList.toString());
    }
}
