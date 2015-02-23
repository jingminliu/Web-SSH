package dao;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


import java.util.*;
import entity.*;
public class OrdersManage{
	private SessionFactory sessionFactory;
	
	//��ѯ���ж���
	@SuppressWarnings("unchecked")
	public List<Orders> allOrders(final int pageNumber,final int pageSize){
		Session session = sessionFactory.openSession();
		String hql = "from Orders as orders order by ordersTime desc";
		List<Orders> allOrders = null;
		try {
			Query query = session.createQuery(hql);
			query.setFirstResult((pageNumber-1)*pageSize);
			query.setMaxResults(pageSize);
			allOrders = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		session.close();
		return allOrders;
	}
	
	//��ѯ���ж���
	@SuppressWarnings("unchecked")
	public List<Orders> allOrdersByDeal(final String isDeal,final int pageNumber,final int pageSize){
		Session session =sessionFactory.openSession();
		String hql = "from Orders as orders where orders.isDeal = '"+isDeal+"' order by ordersTime desc";
		Query query = session.createQuery(hql);
		query.setFirstResult((pageNumber-1)*pageSize);
		query.setMaxResults(pageSize);
		List<Orders> list = query.list();
		session.close();
		return list;
	}

	//���һ���µĶ���
	@SuppressWarnings("unchecked")
	public int addOrders(Orders orders){
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		int i = 0;
		try{
			tx = session.beginTransaction();
			session.save(orders);
			String hql = "select max(ordersId) from Orders";
			List<Integer> idList = session.createQuery(hql).list();
			if(idList.size()>0){
				i = idList.get(0);
			}
			tx.commit();
		}catch (RuntimeException re) {
			re.printStackTrace();
			tx.rollback();
		}
		session.close();
		return i ;
	}
	
	//ɾ��һ������
	public int deleteOrders(int ordersId){
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		int i = 0;
		try{
			tx = session.beginTransaction();
			session.delete(session.get("entity.Orders", ordersId));
			i = 1;
			tx.commit();
		}catch(RuntimeException re){
			re.printStackTrace();
			tx.rollback();
		}
		session.close();
		return i ;
	}
	
	//�޸Ķ���
	public void updateOrders(Orders orders){
		Session session = sessionFactory.openSession();
		Transaction  tx = null;
		try{
			tx = session.beginTransaction();
			session.update(orders);
			tx.commit();
		}catch(RuntimeException re){
			re.printStackTrace();
			tx.rollback();
		}
		session.close();
	}
	
	//����ID��ѯ����
	public Orders findOrders(int ordersId){
		Session session = sessionFactory.openSession();
		try{
			Orders orders = (Orders)session.get("entity.Orders", ordersId);
			return orders;
		}catch(RuntimeException re){
			throw re;
		}finally{
			session.close();
		}
	}
	
	//���һ������ͼ����Ϣ
	public void addOrdersbook(Ordersbook ordersbook){
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			session.save(ordersbook);
			tx.commit();
		}catch (RuntimeException re) {
			
			tx.rollback();
			throw re;
		}finally{
			session.close();
		}
	}
	
	//����userId��ȡ���û����ж���
	@SuppressWarnings("unchecked")
	public List<Orders> allOrdersByUser(int userId,int pageNumber,int pageSize){
		Session session = sessionFactory.openSession();
		String hql = "from Orders as orders where orders.user.userId="+userId+" order by ordersTime desc";
		try{
			List<Orders> allOrdersByUser = session.createQuery(hql).list();
			session.close();
			return allOrdersByUser;
		}catch(RuntimeException re){
			throw re;
		}
	}
	//����userId,��������״̬��ȡ���û����ж���
	@SuppressWarnings("unchecked")
	public List<Orders> allOrdersByUserDeal(int userId,String isDeal,int pageNumber,int pageSize){
		Session session = sessionFactory.openSession();
		String hql = "from Orders as orders where orders.user.userId="+userId+" and orders.isDeal='"+isDeal+"' order by ordersTime desc";
		try{
			List<Orders> allOrdersByUser = session.createQuery(hql).list();
			session.close();
			return allOrdersByUser;
		}catch(RuntimeException re){
			throw re;
		}
	}
	
	//����ordersId��ȡ�ö������ж���ͼ��
	@SuppressWarnings("unchecked")
	public List<Ordersbook> allOrdersbookByOrders(int ordersId){
		Session session = sessionFactory.openSession();
		String hql = "from Ordersbook as ordersbook where ordersbook.orders.ordersId="+ordersId;
		try{
			List<Ordersbook> allOrdersbookByOrders = session.createQuery(hql).list();
			session.close();
			return allOrdersbookByOrders;
		}catch(RuntimeException re){
			throw re;
		}
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	
}
