/*
 * Copyright 2007 Sun Microsystems, Inc.
 * All rights reserved.  You may not modify, use,
 * reproduce, or distribute this software except in
 * compliance with  the terms of the License at:
 * http://developer.sun.com/berkeley_license.html
 */


package com.sun.firstcup.webservice;

import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.jws.WebService;
import javax.jws.WebMethod;


@WebService
public class DukesAge {
    public DukesAge() {
    }

    @WebMethod
    public int getDukesAge() {
        Calendar dukesBirthday = new GregorianCalendar(1995, Calendar.MAY, 23);
        Calendar now = Calendar.getInstance();

        int dukesAge = now.get(Calendar.YEAR)
            - dukesBirthday.get(Calendar.YEAR);
        dukesBirthday.add(Calendar.YEAR, dukesAge);

        if (now.before(dukesBirthday)) {
            dukesAge--;
        }

        return dukesAge;
    }
}
