package com.basic.syntax.json;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import org.json.simple.JSONArray;
import org.json.simple.JSONValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static com.basic.syntax.json.HibernateUtil.getSessionFactory;
import static com.basic.syntax.json.HibernateUtil.shutdown;


public class App {
    private static final Logger log =
            LoggerFactory.getLogger(App.class);
    static List<Site> siteList = new ArrayList<>();

    @SuppressFBWarnings({"DM_DEFAULT_ENCODING", "NP_DEREFERENCE_OF_READLINE_VALUE"})
    public static void main(String[] args) throws IOException {
        boolean flag = true;
        boolean outputFlag;
        String in, out = null;
        var bufferReader = new BufferedReader(new InputStreamReader(System.in));

        while (flag) {
            System.out.println("Welcome to my JSON reading program.");
            System.out.println("Please enter your input file holding JSON data, then press ENTER : ");
            in = bufferReader.readLine();
            // TODO infinite looping
            while (true) {
                System.out.println("Would you like to declare an output file? Y or N : ");
                String isThereAnOutput = bufferReader.readLine();
                if (isThereAnOutput.equalsIgnoreCase("Y")) {
                    System.out.println("Please enter your output file, then press ENTER : ");
                    out = bufferReader.readLine();
                    outputFlag = true;
                    flag = false;
                    break;
                } else if (isThereAnOutput.equalsIgnoreCase("N")) {
                    outputFlag = false;
                    flag = false;
                    break;
                } else {
                    System.out.println("Please enter only valid input.");
                }
            }

            try {
                JSONArray jsonDoc = (JSONArray) JSONValue.parse(new FileReader(in));
                for (Object site : jsonDoc) {
                    site = new Site(site);
                    siteList.add((Site) site);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            System.out.println("Persisting input to Database, please wait...");
            log.info("Initializing Session...");
            var sessionFactory = getSessionFactory();
            var session = sessionFactory.openSession();
            if (session != null) {
                log.info("Session running");
            } else {
                log.info("Session is null - " + sessionFactory.getClass());
            }

            for (var site : siteList) {
                session = sessionFactory.openSession();
                session.beginTransaction();
                session.save(site);
                session.getTransaction().commit();
                session.close();
                log.info("Persisting new site object " + site.getClass());
            }

            session = sessionFactory.openSession();
            session.beginTransaction();
            var result = session.createQuery("from com.basic.syntax.json.Site").list();
            if (outputFlag && out != null) {
                log.info("Beginning write to output file - " + out);
                BufferedWriter output = new BufferedWriter(new FileWriter(out));

                ((List<Site>) result).forEach(site -> {
                    try {
                        output.write(String.valueOf(site));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });

                output.close();
            } else if (!outputFlag) {
                ((List<Site>) result).forEach(site -> {
                    System.out.println(site.getClass() + " : "
                            + "\n\tId : " + site.getId() + " : "
                            + "\n\tName : " + site.getName() + " : "
                            + "\n\tAlarmColor : " + site.getAlarmColor() + " : "
                            + "\n\tParameters : " + site.getParameters() + " : "
                            + "\n\tDataSourcesCount : " + site.getDataSourcesCount() + " : "
                            + "\n\t_alertIcon : " + site.getAlertIcon() + " : "
                            + "\n\tElementCount : " + site.getElementCount() + " : "
                            + "\n\tUniqueID : " + site.getUniqueID());
                });
            }
            session.getTransaction().commit();
            session.close();

            shutdown();
        }

    }
}
