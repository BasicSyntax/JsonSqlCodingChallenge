package com.lemon.hbm;

import org.json.simple.JSONValue;
import org.junit.Test;

import java.io.FileReader;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

public class SiteTest {

    private final List<Site> siteList = new ArrayList<>();
    private Site site;

    
    @Test
    public void checkJsonExportsProperly() {

    }

    @Test
    public void doesNameGetterWork() throws NoSuchFieldException, IllegalAccessException {
        // given
        site = new Site();
        Field field = site.getClass().getDeclaredField("name");
        field.setAccessible(true);
        field.set(site, "Beaumont Spinks");

        // when
        final String result = site.getName();

        // then
        assertEquals("field wasn't retrieved properly", result, "Beaumont Spinks");
    }

    @Test
    public void doesNameSetterWork() throws NoSuchFieldException, IllegalAccessException {
        // given
        final Site site = new Site();

        // when
        site.setName("Beaumont Spinks");

        // then
        final Field field = site.getClass().getDeclaredField("name");
        field.setAccessible(true);
        assertEquals("Fields didn't match", field.get(site), "Beaumont Spinks");
    }

    @Test
    public void doesAlarmColorGetterWork() throws NoSuchFieldException, IllegalAccessException {
        // given
        final Site site = new Site();
        final Field field = site.getClass().getDeclaredField("alarmColor");
        field.setAccessible(true);
        field.set(site, -200);

        // when
        final long result = site.getAlarmColor();

        // then
        assertThat(result).isEqualTo(-200);
    }

    @Test
    public void doesAlarmColorSetterWork() throws NoSuchFieldException, IllegalAccessException {
        // given
        final Site site = new Site();

        // when
        site.setAlarmColor(-250L);

        // then
        final Field field = site.getClass().getDeclaredField("alarmColor");
        field.setAccessible(true);
        assertThat(field.get(site)).isEqualTo(-250L);
    }

    @Test
    public void doesIdGetterWork() throws NoSuchFieldException, IllegalAccessException {
        // given
        final Site site = new Site();
        final Field field = site.getClass().getDeclaredField("id");
        field.setAccessible(true);
        field.set(site, 13);

        // when
        final long result = site.getId();

        // then
        assertThat(result).isEqualTo(13);
    }

    @Test
    public void doesIdSetterWork() throws NoSuchFieldException, IllegalAccessException {
        // given
        final Site site = new Site();

        // when
        site.setId(12);

        // then
        final Field field = site.getClass().getDeclaredField("id");
        field.setAccessible(true);
        assertThat(field.get(site)).isEqualTo(12L);
    }

    @Test
    public void doesParametersGetterWork() throws NoSuchFieldException, IllegalAccessException {
        // given
        final Site site = new Site();
        final Field field = site.getClass().getDeclaredField("parameters");
        field.setAccessible(true);
        field.set(site, Map.of("Parameter", "Map"));

        // when
        final Map<String, String> result = site.getParameters();

        // then
        assertEquals("Fields didn't match", result, Map.of("Parameter", "Map"));
    }

    @Test
    public void doesParametersSetterWork() throws NoSuchFieldException, IllegalAccessException {
        // given
        final Site site = new Site();

        // when
        site.setParameters(Map.of("Parameter", "Map"));

        // then
        final Field field = site.getClass().getDeclaredField("parameters");
        field.setAccessible(true);
        assertEquals("Fields didn't match", field.get(site), Map.of("Parameter", "Map"));
    }

    @Test
    public void doesDataSourcesCountGetterWork() throws NoSuchFieldException, IllegalAccessException {
        // given
        final Site site = new Site();
        final Field field = site.getClass().getDeclaredField("dataSourcesCount");
        field.setAccessible(true);
        field.set(site, 101);

        // when
        final int result = site.getDataSourcesCount();

        // then
        assertThat(result).isEqualTo(101);
    }

