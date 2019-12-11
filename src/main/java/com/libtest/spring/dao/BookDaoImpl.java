package com.libtest.spring.dao;

import com.libtest.spring.model.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookDaoImpl implements IBookDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Book save(Book b) {
         sessionFactory.getCurrentSession().saveOrUpdate(b);
        return  b;
    }

    @Override
    public Book get(Long id) {
        /*CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<T> criteria = builder.createQuery(type);
        criteria.from(type);
        List<T> data = session.createQuery(criteria).getResultList();*/

        /*Query qry = session.createQuery("from Product p");

        List l =qry.list();*/
        List<Book> resBook = sessionFactory.getCurrentSession().createQuery(
                "from Book b where b.bookId : bookId ").
        setParameter("bookId",id).list();
        if(resBook == null || resBook.isEmpty())
            return null;
        else
            return resBook.get(0);


        //Book book = (Book)sessionFactory.getCurrentSession().get(Book.class, 1);

    }

    @Override
    public List<Book> getList() {
        List<Book> resBook = sessionFactory.getCurrentSession().createQuery(
                "from Book b ").list();
        return resBook;
    }

    @Override
    public void update(long id, Book book) {
        Session session = sessionFactory.getCurrentSession();
        Book book2 = session.byId(Book.class).load(id);
        book2.setBookName(book.getBookName());
        book2.setAuthorName(book.getAuthorName());
        session.flush();
    }

    @Override
    public void delete(long id) {
        Session session = sessionFactory.getCurrentSession();
        Book book = session.byId(Book.class).load(id);
        if(book != null )
            session.delete(book);
        else
            new Exception("No Such Book Found");
    }
}
