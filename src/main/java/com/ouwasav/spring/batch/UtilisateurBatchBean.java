package com.ouwasav.spring.batch;

import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.ouwasav.spring.models.Utilisateur;
import com.ouwasav.spring.service.UtilisateurService;

@Profile("batch")
@Component
public class UtilisateurBatchBean {


	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private UtilisateurService utilisateurService;


    @Scheduled(
            cron = "$(batch.greeting.cron)")
    public void cronJob() {
        logger.info("> cronJob");

        // Add scheduled logic here
        Collection<Utilisateur> utilisateurs = utilisateurService.findAll();
        logger.info("There are {} utilisateurs in the data store.",
                utilisateurs.size());

        logger.info("< cronJob");
    }

    /**
     * Execute logic beginning at fixed intervals with a delay after the
     * application starts. Use the <code>fixedRate</code> element to indicate
     * how frequently the method is to be invoked. Use the
     * <code>initialDelay</code> element to indicate how long to wait after
     * application startup to schedule the first execution.
     */
    @Scheduled(
            initialDelayString = "${batch.greeting.initialdelay}",
            fixedRateString = "${batch.greeting.fixedrate}")
    public void fixedRateJobWithInitialDelay() {
        logger.info("> fixedRateJobWithInitialDelay");

        // Add scheduled logic here

        // Simulate job processing time
        long pause = 5000;
        long start = System.currentTimeMillis();
        do {
            if (start + pause < System.currentTimeMillis()) {
                break;
            }
        } while (true);
        logger.info("Processing time was {} seconds.", pause / 1000);

        logger.info("< fixedRateJobWithInitialDelay");
    }

    /**
     * Execute logic with a delay between the end of the last execution and the
     * beginning of the next. Use the <code>fixedDelay</code> element to
     * indicate the time to wait between executions. Use the
     * <code>initialDelay</code> element to indicate how long to wait after
     * application startup to schedule the first execution.
     */
    @Scheduled(
            initialDelayString = "${batch.greeting.initialdelay}",
            fixedDelayString = "${batch.greeting.fixeddelay}")
    public void fixedDelayJobWithInitialDelay() {
        logger.info("> fixedDelayJobWithInitialDelay");

        // Add scheduled logic here

        // Simulate job processing time
        long pause = 5000;
        long start = System.currentTimeMillis();
        do {
            if (start + pause < System.currentTimeMillis()) {
                break;
            }
        } while (true);
        logger.info("Processing time was {} seconds.", pause / 1000);

        logger.info("< fixedDelayJobWithInitialDelay");
    }

}
