package com.ouwasav.spring.service;

import java.util.Collection;

import javax.persistence.EntityExistsException;
import javax.persistence.NoResultException;

import org.hsqldb.types.Collation;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.ouwasav.spring.AbstractTest;
import com.ouwasav.spring.models.Utilisateur;

@Transactional
public class UtilisateurServiceTest extends AbstractTest{

	@Autowired
	private UtilisateurService utilisateurService;


	@Before
	public void setUp()
	{
		utilisateurService.evictCache();
	}

	@After
	public void teardown()
	{
		//clean up after each test method
	}

	@Test
	public void testFindAll()
	{
		Collection<Utilisateur> list = utilisateurService.findAll();

		Assert.assertNotNull("failur - expected not null", list);
		Assert.assertEquals("failur - expected size ", 1,list.size());
	}

	  @Test
	    public void testFindOne() {

	        int id = 1;

	        Utilisateur entity = utilisateurService.findOne(id);

	        Assert.assertNotNull("failure - expected not null", entity);
	        Assert.assertEquals("failure - expected id attribute match", id,
	                entity.getId());

	    }

	    @Test
	    public void testFindOneNotFound() {

	        int id = Integer.MAX_VALUE;

	        Utilisateur entity = utilisateurService.findOne(id);

	        Assert.assertNull("failure - expected null", entity);

	    }

	    @Test
	    public void testCreate() {

	        Utilisateur entity = new Utilisateur();
	        entity.setNom("testNom");
	        entity.setPassword("testpassword");
	        entity.setMail("test@gtest.fr");

	        Utilisateur createdEntity = utilisateurService.create(entity);

	        Assert.assertNotNull("failure - expected not null", createdEntity);
	        Assert.assertNotNull("failure - expected id attribute not null",
	                createdEntity.getId());
	        Assert.assertEquals("failure - expected nom attribute match", "testNom",
	                createdEntity.getNom());
	        Assert.assertEquals("failure - expected password attribute match", "testpassword",
	                createdEntity.getPassword());
	        Assert.assertEquals("failure - expected mail attribute match", "test@gtest.fr",
	                createdEntity.getMail());

	        Collection<Utilisateur> list = utilisateurService.findAll();

	        Assert.assertEquals("failure - expected size", 2, list.size());

	    }

	    @Test
	    public void testCreateWithId() {

	        Exception exception = null;

	        Utilisateur entity = new Utilisateur();
	        entity.setId(1);
	        entity.setNom("testNom");
	        entity.setPassword("testpassword");
	        entity.setMail("test@gtest.fr");

	        try {
	            utilisateurService.create(entity);
	        } catch (EntityExistsException e) {
	            exception = e;
	        }

	        Assert.assertNotNull("failure - expected exception", exception);
	        Assert.assertTrue("failure - expected EntityExistsException",
	                exception instanceof EntityExistsException);

	    }

	    @Test
	    public void testUpdate() {

	        int id = 1;

	        Utilisateur entity = utilisateurService.findOne(id);

	        Assert.assertNotNull("failure - expected not null", entity);


	        entity.setNom("testNom");
	        entity.setPassword("testpassword");
	        entity.setMail("test@gtest.fr");
	        Utilisateur updatedEntity = utilisateurService.update(entity,id);

	        Assert.assertNotNull("failure - expected not null", updatedEntity);
	        Assert.assertEquals("failure - expected id attribute match", id,
	                updatedEntity.getId());
	        Assert.assertEquals("failure - expected text attribute match",
	        		"testNom", updatedEntity.getNom());
	        Assert.assertEquals("failure - expected text attribute match",
	        		"testpassword", updatedEntity.getPassword());
	        Assert.assertEquals("failure - expected text attribute match",
	        		"test@gtest.fr", updatedEntity.getMail());

	    }

	    @Test
	    public void testUpdateNotFound() {

	        Exception exception = null;

	        Utilisateur entity = new Utilisateur();
	        entity.setId(Integer.MAX_VALUE);
	        entity.setNom("testNom");
	        entity.setPassword("testpassword");
	        entity.setMail("test@gtest.fr");

	        try {
	            utilisateurService.update(entity,Integer.MAX_VALUE);
	        } catch (NoResultException e) {
	            exception = e;
	        }

	        Assert.assertNotNull("failure - expected exception", exception);
	        Assert.assertTrue("failure - expected NoResultException",
	                exception instanceof NoResultException);

	    }

	    @Test
	    public void testDelete() {

	        int id = 1;

	        Utilisateur entity = utilisateurService.findOne(id);

	        Assert.assertNotNull("failure - expected not null", entity);

	        utilisateurService.delete(id);

	        Collection<Utilisateur> list = utilisateurService.findAll();

	        Assert.assertEquals("failure - expected size", 0, list.size());

	        Utilisateur deletedEntity = utilisateurService.findOne(id);

	        Assert.assertNull("failure - expected null", deletedEntity);

	    }




}
