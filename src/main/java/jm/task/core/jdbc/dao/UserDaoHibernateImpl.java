package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Objects;

public class UserDaoHibernateImpl implements UserDao {
    private final SessionFactory sessionFactory = Util.getConnectionHiber();

    public void createUsersTable() {
        Transaction transaction = null;

        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.createSQLQuery("CREATE TABLE IF NOT EXISTS User" +
                    "(id mediumint not null auto_increment," +
                    "name VARCHAR(30), " +
                    "lastname VARCHAR(30), " +
                    "age tinyint, " +
                    "PRIMARY KEY (id))").executeUpdate();
            transaction.commit();
        } catch (RuntimeException e) {
            e.printStackTrace();
            if (Objects.nonNull(transaction)) transaction.rollback();
            throw e;
        }
    }

    public void dropUsersTable() {
        Transaction transaction = null;

        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.createSQLQuery("drop table if exists User ").executeUpdate();
            transaction.commit();
        } catch (RuntimeException e) {
            if (Objects.nonNull(transaction)) transaction.rollback();
            throw e;
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        Transaction transaction = null;

        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.saveOrUpdate(new User(name, lastName, age));
            transaction.commit();
        } catch (RuntimeException e) {
            e.printStackTrace();
            if (Objects.nonNull(transaction)) transaction.rollback();
            throw e;
        }
    }

    public void removeUserById(long id) {
        Transaction transaction = null;

        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.delete(session.get(User.class, id));
            transaction.commit();
        } catch (RuntimeException e) {
            if (Objects.nonNull(transaction)) transaction.rollback();
            throw e;
        }
    }

    public List<User> getAllUsers() {
        Transaction transaction = null;

        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            List<User> users = session.createQuery("from User", User.class).list();
            session.getTransaction().commit();
            return users;
        } catch (RuntimeException e) {
            if (Objects.nonNull(transaction)) transaction.rollback();
            throw e;
        }
    }

    public void cleanUsersTable() {
        Transaction transaction = null;

        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.createSQLQuery("delete from User").executeUpdate();
            transaction.commit();
        } catch (RuntimeException e) {
            if (Objects.nonNull(transaction)) transaction.rollback();
            throw e;
        }
    }
}