    @Test
    public void doesDataSourcesCountSetterWork() throws NoSuchFieldException, IllegalAccessException {
        // given
        final Site site = new Site();

        // when
        site.setDataSourcesCount(100);

        // then
        final Field field = site.getClass().getDeclaredField("dataSourcesCount");
        field.setAccessible(true);
        assertEquals("Fields didn't match", field.get(site), 100);
    }

    @Test
    public void doesAlertIconGetterWork() throws NoSuchFieldException, IllegalAccessException {
        // given
        final Site site = new Site();
        final Field field = site.getClass().getDeclaredField("alertIcon");
        field.setAccessible(true);
        field.set(site, "Communications");

        // when
        final String result = site.getAlertIcon();

        // then
        assertThat(result).isEqualTo("Communications");
    }

    @Test
    public void doesAlertIconSetterWork() throws NoSuchFieldException, IllegalAccessException {
        // given
        final Site site = new Site();

        // when
        site.setAlertIcon("Warning");

        // then
        final Field field = site.getClass().getDeclaredField("alertIcon");
        field.setAccessible(true);
        assertEquals("Fields didn't match", field.get(site), "Warning");
    }

    @Test
    public void doesElementCountGetterWork() throws NoSuchFieldException, IllegalAccessException {
        // given
        final Site site = new Site();
        final Field field = site.getClass().getDeclaredField("elementCount");
        field.setAccessible(true);
        field.set(site, 11);

        // when
        final int result = site.getElementCount();

        // then
        assertThat(result).isEqualTo(11);
    }

    @Test
    public void doesElementCountSetterWork() throws NoSuchFieldException, IllegalAccessException {
        // given
        final Site site = new Site();

        // when
        site.setElementCount(10);

        // then
        final Field field = site.getClass().getDeclaredField("elementCount");
        field.setAccessible(true);
        assertEquals("Fields didn't match", field.get(site), 10);
    }

    @Test
    public void doesUniqueIDGetterWork() throws NoSuchFieldException, IllegalAccessException {
        // given
        final Site site = new Site();
        final Field field = site.getClass().getDeclaredField("uniqueID");
        field.setAccessible(true);
        field.set(site, "shashashasha");

        // when
        final String result = site.getUniqueID();

        // then
        assertThat(result).isEqualTo("shashashasha");
    }

    @Test
    public void doesUniqueIDSetterWork() throws NoSuchFieldException, IllegalAccessException {
        // given
        final Site site = new Site();

        // when
        site.setUniqueID("hashhashhashhash");

        // then
        final Field field = site.getClass().getDeclaredField("uniqueID");
        field.setAccessible(true);
        assertEquals("Fields didn't match", field.get(site), "hashhashhashhash");
    }

    @edu.umd.cs.findbugs.annotations.SuppressFBWarnings("DM_DEFAULT_ENCODING")
    @Test
    public void testToString() {
        // given
        // when
        try {
            Object jsonDoc = JSONValue.parse(new FileReader("src/test/java/com/lemon/hbm/jsonTest.json"));
            site = new Site(jsonDoc);
        } catch (Exception e) {
            e.printStackTrace();
        }

        String result = site.toString();

        // then
        assertThat(result).
                isEqualTo("com.lemon.hbm.Site{" +
                        "name='" + "TestName" + '\'' +
                        ", alarmColor=" + -1000 +
                        ", id=" + 45 +
                        ", parameters=" +
                        "{Peak Power=1000.11, " +
                        "Description=4000.44 kW, " +
                        "Panel Degradation Correction Coefficient=1.1, " +
                        "Situation=WorkingAsIntended, " +
                        "Temperature Correction Coefficient=-0.99, " +
                        "Name=TestParameterName}" +
                        ", dataSourcesCount=" + 10 +
                        ", alertIcon='" + "IsThisWorking?" + '\'' +
                        ", elementCount=" + 500 +
                        ", uniqueID='" + "34567tdd-7tdd-7tdd-7tdd-324h23tdd" + '\'' +
                        '}');
    }
}
