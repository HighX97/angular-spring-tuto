package com.ouwasav.spring.service;

import java.util.concurrent.Future;

import com.ouwasav.spring.models.Utilisateur;


/**
 * The EmailService interface defines all public business behaviors for
 * composing and transmitting email messages.
 *
 * This interface should be injected into EmailService clients, not the
 * implementation bean.
 *
 * @author Matt Warman
 */
public interface EmailService {

    /**
     * Send a Utilisateur via email synchronously.
     * @param utilisateur A Utilisateur to send.
     * @return A Boolean whose value is TRUE if sent successfully; otherwise
     *         FALSE.
     */
    Boolean send(Utilisateur utilisateur);

    /**
     * Send a Utilisateur via email asynchronously.
     * @param utilisateur A Utilisateur to send.
     */
    void sendAsync(Utilisateur utilisateur);

    /**
     * Send a Utilisateur via email asynchronously. Returns a Future&lt;Boolean&gt;
     * response allowing the client to obtain the status of the operation once
     * it is completed.
     * @param utilisateur A Utilisateur to send.
     * @return A Future&lt;Boolean&gt; whose value is TRUE if sent successfully;
     *         otherwise, FALSE.
     */
    Future<Boolean> sendAsyncWithResult(Utilisateur utilisateur);

}
