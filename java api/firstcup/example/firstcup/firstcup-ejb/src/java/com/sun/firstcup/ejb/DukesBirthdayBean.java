/*
 * Copyright 2007 Sun Microsystems, Inc.
 * All rights reserved.  You may not modify, use,
 * reproduce, or distribute this software except in
 * compliance with  the terms of the License at:
 * http://developer.sun.com/berkeley_license.html
 */


package com.sun.firstcup.ejb;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Logger;
import javax.ejb.Stateless;


/**
 * DukesBirthdayBean is a stateless session bean that calculates the age
 * difference between a user and Duke, who was born on May 23, 1995.
 */
@Stateless
public class DukesBirthdayBean implements DukesBirthdayRemote {
    private static Logger logger = Logger.getLogger(
                "com.sun.firstcup.ejb.DukesBirthdayBean");

    public int getAgeDifference(Date date) {
        int ageDifference;

        Calendar theirBirthday = new GregorianCalendar();
        Calendar dukesBirthday = new GregorianCalendar(1995, Calendar.MAY, 23);

        // Set the Calendar object to the passed in Date
        theirBirthday.setTime(date);

        // Subtract the user's age from Duke's age
        ageDifference = dukesBirthday.get(Calendar.YEAR)
            - theirBirthday.get(Calendar.YEAR);
        logger.info("Raw ageDifference is: " + ageDifference);

        // Check to see if Duke's birthday occurs before the user's. If so, 
        // subtract one from the age difference
        if (dukesBirthday.before(theirBirthday) && (ageDifference > 0)) {
            ageDifference--;
        }

        logger.info("Final ageDifference is: " + ageDifference);

        return ageDifference;
    }
}
