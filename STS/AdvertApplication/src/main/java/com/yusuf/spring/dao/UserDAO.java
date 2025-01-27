package com.yusuf.spring.dao;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.yusuf.spring.exception.AdException;
import com.yusuf.spring.pojo.Email;
import com.yusuf.spring.pojo.User;

public class UserDAO extends DAO {

    public UserDAO() {
    }

    public User get(String username)
            throws AdException {
        try {
            begin();
            Query q = getSession().createQuery("from User where name = :username");
            q.setString("username", username);
           
            User user = (User) q.uniqueResult();//one unique result, otherwise exception
            commit();
            return user;
        } catch (HibernateException e) {
            rollback();
            throw new AdException("Could not get user " + username, e);
        }
    }

    public User create(String username, String password,String emailId)
            throws AdException {
        try {
            begin();
            //insert Code here
            Email email= new Email(emailId);
            User user= new User(username,password);
            user.setEmail(email);
            getSession().save(user);
            commit();
            return user;
        } catch (HibernateException e) {
            rollback();
            //throw new AdException("Could not create user " + username, e);
            throw new AdException("Exception while creating user: " + e.getMessage());
        }
    }

    public void delete(User user)
            throws AdException {
        try {
            begin();
            getSession().delete(user);
            commit();
        } catch (HibernateException e) {
            rollback();
            throw new AdException("Could not delete user " + user.getName(), e);
        }
    }
}