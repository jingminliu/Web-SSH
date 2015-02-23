package dao;
import java.util.*;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.hibernate.Transaction;

import entity.*;

public class BookManage {
	private SessionFactory sessionFactory;
	

	// 添加新的图书
	public int addBook(Book book) {
		int i = 0;
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx=session.beginTransaction();
			session.save(book);
			i = 1;
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
		session.close();//关闭Session
		return i;
	}
	// 修改图书
	public int updateBook(Book book) {
		int i = 0;
		Session session = sessionFactory.openSession();
		try {
			session.update(book);
			i = 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		session.close();
		return i;
	}

	// 根据图书ID查询该图书
	public Book findBook(int bookId) {
		Session session = sessionFactory.openSession();
		Book book = null;
		try {
			book = (Book) session.get("entity.Book",bookId);
		} catch (RuntimeException re) {
			re.printStackTrace();
		}finally{
			session.close();
		}
		return book;
		
	}

	// 查询销量最好的图书
	@SuppressWarnings("unchecked")
	public List<Book> bestSellingBook(int pageNumber, int pageSize) {
		Session session = sessionFactory.openSession();
		String hql = "from Book as book where book.bookSales > 0 and book.bookAmount > 0 order by book.bookSales desc ";
		List<Book> bestSellingBook = null;
		try {
			Query query = session.createQuery(hql);
			query.setFirstResult((pageNumber-1)*pageSize);	//设置查询起始点
			query.setMaxResults(pageSize);				//设置查询数量最大值
			bestSellingBook = query.list();
		} catch (RuntimeException re) {
			re.printStackTrace();
		}
		session.close();
		return bestSellingBook;
	}

	// 查询最新上架的图书
	@SuppressWarnings("unchecked")
	public List<Book> latestBook(int pageNumber, int pageSize) {
		Session session = sessionFactory.openSession();
		String hql = "from Book as book where book.bookAmount > 0 order by book.bookShelveTime desc ";
		List<Book> latestBook  = null;
		try {
			latestBook = session.createQuery(hql).list();
		} catch (RuntimeException re) {
			re.printStackTrace();
		}
		session.close();
		return latestBook;
	}

	// 查询推荐图书ID
	@SuppressWarnings("unchecked")
	public List<Recommended> allRecommended(int pageNumber, int pageSize) {
		Session session = sessionFactory.openSession();
		String hql = "from Recommended as recommended ";
		List<Recommended> allRecommended = null;
		try {
			allRecommended = session.createQuery(hql).list();
		} catch (RuntimeException re) {
			re.printStackTrace();
		}
		session.close();
		return allRecommended;
	}

	// 查询特价图书ID
	@SuppressWarnings("unchecked")
	public List<Bargain> allBargain(int pageNumber, int pageSize) {
		Session session = sessionFactory.openSession();
		String hql = "from Bargain as bargain ";
		List<Bargain> allBargain = null;
		try {
			allBargain = session.createQuery(hql).list();
			return allBargain;
		} catch (RuntimeException re) {
			re.printStackTrace();
		}
		session.close();
		return allBargain;
	}

	// 根据图书名称查询图书
	@SuppressWarnings("unchecked")
	public List<Book> allBookByName(String bookName, int pageNumber,int pageSize) {
		Session session = sessionFactory.openSession();
		String hql = "from Book as book where book.bookName like '%" + bookName + "%'";
		List<Book> allBookByName = null;
		try {
			Query query = session.createQuery(hql);
			query.setMaxResults(pageSize);
			allBookByName = query.list();	
		} catch (RuntimeException re) {
			re.printStackTrace();
		}
		session.close();
		return allBookByName;
	}

	// 根据作者查询图书
	@SuppressWarnings("unchecked")
	public List<Book> allBookByAuthor(String bookAuthor, int pageNumber, int pageSize) {
		Session session = sessionFactory.openSession();
		String hql = "from Book as book where book.bookAuthor like '%" + bookAuthor + "%'";
		List<Book> allBookByAuthor = null;
		try {
			Query query = session.createQuery(hql);
			query.setMaxResults(pageSize);
			allBookByAuthor = query.list();
			
		} catch (RuntimeException re) {
			re.printStackTrace();
		}
		session.close();
		return allBookByAuthor;
	}

	// 根据出版社查询图书
	@SuppressWarnings("unchecked")
	public List<Book> allBookByPress(String bookPress, int pageNumber, int pageSize) {
		String hql = "from Book as book where book.bookPress like '%" + bookPress + "%'";
		List<Book> allBookByPress = null;
		Session session = sessionFactory.openSession();
		try {
			Query query = session.createQuery(hql);
			query.setMaxResults(pageSize);
			allBookByPress = query.list();
			
		} catch (RuntimeException re) {
			throw re;
		}
		session.close();
		return allBookByPress;
	}
	
	//根据类别ID来获取类别
	public Type findType(int typeId){
		Session session =sessionFactory.openSession();
		Type type = null;
		try{
			type = (Type)session.get("entity.Type", typeId);
			session.close();
			return type;
		}catch(RuntimeException re){
			throw re;
		}
	}
	
	//根据图书类别来查询图书
	@SuppressWarnings("unchecked")
	public List<Book> allBookByType(int typeId, int pageNumber, int pageSize){
		String hql = "from Book as book where book.type.typeId="+typeId;
		List<Book> allBookByType  = null;
		Session session = sessionFactory.openSession();
		try{
			allBookByType= session.createQuery(hql).list();
			
		}catch(RuntimeException re){
			re.printStackTrace();
		}
		session.close();
		return allBookByType;
	}
	
	//查询图书是否为特价图书
	@SuppressWarnings("unchecked")
	public Bargain isBargain(int bookId){
		Bargain bargain = null;
		String hql = "from Bargain as bargain where bargain.book.bookId="+bookId;
		Session session = sessionFactory.openSession();
		try{
			List<Bargain> bargainList = session.createQuery(hql).list(); 
			if(bargainList.size() > 0){
				bargain = bargainList.get(0);
			}
		}catch(RuntimeException re){
			throw re;
		}
		session.close();
		return bargain;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
