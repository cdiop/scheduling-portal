/*
 * ################################################################
 *
 * ProActive Parallel Suite(TM): The Java(TM) library for
 *    Parallel, Distributed, Multi-Core Computing for
 *    Enterprise Grids & Clouds
 *
 * Copyright (C) 1997-2015 INRIA/University of
 *                 Nice-Sophia Antipolis/ActiveEon
 * Contact: proactive@ow2.org or contact@activeeon.com
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Affero General Public License
 * as published by the Free Software Foundation; version 3 of
 * the License.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this library; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307
 * USA
 *
 * If needed, contact us to obtain a release under GPL Version 2 or 3
 * or a different license than the AGPL.
 *
 *  Initial developer(s):               The ProActive Team
 *                        http://proactive.inria.fr/team_members.htm
 *  Contributor(s):
 *
 * ################################################################
 * $$PROACTIVE_INITIAL_DEV$$
 */
package org.ow2.proactive_grid_cloud_portal.scheduler.shared;

import org.ow2.proactive_grid_cloud_portal.common.shared.Config;


/**
 * Scheduler specific configuration
 * 
 * 
 * 
 * @author mschnoor
 *
 */
public class SchedulerConfig extends Config {

    /**
     * Path to the user-defined RM property file, relative
     * to the webapp file path
     */
    public static final String CONFIG_PATH = "scheduler.conf";

    /** URL of the remote REST service */
    public static final String REST_URL = "sched.rest.url";
    private static final String d_REST_URL = "http://localhost:8080/rest";

    public static final String REST_PUBLIC_URL = "sched.rest.public.url";
    private static final String d_REST_PUBLIC_URL = "http://localhost:8080/rest";

    /** URL of the remote noVNC proxy */
    public static final String NOVNC_URL = "sched.novnc.url";
    private static final String d_NOVNC_URL = "http://localhost:8080/rest";

    /** URL of the remote noVNC webpage */
    public static final String NOVNC_PAGE_URL = "sched.novnc.page.url";
    private static final String d_NOVNC_PAGE_URL = "http://localhost:8080/rest";

    /** client refresh rate in millis */
    public static final String CLIENT_REFRESH_TIME = "sched.client.refresh.time";
    private static final String d_CLIENT_REFRESH_TIME = "3000";

    /** client livelog refresh rate in millis */
    public static final String LIVELOGS_REFRESH_TIME = "sched.client.livelog.refresh.time";
    private static final String d_LIVELOGS_REFRESH_TIME = "1000";

    /** job page size */
    public static final String JOBS_PAGE_SIZE = "sched.jobs.page.size";
    private static final String d_JOBS_PAGE_SIZE = "50";

    /** release version string */
    public static final String VERSION = "sched.version";
    private static final String d_VERSION = "0.0";

    /** REST version string */
    public static final String REST_VERSION = "sched.rest.version";
    private static final String d_REST_VERSION = "0.0";

    /** Sched version string */
    public static final String SCHED_VERSION = "sched.server.version";
    private static final String d_SCHED_VERSION = "0.0";

    /** message of the day service URL */
    public static final String MOTD_URL = "sched.motd.url";
    private static final String d_MOTD_URL = "";

    private static SchedulerConfig instance = null;

    /**
     * @return current static config instance, cannot be null
     */
    public static SchedulerConfig get() {
        if (instance == null) {
            instance = new SchedulerConfig();
            instance.setDefaults();
        }
        return instance;
    }

    private void setDefaults() {
        properties.put(REST_URL, d_REST_URL);
        properties.put(REST_PUBLIC_URL, d_REST_PUBLIC_URL);
        properties.put(NOVNC_URL, d_NOVNC_URL);
        properties.put(NOVNC_PAGE_URL, d_NOVNC_PAGE_URL);
        properties.put(CLIENT_REFRESH_TIME, d_CLIENT_REFRESH_TIME);
        properties.put(LIVELOGS_REFRESH_TIME, d_LIVELOGS_REFRESH_TIME);
        properties.put(JOBS_PAGE_SIZE, d_JOBS_PAGE_SIZE);
        properties.put(VERSION, d_VERSION);
        properties.put(SCHED_VERSION, d_SCHED_VERSION);
        properties.put(REST_VERSION, d_REST_VERSION);
        properties.put(MOTD_URL, d_MOTD_URL);
    }

    @Override
    public String getApplicationName() {
        return "Scheduler";
    }

    @Override
    public String getRestUrl() {
        return properties.get(REST_URL);
    }

    @Override
    public String getRestPublicUrlIfDefinedOrOverridden() { return properties.get(REST_PUBLIC_URL);}

    public String getNoVncUrl() {
        return properties.get(NOVNC_URL);
    }

    public String getNoVncPageUrl() {
        return properties.get(NOVNC_PAGE_URL);
    }

    @Override
    public String getVersion() {
        return properties.get(VERSION);
    }

    @Override
    public String getRestVersion() {
        return properties.get(REST_VERSION);
    }

    @Override
    public String getApplicationVersion() {
        return properties.get(SCHED_VERSION);
    }

    @Override
    public String getMotdUrl() {
        return properties.get(MOTD_URL);
    }

    /**
     * @return the client refresh rate in millis
     */
    public int getClientRefreshTime() {
        return Integer.parseInt(properties.get(CLIENT_REFRESH_TIME));
    }

    /**
     * @return number of jobs per page
     */
    public int getJobsPageSize() {
        return Integer.parseInt(properties.get(JOBS_PAGE_SIZE));
    }

    /**
     * @return refresh rate for live logs in millis
     */
    public int getLivelogsRefreshTime() {
        return Integer.parseInt(properties.get(LIVELOGS_REFRESH_TIME));
    }
}
