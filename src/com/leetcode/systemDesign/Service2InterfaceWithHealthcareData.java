package com.leetcode.systemDesign;

public class Service2InterfaceWithHealthcareData {
    String[] requirement = new String[]{
            "You have a third-party vendor a database with a huge list of doctors, their aggegrate ratings from " +
                    "patients (1 star being the worst, 5 stars being the best), and maybe their practice (no " +
                    "duplicate entries for doctors). This database gets rarely updated, but it does get updated.",
            "Your task is design a proxy service, so that a client using your service can get the ratings " +
                    "about a list of doctors from database. You don't always want to access the database because it's" +
                    " read expensive.",
            "What technologies would you use in designing your service, what are the benefits of cost of " +
                    "using each technology?"
    };

    String discussion =
            "https://leetcode.com/discuss/interview-question/system-design/368245/Design-Service-to-Interface-with" +
                    "-Healthcare-Data";
}
