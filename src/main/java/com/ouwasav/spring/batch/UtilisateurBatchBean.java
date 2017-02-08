package com.ouwasav.spring.batch;

import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.ouwasav.spring.models.Utilisateur;
import com.ouwasav.spring.service.UtilisateurService;

@Component
public class UtilisateurBatchBean {


	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private UtilisateurService utilisateurService;


    @Scheduled(
            cron = "0,30 * * * * *")
    public void cronJob() {
        logger.info("> cronJob");

        // Add scheduled logic here
        Collection<Utilisateur> utilisateurs = utilisateurService.findAll();
        logger.info("There are {} utilisateurs in the data store.",
                utilisateurs.size());

        logger.info("< cronJob");
    }

    @Scheduled(
            initialDelay = 5000,
            fixedRate = 15000)
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

    @Scheduled(
            initialDelay = 5000,
            fixedDelay = 15000)
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
