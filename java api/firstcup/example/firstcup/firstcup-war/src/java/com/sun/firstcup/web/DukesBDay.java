/*
 * Copyright 2007 Sun Microsystems, Inc.
 * All rights reserved.  You may not modify, use,
 * reproduce, or distribute this software except in
 * compliance with  the terms of the License at:
 * http://developer.sun.com/berkeley_license.html
 */


package com.sun.firstcup.web;

import com.sun.firstcup.ejb.DukesBirthdayRemote;
import java.util.Date;
import javax.ejb.EJB;


/**
 *
 * @author Jennifer Ball
 */
public class DukesBDay {
    private Date yourBD;
    @EJB
    private DukesBirthdayRemote dukesBirthday;
    private int absAgeDiff;
    private int age;
    private int ageDiff;

    /** Creates a new instance of DukesBDay */
    public DukesBDay() {
        age = -1;
        yourBD = null;
        ageDiff = 0;
        absAgeDiff = 0;
    }

    public int getAge() {
        try { // Call Web Service Operation

            com.sun.firstcup.webservice.DukesAgeService service = new com.sun.firstcup.webservice.DukesAgeService();
            com.sun.firstcup.webservice.DukesAge port = service
                .getDukesAgePort();
            // TODO process result here
            age = port.getDukesAge();
        } catch (Exception ex) {
            // TODO handle custom exceptions here
            ex.printStackTrace();
        }

        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getYourBD() {
        return yourBD;
    }

    public void setYourBD(Date yourBD) {
        this.yourBD = yourBD;
    }

    public int getAgeDiff() {
        ageDiff = dukesBirthday.getAgeDifference(yourBD);
        System.out.println("age diff from dukesbday " + ageDiff);
        setAbsAgeDiff(Math.abs(ageDiff));
        System.out.println("absAgeDiff " + absAgeDiff);

        return ageDiff;
    }

    public void setAgeDiff(int ageDiff) {
        this.ageDiff = ageDiff;
    }

    public int getAbsAgeDiff() {
        System.out.println("getabsAgeDiff " + absAgeDiff);

        return absAgeDiff;
    }

    public void setAbsAgeDiff(int absAgeDiff) {
        System.out.println("setabsAgeDiff " + absAgeDiff);
        this.absAgeDiff = absAgeDiff;
    }
}
