package dao;
import java.util.*;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.hibernate.Transaction;

import entity.*;

public class BookManage {
	private SessionFactory sessionFactory;
	

	// ����µ�ͼ��
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
		session.close();//�ر�Session
		return i;
	}
	// �޸�ͼ��
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

	// ����ͼ��ID��ѯ��ͼ��
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

	// ��ѯ������õ�ͼ��
	@SuppressWarnings("unchecked")
	public List<Book> bestSellingBook(int pageNumber, int pageSize) {
		Session session = sessionFactory.openSession();
		String hql = "from Book as book where book.bookSales > 0 and book.bookAmount > 0 order by book.bookSales desc ";
		List<Book> bestSellingBook = null;
		try {
			Query query = session.createQuery(hql);
			query.setFirstResult((pageNumber-1)*pageSize);	//���ò�ѯ��ʼ��
			query.setMaxResults(pageSize);				//���ò�ѯ�������ֵ
			bestSellingBook = query.list();
		} catch (RuntimeException re) {
			re.printStackTrace();
		}
		session.close();
		return bestSellingBook;
	}

	// ��ѯ�����ϼܵ�ͼ��
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

	// ��ѯ�Ƽ�ͼ��ID
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

	// ��ѯ�ؼ�ͼ��ID
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

	// ����ͼ�����Ʋ�ѯͼ��
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

	// �������߲�ѯͼ��
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

	// ���ݳ������ѯͼ��
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
	
	//�������ID����ȡ���
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
	
	//����ͼ���������ѯͼ��
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
	
	//��ѯͼ���Ƿ�Ϊ�ؼ�ͼ��
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
